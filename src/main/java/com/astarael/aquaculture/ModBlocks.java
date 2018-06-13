package com.astarael.aquaculture;

import com.astarael.aquaculture.Blocks.*;
import com.astarael.aquaculture.TileEntitities.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("aquaculture:limekiln")
    public static LimeKiln limeKiln;

    @GameRegistry.ObjectHolder("aquaculture:limestone")
    public static Limestone limestone;

    @GameRegistry.ObjectHolder("aquaculture:vat")
    public static Vat vat;

    @GameRegistry.ObjectHolder("aquaculture:ore_titanium")
    public static Ore_Titanium oretitanium;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        limeKiln.initModel();
        limestone.initModel();
        vat.initModel();
        oretitanium.initModel();
    }

}
