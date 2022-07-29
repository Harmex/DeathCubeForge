package com.harmex.deathcube.world.feature;

import com.google.common.collect.ImmutableList;
import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DeathCube.MODID);

    public static final RegistryObject<PlacedFeature> ZANTHINE_ORE_PLACED =
            PLACED_FEATURES.register("zanthine_ore_placed", () -> new PlacedFeature(
                    ModConfiguredFeatures.ZANTHINE_ORE.getHolder().get(),
                    commonOrePlacement(7, HeightRangePlacement
                            .triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))
            ));

    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);
    public static final RegistryObject<PlacedFeature> CHERRY_CHECKED =
            PLACED_FEATURES.register("cherry_checked", () -> new PlacedFeature(
                    ModConfiguredFeatures.CHERRY_TREE.getHolder().get(),
                    treePlacement(PlacementUtils.filteredByBlockSurvival(ModBlocks.CHERRY_SAPLING.get()))
            ));

    public static final RegistryObject<PlacedFeature> CHERRY_PLACED =
            PLACED_FEATURES.register("cherry_placed", () -> new PlacedFeature(
                    ModConfiguredFeatures.CHERRY_TREE.getHolder().get(),
                    treePlacement(
                            PlacementUtils.countExtra(0 /*per chunk*/, 0.01F /*addition chance*/, 1 /* addition number*/),
                            ModBlocks.CHERRY_SAPLING.get()
                    )
            ));


    public static List<PlacementModifier> orePlacement(PlacementModifier pRarity, PlacementModifier pLayers) {
        return List.of(pRarity, InSquarePlacement.spread(), pLayers, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pVeinsPerChunk, PlacementModifier pLayers) {
        return orePlacement(CountPlacement.of(pVeinsPerChunk), pLayers);
    }

    public static List<PlacementModifier> rareOrePlacement(int pOnceEveryXChunk, PlacementModifier pLayers) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pOnceEveryXChunk), pLayers);
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier pPlacementModifier) {
        return ImmutableList.<PlacementModifier>builder().add(pPlacementModifier).add(InSquarePlacement.spread()).add(TREE_THRESHOLD)
                .add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier pPlacementModifier) {
        return treePlacementBase(pPlacementModifier).build();
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier pPlacementModifier, Block pBlockWouldSurvive) {
        return treePlacementBase(pPlacementModifier).add(BlockPredicateFilter
                .forPredicate(BlockPredicate.wouldSurvive(pBlockWouldSurvive.defaultBlockState(), BlockPos.ZERO))).build();
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
