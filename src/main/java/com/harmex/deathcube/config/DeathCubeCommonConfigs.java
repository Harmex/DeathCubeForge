package com.harmex.deathcube.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeathCubeCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> APPLES_TEMP_HEALTH;

    static {
        BUILDER.push("Configs for DeathCube");

        APPLES_TEMP_HEALTH = BUILDER.comment("Wether or not should special apples give temporary health boost.")
                .define("Apples Temporary Health", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
