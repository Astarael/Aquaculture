package com.astarael.aquaculture.Blocks;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;

public class BlockBase extends Block {

    protected String name;

    public BlockBase (Material material, String name) {

        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);

    }

    public void registerItemModel (Item itemBlock) {

        Aquaculture.proxy.registerItemRenderer(itemBlock,0,name);

    }

    public Item createItemBlock () {

        return new ItemBlock(this).setRegistryName(getRegistryName());

    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {

        super.setCreativeTab(tab);
        return this;

    }

}
