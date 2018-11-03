package com.astarael.aquaculture.Registry;

import com.astarael.aquaculture.Blocks.*;
import com.astarael.aquaculture.TileEntitities.*;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("aquaculture:limekiln")
    public static LimeKiln limeKiln;

    @GameRegistry.ObjectHolder("aquaculture:limestone")
    public static Limestone limestone;

    @GameRegistry.ObjectHolder("aquaculture:vat")
    public static Vat vat = new Vat();

    @GameRegistry.ObjectHolder("aquaculture:ore_rutile")
    public static Ore_Rutile ore_rutile;

    @GameRegistry.ObjectHolder("aquaculture:evaporationtower")
    public static EvaporationTower evaporationTower = new EvaporationTower();

    @GameRegistry.ObjectHolder("aquaculture:brineblock")
    public static BlockAquacultureFluid brineBlock;

    @SideOnly(Side.CLIENT)
    public static void initModels (ModelRegistryEvent event) {

        limeKiln.initModel();
        limestone.initModel();
        vat.initModel();
        ore_rutile.initModel();
        evaporationTower.initModel();

    }


}
