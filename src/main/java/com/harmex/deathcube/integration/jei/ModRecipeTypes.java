package com.harmex.deathcube.integration.jei;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import mezz.jei.api.recipe.RecipeType;

public class ModRecipeTypes {
    public static final RecipeType<ShapedMatterManipulationRecipe> MATTER_MANIPULATION_SHAPED =
            RecipeType.create(DeathCube.MODID, "matter_manipulation_shaped", ShapedMatterManipulationRecipe.class);
}
