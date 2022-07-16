package com.harmex.deathcube.datagen.loot;

import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.block.custom.GoldenCarrotCropBlock;
import com.harmex.deathcube.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModBlockLootTables extends BlockLoot {
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] NORMAL_LEAVES_FRUIT_CHANCES = new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F};

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.ECHO_AMETHYST_BLOCK.get());
        this.dropSelf(ModBlocks.MATTER_MANIPULATOR.get());
        this.dropSelf(ModBlocks.RESURRECTION_ALTAR.get());

        LootItemCondition.Builder goldenCarrotsLootCondition =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOLDEN_CARROT_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldenCarrotCropBlock.AGE, 7));
        this.add(ModBlocks.GOLDEN_CARROT_CROP.get(),
                applyExplosionDecay(ModBlocks.GOLDEN_CARROT_CROP.get(), LootTable.lootTable()
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.GOLDEN_CARROT)))
                        .withPool(LootPool.lootPool().when(goldenCarrotsLootCondition).add(LootItem.lootTableItem(Items.GOLDEN_CARROT)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))));

        this.dropSelf(ModBlocks.CHERRY_PLANKS.get());
        this.dropSelf(ModBlocks.CHERRY_SAPLING.get());
        this.dropPottedContents(ModBlocks.POTTED_CHERRY_SAPLING.get());
        this.add(ModBlocks.CHERRY_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES)
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                                .add(applyExplosionCondition(block, LootItem.lootTableItem(ModItems.CHERRY.get()))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                                NORMAL_LEAVES_FRUIT_CHANCES)))));
        this.dropSelf(ModBlocks.CHERRY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.CHERRY_WOOD.get());
        this.add(ModBlocks.CHERRY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.CHERRY_FENCE.get());
        this.dropSelf(ModBlocks.CHERRY_STAIRS.get());
        this.dropSelf(ModBlocks.CHERRY_BUTTON.get());
        this.dropSelf(ModBlocks.CHERRY_PRESSURE_PLATE.get());
        this.add(ModBlocks.CHERRY_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(ModBlocks.CHERRY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CHERRY_FENCE_GATE.get());
        this.dropOther(ModBlocks.CHERRY_SIGN.get(), ModItems.CHERRY_SIGN.get());
        this.dropOther(ModBlocks.CHERRY_WALL_SIGN.get(), ModItems.CHERRY_SIGN.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
