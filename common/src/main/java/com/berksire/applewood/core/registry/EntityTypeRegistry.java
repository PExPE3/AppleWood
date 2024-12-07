package com.berksire.applewood.core.registry;

import com.berksire.applewood.AppleWood;
import com.berksire.applewood.core.block.entity.AppleWoodStorageBlockEntity;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;


import java.util.HashSet;
import java.util.Set;

public class EntityTypeRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(AppleWood.MODID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<AppleWoodStorageBlockEntity>> STORAGE_ENTITY = BLOCK_ENTITY_TYPES.register("storage", () -> {Set<Block> blocks = StorageTypeRegistry.registerBlocks(new HashSet<>());return BlockEntityType.Builder.of(AppleWoodStorageBlockEntity::new, blocks.toArray(new Block[0])).build(null);});

    public static void init() {
        BLOCK_ENTITY_TYPES.register();
    }
}
