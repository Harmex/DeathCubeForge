package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.config.DeathCubeCommonConfigs;
import com.harmex.deathcube.item.ModArmorMaterials;
import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.ModRarities;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class EmeraldArmorItem extends ArmorItem {
    private static final MobEffectInstance fullSuitEffect =
            new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 20, 0,
                    true, false, true);

    public EmeraldArmorItem(EquipmentSlot pSlot) {
        super(ModArmorMaterials.EMERALD, pSlot, new Item.Properties()
                .tab(ModCreativeModeTab.DEATHCUBE_ARMOR_TAB)
                .rarity(ModRarities.EMERALD)
        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if (DeathCubeCommonConfigs.OBSIDIAN_ARMOR_EFFECT.get()) {
            pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor")
                    .withStyle(ChatFormatting.GRAY));
            pTooltipComponents.add(Component.translatable("tooltip.deathcube.full_armor.emerald")
                    .withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (hasFullSuitOn(player)) {
            if (DeathCubeCommonConfigs.EMERALD_ARMOR_EFFECT.get()) {
                fullSuitEffect(player);
            }
            if (DeathCubeCommonConfigs.EMERALD_ARMOR_DECAY.get()) {
                damageArmor(player);
            }
        }
    }

    private boolean hasFullSuitOn(Player player) {
        for (int i = 0; i < 4; i++) {
            if (!(player.getInventory().getArmor(i).getItem() instanceof EmeraldArmorItem)) {
                return false;
            }
        }
        return true;
    }

    private void fullSuitEffect(Player player) {
        if(!player.hasEffect(fullSuitEffect.getEffect())) {
            player.addEffect(fullSuitEffect);
        }
    }

    private void damageArmor(Player player) {
        if (!player.isCreative() && !player.isSpectator()) {
            if(new Random().nextFloat() < 0.01f) {
                player.getInventory().hurtArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            }
        }
    }
}
