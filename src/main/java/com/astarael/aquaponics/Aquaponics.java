package com.astarael.aquaponics;

import com.astarael.aquaponics.CommonProxy;
import com.astarael.aquaponics.ClientProxy;
import com.astarael.aquaponics.ServerProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Aquaponics.MODID, name = Aquaponics.NAME, version = Aquaponics.VERSION, dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)
public class Aquaponics
{
    public static final String MODID = "aquaponics";
    public static final String NAME = "Aquaponics";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @Mod.Instance
    public static Aquaponics instance;

    @SidedProxy(clientSide = "com.astarael.aquaponics.ClientProxy", serverSide = "com.astarael.aquaponics.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
