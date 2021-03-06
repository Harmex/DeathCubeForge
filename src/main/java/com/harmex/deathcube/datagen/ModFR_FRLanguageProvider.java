package com.harmex.deathcube.datagen;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModFR_FRLanguageProvider extends LanguageProvider {
    public ModFR_FRLanguageProvider(DataGenerator gen, String locale) {
        super(gen, DeathCube.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + DeathCube.MODID + ".misc", "DeathCube | Divers");
        add("itemGroup." + DeathCube.MODID + ".blocks", "DeathCube | Blocs");
        add("itemGroup." + DeathCube.MODID + ".tools", "DeathCube | Outils");
        add("itemGroup." + DeathCube.MODID + ".armors", "DeathCube | Armures");
        add("itemGroup." + DeathCube.MODID + ".foods", "DeathCube | Nourritures");

        add("container." + DeathCube.MODID + ".upgrading_station", "Station d'amélioration");
        add("container." + DeathCube.MODID + ".matter_manipulator", "Manipulateur de matière");
        add("container." + DeathCube.MODID + ".resurrection_altar", "Autel de résurrection");

        add(ModItems.GALTERIUS_SPAWN_EGG.get(), "Oeuf d'apparition de Galterius");

        add(ModBlocks.CHERRY_PLANKS.get(), "Planches de cerisier");
        add(ModBlocks.CHERRY_SAPLING.get(), "Pousse de cerisier");
        add(ModBlocks.CHERRY_LOG.get(), "Bûche de cerisier");
        add(ModBlocks.STRIPPED_CHERRY_LOG.get(), "Bûche de cerisier écorcé");
        add(ModBlocks.STRIPPED_CHERRY_WOOD.get(), "Bois de cerisier écorcé");
        add(ModBlocks.CHERRY_WOOD.get(), "Bois de cerisier");
        add(ModBlocks.CHERRY_LEAVES.get(), "Feuilles de cerisier");
        add(ModBlocks.CHERRY_SLAB.get(), "Dalle en cerisier");
        add(ModBlocks.CHERRY_FENCE.get(), "Barrière en cerisier");
        add(ModBlocks.CHERRY_STAIRS.get(), "Escalier en cerisier");
        add(ModBlocks.CHERRY_BUTTON.get(), "Bouton en cerisier");
        add(ModBlocks.CHERRY_PRESSURE_PLATE.get(), "Plaque de pression en cerisier");
        add(ModBlocks.CHERRY_DOOR.get(), "Porte en cerisier");
        add(ModBlocks.CHERRY_TRAPDOOR.get(), "Trappe en cerisier");
        add(ModBlocks.CHERRY_FENCE_GATE.get(), "Portillon en cerisier");
        add(ModBlocks.CHERRY_SIGN.get(), "Pancarte en cerisier");

        add(ModBlocks.ECHO_AMETHYST_BLOCK.get(), "Bloc d'écho-améthyste");
        add(ModBlocks.UPGRADING_STATION.get(), "Station d'amélioration");
        add(ModBlocks.MATTER_MANIPULATOR.get(), "Manipulateur de matière");
        add(ModBlocks.RESURRECTION_ALTAR.get(), "Autel de résurrection");

        add(ModBlocks.ZANTHINE_ORE.get(), "Minerai de zanthine");
        add(ModBlocks.DEEPSLATE_ZANTHINE_ORE.get(), "Minerai de zanthine des abîmes");
        add(ModItems.ZANTHINE.get(), "Zanthine");

        add(ModItems.FRESH_WATER_BOTTLE.get(), "Fiole d'eau potable");
        add(ModItems.CHERRY.get(), "Cerise");
        add(ModItems.TIME_GEM_APPLE.get(), "Pomme en gemme du temps");
        add(ModItems.DIAMOND_APPLE.get(), "Pomme en diamant");
        add(ModItems.NETHERITE_APPLE.get(), "Pomme en Netherite");
        add(ModItems.BEDROCK_APPLE.get(), "Pomme en Bedrock");

        add(ModItems.TIME_GEM.get(), "Gemme du temps");
        add(ModItems.ECHO_AMETHYST_SHARD.get(), "Éclat d'écho-améthyste");
        add(ModItems.ECHO_AMETHYST_INGOT.get(), "Lingot d'écho-améthyste");
        add(ModItems.WARDEN_HEART.get(), "Coeur de Warden");
        add(ModItems.ENDER_DRAGON_SCALE.get(), "Écaille d'Ender Dragon");
        add(ModItems.TIME_WAND.get(), "Baguette du temps");
        add(ModItems.SMALL_BAG.get(), "Petit sac");
        add(ModItems.ENDER_BAG.get(), "Sac de l'Ender");
        add(ModItems.TOTEM_OF_RESURRECTION.get(), "Totem de résurrection");
        add(ModItems.OAK_HELMET.get(), "Casque en chêne");
        add(ModItems.OAK_CHESTPLATE.get(), "Plastron en chêne");
        add(ModItems.OAK_LEGGINGS.get(), "Jambières en chêne");
        add(ModItems.OAK_BOOTS.get(), "Bottes en chêne");
        add(ModItems.SPRUCE_HELMET.get(), "Casque en sapin");
        add(ModItems.SPRUCE_CHESTPLATE.get(), "Plastron en sapin");
        add(ModItems.SPRUCE_LEGGINGS.get(), "Jambières en sapin");
        add(ModItems.SPRUCE_BOOTS.get(), "Bottes en sapin");
        add(ModItems.BIRCH_HELMET.get(), "Casque en bouleau");
        add(ModItems.BIRCH_CHESTPLATE.get(), "Plastron en bouleau");
        add(ModItems.BIRCH_LEGGINGS.get(), "Jambières en bouleau");
        add(ModItems.BIRCH_BOOTS.get(), "Bottes en bouleau");
        add(ModItems.JUNGLE_HELMET.get(), "Casque en acajou");
        add(ModItems.JUNGLE_CHESTPLATE.get(), "Plastron en acajou");
        add(ModItems.JUNGLE_LEGGINGS.get(), "Jambières en acajou");
        add(ModItems.JUNGLE_BOOTS.get(), "Bottes en acajou");
        add(ModItems.ACACIA_HELMET.get(), "Casque en acacia");
        add(ModItems.ACACIA_CHESTPLATE.get(), "Plastron en acacia");
        add(ModItems.ACACIA_LEGGINGS.get(), "Jambières en acacia");
        add(ModItems.ACACIA_BOOTS.get(), "Bottes en acacia");
        add(ModItems.DARK_OAK_HELMET.get(), "Casque en chêne noir");
        add(ModItems.DARK_OAK_CHESTPLATE.get(), "Plastron en chêne noir");
        add(ModItems.DARK_OAK_LEGGINGS.get(), "Jambières en chêne noir");
        add(ModItems.DARK_OAK_BOOTS.get(), "Bottes en chêne noir");
        add(ModItems.MANGROVE_HELMET.get(), "Casque en palétuvier");
        add(ModItems.MANGROVE_CHESTPLATE.get(), "Plastron en palétuvier");
        add(ModItems.MANGROVE_LEGGINGS.get(), "Jambières en palétuvier");
        add(ModItems.MANGROVE_BOOTS.get(), "Bottes en palétuvier");
        add(ModItems.CHERRY_HELMET.get(), "Casque en cerisier");
        add(ModItems.CHERRY_CHESTPLATE.get(), "Plastron en cerisier");
        add(ModItems.CHERRY_LEGGINGS.get(), "Jambières en cerisier");
        add(ModItems.CHERRY_BOOTS.get(), "Bottes en cerisier");
        add(ModItems.CRIMSON_HELMET.get(), "Casque carmin");
        add(ModItems.CRIMSON_CHESTPLATE.get(), "Plastron carmin");
        add(ModItems.CRIMSON_LEGGINGS.get(), "Jambières carmin");
        add(ModItems.CRIMSON_BOOTS.get(), "Bottes carmin");
        add(ModItems.WARPED_HELMET.get(), "Casque biscornu");
        add(ModItems.WARPED_CHESTPLATE.get(), "Plastron biscornu");
        add(ModItems.WARPED_LEGGINGS.get(), "Jambières biscornues");
        add(ModItems.WARPED_BOOTS.get(), "Bottes biscornues");
        add(ModItems.BONE_HELMET.get(), "Casque en os");
        add(ModItems.BONE_CHESTPLATE.get(), "Plastron en os");
        add(ModItems.BONE_LEGGINGS.get(), "Jambières en os");
        add(ModItems.BONE_BOOTS.get(), "Bottes en os");
        add(ModItems.BONE_SWORD.get(), "Épée en os");
        add(ModItems.BONE_PICKAXE.get(), "Pioche en os");
        add(ModItems.BONE_AXE.get(), "Hache en os");
        add(ModItems.BONE_SHOVEL.get(), "Pelle en os");
        add(ModItems.BONE_HOE.get(), "Houe en os");
        add(ModItems.COPPER_HELMET.get(), "Casque en cuivre");
        add(ModItems.COPPER_CHESTPLATE.get(), "Plastron en cuivre");
        add(ModItems.COPPER_LEGGINGS.get(), "Jambières en cuivre");
        add(ModItems.COPPER_BOOTS.get(), "Bottes en cuivre");
        add(ModItems.COPPER_SWORD.get(), "Épée en cuivre");
        add(ModItems.COPPER_PICKAXE.get(), "Pioche en cuivre");
        add(ModItems.COPPER_AXE.get(), "Hache en cuivre");
        add(ModItems.COPPER_SHOVEL.get(), "Pelle en cuivre");
        add(ModItems.COPPER_HOE.get(), "Houe en cuivre");
        add(ModItems.EMERALD_HELMET.get(), "Casque en émeraude");
        add(ModItems.EMERALD_CHESTPLATE.get(), "Plastron en émeraude");
        add(ModItems.EMERALD_LEGGINGS.get(), "Jambières en émeraude");
        add(ModItems.EMERALD_BOOTS.get(), "Bottes en émeraude");
        add(ModItems.EMERALD_SWORD.get(), "Épée en émeraude");
        add(ModItems.EMERALD_PICKAXE.get(), "Pioche en émeraude");
        add(ModItems.EMERALD_AXE.get(), "Hache en émeraude");
        add(ModItems.EMERALD_SHOVEL.get(), "Pelle en émeraude");
        add(ModItems.EMERALD_HOE.get(), "Houe en émeraude");
        add(ModItems.OBSIDIAN_HELMET.get(), "Casque en obsidienne");
        add(ModItems.OBSIDIAN_CHESTPLATE.get(), "Plastron en obsidienne");
        add(ModItems.OBSIDIAN_LEGGINGS.get(), "Jambières en obsidienne");
        add(ModItems.OBSIDIAN_BOOTS.get(), "Bottes en obsidienne");
        add(ModItems.OBSIDIAN_SWORD.get(), "Épée en obsidienne");
        add(ModItems.OBSIDIAN_PICKAXE.get(), "Pioche en obsidienne");
        add(ModItems.OBSIDIAN_AXE.get(), "Hache en obsidienne");
        add(ModItems.OBSIDIAN_SHOVEL.get(), "Pelle en obsidienne");
        add(ModItems.OBSIDIAN_HOE.get(), "Houe en obsidienne");
    }
}
