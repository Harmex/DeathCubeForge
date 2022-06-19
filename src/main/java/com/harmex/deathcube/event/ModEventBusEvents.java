package com.harmex.deathcube.event;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.recipe.MatterManipulatorRecipe;
import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeathCube.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    //@SubscribeEvent
    //public static void registerRecipeTypes() {
    //    Registry.register(Registry.RECIPE_TYPE_REGISTRY, MatterManipulatorRecipe.Type.ID, MatterManipulatorRecipe.Type.INSTANCE);
    //}
}
