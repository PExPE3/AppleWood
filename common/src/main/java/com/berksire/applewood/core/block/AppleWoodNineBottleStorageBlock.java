package com.berksire.applewood.core.block;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import com.berksire.applewood.core.registry.StorageTypeRegistry;
import net.satisfy.vinery.core.registry.TagRegistry;

public class AppleWoodNineBottleStorageBlock extends AppleWoodStorageBlock {
    public AppleWoodNineBottleStorageBlock(Properties settings) {
        super(settings);
    }

    @Override
    public int size(){
        return 9;
    }

    @Override
    public boolean canInsertStack(ItemStack stack) {
        return stack.is(TagRegistry.SMALL_BOTTLE);
    }

    @Override
    public ResourceLocation type() {
        return StorageTypeRegistry.NINE_BOTTLE;
    }

    @Override
    public Direction[] unAllowedDirections() {
        return new Direction[]{Direction.DOWN, Direction.UP};
    }

    @Override
    public int getSection(Float x, Float y) {

        float l = (float) 1/3;

        int nSection;
        if (x < 0.375F) {
            nSection = 0;
        } else {
            nSection = x < 0.6875F ? 1 : 2;
        }

        int i = y >= l*2 ? 0 : y >= l ? 1 : 2;
        return nSection + i * 3;
    }
}
