package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.block.IGlassTierBlockState;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EPMetaTileEntityCVDUnit extends GlassTierMultiblockController {

//    private int glassTier;
    private int temperature;

    public EPMetaTileEntityCVDUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.CVD_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new EPMetaTileEntityCVDUnit(metaTileEntityId);
    }

//    @Override
//    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
//        return this.glassTier >= recipe.getProperty(GlassTierProperty.getInstance(), 0) && super.checkRecipe(recipe, consumeIfSuccess);
//    }
//
//    @Override
//    protected void formStructure(PatternMatchContext context) {
//        super.formStructure(context);
//        Object type = context.get("CasingType");
//        if (type instanceof IGlassTierBlockState) {
//            this.glassTier = ((IGlassTierBlockState) type).getGlassTier();
//        } else {
//            this.glassTier = 0;
//        }
//    }
//
//    @Override
//    public void invalidateStructure() {
//        super.invalidateStructure();
//        this.glassTier = 0;
//    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "XGGGX", "XGGGX")
                .aisle("XXXXX", "XCCCX", "XGGGX").setRepeatable(3)
                .aisle("XXXXX", "SGGGX", "XGGGX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(35)
                        .or(autoAbilities()))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('C', states(getSubstrateState()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getSubstrateState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.SUBSTRATE_CASING);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return EPTextures.CVD_UNIT_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.NONCONDUCTING_CASING;
    }

//    @Override
//    protected void addDisplayText(List<ITextComponent> textList) {
//        super.addDisplayText(textList);
//        if (this.isStructureFormed() && glassTier > 0) {
//            String tierName = GTValues.VNF[glassTier];
//            textList.add(new TextComponentTranslation("epimorphism.machine.multiblock.glass_tier", new Object[]{glassTier, tierName}));
//        }
//    }

    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("EETXX", "RGGGU", "PGGGQ")
                .aisle("XXXXX", "XCCCX", "XGGGX")
                .aisle("XXXXX", "XCCCX", "XGGGX")
                .aisle("XXXXX", "XCCCX", "XGGGX")
                .aisle("XXXXX", "SGGGX", "XGGGX")
                .where('S', EPMetaTileEntities.CVD_UNIT, EnumFacing.SOUTH)
                .where('X', getCasingState())
                .where('C', getSubstrateState())
                .where('P', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.NORTH)
                .where('Q', MetaTileEntities.ITEM_EXPORT_BUS[4], EnumFacing.NORTH)
                .where('R', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.NORTH)
                .where('U', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.NORTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[4], EnumFacing.NORTH)
                .where('T', () -> {
                    return ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
                }, EnumFacing.NORTH);
        EPAPI.EP_Glass.entrySet().stream().sorted(Comparator.comparingInt((entry) -> {
            return ((IGlassTierBlockState)entry.getValue()).getGlassTier();
        })).forEach((entry) -> {
            shapeInfo.add(builder.where('G', (IBlockState)entry.getKey()).build());
        });
        return shapeInfo;
    }
}
