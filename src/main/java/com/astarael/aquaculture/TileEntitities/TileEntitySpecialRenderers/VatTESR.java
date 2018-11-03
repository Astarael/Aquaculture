package com.astarael.aquaculture.TileEntitities.TileEntitySpecialRenderers;

import com.astarael.aquaculture.Registry.ModBlocks;
import com.astarael.aquaculture.TileEntitities.TileEntityVat;
import com.astarael.aquaculture.TileEntitities.Vat;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class VatTESR extends TileEntitySpecialRenderer<TileEntityVat> {

    /*private static final ModelVertex[] model = new ModelVertex[4];

    static {
        model[0] = new ModelVertex(EnumFacing.UP, 0.125, 0.875, 0.125, 0, 0);
        model[1] = new ModelVertex(EnumFacing.UP, 0.875, 0.875, 0.125, 1, 0);
        model[2] = new ModelVertex(EnumFacing.UP, 0.875, 0.875, 0.875, 1, 1);
        model[3] = new ModelVertex(EnumFacing.UP, 0.125, 0.875, 0.875, 0, 1);
    }*/

    /*@Override
    public void render(TileEntityVat te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushAttrib();
        GlStateManager.pushMatrix();

        // Translate to the location of our tile entity
        GlStateManager.translate(x, y, z);
        GlStateManager.disableRescaleNormal();

        // Render the rotating handles
        renderHandles(te);

        // Render our item
        renderItem(te);

        GlStateManager.popMatrix();
        GlStateManager.popAttrib();
    }*/


    /* TODO Fill level needs implementing
    @Override
    public void renderTileEntityFast(@Nullable TileEntityVat te, double x, double y, double z, float partialTicks, int destroyStage, float partial, @Nullable BufferBuilder buffer) {
        if (te == null || te.getMode() == null || buffer == null) return;

        // Fill Level
        float fill = te.getMode().getFilledLevelForRender(te);

        if (fill == 0) return;

        final SpriteColor sprite = te.getMode().getSpriteColor(te);
        buffer.setTranslation(x, y, z);
        addSpriteColor(te, sprite, buffer, te.getMode().getFilledLevelForRender(te));
        buffer.setTranslation(0, 0, 0);

    }

    private void addSpriteColor(TileBarrel te, SpriteColor sprite, BufferBuilder buffer, float fill) {
        if (sprite == null) return;

        final BlockPos pos = te.getPos();
        // Light levels
        final int mixedBrightness = te.getWorld().getBlockState(pos).getPackedLightmapCoords(te.getWorld(), te.getPos());
        final int skyLight = mixedBrightness >> 16 & 0xFFFF;
        final int blockLight = mixedBrightness & 0xFFFF;
        // Texturing
        TextureAtlasSprite icon = sprite.getSprite();
        Color color = sprite.getColor();

        // Draw
        for (final ModelVertex vert : model) {
            for (final VertexFormatElement e : buffer.getVertexFormat().getElements()) {
                switch (e.getUsage()) {
                    case COLOR:
                        buffer.color(color.r, color.g, color.b, color.a);
                        break;

                    case NORMAL:
                        buffer.normal(vert.face.getXOffset(), vert.face.getYOffset(), vert.face.getZOffset());
                        break;

                    case POSITION:
                        final double vertX = vert.x;
                        final double vertZ = vert.z;

                        buffer.pos(vertX, (double) fill, vertZ);
                        break;

                    case UV:
                        if (e.getIndex() == 1) {
                            buffer.lightmap(skyLight, blockLight);
                        } else {
                            buffer.tex(icon.getInterpolatedU(vert.u), icon.getInterpolatedV(16.0 - vert.v));
                        }
                        break;

                    default:
                        break;
                }
            }
            buffer.endVertex();
}*/

    private void renderItem(TileEntityVat te) {
        ItemStack stack = te.getStack(false);
        if (!stack.isEmpty()) {
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableLighting();
            GlStateManager.pushMatrix();
            // Translate to the center of the block and .9 points higher
            GlStateManager.translate(.5, .9, .5);
            GlStateManager.scale(.4f, .4f, .4f);

            Minecraft.getMinecraft().getRenderItem().renderItem(stack, ItemCameraTransforms.TransformType.NONE);

            GlStateManager.popMatrix();
        }
    }

}