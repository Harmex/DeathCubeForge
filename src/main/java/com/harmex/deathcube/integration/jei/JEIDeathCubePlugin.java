package com.harmex.deathcube.integration.jei;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import com.harmex.deathcube.screen.MatterManipulatorMenu;
import com.harmex.deathcube.screen.ModMenuTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDeathCubePlugin implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(DeathCube.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new MatterManipulatorRecipeCategory(registration.getJeiHelpers().getGuiHelper(), 200));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ShapedMatterManipulationRecipe> recipes = recipeManager.getAllRecipesFor(ShapedMatterManipulationRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(MatterManipulatorRecipeCategory.UID, ShapedMatterManipulationRecipe.class), recipes);
    }

    @Override
    public void registerRecipeTransferHandlers(@NotNull IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(MatterManipulatorMenu.class, ModMenuTypes.MATTER_MANIPULATOR_MENU.get(),
                ModRecipeTypes.MATTER_MANIPULATION_SHAPED,
                0, 10, 11, 36);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MATTER_MANIPULATOR.get()),
                ModRecipeTypes.MATTER_MANIPULATION_SHAPED);
    }
}
