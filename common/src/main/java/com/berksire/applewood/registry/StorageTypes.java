package com.berksire.applewood.registry;

import net.minecraft.world.level.block.Block;
import satisfyu.vinery.registry.StorageTypeRegistry;

import java.util.Set;

public class StorageTypes extends StorageTypeRegistry {
    public static void registerBlocks(Set<Block> blocks) {
        blocks.add(ObjectRegistry.APPLE_WINE_RACK_BIG.get());
        blocks.add(ObjectRegistry.APPLE_WINE_RACK_MID.get());
        blocks.add(ObjectRegistry.APPLE_WINE_RACK_SMALL.get());
        blocks.add(ObjectRegistry.APPLE_SHELF.get());
    }
}
