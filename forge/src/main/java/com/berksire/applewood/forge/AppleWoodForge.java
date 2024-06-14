package com.berksire.applewood.forge;

import com.berksire.applewood.AppleWood;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AppleWood.MODID)
public class AppleWoodForge {
    public AppleWoodForge() {
        EventBuses.registerModEventBus(AppleWood.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        AppleWood.init();
    }
}
