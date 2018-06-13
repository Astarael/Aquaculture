package com.astarael.aquaculture.TileEntitities;

import com.astarael.aquaculture.Aquaculture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class Vat extends Block {

    public Vat() {

        super(Material.ROCK);
        setUnlocalizedName(Aquaculture.MODID + ".vat");     // Used for localization (en_US.lang)
        setRegistryName("vat");        // The unique name (within your mod) that identifies this block

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

}
