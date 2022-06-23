package com.harmex.deathcube.item;

import com.harmex.deathcube.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DEATHCUBE_MISC_TAB = new CreativeModeTab("deathcube.misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TOTEM_OF_RESURRECTION.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_BLOCKS_TAB = new CreativeModeTab("deathcube.blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CHERRY_LEAVES.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_FOODS_TAB = new CreativeModeTab("deathcube.foods") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BEDROCK_APPLE.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_TOOLS_TAB = new CreativeModeTab("deathcube.tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EMERALD_AXE.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_ARMOR_TAB = new CreativeModeTab("deathcube.armors") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OBSIDIAN_CHESTPLATE.get());
        }
    };
}
