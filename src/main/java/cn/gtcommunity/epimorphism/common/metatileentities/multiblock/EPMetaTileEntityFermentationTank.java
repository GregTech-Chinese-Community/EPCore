package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.capability.EPCapabilities;
import cn.gtcommunity.epimorphism.api.capability.IPHValue;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.recipe.properties.PHChangeProperty;
import cn.gtcommunity.epimorphism.api.recipe.properties.PHErrorRangeProperty;
import cn.gtcommunity.epimorphism.api.recipe.properties.PHProperty;
import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockGlassCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;

import java.util.List;

import static gregtech.api.unification.material.Materials.Steel;

public class EPMetaTileEntityFermentationTank extends RecipeMapMultiblockController implements IPHValue {
    private double pH = 7;

    public EPMetaTileEntityFermentationTank(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.FERMENTATION_TANK_RECIPES);
        this.recipeMapWorkable = new PHRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new EPMetaTileEntityFermentationTank(metaTileEntityId);
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        double min = recipe.getProperty(PHProperty.getInstance(), 7D) - recipe.getProperty(PHErrorRangeProperty.getInstance(), 0D);
        double max = recipe.getProperty(PHProperty.getInstance(), 7D) + recipe.getProperty(PHErrorRangeProperty.getInstance(), 0D);
        if (min < 0) {min = 0D;}
        if (max > 14) {max = 14D;}
        return this.pH >= min && this.pH <= max;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.pH = 7D;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("FAAAF", "FXXXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                .aisle("AXXXA", "XEPEX", "GEPEG", "GEPEG", "GEPEG", "XEPEX", "AXXXA")
                .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                .aisle("FAAAF", "FXSXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(42).or(autoAbilities()).or(abilities(EPCapabilities.BUFFER_MULTIBLOCK_ABILITY).setExactLimit(1)))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where('P', states(getBoilerState()))
                .where('A', any())
                .where('E', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    private static IBlockState getBoilerState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    @Nonnull
    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Steel).getBlock(Steel);
    }

    private static IBlockState getGlassState() {
        return EPMetablocks.EP_GLASS_CASING.getState(EPBlockGlassCasing.CasingType.OSMIR_BORON_SILICATE_GLASS);
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        textList.add(new TextComponentString(String.valueOf(this.pH)));
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return EPTextures.CVD_UNIT_OVERLAY;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @Override
    public double getCurrentPHValue() {
        return this.pH;
    }

    @Override
    public void changeCurrentPHValue(double ph_change) {
        double ph = this.pH + ph_change;
        if (ph < 0){
            this.pH = 0D;
        } else if (ph > 14){
            this.pH = 14D;
        } else {this.pH = ph;}
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setDouble("ph", this.pH);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.pH = data.getDouble("ph");
    }

    protected class PHRecipeLogic extends MultiblockRecipeLogic {
        private Recipe current_recipe;
        public PHRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
            super(metaTileEntity);
            if (!(metaTileEntity instanceof IPHValue)) {
                throw new IllegalArgumentException("MetaTileEntity must be instanceof IPHValue");
            }
        }

        @Override
        protected void setupRecipe(Recipe recipe) {
            super.setupRecipe(recipe);
            this.current_recipe = recipe;
        }

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            ((IPHValue)this.metaTileEntity).changeCurrentPHValue(current_recipe.getProperty(PHChangeProperty.getInstance(), 0D));
        }
    }
}
