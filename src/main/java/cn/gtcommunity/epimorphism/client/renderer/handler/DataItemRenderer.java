package cn.gtcommunity.epimorphism.client.renderer.handler;

import cn.gtcommunity.epimorphism.api.items.metaitem.IRenderer;
import cn.gtcommunity.epimorphism.common.items.behaviors.renderer.DataRenderItemBehavior;
import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.render.item.IItemRenderer;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.IResearchRecipeMap;
import gregtech.api.util.AssemblyLineManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.IModelState;
import org.lwjgl.input.Keyboard;

import java.util.Collection;

public class DataItemRenderer implements IItemRenderer {

    protected IBakedModel wrapped;
    private final IModelState state;

    public DataItemRenderer(IModelState state, WrappedItemRenderer.IWrappedModelGetter getter) {
        this.state = state;
        ModelRegistryHelper.registerPreBakeCallback(modelRegistry -> wrapped = getter.getWrappedModel(modelRegistry));
    }

    @Override
    public void renderItem(ItemStack stack, ItemCameraTransforms.TransformType transformType) {

        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        GlStateManager.translate(0.5F, 0.5F, 0.5F);
        boolean needSpecialRender = false;

        do {
            if (transformType != ItemCameraTransforms.TransformType.GUI) break;

            MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>)stack.getItem()).getItem(stack);
            DataRenderItemBehavior dri = null;

            if (valueItem != null) {
                dri = (DataRenderItemBehavior) ((IRenderer)valueItem).getRendererManager();
            }
            if (dri == null || !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) break;

            String researchId = AssemblyLineManager.readResearchId(stack);
            if (researchId == null) break;

            Collection<Recipe> recipes = ((IResearchRecipeMap) RecipeMaps.ASSEMBLY_LINE_RECIPES).getDataStickEntry(researchId);
            if (recipes == null || recipes.isEmpty()) break;

            for (Recipe recipe : recipes) {
                renderItem.renderItem(recipe.getOutputs().get(0), transformType);
            }

            needSpecialRender = true;

        } while (!needSpecialRender);

        if (!needSpecialRender) {
            renderItem.renderItem(stack, wrapped);
        }
    }

    @Override
    public IModelState getTransforms() {
        return state;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }
}
