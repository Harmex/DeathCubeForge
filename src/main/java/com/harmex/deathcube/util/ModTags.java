package com.harmex.deathcube.util;


import com.harmex.deathcube.DeathCube;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CHERRY_LOGS =
                tag("cherry_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DeathCube.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CHERRY_LOGS =
                tag("cherry_logs");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DeathCube.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
