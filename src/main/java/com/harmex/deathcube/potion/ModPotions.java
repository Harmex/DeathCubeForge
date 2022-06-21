package com.harmex.deathcube.potion;

import com.harmex.deathcube.DeathCube;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, DeathCube.MODID);

    //public static final RegistryObject<Potion> FRESH_WATER =
    //        POTIONS.register("fresh_water",
    //                () -> new Potion())


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
