package com.harmex.deathcube.datagen;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DeathCube.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.MATTER_MANIPULATOR.get());
        simpleBlock(ModBlocks.CHERRY_SAPLING.get(), models().cross(ModBlocks.CHERRY_SAPLING.getKey().location().getPath(),
                blockTexture(ModBlocks.CHERRY_SAPLING.get())));
        simpleBlock(ModBlocks.POTTED_CHERRY_SAPLING.get(),
                flowerPotCross(ModBlocks.POTTED_CHERRY_SAPLING.get(), ModBlocks.CHERRY_SAPLING.get()));
        simpleBlock(ModBlocks.CHERRY_LEAVES.get());
        logBlock((RotatedPillarBlock) ModBlocks.CHERRY_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.CHERRY_WOOD.get(),
                blockTexture(ModBlocks.CHERRY_LOG.get()), blockTexture(ModBlocks.CHERRY_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CHERRY_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CHERRY_WOOD.get(),
                blockTexture(ModBlocks.STRIPPED_CHERRY_LOG.get()), blockTexture(ModBlocks.STRIPPED_CHERRY_LOG.get()));
        simpleBlock(ModBlocks.CHERRY_PLANKS.get());

    }


    private ModelFile flowerPotCross(Block block, Block plant) {
        return flowerPotCross(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)),
                Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(plant)));
    }

    public ModelFile flowerPotCross(ResourceLocation block, ResourceLocation plant) {
        return models().withExistingParent(block.getPath(), "flower_pot_cross")
                .texture("plant", new ResourceLocation(block.getNamespace(), "block/" + plant.getPath()));
    }
}
