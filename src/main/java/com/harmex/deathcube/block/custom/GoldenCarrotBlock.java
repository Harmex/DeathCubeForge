package com.harmex.deathcube.block.custom;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

/**
 * Unused.
 */
public class GoldenCarrotBlock extends CropBlock {
    // Crop state property
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

    public GoldenCarrotBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return Items.GOLDEN_CARROT;
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }
}
