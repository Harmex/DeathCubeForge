package com.harmex.deathcube.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeathCubeCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> APPLES_TEMP_HEALTH;
    public static final ForgeConfigSpec.ConfigValue<Boolean> EMERALD_ARMOR_EFFECT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> EMERALD_ARMOR_DECAY;
    public static final ForgeConfigSpec.ConfigValue<Boolean> OBSIDIAN_ARMOR_EFFECT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> OBSIDIAN_ARMOR_DECAY;

    static {
        BUILDER.push("Configs for DeathCube");

        APPLES_TEMP_HEALTH = BUILDER.comment("Should special apples give temporary health boost ?")
                .define("Apples Temporary Health", true);
        EMERALD_ARMOR_EFFECT = BUILDER.comment("Should the Emerald Armor have the Hero of the Village effect ?")
                .define("Emerald Armor Effect", true);
        EMERALD_ARMOR_DECAY = BUILDER.comment("Should the Emerald Armor decay overtime ?")
                .define("Emerald Armor Decay", true);
        OBSIDIAN_ARMOR_EFFECT = BUILDER.comment("Should the Obsidian Armor have the Fire Resistance effect ?")
                .define("Obsidian Armor Effect", true);
        OBSIDIAN_ARMOR_DECAY = BUILDER.comment("Should the Obsidian Armor decay overtime ?")
                .define("Obsidian Armor Decay", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
