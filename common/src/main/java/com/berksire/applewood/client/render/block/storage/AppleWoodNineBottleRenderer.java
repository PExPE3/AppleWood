package com.berksire.applewood.client.render.block.storage;

import com.berksire.applewood.core.block.entity.AppleWoodStorageBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.satisfy.vinery.client.util.ClientUtil;
import net.satisfy.vinery.core.block.WineBottleBlock;

@Environment(EnvType.CLIENT)
public class AppleWoodNineBottleRenderer implements AppleWoodStorageTypeRenderer {
    @Override
    public void render(AppleWoodStorageBlockEntity entity, PoseStack matrices, MultiBufferSource vertexConsumers, NonNullList<ItemStack> itemStacks) {
        matrices.translate(-0.13, 0.335, 0.125);
        matrices.scale(0.9f, 0.9f, 0.9f);
        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack stack = itemStacks.get(i);
            if (!stack.isEmpty() && stack.getItem() instanceof BlockItem blockItem) {
                matrices.pushPose();
                int line = i >= 6 ? 3 : i >= 3 ? 2 : 1;
                float x;
                float y;
                if(line == 1){
                    x = -0.35f * i;
                    y = 0;
                }
                else if(line == 2){
                    x = -0.35f * (i - 3);
                    y = -0.33f;
                }
                else{
                    x = -0.35f * (i - 6);
                    y = -0.66f;
                }

                matrices.translate(x, y, 0f);
                matrices.mulPose(Axis.XN.rotationDegrees(90));
                ClientUtil.renderBlock(blockItem.getBlock().defaultBlockState().setValue(WineBottleBlock.FAKE_MODEL, false), matrices, vertexConsumers, entity);
                matrices.popPose();
            }
        }
    }
}
