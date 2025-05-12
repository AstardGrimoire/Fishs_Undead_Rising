package com.Fishmod.mod_LavaCow.entities.aquatic;

import javax.annotation.Nullable;

import com.Fishmod.mod_LavaCow.client.Modconfig;
import com.Fishmod.mod_LavaCow.entities.ai.EntityAIPickupMeat;
import com.Fishmod.mod_LavaCow.util.LootTableHandler;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityPiranha extends EntityZombiePiranha{
	
    public EntityPiranha(World worldIn)
    {
        super(worldIn); 
        this.setSize(0.7F, 0.5F);
        this.BeachedLife = 300;
    }
    
    @Override
    protected void applyEntityAI() {
    	if(Modconfig.Piranha_AnimalAttack) {
        	this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntitySquid>(this, EntitySquid.class, true));
    		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<>(this, EntityAgeable.class, 0, true, true, new Predicate<Entity>() {
                public boolean apply(@Nullable Entity p_apply_1_) {
                    return !(p_apply_1_ instanceof EntityTameable) && ((EntityAgeable)p_apply_1_).getHealth() < ((EntityAgeable)p_apply_1_).getMaxHealth();
                }
            }));
    	}
    	this.targetTasks.addTask(5, new EntityAIPickupMeat<>(this, EntityItem.class, true));
    }
    
    //@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Modconfig.Piranha_Health);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)1.2F);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(Modconfig.Piranha_Attack);
    }
    
    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Modconfig.Piranha_Health);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(Modconfig.Piranha_Attack);
        this.setHealth(this.getMaxHealth());

        return super.onInitialSpawn(difficulty, livingdata);
    }
    
    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
     }
    
    @Override
    protected SoundEvent getDeathSound() {
    	 return SoundEvents.ENTITY_GUARDIAN_HURT_LAND;
     }

    @Override
     protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
    	 return SoundEvents.ENTITY_GUARDIAN_FLOP;
     }
    
     @Override
     @Nullable
     protected ResourceLocation getLootTable() {
    	 return LootTableHandler.PIRANHA;
     }
}
