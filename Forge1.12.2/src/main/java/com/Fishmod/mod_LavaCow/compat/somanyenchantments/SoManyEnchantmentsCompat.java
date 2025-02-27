package com.Fishmod.mod_LavaCow.compat.somanyenchantments;

import com.Fishmod.mod_LavaCow.entities.projectiles.EntityCactusThorn;
import com.Fishmod.mod_LavaCow.item.ItemPiranhaLauncher;
import com.shultrea.rin.properties.ArrowPropertiesProvider;
import com.shultrea.rin.properties.ArrowPropertiesHandler;
import com.shultrea.rin.properties.IArrowProperties;
import com.shultrea.rin.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoManyEnchantmentsCompat {

    public static void init(){
        // Currently a disaster
//        MinecraftForge.EVENT_BUS.register(LauncherAmmoHandler.class);
    }

    public static int getAdvancedMendingLevel(ItemStack itemStack){
        if(!(EnchantmentRegistry.advancedMending.isEnabled())) return 0;
        return EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedMending, itemStack);
    }
    public static int roundAverage(float value) {
        double floor = Math.floor(value);
        return (int) floor + (Math.random() < value - floor ? 1 : 0);
    }

    // EntityCactusThorn extends EntityArrow
    // EntityDeathCoil extends EntityWitherSkull extends EntityFireball
    // EntityPiranhaLauncher extends EntityEnchantableFireBall extends EntityFireball
    // EntityEnchantableFireBall extends EntityFireball

    /*
    * SME auto does handling on EntityJoinWorldEvent only on instances of EntityArrow
    * Therefore must get the modded enchant levels and return their ratio compared to vanilla
    * Also have to consider SME Arrow properties applying to EntityCactusThorn, but not the other three ammos
    */
    public static int getSMEPowerLevel(ItemStack bow){
        if(EnchantmentRegistry.powerless.isEnabled()) {
            int powerlessLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.powerless, bow);
            if(powerlessLevel > 0) { return -1 * powerlessLevel; } // Curse, equal to -1 Power per level
        }
        else if(EnchantmentRegistry.advancedPower.isEnabled()) {
            int advPowerLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedPower, bow);
            if(advPowerLevel > 0) { return (int)(advPowerLevel * 5 / 3); } // 5/3 Power at level V, gets truncated
        }
        return 0;
    }
    public static int getSMEPunchLevel(ItemStack bow){
        if(EnchantmentRegistry.advancedPunch.isEnabled()) {
            int advPunchLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedPunch, bow);
            if (advPunchLevel > 0) { return (1 + advPunchLevel * 2); }
        }
        // Would be funny but not possible to do SME Dragging
        return 0;
    }
    public static int getSMEFlameLevel(ItemStack bow){
        if(EnchantmentRegistry.lesserFlame.isEnabled()) {
            int levelLessFlame = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.lesserFlame, bow);
            if(levelLessFlame > 0) { return levelLessFlame; } // Technically should be 0.5, but using ints
        }
        else if(EnchantmentRegistry.advancedFlame.isEnabled()) {
            int levelAdvFlame = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedFlame, bow);
            if(levelAdvFlame > 0) { return 2 * levelAdvFlame; }
        }
        else if(EnchantmentRegistry.supremeFlame.isEnabled()) {
            int levelSupFlame = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.supremeFlame, bow);
            if(levelSupFlame > 0) { return 4 * levelSupFlame; }
        }
        else if(EnchantmentRegistry.extinguish.isEnabled()) {
            if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.extinguish, bow) > 0) { return 0; }
        }
        return 0;
    }
}
