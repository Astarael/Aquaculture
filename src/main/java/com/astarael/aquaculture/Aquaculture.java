package com.astarael.aquaculture;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Aquaculture.MODID, name = Aquaculture.NAME, version = Aquaculture.VERSION, dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)
public class Aquaculture
{
    public static final String MODID = "aquaculture";
    public static final String NAME = "Aquaculture";
    public static final String VERSION = "1.0.0";

    private static Logger logger;

    @Mod.Instance
    public static Aquaculture instance;

    @SidedProxy(clientSide = "com.astarael.aquaculture.ClientProxy", serverSide = "com.astarael.aquaculture.ServerProxy")
    public static CommonProxy proxy;


    public static final ItemArmor.ArmorMaterial neopreneArmorMaterial = EnumHelper.addArmorMaterial("NEOPRENE", MODID + ":neoprene", 15, new int[]{2, 3, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final AquacultureCreativeTab creativeTab = new AquacultureCreativeTab();

    //public static final Item.ToolMaterial

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModRecipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
