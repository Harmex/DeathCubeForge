package com.harmex.deathcube.block;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.custom.*;
import com.harmex.deathcube.block.entity.ModWoodTypes;
import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.ModItems;
import com.harmex.deathcube.world.feature.tree.CherryTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DeathCube.MODID);


    public static final RegistryObject<Block> MATTER_MANIPULATOR = registerBlock("matter_manipulator",
            () -> new MatterManipulatorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> RESURRECTION_ALTAR = registerBlock("resurrection_altar",
            () -> new ResurrectionAltarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f)
                    .requiresCorrectToolForDrops()
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    //region Cherry Tree
    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling",
            () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = registerBlockWithoutBlockItem("potted_cherry_sapling",
            () -> new FlowerPotBlock(null, CHERRY_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)
            ));

    public static final RegistryObject<Block> CHERRY_LOG = registerBlock("cherry_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_WOOD = registerBlock("cherry_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);
    //endregion
    //region Cherry Furniture
    public static final RegistryObject<Block> CHERRY_SLAB = registerBlock("cherry_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_FENCE = registerBlock("cherry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_STAIRS = registerBlock("cherry_stairs",
            () -> new StairBlock(() -> ModBlocks.CHERRY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_BUTTON = registerBlock("cherry_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_DOOR = registerBlock("cherry_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)
            ), ModCreativeModeTab.DEATHCUBE_BLOCKS_TAB);

    public static final RegistryObject<Block> CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHERRY));

    public static final RegistryObject<Block> CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHERRY));
    //endregion

    //Registering things
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
