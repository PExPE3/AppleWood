package com.berksire.applewood.fabric;

import com.berksire.applewood.registry.FlammableBlockRegistry;
import net.fabricmc.api.ModInitializer;
import com.berksire.applewood.AppleWood;

public class AppleWoodFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AppleWood.init();
        FlammableBlockRegistry.registerFlammables();
    }
}
