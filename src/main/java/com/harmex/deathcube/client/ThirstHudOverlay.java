package com.harmex.deathcube.client;

import com.harmex.deathcube.DeathCube;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ThirstHudOverlay {
    private static final ResourceLocation THIRST = new ResourceLocation(DeathCube.MODID,
            "textures/gui/thirst/thirst.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        Minecraft minecraft = gui.getMinecraft();
        Player player = !(minecraft.getCameraEntity() instanceof Player) ? null : (Player)minecraft.getCameraEntity();

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, THIRST);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        int thirstLevel = ClientThirstData.getPlayerThirst();
        int leftPos = width / 2 - 91;
        int rightPos = width / 2 + 91;
        int firstPosY = height - 39;

        int posY = firstPosY - 10;


        if (minecraft.gameMode.canHurtPlayer()) {
            if (player != null) {
                minecraft.getProfiler().popPush("thirst");
                if ((player.getAirSupply() < player.getMaxAirSupply())) {
                    posY = firstPosY - 20;
                }
                for (int i = 0; i < 10 ; i++) {
                    int posX = rightPos - i * 8 - 9;
                    GuiComponent.blit(poseStack, posX, posY, 0, 0, 9, 9, 27, 9);

                    if (i * 2 + 1 < thirstLevel) {
                        GuiComponent.blit(poseStack, posX, posY, 18, 0, 9, 9, 27, 9);
                    }

                    if (i * 2 + 1 == thirstLevel) {
                        GuiComponent.blit(poseStack, posX, posY, 9, 0, 9, 9, 27, 9);
                    }
                }
            }
        }
    });
}
