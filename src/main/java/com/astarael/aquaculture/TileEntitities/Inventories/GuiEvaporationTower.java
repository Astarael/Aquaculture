package com.astarael.aquaculture.TileEntitities.Inventories;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.TileEntitities.TileEntityEvaporationTower;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiEvaporationTower extends GuiContainer {

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(Aquaculture.MODID, "textures/gui/testcontainer.png");

    public GuiEvaporationTower(TileEntityEvaporationTower tileEntity, ContainerEvaporationTower container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
