package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TotemOfResurrectionItem extends Item {
    public TotemOfResurrectionItem() {
        super(new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_MISC_TAB)
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
                .fireResistant()
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (!Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.deathcube.shift").withStyle(ChatFormatting.GRAY));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.deathcube.tor.0").withStyle(ChatFormatting.GRAY));
        }
    }
}
