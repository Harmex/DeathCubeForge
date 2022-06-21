package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModArmorMaterials;
import com.harmex.deathcube.item.ModCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ObsidianArmorItem extends FullArmorItem {
    public ObsidianArmorItem(EquipmentSlot pSlot) {
        super(ModArmorMaterials.OBSIDIAN, pSlot, new Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_ARMOR_TAB)
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor")
                .withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor.obsidian")
                        .withStyle(ChatFormatting.DARK_GREEN));
    }
}
