package com.Fishmod.mod_LavaCow.entities.floating;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import javax.annotation.Nullable;

import com.Fishmod.mod_LavaCow.config.FURConfig;
import com.Fishmod.mod_LavaCow.core.SpawnUtil;
import com.Fishmod.mod_LavaCow.init.FURSoundRegistry;

import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.server.ServerWorld;

public class SeaHagEntity extends FloatingMobEntity {
	private static final DataParameter<Integer> SKIN_TYPE = EntityDataManager.defineId(SeaHagEntity.class, DataSerializers.INT);
	
	public SeaHagEntity(EntityType<? extends SeaHagEntity> p_i48549_1_, World worldIn) {
        super(p_i48549_1_, worldIn);
        this.setPathfindingMalus(PathNodeType.WATER, 8.0F);      
    }
	
    @Override
    protected void registerGoals() {   	
    	super.registerGoals();    
    	this.goalSelector.addGoal(1, new SeaHagEntity.GoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FloatingMobEntity.AIChargeAttack());
		this.goalSelector.addGoal(3, new SeaHagEntity.AIUseSpell());
    }

    @Override
    protected void applyEntityAI() {
    	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected Goal wanderGoal() {
    	return new SeaHagEntity.AIMoveRandom();
    }
    
    @Override
	public float getBrightness() {
		return 1.0F;
	}
    
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes()
        		.add(Attributes.MOVEMENT_SPEED, 0.175D)
        		.add(Attributes.FOLLOW_RANGE, 32.0D)
        		.add(Attributes.MAX_HEALTH, FURConfig.SeaHag_Health.get())
        		.add(Attributes.ATTACK_DAMAGE, FURConfig.SeaHag_Attack.get());
    }
    
	public static boolean checkSeaHagSpawnRules(EntityType<SeaHagEntity> p_223332_0_, IServerWorld p_223332_1_, SpawnReason p_223332_2_, BlockPos p_223332_3_, Random p_223332_4_) {
		Optional<RegistryKey<Biome>> optional = p_223332_1_.getBiomeName(p_223332_3_);
        boolean flag = p_223332_1_.getDifficulty() != Difficulty.PEACEFUL && isDarkEnoughToSpawn(p_223332_1_, p_223332_3_, p_223332_4_) && (p_223332_2_ == SpawnReason.SPAWNER || p_223332_1_.getFluidState(p_223332_3_).is(FluidTags.WATER));

        if (!Objects.equals(optional, Optional.of(Biomes.RIVER)) && !Objects.equals(optional, Optional.of(Biomes.FROZEN_RIVER))) {
        	return p_223332_4_.nextInt(40) == 0 && flag;
        } else {
        	return p_223332_4_.nextInt(15) == 0 && flag;
        }
	}
    
    @Override
    protected void defineSynchedData() {
    	super.defineSynchedData();
    	this.getEntityData().define(SKIN_TYPE, Integer.valueOf(1));
    }
    
    @Override
    public boolean checkSpawnObstruction(IWorldReader p_205019_1_) {
        return p_205019_1_.isUnobstructed(this);
    }
    
    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficulty, SpawnReason p_213386_3_, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT p_213386_5_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(FURConfig.SeaHag_Health.get());
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(FURConfig.SeaHag_Attack.get());
    	this.setHealth(this.getMaxHealth());

