package com.pierrezz.reachesp;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class ESPRenderer {

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        if (Minecraft.getMinecraft().world == null) return;

        for (Entity entity : Minecraft.getMinecraft().world.loadedEntityList) {

            if (entity instanceof EntityPlayer || entity instanceof EntityAnimal) {
                drawESP((EntityLivingBase) entity, event.getPartialTicks());
            }
        }
    }

    private void drawESP(EntityLivingBase entity, float partialTicks) {
        Minecraft mc = Minecraft.getMinecraft();

        double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks
                - mc.getRenderManager().viewerPosX;
        double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks
                - mc.getRenderManager().viewerPosY;
        double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks
                - mc.getRenderManager().viewerPosZ;

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glLineWidth(2.0F);

        // ROSA 🩷
        GL11.glColor3f(1.0F, 0.2F, 0.8F);

        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3d(x - 0.5, y, z - 0.5);
        GL11.glVertex3d(x + 0.5, y, z - 0.5);
        GL11.glVertex3d(x + 0.5, y + entity.height, z - 0.5);
        GL11.glVertex3d(x - 0.5, y + entity.height, z - 0.5);
        GL11.glEnd();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glPopMatrix();
    }
}