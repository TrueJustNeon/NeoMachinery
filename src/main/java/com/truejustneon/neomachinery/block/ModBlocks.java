package com.yourname.neomachinery.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, "neomachinery");

    public static final DeferredHolder<Block, Block> COAL_GENERATOR =
            BLOCKS.register("coal_generator",
                    () -> new Block(BlockBehaviour.Properties.of()
                            .strength(3.0f)));
}