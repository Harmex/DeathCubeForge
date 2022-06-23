package com.harmex.deathcube.item.custom;

import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.ModItems;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class AppleItem extends Item {
    public AppleItem(Properties pProperties) {
        super(pProperties.tab(ModCreativeModeTab.DEATHCUBE_FOODS_TAB));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        ItemStack itemStack = super.finishUsingItem(pStack, pLevel, pLivingEntity);
        if (pStack.getItem() == ModItems.DIAMOND_APPLE.get()) {
            if (pLivingEntity.getMaxHealth() >= 26) {
                return itemStack;
            } else {
                int random = Mth.randomBetweenInclusive(RandomSource.create(), 0, 100);
                if (random <= 20) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 2.0);
                }
            }
        }

        if (pStack.getItem() == ModItems.NETHERITE_APPLE.get()) {
            if (pLivingEntity.getMaxHealth() >= 32) {
                return itemStack;
            } else {
                int random = Mth.randomBetweenInclusive(RandomSource.create(), 0, 100);
                if (random <= 20 && pLivingEntity.getMaxHealth() <= 28) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 4.0);
                } else if (random <= 40) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 2.0);
                }
            }
        }

        if (pStack.getItem() == ModItems.BEDROCK_APPLE.get()) {
            if (pLivingEntity.getMaxHealth() >= 40) {
                return itemStack;
            } else {
                int random = Mth.randomBetweenInclusive(RandomSource.create(), 0, 100);
                if (random <= 20 && pLivingEntity.getMaxHealth() <= 34) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 6.0);
                } else if (random <= 40 && pLivingEntity.getMaxHealth() <= 38) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 4.0);
                } else if (random <= 60) {
                    Objects.requireNonNull(pLivingEntity.getAttribute(Attributes.MAX_HEALTH))
                            .setBaseValue(pLivingEntity.getMaxHealth() + 2.0);
                }
            }
        }
        return itemStack;
    }
}
