package com.berksire.applewood.core.registry;

import com.berksire.applewood.AppleWood;
import com.berksire.applewood.core.block.AppleWoodBigBottleStorageBlock;
import com.berksire.applewood.core.block.AppleWoodFourBottleStorageBlock;
import com.berksire.applewood.core.block.AppleWoodNineBottleStorageBlock;
import com.berksire.applewood.util.AppleWoodIdentifier;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.satisfy.vinery.core.block.*;
import net.satisfy.vinery.core.registry.SoundEventRegistry;
import net.satisfy.vinery.core.util.GeneralUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObjectRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(AppleWood.MODID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(AppleWood.MODID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Block> APPLE_CHAIR = registerWithItem("apple_chair", () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> APPLE_TABLE = registerWithItem("apple_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistrySupplier<Block> APPLE_CABINET = registerWithItem("apple_cabinet", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.CABINET_OPEN.get(), SoundEventRegistry.CABINET_CLOSE.get()));
    public static final RegistrySupplier<Block> APPLE_DRAWER = registerWithItem("apple_drawer", () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEventRegistry.DRAWER_OPEN.get(), SoundEventRegistry.DRAWER_CLOSE.get()));
    public static final RegistrySupplier<Block> APPLE_WINE_RACK_BIG = registerWithItem("apple_wine_rack_big", () -> new AppleWoodNineBottleStorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> APPLE_WINE_RACK_SMALL = registerWithItem("apple_wine_rack_small", () -> new AppleWoodFourBottleStorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> APPLE_WINE_RACK_MID = registerWithItem("apple_wine_rack_mid", () -> new AppleWoodBigBottleStorageBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> STRIPPED_APPLE_LOG = registerWithItem("stripped_apple_log", GeneralUtil::logBlock);
    public static final RegistrySupplier<Block> STRIPPED_APPLE_WOOD = registerWithItem("stripped_apple_wood", GeneralUtil::logBlock);
    public static final RegistrySupplier<Block> APPLE_WOOD = registerWithItem("apple_wood", GeneralUtil::logBlock);
    public static final RegistrySupplier<Block> APPLE_BEAM = registerWithItem("apple_beam", GeneralUtil::logBlock);
    public static final RegistrySupplier<Block> APPLE_PLANKS = registerWithItem("apple_planks", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BIT)));
    public static final RegistrySupplier<Block> APPLE_STAIRS = registerWithItem("apple_stairs", () -> new StairBlock(APPLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(APPLE_PLANKS.get())));
    public static final RegistrySupplier<Block> APPLE_SLAB = registerWithItem("apple_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2.0F).explosionResistance(3.0F).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> APPLE_FENCE = registerWithItem("apple_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistrySupplier<Block> APPLE_FENCE_GATE = registerWithItem("apple_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), WoodType.CHERRY));
    public static final RegistrySupplier<Block> APPLE_BUTTON = registerWithItem("apple_button", () -> woodenButton(FeatureFlags.VANILLA));
    public static final RegistrySupplier<Block> APPLE_PRESSURE_PLATE = registerWithItem("apple_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.CHERRY));
    public static final RegistrySupplier<Block> APPLE_DOOR = registerWithItem("apple_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.CHERRY));
    public static final RegistrySupplier<Block> APPLE_TRAPDOOR = registerWithItem("apple_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.CHERRY));
    public static final RegistrySupplier<Block> APPLE_LATTICE = registerWithItem("apple_lattice", () -> new LatticeBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(Blocks.JUNGLE_PLANKS.getSoundType(Blocks.JUNGLE_PLANKS.defaultBlockState())).noOcclusion()));
    public static final RegistrySupplier<Block> APPLE_BIG_TABLE = registerWithItem("apple_big_table", () -> new BigTableBlock(BlockBehaviour.Properties.of().strength(2.0F, 2.0F).pushReaction(PushReaction.IGNORE)));
    public static final RegistrySupplier<Block> APPLE_SHELF = registerWithItem("apple_shelf", () -> new ShelfBlock(BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion()));

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    private static ButtonBlock woodenButton(FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }

        return new ButtonBlock(properties, BlockSetType.CHERRY, 30, true);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return GeneralUtil.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new AppleWoodIdentifier(name), block);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return GeneralUtil.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new AppleWoodIdentifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return GeneralUtil.registerItem(ITEMS, ITEM_REGISTRAR, new AppleWoodIdentifier(path), itemSupplier);
    }
}

