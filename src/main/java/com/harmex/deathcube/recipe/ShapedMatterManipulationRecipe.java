package com.harmex.deathcube.recipe;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.harmex.deathcube.DeathCube;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class ShapedMatterManipulationRecipe implements Recipe<SimpleContainer> {
    static int MAX_WIDTH = 3;
    static int MAX_HEIGHT = 3;

    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<ItemStack> recipeItems;
    private final ItemStack extraItem;
    private CompoundTag extraItemTag = new CompoundTag();
    private final int width;
    private final int height;
    private final int manipulationTime;

    public ShapedMatterManipulationRecipe(ResourceLocation id, int width, int height, int manipulationTime,
                                          NonNullList<ItemStack> recipeItems,
                                          ItemStack extraItem, ItemStack result) {
        this.id = id;
        this.result = result;
        this.extraItem = extraItem;
        this.recipeItems = recipeItems;
        this.width = width;
        this.height = height;
        this.manipulationTime = manipulationTime;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return this.id;
    }

    public int getManipulationTime() {
        return this.manipulationTime;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        ItemStack resultWithTag = this.result.copy();
        resultWithTag.setTag(extraItemTag);
        return resultWithTag;
    }

    public NonNullList<ItemStack> getRecipeItemStacks() {
        return this.recipeItems;
    }

    public ItemStack getExtraItem() {
        return this.extraItem;
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth >= this.width && pHeight >= this.height;
    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        for(int i = 0; i <= 3 - this.width; ++i) {
            for (int j = 0; j <= 3 - this.height; ++j) {
                if (this.matches(pContainer, i, j, true)) {
                    this.extraItemTag = pContainer.getItem(9).getTag();
                    return true;
                }

                if (this.matches(pContainer, i, j, false)) {
                    this.extraItemTag = pContainer.getItem(9).getTag();
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(Container pContainer, int pWidth, int pHeight, boolean pMirrored) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                int k = i - pWidth;
                int l = j - pHeight;
                ItemStack recipeItem = ItemStack.EMPTY;
                if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
                    if (pMirrored) {
                        recipeItem = this.recipeItems.get(this.width - k - 1 + l * this.width);
                    } else {
                        recipeItem = this.recipeItems.get(k + l * this.width);
                    }
                }

                if (!recipeItem.getItem().equals(pContainer.getItem(i + j * 3).getItem())
                        || pContainer.getItem(i + j * 3).getCount() != 0
                        && recipeItem.getCount() > pContainer.getItem(i + j * 3).getCount()) {
                    return false;
                }
            }
        }

        return this.extraItem.getItem().equals(pContainer.getItem(9).getItem());
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SimpleContainer pContainer) {
        return this.result.copy();
    }

    static NonNullList<ItemStack> dissolvePattern(String[] pPattern, Map<String, ItemStack> pKeys, int pPatternWidth, int pPatternHeight) {
        NonNullList<ItemStack> pattern = NonNullList.withSize(pPatternWidth * pPatternHeight, ItemStack.EMPTY);
        Set<String> set = Sets.newHashSet(pKeys.keySet());
        set.remove(" ");

        for(int i = 0; i < pPattern.length; ++i) {
            for(int j = 0; j < pPattern[i].length(); ++j) {
                String s = pPattern[i].substring(j, j + 1);
                ItemStack itemStack = pKeys.get(s);
                if (itemStack == null) {
                    throw new JsonSyntaxException("Pattern references symbol '" + s + "' but it's not defined in the key");
                }

                set.remove(s);
                pattern.set(j + pPatternWidth * i, itemStack);
            }
        }

        if (!set.isEmpty()) {
            throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
        } else {
            return pattern;
        }
    }

    static String[] shrink(String... pToShrink) {
        int firstCharIndex = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;

        for(int i = 0; i < pToShrink.length; ++i) {
            String row = pToShrink[i];
            firstCharIndex = Math.min(firstCharIndex, firstNonSpace(row));
            int lastCharIndex = lastNonSpace(row);
            j = Math.max(j, lastCharIndex);
            if (lastCharIndex < 0) {
                if (k == i) {
                    ++k;
                }

                ++l;
            } else {
                l = 0;
            }
        }

        if (pToShrink.length == l) {
            return new String[0];
        } else {
            String[] shrunkPattern = new String[pToShrink.length - l - k];

            for(int k1 = 0; k1 < shrunkPattern.length; ++k1) {
                shrunkPattern[k1] = pToShrink[k1 + k].substring(firstCharIndex, j + 1);
            }

            return shrunkPattern;
        }
    }

    public boolean isIncomplete() {
        NonNullList<Ingredient> nonnulllist = this.getIngredients();
        return nonnulllist.isEmpty() || nonnulllist.stream().filter((p_151277_) -> {
            return !p_151277_.isEmpty();
        }).anyMatch((p_151273_) -> {
            return net.minecraftforge.common.ForgeHooks.hasNoElements(p_151273_);
        });
    }

    private static int firstNonSpace(String pEntry) {
        int i;
        for(i = 0; i < pEntry.length() && pEntry.charAt(i) == ' '; ++i) {
        }

        return i;
    }

    private static int lastNonSpace(String pEntry) {
        int i;
        for(i = pEntry.length() - 1; i >= 0 && pEntry.charAt(i) == ' '; --i) {
        }

        return i;
    }

    static String[] patternFromJson(JsonArray pPatternArray) {
        String[] pattern = new String[pPatternArray.size()];
        if (pattern.length > MAX_HEIGHT) {
            throw new JsonSyntaxException("Invalid pattern: too many rows, " + MAX_HEIGHT + " is maximum");
        } else if (pattern.length == 0) {
            throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
        } else {
            for(int i = 0; i < pattern.length; ++i) {
                String row = GsonHelper.convertToString(pPatternArray.get(i), "pattern[" + i + "]");
                if (row.length() > MAX_WIDTH) {
                    throw new JsonSyntaxException("Invalid pattern: too many columns, " + MAX_WIDTH + " is maximum");
                }

                if (i > 0 && pattern[0].length() != row.length()) {
                    throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                }

                pattern[i] = row;
            }

            return pattern;
        }
    }

    static Map<String, ItemStack> keyFromJson(JsonObject pKeyEntry) {
        Map<String, ItemStack> map = Maps.newHashMap();

        for(Map.Entry<String, JsonElement> entry : pKeyEntry.entrySet()) {
            if (entry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + entry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(entry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(entry.getKey(), itemStackFromJson(GsonHelper.getAsJsonObject(pKeyEntry, entry.getKey())));
        }

        map.put(" ", ItemStack.EMPTY);
        return map;
    }


    public static ItemStack itemStackFromJson(JsonObject pStackObject) {
        return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(pStackObject, true, true);
    }

    public static class Type implements RecipeType<ShapedMatterManipulationRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "matter_manipulation_shaped";
    }

    public static class Serializer implements RecipeSerializer<ShapedMatterManipulationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(DeathCube.MODID,"matter_manipulation_shaped");

        @Override
        public @NotNull ShapedMatterManipulationRecipe fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pJson) {
            //Get the ingredients linked to a key character
            Map<String, ItemStack> ingredientFromKey = ShapedMatterManipulationRecipe
                    .keyFromJson(GsonHelper.getAsJsonObject(pJson, "key"));

            //Get the shrunk pattern for the craft
            String[] pattern = ShapedMatterManipulationRecipe.shrink(ShapedMatterManipulationRecipe
                            .patternFromJson(GsonHelper.getAsJsonArray(pJson, "pattern")));

            //Get the width / height of the pattern
            int width = pattern[0].length();
            int height = pattern.length;

            //Get the list of the ingredients
            NonNullList<ItemStack> recipeItems = ShapedMatterManipulationRecipe
                    .dissolvePattern(pattern, ingredientFromKey, width, height);

            //Get the extra item
            ItemStack extraItem = ShapedMatterManipulationRecipe
                    .itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "extra"));

            //Get the result of the craft
            ItemStack result = ShapedMatterManipulationRecipe
                    .itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));

            //Get the time it takes to make the craft
            int manipulationTime = GsonHelper.getAsInt(pJson, "manipulationtime", 200);
            return new ShapedMatterManipulationRecipe(pRecipeId, width, height, manipulationTime,
                    recipeItems, extraItem, result);
        }

        @Override
        public ShapedMatterManipulationRecipe fromNetwork(@NotNull ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            //Get the width / height of the craft
            int width = pBuffer.readVarInt();
            int height = pBuffer.readVarInt();

            //Create a list for the ingredients
            NonNullList<ItemStack> recipeItems = NonNullList.withSize(width * height, ItemStack.EMPTY);

            //Put the ingredients in the list
            recipeItems.replaceAll(ignored -> pBuffer.readItem());

            //get the extra item
            ItemStack extraItem = pBuffer.readItem();

            //Get the result of the craft
            ItemStack result = pBuffer.readItem();

            //Get the time it takes to craft
            int manipulationTime = pBuffer.readVarInt();

            //Create the recipe
            return new ShapedMatterManipulationRecipe(pRecipeId, width, height, manipulationTime,
                    recipeItems, extraItem, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ShapedMatterManipulationRecipe pRecipe) {
            //Send the width / height
            pBuffer.writeVarInt(pRecipe.width);
            pBuffer.writeVarInt(pRecipe.height);

            //Send the ingredients
            for(ItemStack itemStack : pRecipe.recipeItems) {
                pBuffer.writeItem(itemStack);
            }

            //Send the extra item
            pBuffer.writeItem(pRecipe.extraItem);

            //Send the result
            pBuffer.writeItem(pRecipe.result);

            //Send the time it takes to craft
            pBuffer.writeVarInt(pRecipe.manipulationTime);
        }
    }
}
