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

    public static final RegistryObject<PaintingVariant> THOMAS_FACE =
            PAINTING_VARIANTS.register("thomas_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> SHEMOI_FACE =
            PAINTING_VARIANTS.register("shemoi_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> NOSS_FACE =
            PAINTING_VARIANTS.register("noss_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> CHAMOUZ_FACE =
            PAINTING_VARIANTS.register("chamouz_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> WRODKA_FACE =
            PAINTING_VARIANTS.register("wrodka_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MOON_FACE =
            PAINTING_VARIANTS.register("moon_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> LYDEAD_FACE =
            PAINTING_VARIANTS.register("lydead_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> ZAZADOC_FACE =
            PAINTING_VARIANTS.register("zazadoc_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> ROCKMILK_FACE =
            PAINTING_VARIANTS.register("rockmilk_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> HAKARA_FACE =
            PAINTING_VARIANTS.register("hakara_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MARVIS_FACE =
            PAINTING_VARIANTS.register("marvis_face", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> HARMEX_FACE =
            PAINTING_VARIANTS.register("harmex_face", () -> new PaintingVariant(16, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
