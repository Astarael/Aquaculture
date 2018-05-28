package com.astarael.aquaponics;

import com.astarael.aquaponics.Blocks.Limestone;
import com.astarael.aquaponics.Items.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder("aquaponics:fishCod")
    public static FishCod fishCod;

    public static ItemIngotTitanium ingotTitanium;
    public static Limestone limestone;
}
