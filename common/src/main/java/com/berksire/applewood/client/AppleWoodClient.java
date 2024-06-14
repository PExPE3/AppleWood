package com.berksire.applewood.client;

import com.berksire.applewood.registry.BoatAndSignRegistry;
import de.cristelknight.doapi.terraform.sign.TerraformSignHelper;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;

import static com.berksire.applewood.registry.ObjectRegistry.*;
import static satisfyu.vinery.Vinery.LOGGER;

@Environment(EnvType.CLIENT)
public class AppleWoodClient {

    public static void onInitializeClient() {
        RenderTypeRegistry.register(RenderType.cutout(),
                APPLE_WINE_RACK_BIG.get(), APPLE_LATTICE.get(), APPLE_CHAIR.get(), APPLE_TABLE.get(), APPLE_WINE_RACK_MID.get()
        );
    }

    public static void preInitClient(){
        TerraformSignHelper.regsterSignSprite(BoatAndSignRegistry.APPLE_SIGN_TEXTURE);
        LOGGER.info("Resource provider initialized, side is {}", Platform.getEnvironment().toPlatform().toString());
    }
}