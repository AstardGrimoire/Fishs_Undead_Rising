package com.Fishmod.mod_LavaCow.compat.tinkers;

import c4.conarm.common.armor.traits.ArmorTraits;
import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.ArmorMaterials;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.TinkerRegistry;

public class ConstructsArmoryCompat {
    private static final ConstructsArmoryCompat INSTANCE = new ConstructsArmoryCompat();

    // These traits are for Construct's Armory armor and not Tinkers' Construct tools
    public static final AbstractArmorTrait BROODMOTHER_ARMOR = new TraitBroodMotherArmor();
    public static final AbstractArmorTrait FEEDING_FRENZY = new TraitFeedingFrenzyArmor();
    public static final AbstractArmorTrait UNHOLY_AURA = new TraitUnholyAuraArmor();
    public static final AbstractArmorTrait VESPA_WARD_ARMOR = new TraitVespaWardArmor();
    public static final AbstractArmorTrait AMBER_PHARAOH_ARMOR = new TraitAmberPharaohArmor();

    // Materials are already registered in TinkersCompat.class, this only adds support for Construct's Armory armor
    public static void init() {
        MinecraftForge.EVENT_BUS.register(INSTANCE);
        TinkerRegistry.addMaterialStats(TinkersCompat.MOLTEN_MEAT,
                new CoreMaterialStats(10.0F, 14.0F),
                new PlatesMaterialStats(1.0F, 6.0F, 1.0F),
                new TrimMaterialStats(7.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.MOLTEN_MEAT, ArmorTraits.infernal, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.MOLTEN_MEAT, ArmorTraits.superhot, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.MOLTEN_MEAT, ArmorTraits.superhot, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.MOLTEN_MEAT, ArmorTraits.superhot, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.VESPA_CARAPACE,
                new CoreMaterialStats(17.5F, 15.5F),
                new PlatesMaterialStats(0.9F, 7.0F, 4.5F),
                new TrimMaterialStats(10.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.VESPA_CARAPACE, BROODMOTHER_ARMOR, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.VESPA_CARAPACE, VESPA_WARD_ARMOR, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.VESPA_CARAPACE, VESPA_WARD_ARMOR, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.VESPA_CARAPACE, VESPA_WARD_ARMOR, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.SCYTHE_CLAW,
                new CoreMaterialStats(8.5F, 10.0F),
                new PlatesMaterialStats(0.8F, -5.0F, 1.0F),
                new TrimMaterialStats(3.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.SCYTHE_CLAW, FEEDING_FRENZY, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.SCYTHE_CLAW, ArmorTraits.vengeful, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.SCYTHE_CLAW, ArmorTraits.vengeful, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.ECTOPLASM,
                new CoreMaterialStats(40.0F, 2.0F),
                new PlatesMaterialStats(1.4F, -5.0F, 4.0F),
                new TrimMaterialStats(7.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.ECTOPLASM, UNHOLY_AURA, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.ECTOPLASM, UNHOLY_AURA, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.ECTOPLASM, UNHOLY_AURA, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.HOLY_SLUDGE,
                new CoreMaterialStats(19.0F, 15.0F),
                new PlatesMaterialStats(1.0F, -6.0F, 2.4F),
                new TrimMaterialStats(11.5F));
        ArmorMaterials.addArmorTrait(TinkersCompat.HOLY_SLUDGE, ArmorTraits.blessed, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.HOLY_SLUDGE, ArmorTraits.bouncy, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.HOLY_SLUDGE, ArmorTraits.blessed, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.HOLY_SLUDGE, ArmorTraits.blessed, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.ANCIENT_AMBER,
                new CoreMaterialStats(14.0F, 14.5F),
                new PlatesMaterialStats(1.05F, 5.0F, 0.0F),
                new TrimMaterialStats(5.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.ANCIENT_AMBER, AMBER_PHARAOH_ARMOR, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.ANCIENT_AMBER, ArmorTraits.aridiculous, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.ANCIENT_AMBER, ArmorTraits.aridiculous, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.ANCIENT_AMBER, ArmorTraits.aridiculous, ArmorMaterialType.TRIM);

        TinkerRegistry.addMaterialStats(TinkersCompat.CHITIN,
                new CoreMaterialStats(12.0F, 14.0F),
                new PlatesMaterialStats(0.95F, 5.0F, 3.0F),
                new TrimMaterialStats(5.0F));
        ArmorMaterials.addArmorTrait(TinkersCompat.CHITIN, ArmorTraits.spiny, ArmorMaterialType.CORE);
        ArmorMaterials.addArmorTrait(TinkersCompat.CHITIN, ArmorTraits.spiny, ArmorMaterialType.PLATES);
        ArmorMaterials.addArmorTrait(TinkersCompat.CHITIN, ArmorTraits.spiny, ArmorMaterialType.TRIM);
    }
}
