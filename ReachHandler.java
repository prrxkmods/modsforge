package com.pierrezz.reachesp;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ReachHandler {

    // Reach configurável (0 a 10)
    public static float reach = 6.0F;

    @SubscribeEvent
    public void onMouse(MouseEvent event) {
        if (Minecraft.getMinecraft().playerController != null) {
            Minecraft.getMinecraft()
                    .playerController
                    .setBlockReachDistance(reach);
        }
    }
}