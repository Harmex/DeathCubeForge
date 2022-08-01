package com.harmex.deathcube.event;

import com.harmex.deathcube.DeathCube;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = DeathCube.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeBusEvents {
    //@SubscribeEvent
    //public static void renderGuiOverlay(RenderGuiOverlayEvent event) {
    //    if (Objects.equals(event.getOverlay().id(), new ResourceLocation("minecraft:air_level"))) {
    //        event.getPoseStack().translate(0, -10, 0);
    //    }
    //}
}
