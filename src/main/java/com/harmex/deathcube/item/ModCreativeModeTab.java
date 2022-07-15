package com.harmex.deathcube.item;

import com.harmex.deathcube.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModCreativeModeTab {
    public static final CreativeModeTab DEATHCUBE_MISC_TAB = new CreativeModeTab("deathcube.misc") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.TOTEM_OF_RESURRECTION.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_BLOCKS_TAB = new CreativeModeTab("deathcube.blocks") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CHERRY_LOG.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_FOODS_TAB = new CreativeModeTab("deathcube.foods") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.CHERRY.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_TOOLS_TAB = new CreativeModeTab("deathcube.tools") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_PICKAXE.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_ARMORS_TAB = new CreativeModeTab("deathcube.armors") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(ModItems.OBSIDIAN_CHESTPLATE.get());
        }
    };
}
