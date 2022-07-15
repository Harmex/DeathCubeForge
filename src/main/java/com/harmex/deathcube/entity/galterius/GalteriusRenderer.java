package com.harmex.deathcube.entity.galterius;

import com.harmex.deathcube.DeathCube;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GalteriusRenderer extends HumanoidMobRenderer<GalteriusEntity, GalteriusModel> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(DeathCube.MODID, "textures/entity/galterius.png");

    public GalteriusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GalteriusModel(pContext.bakeLayer(GalteriusModel.GALTERIUS_LAYER)), 0.5F /* Shadow Radius */);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GalteriusEntity pEntity) {
        return TEXTURE;
    }
}
