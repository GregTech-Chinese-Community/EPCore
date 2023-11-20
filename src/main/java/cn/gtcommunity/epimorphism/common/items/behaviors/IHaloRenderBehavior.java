package cn.gtcommunity.epimorphism.common.items.behaviors;

import cn.gtcommunity.epimorphism.api.items.metaitem.stats.IItemRendererManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHaloRenderBehavior extends IItemRendererManager {
    @SideOnly(Side.CLIENT)
    boolean shouldDrawHalo();

    @SideOnly (Side.CLIENT)
    TextureAtlasSprite getHaloTexture();

    @SideOnly (Side.CLIENT)
    int getHaloColour();

    @SideOnly (Side.CLIENT)
    int getHaloSize();

    @SideOnly (Side.CLIENT)
    boolean shouldDrawPulse();
}
