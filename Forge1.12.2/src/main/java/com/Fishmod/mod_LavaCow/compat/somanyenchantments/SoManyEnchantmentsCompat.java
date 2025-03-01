package com.Fishmod.mod_LavaCow.compat.somanyenchantments;

import com.shultrea.rin.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SoManyEnchantmentsCompat {

    public static void init(){
        MinecraftForge.EVENT_BUS.register(new LauncherAmmoHandler());
        MinecraftForge.EVENT_BUS.register(new EnchantmentSplitshotHandler());
    }

    public static int getPowerlessLevel(ItemStack itemStack){
        return EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.powerless, itemStack);
    }
    public static int getAdvancedPowerLevel(ItemStack itemStack){
        return EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedPower, itemStack);
    }

    public static int getAdvancedMendingLevel(ItemStack itemStack){
        return EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedMending, itemStack);
    }
    public static int roundAverage(float value) {
        double floor = Math.floor(value);
        return (int) floor + (Math.random() < value - floor ? 1 : 0);
    }
}
