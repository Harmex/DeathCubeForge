package com.harmex.deathcube.block.entity;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.block.ModBlocks;
import com.harmex.deathcube.block.entity.custom.MatterManipulatorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, DeathCube.MODID);


    public static final RegistryObject<BlockEntityType<MatterManipulatorBlockEntity>> MATTER_MANIPULATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("matter_manipulator_block_entity",
                    () -> BlockEntityType.Builder.of(MatterManipulatorBlockEntity::new,
                            ModBlocks.MATTER_MANIPULATOR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
