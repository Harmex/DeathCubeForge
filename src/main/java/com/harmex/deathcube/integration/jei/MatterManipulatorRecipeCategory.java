package com.harmex.deathcube.integration.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.recipe.ShapedMatterManipulationRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MatterManipulatorRecipeCategory implements IRecipeCategory<ShapedMatterManipulationRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(DeathCube.MODID, "matter_manipulation_shaped");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(DeathCube.MODID, "textures/gui/matter_manipulator_jei_gui.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    private final int regularManipulationTime;

    public MatterManipulatorRecipeCategory(IGuiHelper helper, int regularManipulationTime) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 148, 54);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MATTER_MANIPULATOR.get()));
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(23)
                .build(new CacheLoader<>() {
                    @Override
                    public @NotNull IDrawableAnimated load(@NotNull Integer manipulationTime) {
                        return helper.drawableBuilder(TEXTURE, 0, 148, 22, 16)
                                .buildAnimated(manipulationTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
        this.regularManipulationTime = regularManipulationTime;
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

    protected IDrawableAnimated getArrow(ShapedMatterManipulationRecipe recipe) {
        int manipulationTime = recipe.getManipulationTime();
        if (manipulationTime <= 0) {
            manipulationTime = regularManipulationTime;
        }
        return this.cachedArrows.getUnchecked(manipulationTime);
    }

    @Override
    public void draw(@NotNull ShapedMatterManipulationRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack stack, double mouseX, double mouseY) {
        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(stack, 95, 19);

        drawManipulationTime(recipe, stack, 45);
    }

    protected void drawManipulationTime(ShapedMatterManipulationRecipe recipe, PoseStack poseStack, int y) {
        int manipulationTime = recipe.getManipulationTime();
        if (manipulationTime > 0) {
            int ManipulationTimeSeconds = manipulationTime / 20;
            Component timeString = Component.translatable("gui.jei.deathcube.category.matter_manipulation_shaped.time.seconds", ManipulationTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(poseStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
        }
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull ShapedMatterManipulationRecipe recipe, @Nonnull IFocusGroup focuses) {
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
                            .addItemStack(pRecipe.getRecipeItemStacks().get(k + l * pRecipe.getWidth()));
                }
            }
        }
    }
}
