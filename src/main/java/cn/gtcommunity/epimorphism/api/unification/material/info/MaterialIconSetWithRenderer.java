package cn.gtcommunity.epimorphism.api.unification.material.info;

import cn.gtcommunity.epimorphism.api.items.metaitem.stats.renderer.IItemRendererManager;
import cn.gtcommunity.epimorphism.api.items.metaitem.IRenderer;
import gregtech.api.unification.material.info.MaterialIconSet;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MaterialIconSetWithRenderer extends MaterialIconSet implements IRenderer, IItemRendererManager {

    private IItemRendererManager rendererManager;

    public MaterialIconSetWithRenderer(@Nonnull String name, IItemRendererManager rendererManager) {
        super(name);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@Nonnull String name, @Nonnull MaterialIconSet parentIconset, IItemRendererManager rendererManager) {
        super(name, parentIconset);
        this.rendererManager = rendererManager;
    }

    public MaterialIconSetWithRenderer(@Nonnull String name, @Nullable MaterialIconSet parentIconset, boolean isRootIconset, IItemRendererManager rendererManager) {
        super(name, parentIconset, isRootIconset);
        this.rendererManager = rendererManager;
    }


    @Override
    public IItemRendererManager getRendererManager() {
        return rendererManager;
    }

    @Override
    public void onRendererRegistry(ResourceLocation location) {
        rendererManager.onRendererRegistry(location);
    }
}
