package com.harmex.deathcube.datagen;

import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.item.ModItems;
import com.harmex.deathcube.util.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        //region Apples
        applesRecipes(pFinishedRecipeConsumer,
                ModItems.TIME_GEM_APPLE.get(),
                ModItems.TIME_GEM.get(),
                "has_time_gem");
        applesRecipes(pFinishedRecipeConsumer,
                ModItems.DIAMOND_APPLE.get(),
                Items.DIAMOND,
                "has_diamond");
        applesRecipes(pFinishedRecipeConsumer,
                ModItems.NETHERITE_APPLE.get(),
                Items.NETHERITE_INGOT,
                "has_netherite_ingot");
        applesRecipes(pFinishedRecipeConsumer,
                ModItems.BEDROCK_APPLE.get(),
                Items.BEDROCK,
                "has_bedrock");
        //endregion

        //region Tools & Armors
        toolAndArmorRecipes(pFinishedRecipeConsumer,
                ModItems.BONE_HELMET.get(),
                ModItems.BONE_CHESTPLATE.get(),
                ModItems.BONE_LEGGINGS.get(),
                ModItems.BONE_BOOTS.get(),
                ModItems.BONE_SWORD.get(),
                ModItems.BONE_PICKAXE.get(),
                ModItems.BONE_AXE.get(),
                ModItems.BONE_SHOVEL.get(),
                ModItems.BONE_HOE.get(),
                Items.BONE,
                "has_bone");
        toolAndArmorRecipes(pFinishedRecipeConsumer,
                ModItems.COPPER_HELMET.get(),
                ModItems.COPPER_CHESTPLATE.get(),
                ModItems.COPPER_LEGGINGS.get(),
                ModItems.COPPER_BOOTS.get(),
                ModItems.COPPER_SWORD.get(),
                ModItems.COPPER_PICKAXE.get(),
                ModItems.COPPER_AXE.get(),
                ModItems.COPPER_SHOVEL.get(),
                ModItems.COPPER_HOE.get(),
                Items.COPPER_INGOT,
                "has_copper_ingot");
        toolAndArmorRecipes(pFinishedRecipeConsumer,
                ModItems.EMERALD_HELMET.get(),
                ModItems.EMERALD_CHESTPLATE.get(),
                ModItems.EMERALD_LEGGINGS.get(),
                ModItems.EMERALD_BOOTS.get(),
                ModItems.EMERALD_SWORD.get(),
                ModItems.EMERALD_PICKAXE.get(),
                ModItems.EMERALD_AXE.get(),
                ModItems.EMERALD_SHOVEL.get(),
                ModItems.EMERALD_HOE.get(),
                Items.EMERALD,
                "has_emerald");
        toolAndArmorRecipes(pFinishedRecipeConsumer,
                ModItems.OBSIDIAN_HELMET.get(),
                ModItems.OBSIDIAN_CHESTPLATE.get(),
                ModItems.OBSIDIAN_LEGGINGS.get(),
                ModItems.OBSIDIAN_BOOTS.get(),
                ModItems.OBSIDIAN_SWORD.get(),
                ModItems.OBSIDIAN_PICKAXE.get(),
                ModItems.OBSIDIAN_AXE.get(),
                ModItems.OBSIDIAN_SHOVEL.get(),
                ModItems.OBSIDIAN_HOE.get(),
                Items.OBSIDIAN,
                "has_obsidian");
        //endregion

        //region Armors
        armorRecipes(pFinishedRecipeConsumer,
                ModItems.OAK_HELMET.get(),
                ModItems.OAK_CHESTPLATE.get(),
                ModItems.OAK_LEGGINGS.get(),
                ModItems.OAK_BOOTS.get(),
                Items.OAK_LOG,
                "has_oak_log");
        //endregion

        shapedRecipes(pFinishedRecipeConsumer);
        shapelessRecipes(pFinishedRecipeConsumer);
    }

    private void applesRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                               Item result, Item ingredient, String unlockCondition) {
        ShapedRecipeBuilder.shaped(result)
                .define('#', ingredient)
                .define('X', Items.APPLE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
    }

    private void toolAndArmorRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     Item helmet, Item chestplate, Item leggings, Item boots, Item sword, Item pickaxe,
                                     Item axe, Item shovel, Item hoe, Item ingredient, String unlockCondition) {
        ShapedRecipeBuilder.shaped(helmet)
                .define('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(chestplate)
                .define('X', ingredient)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(leggings)
                .define('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(boots)
                .define('X', ingredient)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(sword)
                .define('#', Items.STICK)
                .define('X', ingredient)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(pickaxe)
                .define('#', Items.STICK)
                .define('X', ingredient)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(axe)
                .define('#', Items.STICK)
                .define('X', ingredient)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(shovel)
                .define('#', Items.STICK)
                .define('X', ingredient)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(hoe)
                .define('#', Items.STICK)
                .define('X', ingredient)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);

    }


    private void armorRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                     Item helmet, Item chestplate, Item leggings, Item boots,
                                     Item ingredient, String unlockCondition) {
        ShapedRecipeBuilder.shaped(helmet)
                .define('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(chestplate)
                .define('X', ingredient)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(leggings)
                .define('X', ingredient)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(boots)
                .define('X', ingredient)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy(unlockCondition, has(ingredient))
                .save(pFinishedRecipeConsumer);

    }

    private void shapedRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        //Time Wand
        ShapedRecipeBuilder.shaped(ModItems.TIME_WAND.get())
                .define('D', Items.DIAMOND)
                .define('T', ModItems.TIME_GEM.get())
                .define('#', Items.STICK)
                .define('E', Items.EMERALD)
                .pattern("DTD")
                .pattern(" # ")
                .pattern(" E ")
                .unlockedBy("has_time_gem", has(ModItems.TIME_GEM.get()))
                .save(pFinishedRecipeConsumer);

        //Ender Bag
        ShapedRecipeBuilder.shaped(ModItems.ENDER_BAG.get())
                .define('#', Items.OBSIDIAN)
                .define('T', ModItems.TIME_GEM.get())
                .define('E', Items.ENDER_CHEST)
                .pattern("###")
                .pattern("TET")
                .pattern("###")
                .unlockedBy("has_time_gem", has(ModItems.TIME_GEM.get()))
                .save(pFinishedRecipeConsumer);
    }
    private void shapelessRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        //Cherry Planks from Wood
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHERRY_PLANKS.get(), 4)
                .requires(ModTags.Items.CHERRY_LOGS)
                .group("planks")
                .unlockedBy("has_cherry_logs", has(ModTags.Items.CHERRY_LOGS))
                .save(pFinishedRecipeConsumer);
    }
}
