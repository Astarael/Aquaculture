package com.astarael.aquaculture.Items;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;


public class ItemBase extends Item {

    protected String name;

    public ItemBase (String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Aquaculture.creativeTab);
    }

    public void registerItemModel() {
        Aquaculture.proxy.registerItemRenderer(this,0,name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
