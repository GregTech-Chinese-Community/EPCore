package cn.gtcommunity.epimorphism.api.metatileentity.multiblock;

import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import cn.gtcommunity.epimorphism.api.recipe.properties.GlassTierProperty;
import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class GlassTierMultiblockController extends RecipeMapMultiblockController {
    private int glassTier;

    public GlassTierMultiblockController(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return this.glassTier >= recipe.getProperty(GlassTierProperty.getInstance(), 0) && super.checkRecipe(recipe, consumeIfSuccess);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CasingType");
        if (type instanceof ITierGlassBlockState) {
            this.glassTier = ((ITierGlassBlockState) type).getGlassTier();
        } else {
            this.glassTier = 0;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.glassTier = 0;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (this.isStructureFormed() && glassTier > 0) {
            String tierName = GTValues.VNF[glassTier];
            textList.add(0, new TextComponentTranslation("epimorphism.machine.multiblock.glass_tier", new Object[]{glassTier, tierName}));
        }
    }

    public int getGlassTier() {return this.glassTier;}
}
