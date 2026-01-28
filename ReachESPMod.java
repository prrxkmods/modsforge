package com.pierrezz.reachesp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(
        modid = "reachesp",
        name = "Reach ESP",
        version = "1.0",
        acceptedMinecraftVersions = "[1.8.9]"
)
public class ReachESPMod {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        // Registra o Reach
        MinecraftForge.EVENT_BUS.register(new ReachHandler());

        // Registra o ESP
        MinecraftForge.EVENT_BUS.register(new ESPRenderer());
    }
}