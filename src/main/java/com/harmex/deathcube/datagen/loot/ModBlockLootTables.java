package com.harmex.deathcube.datagen.loot;

import com.harmex.deathcube.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.MATTER_MANIPULATOR.get());


        this.dropSelf(ModBlocks.CHERRY_SAPLING.get());
        this.dropPottedContents(ModBlocks.POTTED_CHERRY_SAPLING.get());
        this.add(ModBlocks.CHERRY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ModBlocks.CHERRY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.CHERRY_PLANKS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
