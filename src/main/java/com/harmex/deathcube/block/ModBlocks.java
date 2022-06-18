package com.harmex.deathcube.block;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.custom.MatterManipulatorBlock;
import com.harmex.deathcube.block.entity.custom.MatterManipulatorBlockEntity;
import com.harmex.deathcube.item.ModCreativeModeTab;
import com.harmex.deathcube.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
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
            ), ModCreativeModeTab.DEATHCUBE_MISC_TAB);

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
            ), ModCreativeModeTab.DEATHCUBE_MISC_TAB);


    //Registering things
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
