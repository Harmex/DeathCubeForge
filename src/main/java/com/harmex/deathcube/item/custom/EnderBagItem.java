package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EnderBagItem extends Item {
    public EnderBagItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
        );
    }
}
