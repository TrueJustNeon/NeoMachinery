package com.truejustneon.neomachinery;
import com.truejustneon.neomachinery.NeoMachinery;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import java.util.function.Supplier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import com.truejustneon.neomachinery.ModItems;
import com.truejustneon.neomachinery.ModBlocks;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoMachinery.MODID);

public static final Supplier<CreativeModeTab> NEOMACHINERY_TAB = CREATIVE_MODE_TABS.register("neomachinery_tab", () -> CreativeModeTab.builder()
    //Set the title of the tab. Don't forget to add a translation!
    .title(Component.translatable("itemGroup.neomachinery.neomachinery_tab"))
    //Set the icon of the tab.
    .icon(() -> new ItemStack(ModItems.BASIC_CHIP.get()))
    //Add your items to the tab.
    .displayItems((params, output) -> {
        // ITEMS
        output.accept(ModItems.STEEL_INGOT.get());
        output.accept(ModItems.COAL_DUST.get());
        output.accept(ModItems.BASIC_CHIP.get());
        output.accept(ModItems.ADVANCED_CHIP.get());
        output.accept(ModItems.SOLAR_PANEL.get());
        output.accept(ModItems.IRON_PLATE.get());
        output.accept(ModItems.STEEL_PLATE.get());
        output.accept(ModItems.COPPER_WIRE.get());
        output.accept(ModItems.COPPER_CABLE.get());
        output.accept(ModItems.RUBBER.get());
        output.accept(ModItems.RESIN.get());
        // BLOCKS
        output.accept(ModBlocks.COAL_GENERATOR.get());
        output.accept(ModBlocks.BASIC_SOLAR_PANEL.get());
        output.accept(ModBlocks.ADVANCED_SOLAR_PANEL.get());
        output.accept(ModBlocks.BATTERY.get());
    })
    .build()
);
}