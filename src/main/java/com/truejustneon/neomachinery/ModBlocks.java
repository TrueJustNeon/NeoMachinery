package com.truejustneon.neomachinery;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.core.registries.Registries;
import com.truejustneon.neomachinery.NeoMachinery;
import com.truejustneon.neomachinery.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import java.util.function.Supplier;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {


public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("neomachinery");

public static final DeferredBlock<Block> COAL_GENERATOR = BLOCKS.registerBlock(
        "coal_generator",
        Block::new, // The factory that the properties will be passed into.
        BlockBehaviour.Properties.of()
            .destroyTime(2.0f)
            .explosionResistance(10.0f)
            .lightLevel(state -> 7) // The properties to use.
);
public static final DeferredBlock<Block> BATTERY = BLOCKS.registerBlock(
        "battery",
        Block::new, // The factory that the properties will be passed into.
        BlockBehaviour.Properties.of()
            .destroyTime(2.0f)
            .explosionResistance(10.0f)
            .lightLevel(state -> 7) // The properties to use.
);
public static final DeferredBlock<Block> BASIC_SOLAR_PANEL = BLOCKS.registerBlock(
        "basic_solar_panel",
        Block::new, // The factory that the properties will be passed into.
        BlockBehaviour.Properties.of()
            .destroyTime(2.0f)
            .explosionResistance(10.0f)
            .lightLevel(state -> 5) // The properties to use.
);
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}