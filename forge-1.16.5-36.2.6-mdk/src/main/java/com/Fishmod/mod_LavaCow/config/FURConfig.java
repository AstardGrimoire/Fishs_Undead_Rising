package com.Fishmod.mod_LavaCow.config;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.world.Dimension;
import net.minecraftforge.common.ForgeConfigSpec;

public final class FURConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Double> Lavacow_Health;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Foglet;
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Imp;
	public static final ForgeConfigSpec.ConfigValue<Double> Foglet_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Foglet_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Parasite;
	public static final ForgeConfigSpec.ConfigValue<Double> Parasite_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Parasite_Attack;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Parasite_Hostlist;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_UndeadSwine;
	public static final ForgeConfigSpec.ConfigValue<Double> UndeadSwine_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> UndeadSwine_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_ZombieMushroom;
	public static final ForgeConfigSpec.ConfigValue<Double> ZombieMushroom_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> ZombieMushroom_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_ZombieFrozen;
	public static final ForgeConfigSpec.ConfigValue<Double> ZombieFrozen_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> ZombieFrozen_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Salamander;
	public static final ForgeConfigSpec.ConfigValue<Double> Salamander_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Salamander_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Wendigo;
	public static final ForgeConfigSpec.ConfigValue<Double> Wendigo_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Wendigo_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Mimic;
	public static final ForgeConfigSpec.ConfigValue<Double> Mimic_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Mimic_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_SludgeLord;
	public static final ForgeConfigSpec.ConfigValue<Double> SludgeLord_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> SludgeLord_Attack;
	public static final ForgeConfigSpec.ConfigValue<Integer> SludgeLord_Ability_Num;
	public static final ForgeConfigSpec.ConfigValue<Integer> SludgeLord_Ability_Max;
	public static final ForgeConfigSpec.ConfigValue<Integer> SludgeLord_Ability_Cooldown;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Raven;
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Seagull;
	public static final ForgeConfigSpec.ConfigValue<Double> Raven_Health;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Raven_Perch;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Raven_Slowfall;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Ptera;
	public static final ForgeConfigSpec.ConfigValue<Double> Ptera_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Ptera_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Vespa;
	public static final ForgeConfigSpec.ConfigValue<Double> Vespa_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Vespa_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Scarecrow;
	public static final ForgeConfigSpec.ConfigValue<Double> Scarecrow_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Scarecrow_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Swarmer;
	public static final ForgeConfigSpec.ConfigValue<Double> Swarmer_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Swarmer_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Piranha;
	public static final ForgeConfigSpec.ConfigValue<Double> Piranha_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Piranha_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_BoneWorm;
	public static final ForgeConfigSpec.ConfigValue<Double> BoneWorm_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> BoneWorm_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Pingu;
	public static final ForgeConfigSpec.ConfigValue<Double> Pingu_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Pingu_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Undertaker;
	public static final ForgeConfigSpec.ConfigValue<Double> Undertaker_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Undertaker_Attack;
	public static final ForgeConfigSpec.ConfigValue<Integer> Undertaker_Ability_Num;
	public static final ForgeConfigSpec.ConfigValue<Integer> Undertaker_Ability_Max;
	public static final ForgeConfigSpec.ConfigValue<Integer> Undertaker_Ability_Cooldown;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_GhostRay;
	public static final ForgeConfigSpec.ConfigValue<Double> GhostRay_Health;

	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_DeathMimic;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Banshee;
	public static final ForgeConfigSpec.ConfigValue<Double> Banshee_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Banshee_Attack;
	public static final ForgeConfigSpec.ConfigValue<Double> Banshee_Ability_Radius;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Weta;
	public static final ForgeConfigSpec.ConfigValue<Double> Weta_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Weta_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Avaton;
	public static final ForgeConfigSpec.ConfigValue<Double> Avaton_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Avaton_Attack;
	public static final ForgeConfigSpec.ConfigValue<Integer> Avaton_Ability_Num;
	public static final ForgeConfigSpec.ConfigValue<Integer> Avaton_Ability_Max;
	public static final ForgeConfigSpec.ConfigValue<Integer> Avaton_Ability_Cooldown;
	
	public static final ForgeConfigSpec.ConfigValue<Double> LilSludge_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> LilSludge_Attack;
	public static final ForgeConfigSpec.ConfigValue<Integer> LilSludge_Lifespan;
	
	public static final ForgeConfigSpec.ConfigValue<Double> Unburied_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Unburied_Attack;
	public static final ForgeConfigSpec.ConfigValue<Integer> Unburied_Lifespan;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Forsaken;
	public static final ForgeConfigSpec.ConfigValue<Double> Forsaken_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Forsaken_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Double> SkeletonKing_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> SkeletonKing_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Mummy;
	public static final ForgeConfigSpec.ConfigValue<Double> Mummy_Health;
	public static final ForgeConfigSpec.ConfigValue<Double> Mummy_Attack;
	
	public static final ForgeConfigSpec.ConfigValue<Boolean> MoltenHammer_PVP;
	public static final ForgeConfigSpec.ConfigValue<Integer> Parasite_SandSpawn;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Wendigo_AnimalAttack;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Fission_ModEntity;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Parasite_Attach;
	public static final ForgeConfigSpec.ConfigValue<Integer> General_Intestine;
	public static final ForgeConfigSpec.ConfigValue<Integer> GoldenHeart_dur;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> GoldenHeart_bl;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GoldenHeart_GrantsRegeneration;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GoldenHeart_RepairsEquipment;
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpawnRate_Glowshroom;
	public static final ForgeConfigSpec.ConfigValue<Integer> pSpreadRate_Glowshroom;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Piranha_AnimalAttack;
	public static final ForgeConfigSpec.ConfigValue<Integer> FlyingHeight_limit;
	public static final ForgeConfigSpec.ConfigValue<Integer> BoneSword_Damage;
	public static final ForgeConfigSpec.ConfigValue<Integer> HaloNecklace_Damage;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Intestine_lt;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Intestine_banlist;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Raven_Loot;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Seagull_Loot;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Spectral_Raven_Loot;
	public static final ForgeConfigSpec.ConfigValue<Integer> pScarecrow_PlagueDoctor;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DreamCatcher_spawn;
	public static final ForgeConfigSpec.ConfigValue<Integer> SludgeWand_Cooldown;
	public static final ForgeConfigSpec.ConfigValue<Integer> Undertaker_Shovel_Cooldown;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Tinkers_Compat;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Quark_Compat;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SunScreen_Mode;
	public static final ForgeConfigSpec.ConfigValue<Integer> SpawnRate_Cemetery;
	public static final ForgeConfigSpec.ConfigValue<Integer> BoneSword_DamageCap;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Spawn_AllowList;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Suicidal_Minion;
	public static final ForgeConfigSpec.ConfigValue<Integer> DreamCatcher_dur;	
	public static final ForgeConfigSpec.ConfigValue<Boolean> Potion_Enable;
	public static final ForgeConfigSpec.ConfigValue<Boolean> Enchantment_Enable;
	public static final ForgeConfigSpec.ConfigValue<Integer> MootenHeart_Damage;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> Spawn_Cemetery_AllowList;
	public static final ForgeConfigSpec.ConfigValue<Integer> Cemetery_SpawnRate; 
	public static final ForgeConfigSpec.ConfigValue<Integer> SpawnRate_Desert_Tomb; 
	public static final ForgeConfigSpec.ConfigValue<Boolean> BonusVillagerTrades; 
	public static final ForgeConfigSpec.ConfigValue<Boolean> BonusWanderingTraderTrades; 
	
	static {
		BUILDER.push("Glowshroom");
		pSpawnRate_Glowshroom = BUILDER.comment("Set the spawn rate of Glowshroom [0-100]").defineInRange("glowshroom spawn rate", 1, 0, 100);
		pSpreadRate_Glowshroom = BUILDER.comment("Set the spread rate of Glowshroom [0-100]").defineInRange("glowshroom spread rate", 100, 0, 100);
		BUILDER.pop();
		
		BUILDER.push("Moogma");
		Lavacow_Health = BUILDER.comment("Maximum Moogma health [1-1000]").defineInRange("moogma health", 10.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Foglet");
		pSpawnRate_Foglet = BUILDER.comment("Set the spawn rate of Foglet [0-10000]").defineInRange("foglet spawn rate", 20, 0, 10000);
		pSpawnRate_Imp = BUILDER.comment("Set the spawn rate of Imp [0-10000]").defineInRange("imp spawn rate", 3, 0, 10000);
		Foglet_Health = BUILDER.comment("Maximum Foglet health [1-1000]").defineInRange("foglet health", 16.0D, 1.0D, 1000.0D);
		Foglet_Attack = BUILDER.comment("Foglet strength [1-1000]").defineInRange("foglet attack", 2.0D, 1.0D, 1000.0D);	
		BUILDER.pop();

		BUILDER.push("Parasite");
		pSpawnRate_Parasite = BUILDER.comment("Set the spawn rate of Parasite [0-100]").defineInRange("parasite spawn rate", 10, 0, 100);
		Parasite_Health = BUILDER.comment("Maximum Parasite health [1-1000]").defineInRange("parasite health", 6.0D, 1.0D, 1000.0D);
		Parasite_Attack = BUILDER.comment("Parasite strength [1-1000]").defineInRange("parasite attack", 1.0D, 1.0D, 1000.0D);
		Parasite_SandSpawn = BUILDER.comment("Rate of spawning Parasite when destroying sand blocks in the desert [0-100]").defineInRange("parasite from sand blocks", 2, 0, 100);
		Parasite_Attach = BUILDER.comment("Parasite will attack their target by attaching on them [false/true]").define("parasite attacks by attaching onto target", true);
		Parasite_Hostlist = BUILDER.comment("Allow Parasite to spawn from listed mob. Ex. \\\"minecraft:zombie\\\" or \\\"mod_lavacow:frigid\\\"").defineList("available host for parasite", 
				Lists.newArrayList(
						"minecraft:zombie",
						"minecraft:husk",
						"mod_lavacow:frigid",
						"mod_lavacow:mycosis",
						"mod_lavacow:unburied",
						"mod_lavacow:mummy"), 
				o -> o instanceof String);
		BUILDER.pop();
		
		BUILDER.push("Undead Swine");
		pSpawnRate_UndeadSwine = BUILDER.comment("Set the spawn rate of Undead swine [0-10000]").defineInRange("undeadswine spawn rate", 15, 0, 10000);
		UndeadSwine_Health = BUILDER.comment("Maximum Undead Swine health [1-1000]").defineInRange("undeadswine health", 50.0D, 1.0D, 1000.0D);
		UndeadSwine_Attack = BUILDER.comment("Undead Swine strength [1-1000]").defineInRange("undeadswine attack", 4.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Mycosis");
		pSpawnRate_ZombieMushroom = BUILDER.comment("Set the spawn rate of Mycosis [0-10000]").defineInRange("mycosis spawn rate", 40, 0, 10000);
		ZombieMushroom_Health = BUILDER.comment("Maximum Mycosis health [1-1000]").defineInRange("mycosis health", 20.0D, 1.0D, 1000.0D);
		ZombieMushroom_Attack = BUILDER.comment("Mycosis strength [1-1000]").defineInRange("mycosis attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Frigid");
		pSpawnRate_ZombieFrozen = BUILDER.comment("Set the spawn rate of Frigid [0-10000]").defineInRange("frigid spawn rate", 20, 0, 10000);
		ZombieFrozen_Health = BUILDER.comment("Maximum Frigid health [1-1000]").defineInRange("frigid health", 30.0D, 1.0D, 1000.0D);
		ZombieFrozen_Attack = BUILDER.comment("Frigid strength [1-1000]").defineInRange("frigid attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Salamander");
		pSpawnRate_Salamander = BUILDER.comment("Set the spawn rate of Salamander [0-10000]").defineInRange("salamander spawn rate", 30, 0, 10000);
		Salamander_Health = BUILDER.comment("Maximum Salamander health [1-1000]").defineInRange("salamander health", 60.0D, 1.0D, 1000.0D);
		Salamander_Attack = BUILDER.comment("Salamander strength [1-1000]").defineInRange("salamander attack", 4.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Wendigo");
		pSpawnRate_Wendigo = BUILDER.comment("Set the spawn rate of Wendigo [0-10000]").defineInRange("wendigo spawn rate", 15, 0, 10000);
		Wendigo_AnimalAttack = BUILDER.comment("Should Wendigo attack innocent animals [false/true]").define("wendigo attacks animals", true);
		Wendigo_Health = BUILDER.comment("Maximum Wendigo health [1-1000]").defineInRange("wendigo health", 60.0D, 1.0D, 1000.0D);
		Wendigo_Attack = BUILDER.comment("Wendigo strength [1-1000]").defineInRange("wendigo attack", 8.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Mimicrab");
		pSpawnRate_Mimic = BUILDER.comment("Set the spawn rate of Mimicrab [0-10000]").defineInRange("mimicrab spawn rate", 20, 0, 10000);
		Mimic_Health = BUILDER.comment("Maximum Mimicrab health [1-1000]").defineInRange("mimicrab health", 10.0D, 1.0D, 1000.0D);
		Mimic_Attack = BUILDER.comment("Mimicrab strength [1-1000]").defineInRange("mimicrab attack", 8.0D, 1.0D, 1000.0D);
		pSpawnRate_DeathMimic = BUILDER.comment("Set the spawn rate of Mimicrab near player death [0-1000]").defineInRange("mimicrab spawn rate near player death", 250, 0, 1000);
		BUILDER.pop();

		BUILDER.push("Sludge Lord");
		pSpawnRate_SludgeLord = BUILDER.comment("Set the spawn rate of Sludge Lord [0-10000]").defineInRange("sludge lord spawn rate", 15, 0, 10000);
		SludgeLord_Health = BUILDER.comment("Maximum Sludge Lord health [1-1000]").defineInRange("sludge lord health", 70.0D, 1.0D, 1000.0D);
		SludgeLord_Attack = BUILDER.comment("Sludge Lord strength [1-1000]").defineInRange("sludge lord attack", 5.0D, 1.0D, 1000.0D);
		SludgeLord_Ability_Num = BUILDER.comment("Set the number of Lil'Sludge summoned per cast [0-100]").defineInRange("sludge lord summon number", 3, 0, 100);
		SludgeLord_Ability_Max = BUILDER.comment("Set the max number of Lil'Sludge summoned [0-100]").defineInRange("sludge lord summon max", 8, 0, 100);
		SludgeLord_Ability_Cooldown = BUILDER.comment("Set the cooldown of summoning Lil'Sludge [0-100]").defineInRange("sludge lord summon cooldown", 17, 0, 100);
		BUILDER.pop();
		
		BUILDER.push("Lil'Sludge");
		LilSludge_Lifespan = BUILDER.comment("Lil'Sludge lifespan [1-10000]").defineInRange("lil'sludge lifespan", 60, 0, 10000);
		LilSludge_Health = BUILDER.comment("Maximum Lil'Sludge health [1-1000]").defineInRange("lil'sludge health", 20.0D, 1.0D, 1000.0D);
		LilSludge_Attack = BUILDER.comment("Lil'Sludge strength [1-1000]").defineInRange("lil'sludge attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Raven");
		pSpawnRate_Raven = BUILDER.comment("Set the spawn rate of Raven [0-10000]").defineInRange("raven spawn rate", 8, 0, 10000);
		pSpawnRate_Seagull = BUILDER.comment("Set the spawn rate of Seagull [0-10000]").defineInRange("seagull spawn rate", 8, 0, 10000);
		Raven_Health = BUILDER.comment("Maximum Raven health [1-1000]").defineInRange("raven health", 6.0D, 1.0D, 1000.0D);
		Raven_Perch = BUILDER.comment("Should tamed Raven perch on owner's head [false/true]").define("raven perching", true);
		Raven_Slowfall = BUILDER.comment("Should perching Raven slow down owner's falling speed [false/true]").define("raven slow down falling", true);
		Raven_Loot = BUILDER.comment("Customize drop rates of the items which ravens can find. Ex. \\\"minecraft:tropical_fish,0.4,2\\\" or \\\"mod_lavacow:sharptooth,0.1\\\"").defineList("loot table for ravens", 
				Lists.newArrayList(
						"minecraft:beetroot_seeds,0.15",
						"minecraft:wheat_seeds,0.15,2",
						"minecraft:melon_seeds,0.15",
						"minecraft:pumpkin_seeds,0.15",
						"minecraft:gold_nugget,0.1,2",
						"minecraft:iron_nugget,0.1,2"), 
				o -> o instanceof String);
		Seagull_Loot = BUILDER.comment("Customize drop rates of the items which seagulls can find. Ex. \\\"minecraft:tropical_fish,0.4,2\\\" or \\\"mod_lavacow:sharptooth,0.1\\\"").defineList("loot table for seagulls", 
				Lists.newArrayList(
						"minecraft:cod,0.15",
						"minecraft:tropical_fish,0.15"), 
				o -> o instanceof String);
		Spectral_Raven_Loot = BUILDER.comment("Customize drop rates of the items which spectral ravens can find. Ex. \\\"minecraft:tropical_fish,0.4,2\\\" or \\\"mod_lavacow:sharptooth,0.1\\\"").defineList("loot table for spectral ravens", 
				Lists.newArrayList(
						"minecraft:gold_nugget,0.15,3",
						"minecraft:iron_nugget,0.15,3"), 
				o -> o instanceof String);
		BUILDER.pop();
		
		BUILDER.push("Ptera");
		pSpawnRate_Ptera = BUILDER.comment("Set the spawn rate of Ptera [0-10000]").defineInRange("ptera spawn rate", 20, 0, 10000);
		Ptera_Health = BUILDER.comment("Maximum Ptera health [1-1000]").defineInRange("ptera health", 10.0D, 1.0D, 1000.0D);
		Ptera_Attack = BUILDER.comment("Ptera strength [1-1000]").defineInRange("ptera attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Vespa");
		pSpawnRate_Vespa = BUILDER.comment("Set the spawn rate of Vespa [0-100]").defineInRange("vespa spawn rate", 20, 0, 100);
		Vespa_Health = BUILDER.comment("Maximum Vespa health [1-1000]").defineInRange("vespa health", 20.0D, 1.0D, 1000.0D);
		Vespa_Attack = BUILDER.comment("Vespa strength [1-1000]").defineInRange("vespa attack", 5.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Scarecrow");
		pSpawnRate_Scarecrow = BUILDER.comment("Set the spawn rate of Scarecrow [0-100]").defineInRange("scarecrow spawn rate", 15, 0, 10000);
		Scarecrow_Health = BUILDER.comment("Maximum Scarecrow health [1-1000]").defineInRange("scarecrow health", 40.0D, 1.0D, 1000.0D);
		Scarecrow_Attack = BUILDER.comment("Scarecrow strength [1-1000]").defineInRange("scarecrow attack", 8.0D, 1.0D, 1000.0D);
		pScarecrow_PlagueDoctor = BUILDER.comment("Set the spawn rate of Plague Doctor Scarecrow when a Raven was killed. [0-100]").defineInRange("plague doctor scarecrow spawn rate", 30, 0, 100);
		BUILDER.pop();
		
		BUILDER.push("Swarmer");
		pSpawnRate_Swarmer = BUILDER.comment("Set the spawn rate of Swarmer [0-10000]").defineInRange("swarmer spawn rate", 5, 0, 10000);
		Swarmer_Health = BUILDER.comment("Maximum Swarmer health [1-1000]").defineInRange("swarmer health", 8.0D, 1.0D, 1000.0D);
		Swarmer_Attack = BUILDER.comment("Swarmer strength [1-1000]").defineInRange("swarmer attack", 1.0D, 1.0D, 1000.0D);
		Piranha_AnimalAttack = BUILDER.comment("Should Piranha and Swarmer attack innocent animals [false/true]").define("piranha attacks animals", true);
		BUILDER.pop();
		
		BUILDER.push("Piranha");
		pSpawnRate_Piranha = BUILDER.comment("Set the spawn rate of Piranha [0-10000]").defineInRange("piranha spawn rate", 5, 0, 10000);
		Piranha_Health = BUILDER.comment("Maximum Piranha health [1-1000]").defineInRange("piranha health", 3.0D, 1.0D, 1000.0D);
		Piranha_Attack = BUILDER.comment("Piranha strength [1-1000]").defineInRange("piranha attack", 1.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Osvermis");
		pSpawnRate_BoneWorm = BUILDER.comment("Set the spawn rate of OsVermis [0-10000]").defineInRange("boneworm spawn rate", 20, 0, 10000);
		BoneWorm_Health = BUILDER.comment("Maximum OsVermis health [1-1000]").defineInRange("boneworm health", 32.0D, 1.0D, 1000.0D);
		BoneWorm_Attack = BUILDER.comment("OsVermis strength [1-1000]").defineInRange("boneworm attack", 6.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Penghoul");
		pSpawnRate_Pingu = BUILDER.comment("Set the spawn rate of Penghoul [0-100]").defineInRange("penghoul spawn rate", 20, 0, 10000);
		Pingu_Health = BUILDER.comment("Maximum Penghoul health [1-1000]").defineInRange("penghoul health", 10.0D, 1.0D, 1000.0D);
		Pingu_Attack = BUILDER.comment("Penghoul strength [1-1000]").defineInRange("penghoul attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Undertaker");
		pSpawnRate_Undertaker = BUILDER.comment("Set the spawn rate of Undertaker [0-100]").defineInRange("undertaker spawn rate", 8, 0, 10000);
		Undertaker_Health = BUILDER.comment("Maximum Undertaker health [1-1000]").defineInRange("undertaker health", 40.0D, 1.0D, 1000.0D);
		Undertaker_Attack = BUILDER.comment("Undertaker strength [1-1000]").defineInRange("undertaker attack", 6.0D, 1.0D, 1000.0D);
		Undertaker_Ability_Num = BUILDER.comment("Set the number of Unburied summoned per cast [0-100]").defineInRange("undertaker summon number", 4, 0, 100);
		Undertaker_Ability_Max = BUILDER.comment("Set the max number of Unburied summoned [0-100]").defineInRange("undertaker summon max", 4, 0, 100);
		Undertaker_Ability_Cooldown = BUILDER.comment("Set the cooldown of summoning Unburied [0-100]").defineInRange("undertaker summon cooldown", 15, 0, 100);
		BUILDER.pop();
		
		BUILDER.push("Unburied");
		Unburied_Lifespan = BUILDER.comment("Unburied lifespan [1-10000]").defineInRange("unburied lifespan", 20, 0, 10000);
		Unburied_Health = BUILDER.comment("Maximum Unburied health [1-1000]").defineInRange("unburied health", 20.0D, 1.0D, 1000.0D);
		Unburied_Attack = BUILDER.comment("Unburied strength [1-1000]").defineInRange("unburied attack", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Ghost Ray");
		pSpawnRate_GhostRay = BUILDER.comment("Set the spawn rate of Ghost Ray [0-10000]").defineInRange("ghost ray spawn rate", 10, 0, 10000);
		GhostRay_Health = BUILDER.comment("Maximum Ghost Ray health [1-1000]").defineInRange("ghost ray health", 20.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Banshee");
		pSpawnRate_Banshee = BUILDER.comment("Set the spawn rate of Banshee [0-100]").defineInRange("banshee spawn rate", 20, 0, 10000);
		Banshee_Health = BUILDER.comment("Maximum Banshee health [1-1000]").defineInRange("banshee health", 34.0D, 1.0D, 1000.0D);
		Banshee_Attack = BUILDER.comment("Banshee strength [1-1000]").defineInRange("banshee attack", 7.0D, 1.0D, 1000.0D);
		Banshee_Ability_Radius = BUILDER.comment("Set the effect radius of Banshee scream [1-1000]").defineInRange("banshee scream radius", 3.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Weta");
		pSpawnRate_Weta = BUILDER.comment("Set the spawn rate of Weta [0-10000]").defineInRange("weta spawn rate", 30, 0, 10000);
		Weta_Health = BUILDER.comment("Maximum Weta health [1-1000]").defineInRange("weta health", 12.0D, 1.0D, 1000.0D);
		Weta_Attack = BUILDER.comment("Weta strength [1-1000]").defineInRange("weta attack", 1.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Avaton");
		pSpawnRate_Avaton = BUILDER.comment("Set the spawn rate of Avaton [0-100]").defineInRange("avaton spawn rate", 20, 0, 10000);
		Avaton_Health = BUILDER.comment("Maximum Avaton health [1-1000]").defineInRange("avaton health", 30.0D, 1.0D, 1000.0D);
		Avaton_Attack = BUILDER.comment("Avaton strength [1-1000]").defineInRange("avaton attack", 5.0D, 1.0D, 1000.0D);
		Avaton_Ability_Num = BUILDER.comment("Set the number of Weta summoned per cast [0-100]").defineInRange("avaton summon number", 2, 0, 100);
		Avaton_Ability_Max = BUILDER.comment("Set the max number of Weta summoned [0-100]").defineInRange("avaton summon max", 16, 0, 100);
		Avaton_Ability_Cooldown = BUILDER.comment("Set the cooldown of summoning Weta [0-100]").defineInRange("avaton summon cooldown", 8, 0, 100);
		BUILDER.pop();
		
		BUILDER.push("Forsaken");
		pSpawnRate_Forsaken = BUILDER.comment("Set the spawn rate of Forsaken [0-10000]").defineInRange("forsaken spawn rate", 10, 0, 10000);
		Forsaken_Health = BUILDER.comment("Maximum Forsaken health [1-1000]").defineInRange("forsaken health", 30.0D, 1.0D, 1000.0D);
		Forsaken_Attack = BUILDER.comment("Forsaken strength [1-1000]").defineInRange("forsaken attack", 4.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Skeleton King");
		SkeletonKing_Health = BUILDER.comment("Maximum Skeleton King health [1-1000]").defineInRange("skeleton king health", 360.0D, 1.0D, 1000.0D);
		SkeletonKing_Attack = BUILDER.comment("Skeleton King strength [1-1000]").defineInRange("skeleton king attack", 16.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Mummy");
		pSpawnRate_Mummy = BUILDER.comment("Set the spawn rate of Mummy [0-10000]").defineInRange("mummy spawn rate", 40, 0, 10000);
		Mummy_Health = BUILDER.comment("Maximum Mummy health [1-1000]").defineInRange("mummy health", 24.0D, 1.0D, 1000.0D);
		Mummy_Attack = BUILDER.comment("Mummy strength [1-1000]").defineInRange("mummy attack", 4.0D, 1.0D, 1000.0D);
		BUILDER.pop();
		
		BUILDER.push("Item");
		MoltenHammer_PVP = BUILDER.comment("Allow Molten Hammer active effect to hit players [false/true]").define("allow molten hammer pvp", false);
		Fission_ModEntity = BUILDER.comment("Allow Potion of Fission to be used on entites from other mods [false/true]").define("fission potion works on entities from other mods", false);
		General_Intestine = BUILDER.comment("Set the drop rate of Intestine [0-100]").defineInRange("entity drop intestine", 4, 0, 100);
		Intestine_lt = BUILDER.comment("Customize Items and their drop rates for the Intestine. Ex. \\\"minecraft:slime_ball,0.4\\\" or \\\"mod_lavacow:sharptooth,0.1\\\"").defineList("loot table for intestine", 
				Lists.newArrayList(
						"minecraft:slime_ball,0.4",
						"minecraft:bone_meal,0.4",
						"mod_lavacow:sharptooth,0.1",
						"minecraft:beetroot_seeds,0.1",
						"minecraft:wheat_seeds,0.1",
						"minecraft:melon_seeds,0.1",
						"minecraft:pumpkin_seeds,0.1",
						"minecraft:clay_ball,0.1",
						"mod_lavacow:chitin,0.1",
						"minecraft:gold_nugget,0.05",
						"minecraft:iron_nugget,0.05",
						"minecraft:diamond,0.01"), 
				o -> o instanceof String);
		Intestine_banlist = BUILDER.comment("Customize the banlist for which mobs that intestines shouldn't drop from. Ex. \\\"minecraft:slime\\\" or \\\"mod_lavacow:vespa\\\"").defineList("mobs that intestine should not drop from", 
				Lists.newArrayList(
						"minecraft:chicken",
						"minecraft:squid",
						"minecraft:snowman",
						"minecraft:villager_golem",
						"minecraft:skeleton_horse",
						"minecraft:enderman",
						"minecraft:silverfish",
						"minecraft:endermite",
						"minecraft:shulker",
						"minecraft:blaze",
			      		"minecraft:slime",
			      		"minecraft:magma_cube",
			      		"minecraft:ender_dragon",
			      		"minecraft:wither",
			      		"minecraft:ghast",
			      		"minecraft:skeleton",
			      		"minecraft:wither_skeleton",
			      		"minecraft:stray",
			      		"mod_lavacow:avaton",
			      		"mod_lavacow:banshee",
			      		"mod_lavacow:sludgelord",
			      		"mod_lavacow:lilsludge",
			      		"mod_lavacow:scarecrow",
			      		"mod_lavacow:ghostray",
			      		"mod_lavacow:skeletonking",
			      		"mod_lavacow:forsaken"
			      		), 
				o -> o instanceof String);
		GoldenHeart_dur = BUILDER.comment("Set the duribility of Golden Heart, 0 = Infinite [0-10000]").defineInRange("golden heart duribility", 250, 0, 10000);
		GoldenHeart_bl = BUILDER.comment("BlackBanlist for items that Golden Heart are unable to mend. Ex. \\\"minecraft:shears\\\" or \\\"mod_lavacow:moltenhammer\\\"").defineList("banlisted items from golden heart", 
				Lists.newArrayList(), o -> o instanceof String);		
		GoldenHeart_GrantsRegeneration = BUILDER.comment("Enables the Regeneration effect of the Golden Heart. [false/true]").define("golden heart grants regeneration", true);
		GoldenHeart_RepairsEquipment = BUILDER.comment("Allow the Golden Heart to repair worn equipment. [false/true]").define("golden heart repairs equipment", true);	
		BoneSword_Damage = BUILDER.comment("Set the bonus damage of Bone Sword to X% [0-100]").defineInRange("bonesword bonus damage", 5, 0, 100);		
		HaloNecklace_Damage = BUILDER.comment("Set the bonus damage of Halo Necklace to X% [0-10000]").defineInRange("halo necklace bonus damage", 10, 0, 10000);		
		DreamCatcher_spawn = BUILDER.comment("Customize the Spawn list for the Dreamcatcher. Ex. \\\"mod_lavacow:foglet,40,1,2\\\" or \\\"mod_lavacow:vespa,20,1,1\\\"").defineList("spawn list for dreamcatcher", 
				Lists.newArrayList(
						"mod_lavacow:foglet,40,1,2",
						"mod_lavacow:undeadswine,20,1,1",
						"mod_lavacow:ithaqua,20,1,1",
						"mod_lavacow:sludgelord,20,1,1",
						"mod_lavacow:vespa,20,1,1",
						"mod_lavacow:scarecrow,20,1,1",
						"mod_lavacow:boneworm,20,1,1",
						"mod_lavacow:pingu,40,4,8",
						"mod_lavacow:undertaker,20,1,1",
						"mod_lavacow:banshee,20,1,1",
						"mod_lavacow:avaton,20,1,1"), 
				o -> o instanceof String);
		DreamCatcher_dur = BUILDER.comment("Set the duribility of Dreamcatcher, 0 = Infinite [0-10000]").defineInRange("dreamcatcher duribility", 80, 0, 10000);				
		SludgeWand_Cooldown = BUILDER.comment("Ability cooldown of \\\"Pestilence\\\" [1-10000]").defineInRange("pestilence cooldown", 60, 0, 10000);
		Undertaker_Shovel_Cooldown = BUILDER.comment("Ability cooldown of Midnight Mourne [1-10000]").defineInRange("midnight mourne cooldown", 60, 0, 10000);							
		BoneSword_DamageCap = BUILDER.comment("Set the bonus damage cap of Bone Sword [0-10000]").defineInRange("bonesword bonus damage cap", 10000, 0, 10000);		
		MootenHeart_Damage = BUILDER.comment("Set the fire damage reduction of Molten Heart to X% [0-10000]").defineInRange("molten heart damage reduction", 20, 0, 10000);		
		BUILDER.pop();
		
		BUILDER.push("Structure");
		SpawnRate_Cemetery = BUILDER.comment("Spawn rate of Cemetery [1-10000]").defineInRange("cemetery spawn rate", 500, 0, 10000);
		Spawn_Cemetery_AllowList = BUILDER.comment("Cemetery are only allowed to spawn in these dimensions' IDs").defineList("cemetery spawn allow dimensions", 
				Lists.newArrayList(Dimension.OVERWORLD.location().toString()), o -> o instanceof String);
		Cemetery_SpawnRate = BUILDER.comment("Cemetery spawns Unburied occasionally. [0-100]").defineInRange("cemetery spawns unburied", 40, 0, 100);		
		SpawnRate_Desert_Tomb = BUILDER.comment("Spawn rate of Desert Tomb [1-10000]").defineInRange("desert tomb spawn rate", 5, 0, 10000);
		BUILDER.pop();
		
		BUILDER.push("General");
		FlyingHeight_limit = BUILDER.comment("Set the height limit to X blocks above the ground for flyers, 0 = Infinite [0-100]").defineInRange("flying height limit", 16, 0, 100);		
		Potion_Enable = BUILDER.comment("Adding new brewing recipe (existing property will be preserved). [false/true]").define("enable brewing recipe", true);
		Enchantment_Enable = BUILDER.comment("Adding new enchantment (existing property will be preserved). [false/true]").define("enable enchantment", true);
		Tinkers_Compat = BUILDER.comment("Adding new materials to Tinkers Construct. [false/true]").define("tinkers compatibility", false);
		Quark_Compat = BUILDER.comment("Add additional content that works with Quark. [false/true]").define("quark compatibility", false);
		SunScreen_Mode = BUILDER.comment("Mobs in this mod will not burn under daylight. [false/true]").define("sunscreen mode", false);	
		Spawn_AllowList = BUILDER.comment("All mobs are only allowed to spawn in these dimensions' IDs").defineList("mob spawn allow dimensions", 
				Lists.newArrayList(Dimension.OVERWORLD.location().toString(), Dimension.NETHER.location().toString(), Dimension.END.location().toString()), o -> o instanceof String);		
		Suicidal_Minion = BUILDER.comment("Entities summoned by other mobs die when their summoner dies. [false/true]").define("suicidal", true);
		BonusVillagerTrades = BUILDER.comment("Offers bonus Villager trades. [false/true]").define("bonus villager trades", true);
		BonusWanderingTraderTrades = BUILDER.comment("Offers bonus Wandering Trader trades. [false/true]").define("bonus wandering trader trades", true); 
		BUILDER.pop();
		
		SPEC = BUILDER.build();
	}
}
