package com.truejustneon.neomachinery;
import com.truejustneon.neomachinery.NeoMachinery;
import com.truejustneon.neomachinery.block.entity.BasicSolarPanelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import com.truejustneon.neomachinery.ModBlocks;
import net.minecraft.world.level.block.BaseEntityBlock;
import com.truejustneon.neomachinery.block.entity.BatteryBlockEntity;
import com.truejustneon.neomachinery.block.entity.AdvancedSolarPanelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModBlockEntities {


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "neomachinery");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BasicSolarPanelBlockEntity>> BASIC_SOLAR_PANEL =
        BLOCK_ENTITIES.register("basic_solar_panel",
            () -> BlockEntityType.Builder.of(
                BasicSolarPanelBlockEntity::new,
                ModBlocks.BASIC_SOLAR_PANEL.get()
                
            ).build(null)
        );


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AdvancedSolarPanelBlockEntity>> ADVANCED_SOLAR_PANEL =
        BLOCK_ENTITIES.register("advanced_solar_panel",
            () -> BlockEntityType.Builder.of(
                AdvancedSolarPanelBlockEntity::new,
                ModBlocks.ADVANCED_SOLAR_PANEL.get()
                
            ).build(null)
        );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BatteryBlockEntity>> BATTERY =
        BLOCK_ENTITIES.register("battery",
                () -> BlockEntityType.Builder.of(
                        BatteryBlockEntity::new,
                        ModBlocks.BATTERY.get()
                ).build(null)
        );
}