package com.berksire.applewood.registry;

import com.berksire.applewood.util.AppleWoodIdentifier;
import de.cristelknight.doapi.DoApiCommonEP;
import de.cristelknight.doapi.terraform.boat.TerraformBoatType;
import de.cristelknight.doapi.terraform.boat.item.TerraformBoatItemHelper;
import de.cristelknight.doapi.terraform.sign.TerraformSignHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;

public class BoatAndSignRegistry {
    public static final ResourceLocation APPLE_BOAT_TYPE = new AppleWoodIdentifier("apple");
    public static final ResourceLocation APPLE_SIGN_TEXTURE = new AppleWoodIdentifier("entity/signs/apple");
    public static final ResourceLocation APPLE_HANGING_SIGN_TEXTURE = new AppleWoodIdentifier("entity/signs/hanging/apple");
    public static final ResourceLocation APPLE_HANGING_SIGN_GUI_TEXTURE = new AppleWoodIdentifier("textures/gui/hanging_signs/apple");

    public static final RegistrySupplier<Block> APPLE_SIGN = ObjectRegistry.registerWithoutItem("apple_sign", () -> TerraformSignHelper.getSign(APPLE_SIGN_TEXTURE));
    public static final RegistrySupplier<Block> APPLE_WALL_SIGN = ObjectRegistry.registerWithoutItem("apple_wall_sign", () -> TerraformSignHelper.getWallSign(APPLE_SIGN_TEXTURE));
    public static final RegistrySupplier<Item> APPLE_SIGN_ITEM = ObjectRegistry.registerItem("apple_sign", () -> new SignItem(ObjectRegistry.getSettings().stacksTo(16), APPLE_SIGN.get(), APPLE_WALL_SIGN.get()));


    public static final RegistrySupplier<Block> APPLE_HANGING_SIGN = ObjectRegistry.registerWithoutItem("apple_hanging_sign", () -> TerraformSignHelper.getHangingSign(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Block> APPLE_WALL_HANGING_SIGN = ObjectRegistry.registerWithoutItem("apple_wall_hanging_sign", () -> TerraformSignHelper.getWallHangingSign(APPLE_HANGING_SIGN_TEXTURE, APPLE_HANGING_SIGN_GUI_TEXTURE));
    public static final RegistrySupplier<Item> APPLE_HANGING_SIGN_ITEM = ObjectRegistry.registerItem("apple_hanging_sign", () -> new HangingSignItem(APPLE_HANGING_SIGN.get(), APPLE_WALL_HANGING_SIGN.get(), ObjectRegistry.getSettings().stacksTo(16)));

    public static RegistrySupplier<Item> APPLE_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "apple_boat", APPLE_BOAT_TYPE, false);
    public static RegistrySupplier<Item> APPLE_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ObjectRegistry.ITEMS, "apple_chest_boat", APPLE_BOAT_TYPE, true);

    public static void init() {
        DoApiCommonEP.registerBoatType(APPLE_BOAT_TYPE, new TerraformBoatType.Builder().item(APPLE_BOAT).chestItem(APPLE_CHEST_BOAT).build());
    }
}
