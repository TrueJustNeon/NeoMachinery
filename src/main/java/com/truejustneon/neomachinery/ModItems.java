package com.truejustneon.neomachinery;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.Registries;
import java.util.function.Supplier;
import com.truejustneon.neomachinery.ModBlocks;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NeoMachinery.MODID);

    public static final Supplier<Item> STEEL_INGOT = ITEMS.registerItem(
        "steel_ingot",
        Item::new,
        new Item.Properties()
    );
    
    public static final Supplier<Item> COAL_DUST = ITEMS.registerItem(
        "coal_dust",
        Item::new,
        new Item.Properties()
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    // BLOCK ITEMS
public static final DeferredItem<BlockItem> COAL_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem(
    "coal_generator", // blockitem id
    ModBlocks.COAL_GENERATOR // block that represents
);
public static final DeferredItem<BlockItem> BASIC_SOLAR_PANEL_ITEM = ITEMS.registerSimpleBlockItem(
    "basic_solar_panel", // blockitem id
    ModBlocks.BASIC_SOLAR_PANEL // block that represents
);
}