    	return super.finalizeSpawn(worldIn, difficulty, p_213386_3_, livingdata, p_213386_5_);
    }
    
    @Override
    @Nullable
    protected IParticleData ParticleType() {   	
    	return this.isInWater() ? null : ParticleTypes.FALLING_WATER;
    }
    
	/**
	* Called when the entity is attacked.
	*/
    @Override
	public boolean hurt(DamageSource source, float amount) {
    	if(source.getEntity() instanceof PufferfishEntity)
    		return false;

    	return super.hurt(source, amount);
    }	    
    
    public class AIUseSpell extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean canUse() {
        	if (SeaHagEntity.this.isSpellcasting()) {
                return false;
            } else {
                int i = SeaHagEntity.this.level.getEntitiesOfClass(PufferfishEntity.class, SeaHagEntity.this.getBoundingBox().inflate(16.0D)).size();               
            	return SeaHagEntity.this.tickCount >= this.spellCooldown && ((SeaHagEntity.this.getTarget() != null && Math.abs(SeaHagEntity.this.getY() - SeaHagEntity.this.getTarget().getY()) < 4.0D)) && i < FURConfig.SeaHag_Ability_Max.get();
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.spellWarmup = this.getCastWarmupTime();
            SeaHagEntity.this.spellTicks = this.getCastingTime();
            SeaHagEntity.this.level.broadcastEntityEvent(SeaHagEntity.this, (byte)10);
            this.spellCooldown = SeaHagEntity.this.tickCount + this.getCastingInterval();
            SoundEvent soundevent = this.getSpellPrepareSound();

            if (soundevent != null) {
                SeaHagEntity.this.playSound(soundevent, 1.0F, 1.0F);
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.spellWarmup;

            if (this.spellWarmup == 5) {
        		this.castSpell();        	
                SeaHagEntity.this.playSound(SeaHagEntity.this.getSpellSound(), 4.0F, 1.2F);                         
            }
        }
       
        protected void castSpell() {
            for (int i = 0; i < FURConfig.SeaHag_Ability_Num.get(); ++i) {
            	if (SeaHagEntity.this.level instanceof ServerWorld) {
	                BlockPos blockpos = SeaHagEntity.this.blockPosition().offset(-2 + SeaHagEntity.this.getRandom().nextInt(3), 1, -2 + SeaHagEntity.this.getRandom().nextInt(3));
	                PufferfishEntity entity = SpawnUtil.trySpawnEntity(EntityType.PUFFERFISH, ((ServerWorld) SeaHagEntity.this.level), blockpos);
	          
	                if (entity != null) {
	                	entity.setAirSupply(80);
	                	entity.addTag("FUR_noLoot");	
	
		                for (int j = 0; j < 4; ++j) {
		                	double d0 = entity.getX() + (double)(SeaHagEntity.this.getRandom().nextFloat() * entity.getBbWidth() * 2.0F) - (double)entity.getBbWidth();
		                	double d1 = entity.getY() + (double)(SeaHagEntity.this.getRandom().nextFloat() * entity.getBbHeight());
		                	double d2 = entity.getZ() + (double)(SeaHagEntity.this.getRandom().nextFloat() * entity.getBbWidth() * 2.0F) - (double)entity.getBbWidth();
		                	((ServerWorld) SeaHagEntity.this.level).sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, d0, d1, d2, 15, 0.0D, 0.0D, 0.0D, 0.0D);
		                	
		                }
	                }
                }
            }
        }

        protected int getCastWarmupTime() {
            return 20;
        }

        protected int getCastingTime() {
            return 30;
        }

        protected int getCastingInterval() {
        	return FURConfig.SeaHag_Ability_Cooldown.get() * 20;
        }

        @Nullable
        protected SoundEvent getSpellPrepareSound() {
            return null;
        }
    }
    
    static class GoToWaterGoal extends Goal {
        private final CreatureEntity mob;
        private double wantedX;
        private double wantedY;
        private double wantedZ;
        private final double speedModifier;
        private final World level;

        public GoToWaterGoal(CreatureEntity p_i48910_1_, double p_i48910_2_) {
           this.mob = p_i48910_1_;
           this.speedModifier = p_i48910_2_;
           this.level = p_i48910_1_.level;
           this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canUse() {
           if (!this.level.isDay()) {
              return false;
           } else if (this.mob.isInWater()) {
              return false;
           } else {
              Vector3d vector3d = this.getWaterPos();
              if (vector3d == null) {
                 return false;
              } else {
                 this.wantedX = vector3d.x;
                 this.wantedY = vector3d.y;
                 this.wantedZ = vector3d.z;
                 return true;
              }
           }
        }

        public boolean canContinueToUse() {
        	return !this.mob.getNavigation().isDone();
        }

        public void start() {
        	this.mob.getMoveControl().setWantedPosition(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
        }

        @Nullable
        private Vector3d getWaterPos() {
           Random random = this.mob.getRandom();
           BlockPos blockpos = this.mob.blockPosition();

           for(int i = 0; i < 10; ++i) {
              BlockPos blockpos1 = blockpos.offset(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
              if (this.level.getBlockState(blockpos1).is(Blocks.WATER)) {
                 return Vector3d.atBottomCenterOf(blockpos1);
              }
           }

           return null;
        }
	}
    
    class AIMoveRandom extends Goal {
        public AIMoveRandom() {
        	this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean canUse() {
            return !SeaHagEntity.this.getMoveControl().hasWanted() && SeaHagEntity.this.getRandom().nextInt(7) == 0;
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return false;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {            
            BlockPos blockpos = SeaHagEntity.this.blockPosition();
            int groundHeight = SpawnUtil.getHeight(SeaHagEntity.this).getY();
            int y = SeaHagEntity.this.getRandom().nextInt(11) - 5;

            if (groundHeight > 0) {
            	y = Math.min(groundHeight + 4 - blockpos.getY(), y);
            }

            for(int i = 0; i < 3; ++i) {
               BlockPos blockpos1 = blockpos.offset(SeaHagEntity.this.random.nextInt(15) - 7, y, SeaHagEntity.this.random.nextInt(15) - 7);
               if ((!SeaHagEntity.this.level.isDay() && SeaHagEntity.this.level.isEmptyBlock(blockpos1)) || SeaHagEntity.this.level.isWaterAt(blockpos1)) {
                  SeaHagEntity.this.moveControl.setWantedPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
                  if (SeaHagEntity.this.getTarget() == null) {
                     SeaHagEntity.this.getLookControl().setLookAt((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
                  }
                  break;
               }
            }
        }
    }
    
    public int getSkin() {
        return this.getEntityData().get(SKIN_TYPE).intValue();
    }

    public void setSkin(int skinType) {
        this.getEntityData().set(SKIN_TYPE, Integer.valueOf(skinType));
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return FURSoundRegistry.SEAHAG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return FURSoundRegistry.BANSHEE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FURSoundRegistry.SEAHAG_DEATH;
    }
    
    protected SoundEvent getSpellSound() {
        return SoundEvents.BUBBLE_COLUMN_UPWARDS_AMBIENT;
    }
    
    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.setSkin(compound.getInt("Variant"));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
	@Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", getSkin());
    }
	
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEAD;
    }
}
