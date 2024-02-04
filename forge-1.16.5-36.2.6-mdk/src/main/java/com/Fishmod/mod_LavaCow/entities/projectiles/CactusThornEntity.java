package com.Fishmod.mod_LavaCow.entities.projectiles;

import com.Fishmod.mod_LavaCow.init.FUREntityRegistry;
import com.Fishmod.mod_LavaCow.init.FURItemRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class CactusThornEntity extends AbstractArrowEntity implements IEntityAdditionalSpawnData {
	public CactusThornEntity(EntityType<? extends CactusThornEntity> p_i50158_1_, World worldIn) {
		super(p_i50158_1_, worldIn);
	}

	public CactusThornEntity(World worldIn, LivingEntity shooter) {
		super(FUREntityRegistry.CACTUS_THORN, shooter, worldIn);
	}

	public CactusThornEntity(World worldIn, double posX, double posY, double posZ) {
		super(FUREntityRegistry.CACTUS_THORN, posX, posY, posZ, worldIn);
	}
	
	@Override
	public void writeSpawnData(PacketBuffer buffer) {
		buffer.writeInt(this.getOwner() != null ? this.getOwner().getId() : -1);		
	}

	@Override
	public void readSpawnData(PacketBuffer additionalData) {
        final Entity shooter = this.level.getEntity(additionalData.readInt());

        if (shooter != null) {
            this.setOwner(shooter);
        }
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level.isClientSide && !this.inGround) {
			this.level.addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(FURItemRegistry.CACTUS_THORN);
	}
	
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}