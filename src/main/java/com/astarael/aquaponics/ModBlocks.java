package com.astarael.aquaponics;

import com.astarael.aquaponics.Blocks.*;
import com.astarael.aquaponics.TileEntitities.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("aquaponics:limekiln")
    public static LimeKiln limeKiln;

    @GameRegistry.ObjectHolder("aquaponics:limestone")
    public static Limestone limestone;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        limeKiln.initModel();
        limestone.initModel();
    }

}
