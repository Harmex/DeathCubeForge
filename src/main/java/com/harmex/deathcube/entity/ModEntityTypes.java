package com.harmex.deathcube.entity;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.entity.custom.ModBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, DeathCube.MODID);

    public static final RegistryObject<EntityType<Boat>> CHERRY_BOAT =
            ENTITY_TYPES.register("cherry_boat",
                    () -> EntityType.Builder.<Boat>of(ModBoat::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .setCustomClientFactory((spawnEntity, level) -> new ModBoat(level))
                            .clientTrackingRange(10)
                            .build(new ResourceLocation(DeathCube.MODID, "cherry_boat").toString())
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
