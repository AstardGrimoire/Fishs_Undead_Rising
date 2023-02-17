package com.Fishmod.mod_LavaCow.entities.flying;

import javax.annotation.Nullable;

import com.Fishmod.mod_LavaCow.config.FURConfig;
import com.Fishmod.mod_LavaCow.entities.ParasiteEntity;
import com.Fishmod.mod_LavaCow.entities.ai.FlyerFollowOwnerGoal;
import com.Fishmod.mod_LavaCow.init.FUREffectRegistry;
import com.Fishmod.mod_LavaCow.init.FUREntityRegistry;
import com.Fishmod.mod_LavaCow.init.FURSoundRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NonTamedTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BeelzebubEntity extends RidableFlyingMobEntity {
	private static final DataParameter<Integer> SKIN_TYPE = EntityDataManager.defineId(BeelzebubEntity.class, DataSerializers.INT);
	
	public BeelzebubEntity(EntityType<? extends BeelzebubEntity> p_i48549_1_, World worldIn) {
		super(p_i48549_1_, worldIn);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();		
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.BEEF), false));
		this.goalSelector.addGoal(4, new BeelzebubEntity.AIUseSpell());
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	    this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	    this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));	    
        this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, PlayerEntity.class, false, (p_213440_0_) -> {
            return !(p_213440_0_.isPassenger() && p_213440_0_.getVehicle() instanceof BeelzebubEntity);
        }).setUnseenMemoryTicks(160));
        
        if (FURConfig.Beelzebub_Attack_Zombie.get()) {
	        this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, ZombieEntity.class, false, (p_213440_0_) -> {
	            return true;
	        }).setUnseenMemoryTicks(160));
        }
	}
	
    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes()
        		.add(Attributes.MOVEMENT_SPEED, 0.08D)
        		.add(Attributes.FOLLOW_RANGE, 32.0D)
        		.add(Attributes.MAX_HEALTH, FURConfig.Beelzebub_Health.get())
        		.add(Attributes.ATTACK_DAMAGE, FURConfig.Beelzebub_Attack.get())
        		.add(Attributes.FLYING_SPEED, 0.1D);
    }
	
    @Override
    protected void defineSynchedData() {
    	super.defineSynchedData();
    	this.getEntityData().define(SKIN_TYPE, Integer.valueOf(0));
    }
    
    @Override
    public void setTame(boolean tamed) {
    	super.setTame(tamed);
        
        if (tamed) {
        	this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(FURConfig.Beelzebub_Health.get() * 2.0D);
        	this.setHealth(this.getHealth() * 2.0F);
        } else {
        	this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(FURConfig.Beelzebub_Health.get());
        	this.setHealth(this.getHealth() * 0.5F);
        }
	}
    
    @Override
    protected Goal wanderGoal() {
    	return new FlyingMobEntity.AIRandomFly(this);
    }
    
    @Override
    protected Goal followGoal() {
    	return new FlyerFollowOwnerGoal(this, 1.0D, 10.0F, 4.0F, false);
    }
    
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.BEEF;
    }
    
    @Override
    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
    	return p_213348_2_.height * 0.45F;
    }
    
    @Override
	public int abilityCooldown() {
    	return FURConfig.Beelzebub_Ability_Cooldown.get() * 20;
    }
    
    @Override
    public void tick() {
    	super.tick();
    	
    	if(!this.onGround && this.tickCount % 20 == 0) {
    		this.playSound(this.getFlyingSound(), 1.0F, 1.0F);
    	}
    	
    	if (this.getAttackTimer() == 6 && this.abilityCooldown > 0 && this.deathTime <= 0) {
			double d0 = this.getX() + 1.75D * this.getLookAngle().normalize().x;
            double d1 = this.getY();
            double d2 = this.getZ() + 1.75D * this.getLookAngle().normalize().z;
    		      		        
            for (LivingEntity entitylivingbase : this.level.getEntitiesOfClass(LivingEntity.class, new AxisAlignedBB(d0, d1, d2, d0, d1, d2).inflate(1.0D))) {
            	if (!this.equals(entitylivingbase) && !this.isAlliedTo(entitylivingbase)) {
            		this.doHurtTarget(entitylivingbase);
                }
            }	
            
            this.playSound(SoundEvents.TRIDENT_THROW, 0.6F, 2.0F);
    	}
    }
   
    @Override
	public boolean doHurtTarget(Entity par1Entity) {
 	   if (par1Entity instanceof ZombieEntity) {
 		  this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(FURConfig.Beelzebub_Attack.get() * 2.0D);
 	   } else {
		   this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(FURConfig.Beelzebub_Attack.get());
 	   }
 	   
 	   if (super.doHurtTarget(par1Entity)) {
 		   if (par1Entity instanceof LivingEntity) {
 			   float local_difficulty = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
 			   ((LivingEntity) par1Entity).addEffect(new EffectInstance(FUREffectRegistry.SOILED, 6 * 20 * (int)local_difficulty, 2));
 		   }

 		   return true;
 	   } else {
    	   return false;
       }
	}

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean hurt(DamageSource source, float amount) {    	
    	if(source.getEntity() instanceof ZombieEntity) {
    		return super.hurt(source, amount * 0.5F);
    	}
    	   
 	   	return super.hurt(source, amount);
    }
    
    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance difficulty, SpawnReason p_213386_3_, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT p_213386_5_) {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(FURConfig.Beelzebub_Health.get());
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(FURConfig.Beelzebub_Attack.get());
    	this.setHealth(this.getMaxHealth());
    	
    	return super.finalizeSpawn(p_213386_1_, difficulty, p_213386_3_, livingdata, p_213386_5_);
    }
      
    public int getSkin() {
    	return this.getEntityData().get(SKIN_TYPE).intValue();
    }

    public void setSkin(int skinType) {
    	this.getEntityData().set(SKIN_TYPE, Integer.valueOf(skinType));
    }
    
    @Override
	protected double VehicleSpeedMod() {
		return (this.isInLava() || this.isInWater()) ? 0.2D : 1.8D;
	}
    
    /**
     * Handler for {@link World#setEntityState}
     */
	@Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
		switch(id) {
			case 10:
				this.spellTicks = 30;
				break;
			default:
				super.handleEntityEvent(id);
				break;
		}
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
	
    public void castSpell() {
        for (int i = 0; i < FURConfig.Beelzebub_Ability_Num.get(); ++i) {
            BlockPos blockpos = this.blockPosition().offset(-2 + this.getRandom().nextInt(5), 1, -2 + this.getRandom().nextInt(5));
            ParasiteEntity entity = FUREntityRegistry.PARASITE.create(this.level);
            entity.moveTo(blockpos, 0.0F, 0.0F);
            entity.setSkin(0);
            entity.setSummoned(true);
            
            if(!this.level.isClientSide())
            	this.level.addFreshEntity(entity);
            
            entity.setTarget(this.getTarget());
            
            for (int j = 0; j < 24; ++j) {
            	double d0 = entity.getX() + (double)(this.getRandom().nextFloat() * entity.getBbWidth() * 2.0F) - (double)entity.getBbWidth();
            	double d1 = entity.getY() + (double)(this.getRandom().nextFloat() * entity.getBbHeight());
            	double d2 = entity.getZ() + (double)(this.getRandom().nextFloat() * entity.getBbWidth() * 2.0F) - (double)entity.getBbWidth();
            	this.level.addParticle(ParticleTypes.FALLING_HONEY, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
	
	public class AIUseSpell extends Goal {
        protected int spellWarmup;
        protected int spellCooldown;

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean canUse() {
            if (BeelzebubEntity.this.getTarget() == null) {
                return false;
            } else if (BeelzebubEntity.this.isSpellcasting() || BeelzebubEntity.this.getAttackTimer() > 0) {
                return false;
            } else {
                int i = BeelzebubEntity.this.level.getEntitiesOfClass(ParasiteEntity.class, BeelzebubEntity.this.getBoundingBox().inflate(16.0D)).size();
            	return BeelzebubEntity.this.tickCount >= this.spellCooldown && i < FURConfig.Beelzebub_Ability_Max.get();
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return BeelzebubEntity.this.getTarget() != null && this.spellWarmup > 0;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            this.spellWarmup = this.getCastWarmupTime();
            BeelzebubEntity.this.spellTicks = this.getCastingTime();
            this.spellCooldown = BeelzebubEntity.this.tickCount + this.getCastingInterval();
            SoundEvent soundevent = this.getSpellPrepareSound();
            BeelzebubEntity.this.level.broadcastEntityEvent(BeelzebubEntity.this, (byte)10);         
            if (soundevent != null) {
                BeelzebubEntity.this.playSound(soundevent, 1.0F, 1.0F);
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            --this.spellWarmup;

            if (this.spellWarmup == 0) {
            	BeelzebubEntity.this.castSpell();
                BeelzebubEntity.this.playSound(BeelzebubEntity.this.getSpellSound(), 0.175F, 1.0F);
            }
        }

        protected int getCastWarmupTime() {
            return 10;
        }

        protected int getCastingTime() {
            return 10;
        }

        protected int getCastingInterval() {
        	return FURConfig.Beelzebub_Ability_Cooldown.get() * 20;
        }

        @Nullable
        protected SoundEvent getSpellPrepareSound() {
        	return null;
        }
    }
	
	@Override
	public int getAmbientSoundInterval() {
		return 1000;
	}
	
	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	protected SoundEvent getAmbientSound() {
		return FURSoundRegistry.BEELZEBUB_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return FURSoundRegistry.BEELZEBUB_HURT;
	}

	protected SoundEvent getDeathSound() {
		return FURSoundRegistry.BEELZEBUB_DEATH;
	}
	
    public SoundEvent getSpellSound() {
        return FURSoundRegistry.BEELZEBUB_SPELL;
    }
	
	protected SoundEvent getFlyingSound() {
		return FURSoundRegistry.VESPA_FLYING;
	}
	
	@Override
    protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.getLandTimer() > 10) {
			this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
		}
	}
	
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.ARTHROPOD;
    }

	/**
	* Returns the volume for the sounds this mob makes.
	*/
	protected float getSoundVolume() {
		return 0.5F;
	}
}
