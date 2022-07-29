package com.harmex.deathcube.world.feature.tree;

import com.harmex.deathcube.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CherryTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource p_222910_, boolean p_222911_) {
        return ModPlacedFeatures.CHERRY_CHECKED.get().feature();
    }
}
