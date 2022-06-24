package com.harmex.deathcube.integration;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MatterManipulatorRecipeCategory implements IRecipeCategory<ShapedMatterManipulationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(DeathCube.MODID, "matter_manipulation_shaped");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(DeathCube.MODID, "textures/gui/matter_manipulator_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MatterManipulatorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 148, 54);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MATTER_MANIPULATOR.get()));
    }

    @Override
    public @NotNull RecipeType<ShapedMatterManipulationRecipe> getRecipeType() {
        return new RecipeType<>(new ResourceLocation(DeathCube.MODID,
                ShapedMatterManipulationRecipe.Type.ID), ShapedMatterManipulationRecipe.class);
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("gui.jei.deathcube.category.matter_manipulation_shaped");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull ShapedMatterManipulationRecipe recipe, @Nonnull IFocusGroup focuses) {
        //for(int i = 0; i < 3; ++i) {
        //    for(int j = 0; j < 3; ++j) {
        //        if ((j + i * 3) >= recipe.getIngredients().size()) {
        //            builder.addSlot(RecipeIngredientRole.INPUT, 1 + j * 18, 1 + i * 18).addIngredients(Ingredient.EMPTY);
        //        } else {
        //            builder.addSlot(RecipeIngredientRole.INPUT, 1 + j * 18, 1 + i * 18).addIngredients(recipe.getIngredients().get(j + i * 3));
        //        }
        //    }
        //}
        for(int i = 0; i <= 3 - recipe.getWidth(); ++i) {
            for (int j = 0; j <= 3 - recipe.getHeight(); ++j) {
                this.addSlots(recipe, builder, i, j);
            }
        }

        builder.addSlot(RecipeIngredientRole.CATALYST, 73, 19).addItemStack(recipe.getExtraItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 127, 19).addItemStack(recipe.getResultItem());
    }

    private void addSlots(ShapedMatterManipulationRecipe pRecipe, IRecipeLayoutBuilder pBuilder, int pWidth, int pHeight) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                int k = i - pWidth;
                int l = j - pHeight;
                if (k >= 0 && l >= 0 && k < pRecipe.getWidth() && l < pRecipe.getHeight()) {
                    pBuilder.addSlot(RecipeIngredientRole.INPUT, 1 + k * 18, 1 + l * 18)
                            .addIngredients(pRecipe.getIngredients().get(k + l * pRecipe.getWidth()));
                }
            }
        }
    }
}
