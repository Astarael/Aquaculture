package com.astarael.aquaculture.TileEntitities.Inventories;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.TileEntitities.TileEntityEvaporationTower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    // Evaporation Tower
    private static final int E_TOWER_HEIGHT = 152;
    private static final int E_TOWER_WIDTH = 180;
    private static final ResourceLocation E_TOWER_BKG = new ResourceLocation(Aquaculture.MODID, "textures/gui/evaporation_tower.png");

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityEvaporationTower) {
            return new ContainerEvaporationTower(player.inventory, (TileEntityEvaporationTower) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityEvaporationTower) {
            TileEntityEvaporationTower containerTileEntity = (TileEntityEvaporationTower) te;
            return new AquacultureGui(world.getTileEntity( new BlockPos(x, y, z)), new ContainerEvaporationTower(player.inventory, containerTileEntity), E_TOWER_WIDTH, E_TOWER_HEIGHT, E_TOWER_BKG);
        }
        return null;
    }
}
