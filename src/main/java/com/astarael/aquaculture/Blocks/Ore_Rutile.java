package com.astarael.aquaculture.Blocks;


import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.Items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Ore_Rutile extends Block {

    public Ore_Rutile() {

        super(Material.ROCK);
        setHardness(3f);
        setResistance(5f);

        setUnlocalizedName(Aquaculture.MODID + ".ore_rutile");
        setRegistryName("ore_rutile");

        setCreativeTab(Aquaculture.creativeTab);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public Block setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}