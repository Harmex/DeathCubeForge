package com.harmex.deathcube.thirst;

import com.harmex.deathcube.DeathCube;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ThirstHudOverlay {
    private static final ResourceLocation THIRST_ICONS = new ResourceLocation(DeathCube.MODID,
            "textures/gui/thirst/thirst.png");
    private static final int textureWidth = 36;
    private static final int textureHeight = 9;

    private static final RandomSource random = RandomSource.create();

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        Minecraft minecraft = gui.getMinecraft();
        Player player = !(minecraft.getCameraEntity() instanceof Player) ? null : (Player)minecraft.getCameraEntity();
        if (gui.shouldDrawSurvivalElements()
                && !(player.getVehicle() instanceof LivingEntity)
                && !minecraft.options.hideGui) {
            gui.setupOverlayRenderState(true, false, THIRST_ICONS);

            RenderSystem.enableBlend();

            minecraft.getProfiler().popPush("thirst");

            if (player != null) {
                int thirstLevel = ClientThirstData.getPlayerThirst();
                int thirstSaturationLevel = ClientThirstData.getPlayerThirstSaturation();
                int rightPos = width / 2 + 91;
                int firstPosY = height - 39;

                int posY = firstPosY - 10;
                if ((player.getAirSupply() < player.getMaxAirSupply())) {
                    posY = firstPosY - 20;
                }
                for (int i = 0; i < 10 ; i++) {
                    if (thirstSaturationLevel <= 0.0F
                            && gui.getGuiTicks() % (thirstLevel * 3 + 1) == 0
                            && gui.getGuiTicks() % 2 == 0
                            && !minecraft.isPaused()) {
                        if ((player.getAirSupply() < player.getMaxAirSupply())) {
                            posY = firstPosY - 20 + (random.nextInt(3) - 1);
                        } else {
                            posY = firstPosY - 10 + (random.nextInt(3) - 1);
                        }
                    }
                    int posX = rightPos - i * 8 - 9;
                    GuiComponent.blit(poseStack, posX, posY, 0, 0, 9, 9, textureWidth, textureHeight);

                    if (i < thirstSaturationLevel) {
                        GuiComponent.blit(poseStack, posX, posY, 27, 0, 9, 9, textureWidth, textureHeight);
                    }

                    if (i * 2 + 1 < thirstLevel) {
                        GuiComponent.blit(poseStack, posX, posY, 18, 0, 9, 9, textureWidth, textureHeight);
                    }

                    if (i * 2 + 1 == thirstLevel) {
                        GuiComponent.blit(poseStack, posX, posY, 9, 0, 9, 9, textureWidth, textureHeight);
                    }

                }
            }

            RenderSystem.disableBlend();
            minecraft.getProfiler().pop();
        }
    });
}
