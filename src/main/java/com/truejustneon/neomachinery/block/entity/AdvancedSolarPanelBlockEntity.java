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

public class AdvancedSolarPanelBlockEntity extends BlockEntity {

    private final EnergyStorage energy = new EnergyStorage(40000, 1000, 1000);

    public AdvancedSolarPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADVANCED_SOLAR_PANEL.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AdvancedSolarPanelBlockEntity block) {

        if (level.isClientSide) return;

        // generate power if day and sky visible
        if (level.isDay() && level.canSeeSky(pos.above())) {
            block.energy.receiveEnergy(50, false);
        }

        // push power downward
        BlockPos belowPos = pos.below();

        IEnergyStorage storage = level.getCapability(
                Capabilities.EnergyStorage.BLOCK,
                belowPos,
                Direction.UP
        );

        if (storage != null && block.energy.getEnergyStored() > 0) {

            int extract = block.energy.extractEnergy(50, true);
            int accepted = storage.receiveEnergy(extract, false);

            block.energy.extractEnergy(accepted, false);
        }
    }

    public IEnergyStorage getEnergyStorage() {
        return energy;
    }
}