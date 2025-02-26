package com.Fishmod.mod_LavaCow.compat.somanyenchantments;

import com.shultrea.rin.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class SoManyEnchantmentsCompat {

    public static int getAdvancedMendingLevel(ItemStack itemStack){
        return EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.advancedMending, itemStack);
    }

    public static int roundAverage(float value) {
        double floor = Math.floor(value);
        return (int) floor + (Math.random() < value - floor ? 1 : 0);
    }
}
