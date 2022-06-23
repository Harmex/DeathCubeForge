package com.harmex.deathcube.recipe;

import com.harmex.deathcube.DeathCube;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DeathCube.MODID);


    public static final RegistryObject<RecipeSerializer<ShapedMatterManipulationRecipe>> SHAPED_MATTER_MANIPULATION_SERIALIZER =
            SERIALIZERS.register("matter_manipulation_shaped",
                    () -> ShapedMatterManipulationRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
