package com.astarael.aquaponics.Items;

import com.astarael.aquaponics.Aquaponics;
import com.astarael.aquaponics.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotTitanium  extends Item implements IHasModel {

    public ItemIngotTitanium() {
        setRegistryName("ingottitanium");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(Aquaponics.MODID + ".ingottitanium");     // Used for localization (en_US.lang)
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    public void registerModels() {
        // TODO: id
        //Aquaponics.proxy.registerItemRenderer(this, 0, "inventory");


    }
}
