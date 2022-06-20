package com.harmex.deathcube.datagen;

import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.item.ModItems;
import com.harmex.deathcube.util.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        //region Blocks
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHERRY_PLANKS.get(), 4)
                .requires(ModTags.Items.CHERRY_LOGS)
                .group("planks")
                .unlockedBy("has_cherry_logs", has(ModTags.Items.CHERRY_LOGS))
                .save(pFinishedRecipeConsumer);
        //endregion
        //region Foods
        ShapedRecipeBuilder.shaped(ModItems.TIME_GEM_APPLE.get())
                .define('#', ModItems.TIME_GEM.get())
                .define('X', Items.APPLE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_time_gem", has(ModItems.TIME_GEM.get()))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.DIAMOND_APPLE.get())
                .define('#', Items.DIAMOND)
                .define('X', Items.APPLE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.NETHERITE_APPLE.get())
                .define('#', Items.NETHERITE_INGOT)
                .define('X', Items.APPLE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BEDROCK_APPLE.get())
                .define('#', Items.BEDROCK)
                .define('X', Items.APPLE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_bedrock", has(Items.BEDROCK))
                .save(pFinishedRecipeConsumer);
        //endregion
        //region Copper Set
        ShapedRecipeBuilder.shaped(ModItems.COPPER_HELMET.get())
                .define('X', Items.COPPER_INGOT)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_CHESTPLATE.get())
                .define('X', Items.COPPER_INGOT)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_LEGGINGS.get())
                .define('X', Items.COPPER_INGOT)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_BOOTS.get())
                .define('X', Items.COPPER_INGOT)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_SWORD.get())
                .define('#', Items.STICK)
                .define('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_PICKAXE.get())
                .define('#', Items.STICK)
                .define('X', Items.COPPER_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_AXE.get())
                .define('#', Items.STICK)
                .define('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_SHOVEL.get())
                .define('#', Items.STICK)
                .define('X', Items.COPPER_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.COPPER_HOE.get())
                .define('#', Items.STICK)
                .define('X', Items.COPPER_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(pFinishedRecipeConsumer);
        //endregion
        //region Emerald Set
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_HELMET.get())
                .define('X', Items.EMERALD)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_CHESTPLATE.get())
                .define('X', Items.EMERALD)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_LEGGINGS.get())
                .define('X', Items.EMERALD)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_BOOTS.get())
                .define('X', Items.EMERALD)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_SWORD.get())
                .define('#', Items.STICK)
                .define('X', Items.EMERALD)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_PICKAXE.get())
                .define('#', Items.STICK)
                .define('X', Items.EMERALD)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_AXE.get())
                .define('#', Items.STICK)
                .define('X', Items.EMERALD)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_SHOVEL.get())
                .define('#', Items.STICK)
                .define('X', Items.EMERALD)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.EMERALD_HOE.get())
                .define('#', Items.STICK)
                .define('X', Items.EMERALD)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_emerald", has(Items.EMERALD))
                .save(pFinishedRecipeConsumer);
        //endregion
        //region Obsidian Set
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_HELMET.get())
                .define('X', Items.OBSIDIAN)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_CHESTPLATE.get())
                .define('X', Items.OBSIDIAN)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_LEGGINGS.get())
                .define('X', Items.OBSIDIAN)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_BOOTS.get())
                .define('X', Items.OBSIDIAN)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_SWORD.get())
                .define('#', Items.STICK)
                .define('X', Items.OBSIDIAN)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_PICKAXE.get())
                .define('#', Items.STICK)
                .define('X', Items.OBSIDIAN)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_AXE.get())
                .define('#', Items.STICK)
                .define('X', Items.OBSIDIAN)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_SHOVEL.get())
                .define('#', Items.STICK)
                .define('X', Items.OBSIDIAN)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_HOE.get())
                .define('#', Items.STICK)
                .define('X', Items.OBSIDIAN)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_emerald", has(Items.OBSIDIAN))
                .save(pFinishedRecipeConsumer);
        //endregion
    }
}
