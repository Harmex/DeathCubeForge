package com.harmex.deathcube.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHERRY = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.1F)
            .build();
    public static final FoodProperties TIME_GEM_APPLE = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000, 0), 1.0f)
            .alwaysEat()
            .build();
    public static final FoodProperties DIAMOND_APPLE = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000, 0), 1.0f)
            .alwaysEat()
            .build();
    public static final FoodProperties NETHERITE_APPLE = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000, 1), 1.0f)
            .alwaysEat()
            .build();
    public static final FoodProperties BEDROCK_APPLE = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0f)
            .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 12000, 2), 1.0f)
            .alwaysEat()
            .build();

}
