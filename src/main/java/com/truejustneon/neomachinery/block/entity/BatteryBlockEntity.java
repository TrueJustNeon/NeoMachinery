package com.truejustneon.neomachinery.block.entity;

import com.truejustneon.neomachinery.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities;

public class BatteryBlockEntity extends BlockEntity {

    private final EnergyStorage energy = new EnergyStorage(500000, 10000, 10000);

    public BatteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BATTERY.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, BatteryBlockEntity block) {

    if (level.isClientSide) return;

    BlockPos belowPos = pos.below();

    IEnergyStorage storage = level.getCapability(
            Capabilities.EnergyStorage.BLOCK,
            belowPos,
            Direction.UP
    );

    if (storage != null) {

        int extract = block.energy.extractEnergy(200, true);
        int accepted = storage.receiveEnergy(extract, false);

        block.energy.extractEnergy(accepted, false);
    }
}

    public IEnergyStorage getEnergyStorage() {
        return energy;
    }
}