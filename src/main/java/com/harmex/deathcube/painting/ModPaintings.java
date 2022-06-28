package com.harmex.deathcube.painting;

import com.harmex.deathcube.DeathCube;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, DeathCube.MODID);

    public static final RegistryObject<PaintingVariant> HARMEX_LOGO =
            PAINTING_VARIANTS.register("harmex_logo", () -> new PaintingVariant(64, 64));

    public static final RegistryObject<PaintingVariant> THOMAS_HEAD =
            PAINTING_VARIANTS.register("thomas_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> SHEMOI_HEAD =
            PAINTING_VARIANTS.register("shemoi_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> NOSS_HEAD =
            PAINTING_VARIANTS.register("noss_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> CHAMOUZ_HEAD =
            PAINTING_VARIANTS.register("chamouz_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> WRODKA_HEAD =
            PAINTING_VARIANTS.register("wrodka_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MOON_HEAD =
            PAINTING_VARIANTS.register("moon_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> LYDEAD_HEAD =
            PAINTING_VARIANTS.register("lydead_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> ZAZADOC_HEAD =
            PAINTING_VARIANTS.register("zazadoc_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> ROCKMILK_HEAD =
            PAINTING_VARIANTS.register("rockmilk_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> HAKARA_HEAD =
            PAINTING_VARIANTS.register("hakara_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MARVIS_HEAD =
            PAINTING_VARIANTS.register("marvis_head", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> HARMEX_HEAD =
            PAINTING_VARIANTS.register("harmex_head", () -> new PaintingVariant(16, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
