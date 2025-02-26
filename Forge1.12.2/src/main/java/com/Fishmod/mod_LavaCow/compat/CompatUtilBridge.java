package com.Fishmod.mod_LavaCow.compat;

import com.Fishmod.mod_LavaCow.client.Modconfig;
import net.minecraftforge.fml.common.Loader;

public class CompatUtilBridge {
    private static final String QUARK_MODID = "quark";
    private static final String RLCOMBAT_MODID = "bettercombatmod";
    private static final String SO_MANY_ENCHANTMETS_MODID = "somanyenchantments";
    private static final String TINKERS_CONSTRUCT_MODID = "tconstruct";
    private static final String CONSTRUCTS_ARMORY_MODID = "conarm"; // Construct's Armory is only loaded when Tinkers' Construct is installed
    private static final String JUST_ENOUGH_RESOURCES_MODID = "jeresources";

    private static Boolean isQuarkLoaded = null;
    private static Boolean isRLCombatLoaded = null;
    private static Boolean isSMELoaded = null;
    private static Boolean isTinkersConstructLoaded = null;
    private static Boolean isConstructsArmoryLoaded = null;
    private static Boolean isJERLoaded = null;


    public static boolean isQuarkLoaded() {
        if(!(Modconfig.Quark_Compat)) return false;
        if(isQuarkLoaded == null) isQuarkLoaded = Loader.isModLoaded(QUARK_MODID);
        return isQuarkLoaded;
    }

    public static boolean isRLCombatLoaded() {
        if(!(Modconfig.RLCombat_Compat)) return false;
        if(isRLCombatLoaded == null) isRLCombatLoaded = Loader.isModLoaded(RLCOMBAT_MODID);
        return isRLCombatLoaded;
    }

    public static boolean isSMELoaded() {
        if(!(Modconfig.SME_Compat)) return false;
        if(isSMELoaded == null) isSMELoaded = Loader.isModLoaded(SO_MANY_ENCHANTMETS_MODID);
        return isSMELoaded;
    }

    public static boolean isTinkersConstructLoaded() {
        if(!(Modconfig.Tinkers_Compat)) return false;
        if(isTinkersConstructLoaded == null) isTinkersConstructLoaded = Loader.isModLoaded(TINKERS_CONSTRUCT_MODID);
        return isTinkersConstructLoaded;
    }

    public static boolean isConstructsArmoryLoaded() {
        if(!(isTinkersConstructLoaded())) return false;
        if(!(Modconfig.Tinkers_Compat)) return false;
        if(isConstructsArmoryLoaded == null) isConstructsArmoryLoaded = Loader.isModLoaded(CONSTRUCTS_ARMORY_MODID);
        return isConstructsArmoryLoaded;
    }

    public static boolean isJERLoaded() {
        if(isJERLoaded == null) isJERLoaded = Loader.isModLoaded(JUST_ENOUGH_RESOURCES_MODID);
        return isJERLoaded;
    }
}
