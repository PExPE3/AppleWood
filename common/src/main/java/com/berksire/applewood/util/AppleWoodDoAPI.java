package com.berksire.applewood.util;

import com.berksire.applewood.registry.StorageTypes;
import de.cristelknight.doapi.api.DoApiAPI;
import de.cristelknight.doapi.api.DoApiPlugin;
import de.cristelknight.doapi.client.render.feature.CustomArmorManager;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Set;

@DoApiPlugin
public class AppleWoodDoAPI implements DoApiAPI {

    @Override
    public void registerBlocks(Set<Block> blocks) {
        StorageTypes.registerBlocks(blocks);
    }

    @Override
    @SuppressWarnings("deprecation")
    public <T extends LivingEntity> void registerHat(Map<Item, EntityModel<T>> map, EntityModelSet entityModelSet) {
    }

    @Override
    public <T extends LivingEntity> void registerArmor(CustomArmorManager<T> customArmorManager, EntityModelSet entityModelSet) {

    }
}
