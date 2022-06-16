package com.harmex.deathcube.item;

import com.harmex.deathcube.DeathCube;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeathCube.MODID);

    public static final RegistryObject<Item> TOTEM_OF_RESURRECTION =
            ITEMS.register("totem_of_resurrection",
                    () -> new Item(new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
