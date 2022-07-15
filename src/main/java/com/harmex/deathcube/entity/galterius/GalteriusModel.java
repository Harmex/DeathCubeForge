package com.harmex.deathcube.entity.galterius;

import com.harmex.deathcube.DeathCube;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.resources.ResourceLocation;

public class GalteriusModel extends HumanoidModel<GalteriusEntity> {
    public static ModelLayerLocation GALTERIUS_LAYER =
            new ModelLayerLocation(new ResourceLocation(DeathCube.MODID, "galterius"), "body");

    public GalteriusModel(ModelPart pRoot) {
        super(pRoot);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
