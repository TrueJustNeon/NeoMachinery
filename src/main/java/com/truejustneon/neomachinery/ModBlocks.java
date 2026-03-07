package com.truejustneon.neomachinery;

import com.truejustneon.neomachinery.block.CoalGeneratorBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.bus.api.IEventBus;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NeoMachinery.MODID);

    public static final DeferredBlock<Block> COAL_GENERATOR = BLOCKS.register(
        "coal_generator",
        () -> new CoalGeneratorBlock(BlockBehaviour.Properties.of()
            .destroyTime(2.0f)
            .explosionResistance(10.0f)
            .lightLevel(state -> 7)
        )
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}