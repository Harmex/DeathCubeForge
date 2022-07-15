package com.harmex.deathcube.entity;

import com.harmex.deathcube.DeathCube;
import com.harmex.deathcube.entity.galterius.GalteriusEntity;
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
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeathCube.MODID);

    public static final RegistryObject<EntityType<GalteriusEntity>> GALTERIUS_ENTITY =
            ENTITY_TYPES.register("galterius",
                    () -> EntityType.Builder.of(GalteriusEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(8)
                            .fireImmune()
                            .build("galterius")
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
