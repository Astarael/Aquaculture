package com.astarael.aquaculture;

import com.astarael.aquaculture.Items.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemBase ingotTitanium = new ItemBase("ingot_titanium").setCreativeTab(CreativeTabs.MATERIALS);
    public static ItemBase burntBrick = new ItemBase("burnt_brick").setCreativeTab(CreativeTabs.MATERIALS);
    public static ItemArmour neopreneMask = new ItemArmour("neoprene_mask", Aquaculture.neopreneArmorMaterial, EntityEquipmentSlot.HEAD);
    public static ItemArmour neopreneSuit = new ItemArmour("neoprene_suit", Aquaculture.neopreneArmorMaterial, EntityEquipmentSlot.CHEST);
    public static ItemArmour neopreneLeggings = new ItemArmour("neoprene_leggings", Aquaculture.neopreneArmorMaterial, EntityEquipmentSlot.LEGS);
    public static ItemArmour neopreneBoots = new ItemArmour("neoprene_boots", Aquaculture.neopreneArmorMaterial, EntityEquipmentSlot.FEET);

    public static void register(IForgeRegistry<Item> registry) {

        registry.registerAll(ingotTitanium,
                burntBrick,
                neopreneMask,
                neopreneSuit,
                neopreneLeggings,
                neopreneBoots);

    }

    public static void registerModels() {

        ingotTitanium.registerItemModel();
        burntBrick.registerItemModel();
        neopreneMask.registerItemModel();
        neopreneSuit.registerItemModel();
        neopreneLeggings.registerItemModel();
        neopreneBoots.registerItemModel();

    }

}
