package com.harmex.deathcube.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DEATHCUBE_MISC_TAB = new CreativeModeTab("deathcube_misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TOTEM_OF_RESURRECTION.get());
        }
    };

    public static final CreativeModeTab DEATHCUBE_TOOLS_TAB = new CreativeModeTab("deathcube_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.COPPER_AXE.get());
        }
    };
}
