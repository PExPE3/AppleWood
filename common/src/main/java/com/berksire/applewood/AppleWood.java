package com.berksire.applewood;

import com.berksire.applewood.registry.BoatAndSignRegistry;
import com.berksire.applewood.registry.FlammableBlockRegistry;
import com.berksire.applewood.registry.ObjectRegistry;
import com.berksire.applewood.registry.TabRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppleWood {
    public static final String MODID = "applewood";

    public static void init() {
        ObjectRegistry.init();
        TabRegistry.init();
        BoatAndSignRegistry.init();
        FlammableBlockRegistry.init();
    }
}
