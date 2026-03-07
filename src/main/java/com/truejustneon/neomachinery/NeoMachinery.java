package com.truejustneon.neomachinery;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
@Mod(NeoMachinery.MODID)
public class NeoMachinery {
    public static final String MODID = "neomachinery";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

public NeoMachinery(IEventBus modBus) {
    ModBlocks.BLOCKS.register(modBus);
    ModItems.ITEMS.register(modBus);
    //Other stuff here
}
    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("NeoMachinery says hi for Common setup.");
    }
public static final Supplier<CreativeModeTab> NEOMACHINERY_TAB = CREATIVE_MODE_TABS.register("neomachinery_tab", () -> CreativeModeTab.builder()
    //Set the title of the tab. Don't forget to add a translation!
    .title(Component.translatable("itemGroup.neomachinery.neomachinery_tab"))
    //Set the icon of the tab.
    .icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
    //Add your items to the tab.
    .displayItems((params, output) -> {
        output.accept(ModItems.STEEL_INGOT.get());
        output.accept(ModItems.COAL_DUST.get());
        // Accepts an ItemLike. This assumes that MY_BLOCK has a corresponding item.
        output.accept(ModBlocks.COAL_GENERATOR.get());
        output.accept(ModBlocks.BASIC_SOLAR_PANEL.get());
    })
    .build()
);
}