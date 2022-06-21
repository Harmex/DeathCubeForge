package com.harmex.deathcube;

import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.block.entity.ModBlockEntities;
import com.harmex.deathcube.item.ModItems;
import com.harmex.deathcube.painting.ModPaintings;
import com.harmex.deathcube.potion.ModPotions;
import com.harmex.deathcube.recipe.ModRecipes;
import com.harmex.deathcube.screen.MatterManipulatorScreen;
import com.harmex.deathcube.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DeathCube.MODID)
public class DeathCube {
    public static final String MODID = "deathcube";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DeathCube() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModPaintings.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModPotions.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHERRY_SAPLING.getId(), ModBlocks.POTTED_CHERRY_SAPLING);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.MATTER_MANIPULATOR_MENU.get(), MatterManipulatorScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.cutout());
    }
}
