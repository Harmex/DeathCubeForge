package com.harmex.deathcube.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DeathCubeClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for DeathCube");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
