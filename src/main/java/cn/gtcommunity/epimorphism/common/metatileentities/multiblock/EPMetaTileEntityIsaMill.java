package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.EPMultiblockAbility;
import cn.gtcommunity.epimorphism.api.capability.IBall;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.recipe.properties.GrindBallTierProperty;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.damagesources.DamageSources;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.core.advancement.AdvancementTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class EPMetaTileEntityIsaMill extends RecipeMapMultiblockController {

    public EPMetaTileEntityIsaMill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.ISA_MILL_GRINDER);
        this.recipeMapWorkable = new EPMetaTileEntityIsaMill.IsaMillLogic(this);
    }

    protected IBlockState getCasingState() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.ISA_MILL_CASING);
    }

    protected IBlockState getCasingState1() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.ISA_MILL_CASING_GEARBOX);
    }

    protected IBlockState getCasingState2() {
        return EPMetablocks.EP_MILL_CASING.getState(EPBlockMillCasing.CasingType.ISA_MILL_CASING_PIPE);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEE", "EEE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("CCC", "CSC", "CCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState2()))
                .where('E', states(getCasingState()).setMinGlobalLimited(31)
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(EPMultiblockAbility.GRINDBALL_MULTIBLOCK_ABILITY).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('G', states(getCasingState1()))
                .build();
    }

    public IBall getBallHolder() {
        List<IBall> abilities = getAbilities(EPMultiblockAbility.GRINDBALL_MULTIBLOCK_ABILITY);
        if (abilities.isEmpty())
            return null;
        return abilities.get(0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return EPTextures.ISA_MILL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityIsaMill(metaTileEntityId);
    }

    private boolean onRotorHolderInteract(@Nonnull EntityPlayer player) {
        if (player.isCreative()) return false;

        if (!getWorld().isRemote && this.isActive()) {
            player.attackEntityFrom(DamageSources.getTurbineDamage(), 7);
            AdvancementTriggers.ROTOR_HOLDER_DEATH.trigger((EntityPlayerMP) player);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn) || super.onRightClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public boolean onWrenchClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn) || super.onWrenchClick(playerIn, hand, facing, hitResult);
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return onRotorHolderInteract(playerIn);
    }

    @Override
    public void onLeftClick(EntityPlayer player, EnumFacing facing, CuboidRayTraceResult hitResult) {
        onRotorHolderInteract(player);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        EPTextures.ISA_MILL.renderSided(renderState, translation, pipeline, getFrontFacing(), isStructureFormed(), this.getRecipeLogic().isActive());
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return EPTextures.ISA_MILL_OVERLAY;
    }

    public class IsaMillLogic extends MultiblockRecipeLogic {

        private final EPMetaTileEntityIsaMill metaTileEntity;

        private int current_grind_ball_tier;
        public IsaMillLogic(EPMetaTileEntityIsaMill tileEntity) {
            super(tileEntity);
            this.metaTileEntity = tileEntity;
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            return super.checkRecipe(recipe) && (recipe.getProperty(GrindBallTierProperty.getInstance(), 0) == metaTileEntity.getBallHolder().getGrinderTier());
        }

        @Override
        protected void setupRecipe(Recipe recipe) {
            super.setupRecipe(recipe);
            this.current_grind_ball_tier = recipe.getProperty(GrindBallTierProperty.getInstance(), 0);
        }

        protected boolean canProgressRecipe() {
            return (super.canProgressRecipe() && !((IMultiblockController)this.metaTileEntity).isStructureObstructed() && this.checkGrindBallTier());
        }

        private boolean checkGrindBallTier() {
                return this.metaTileEntity.getBallHolder().getGrinderTier() == this.current_grind_ball_tier;
        }

        @Nonnull
        @Override
        public NBTTagCompound serializeNBT() {
            NBTTagCompound tag = super.serializeNBT();
            tag.setInteger("current_grind_ball_tier", this.current_grind_ball_tier);
            return tag;
        }

        @Override
        public void deserializeNBT(@Nonnull NBTTagCompound compound) {
            super.deserializeNBT(compound);
            this.current_grind_ball_tier = compound.getInteger("current_grind_ball_tier");
        }

        @Override
        protected void completeRecipe() {
            super.completeRecipe();
            this.metaTileEntity.getBallHolder().damageGrinder(10);
        }
    }
}
