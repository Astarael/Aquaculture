package com.astarael.aquaculture.TileEntitities.Inventories;

import com.astarael.aquaculture.Aquaculture;
import com.astarael.aquaculture.TileEntitities.TileEntityEvaporationTower;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class AquacultureGui extends GuiContainer {

    private final ResourceLocation background;

    public AquacultureGui(TileEntity tileEntity, BaseContainer container, int width, int height, ResourceLocation background) {
        super(container);

        xSize = width;
        ySize = height;
        this.background = background;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
