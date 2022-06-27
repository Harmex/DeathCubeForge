package com.harmex.deathcube.entity;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.entity.custom.ModBoatEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, DeathCube.MODID);

    public static final RegistryObject<EntityType<ModBoatEntity>> CHERRY_BOAT =
            ENTITY_TYPES.register("cherry_boat",
                    () -> EntityType.Builder.of(ModBoatEntity::new, MobCategory.MISC)
                            .build(new ResourceLocation(DeathCube.MODID, "cherry_boat").toString())
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
