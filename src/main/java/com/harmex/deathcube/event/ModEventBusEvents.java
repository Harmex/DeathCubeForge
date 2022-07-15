package com.harmex.deathcube.event;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.entity.ModEntityTypes;
import com.harmex.deathcube.entity.galterius.GalteriusEntity;
//import com.harmex.deathcube.event.loot.EnderDragonScaleFromEnderDragonAdditionModifier;
//import com.harmex.deathcube.event.loot.WardenHeartFromWardenAdditionModifier;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = DeathCube.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    // TODO : registration des loot modifiers
    @SubscribeEvent
    public static void registerEvent(final RegisterEvent event) {
        /*event.register(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, helper -> {
            helper.register(new ResourceLocation(DeathCube.MODID, "ender_dragon_scale_from_ender_dragon"),
                    new EnderDragonScaleFromEnderDragonAdditionModifier.Serializer());
            helper.register(new ResourceLocation(DeathCube.MODID, "warden_heart_from_warden"),
                    new WardenHeartFromWardenAdditionModifier.Serializer());
        });*/

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(DeathCube.MODID, ShapedMatterManipulationRecipe.Type.ID),
                    ShapedMatterManipulationRecipe.Type.INSTANCE);
        });
    }

    @SubscribeEvent
    public static void onCreateAttribute(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.GALTERIUS_ENTITY.get(), GalteriusEntity.createAttributes().build());
    }
}
