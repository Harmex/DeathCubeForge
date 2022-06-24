package com.harmex.deathcube.integration;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDeathCubePlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DeathCube.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new MatterManipulatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ShapedMatterManipulationRecipe> recipes = recipeManager.getAllRecipesFor(ShapedMatterManipulationRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MatterManipulatorRecipeCategory.UID, ShapedMatterManipulationRecipe.class), recipes);
    }
}
