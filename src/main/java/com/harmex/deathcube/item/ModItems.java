package com.harmex.deathcube.item;

import com.harmex.deathcube.DeathCube;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeathCube.MODID);

    //Misc
    public static final RegistryObject<Item> TOTEM_OF_RESURRECTION =
            ITEMS.register("totem_of_resurrection",
                    () -> new Item(new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_MISC_TAB)));


    //Copper Tools
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",
                    () -> new SwordItem(ModTiers.COPPER, 3, -2.4f, new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
                    () -> new PickaxeItem(ModTiers.COPPER, 1, -2.8f, new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",
                    () -> new AxeItem(ModTiers.COPPER, 6, -3.1f, new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
                    () -> new ShovelItem(ModTiers.COPPER, 1.5f, -3.0f, new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe",
                    () -> new HoeItem(ModTiers.COPPER, -2, -1.0f, new Item.Properties()
                            .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    
    //Emerald Tools
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModTiers.EMERALD, 3, -2.4f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModTiers.EMERALD, 1, -2.8f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModTiers.EMERALD, 5, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModTiers.EMERALD, 1.5f, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModTiers.EMERALD, -3, 0.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    
    //Obsidian Tools
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword",
            () -> new SwordItem(ModTiers.OBSIDIAN, 3, -2.4f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe",
            () -> new PickaxeItem(ModTiers.OBSIDIAN, 1, -2.8f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe",
            () -> new AxeItem(ModTiers.OBSIDIAN, 5, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel",
            () -> new ShovelItem(ModTiers.OBSIDIAN, 1.5f, -3.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe",
            () -> new HoeItem(ModTiers.OBSIDIAN, -3, 0.0f, new Item.Properties()
                    .tab(ModCreativeModeTab.DEATHCUBE_TOOLS_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
