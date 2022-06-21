package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModArmorMaterials;
import com.harmex.deathcube.item.ModCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmeraldArmorItem extends FullArmorItem {
    public EmeraldArmorItem(EquipmentSlot pSlot) {
        super(ModArmorMaterials.EMERALD, pSlot, new Item.Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_ARMOR_TAB)
        );
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.empty());
        pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor")
                .withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor.emerald")
                .withStyle(ChatFormatting.DARK_GREEN));
    }
}
