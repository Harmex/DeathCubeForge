package com.harmex.deathcube.event;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.event.loot.EnderDragonScaleFromEnderDragonAdditionModifier;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = DeathCube.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerEvent(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(DeathCube.MODID, "ender_dragon_scale_from_ender_dragon"),
                    new EnderDragonScaleFromEnderDragonAdditionModifier.Serializer());
        });

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(DeathCube.MODID, ShapedMatterManipulationRecipe.Type.ID),
                    ShapedMatterManipulationRecipe.Type.INSTANCE);
        });
    }
}
