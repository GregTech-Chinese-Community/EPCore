package cn.gtcommunity.epimorphism.common.items.behaviors.renderer;

import cn.gtcommunity.epimorphism.api.items.metaitem.stats.renderer.IItemRendererManager;
import cn.gtcommunity.epimorphism.client.renderer.handler.DataItemRenderer;
import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class DataRenderItemBehavior implements IItemRendererManager {
    @Override
    public void onRendererRegistry(ResourceLocation location) {
        ModelRegistryHelper.register(new ModelResourceLocation(location, "inventory"), new DataItemRenderer(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(new ModelResourceLocation(location, "inventory"))));
    }
}
