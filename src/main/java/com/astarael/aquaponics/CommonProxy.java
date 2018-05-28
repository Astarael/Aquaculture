package com.astarael.aquaponics;

import com.astarael.aquaponics.Blocks.*;
import com.astarael.aquaponics.Items.*;
import com.astarael.aquaponics.TileEntitities.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.*;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    // Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "modtut.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int meta, String id) {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Limestone());
        event.getRegistry().register(new LimeKiln());
        GameRegistry.registerTileEntity(LimeKilnEntity.class, new ResourceLocation(Aquaponics.MODID + ".limekiln"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new FishCod());
        event.getRegistry().register(new ItemIngotTitanium());

        event.getRegistry().register(new ItemBlock(ModBlocks.limestone).setRegistryName(ModBlocks.limestone.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.limeKiln).setRegistryName(ModBlocks.limeKiln.getRegistryName()));
    }
}





