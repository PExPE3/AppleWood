package com.berksire.applewood.core.block;

import com.berksire.applewood.core.registry.StorageTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.satisfy.vinery.core.registry.TagRegistry;
import org.jetbrains.annotations.NotNull;

public class AppleWoodBigBottleStorageBlock extends AppleWoodStorageBlock {

    public AppleWoodBigBottleStorageBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
    }

    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    private static final SoundEvent OPEN_SOUND = SoundEvents.BAMBOO_WOOD_DOOR_OPEN;


    @Override
    public @NotNull InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isShiftKeyDown() && stack.isEmpty()) {
            if (!world.isClientSide()) {
                world.playSound(null, pos, OPEN_SOUND, SoundSource.BLOCKS, 0.4f, 0.4f);
                world.setBlock(pos, state.setValue(OPEN, !state.getValue(OPEN)), UPDATE_ALL);
            }
            return InteractionResult.sidedSuccess(world.isClientSide());
        } else if (state.getValue(OPEN)) {
            return super.use(state, world, pos, player, hand, hit);
        }
        return InteractionResult.PASS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }

    @Override
    public boolean canInsertStack(ItemStack stack) {
        return stack.is(TagRegistry.SMALL_BOTTLE) || stack.is(TagRegistry.LARGE_BOTTLE);
    }

    @Override
    public int size(){
        return 1;
    }

    @Override
    public ResourceLocation type() {
        return StorageTypeRegistry.BIG_BOTTLE;
    }

    @Override
    public Direction[] unAllowedDirections() {
        return new Direction[]{Direction.DOWN, Direction.UP};
    }

    @Override
    public int getSection(Float x, Float y) {
        return 0;
    }
}
