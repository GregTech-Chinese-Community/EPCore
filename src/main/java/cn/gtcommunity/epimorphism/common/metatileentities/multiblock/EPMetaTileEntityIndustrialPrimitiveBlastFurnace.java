package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.NoEnergyMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.*;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class EPMetaTileEntityIndustrialPrimitiveBlastFurnace extends NoEnergyMultiblockController {

    private byte auxiliaryBlastFurnaceNumber = 0;

    private static final TraceabilityPredicate IS_SNOW_LAYER = new TraceabilityPredicate(bws -> GTUtility.isBlockSnowLayer(bws.getBlockState()));

    public EPMetaTileEntityIndustrialPrimitiveBlastFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityIndustrialPrimitiveBlastFurnace(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        if (context.get("AuxiliaryBlastFurnace1") != null) {
            auxiliaryBlastFurnaceNumber += 1;
        }
        if (context.get("AuxiliaryBlastFurnace2") != null) {
            auxiliaryBlastFurnaceNumber += 1;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        auxiliaryBlastFurnaceNumber = 0;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                .aisle("    CDDDC    ", "    CDDDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                .aisle("AAAGDDDDDJFFF", "GGG D###D JJJ", " G  D###D  J ", " G  D###D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                .aisle("AAAGDDDDDJFFF", "G@GHD#&#DIJ$J", "G G D###D J J", "G*G D###D J!J", "G*G D###D J!J", "G*G  D#D  J!J", "     D#D     ", "     D#D     ", "     D#D     ")
                .aisle("AAAGDDDDDJFFF", "GGG D###D JJJ", " G  D###D  J ", " G  D###D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                .aisle("    CDDDC    ", "    CDSDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                .where('S', selfPredicate())
                .where('A', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace1", getFireBoxState()))
                .where('C', states(getFrameState()))
                .where('D', states(getCasingState()))
                .where('F', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace2", getFireBoxState()))
                .where('G', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace1", getCasingState()))
                .where('H', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace1", getBoilerState()))
                .where('I', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace2", getBoilerState()))
                .where('J', EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace2", getCasingState()))
                .where('&', air().or(IS_SNOW_LAYER))
                .where('#', air())
                .where('@', /*EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace1", )*/any())
                .where('*', /*EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace1", )*/any())
                .where('$', /*EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace2", )*/any())
                .where('!', /*EPTraceabilityPredicate.optionalStates("AuxiliaryBlastFurnace2", )*/any())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.Steel).getBlock(Materials.Steel);
    }

    private static IBlockState getBoilerState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    private static IBlockState getFireBoxState() {
        return MetaBlocks.BOILER_FIREBOX_CASING.getState(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.PRIMITIVE_BRICKS;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.PRIMITIVE_BLAST_FURNACE_OVERLAY;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            textList.add(new TextComponentTranslation("epimorphism.machine.industrial_primitive_blast_furnace.auxiliary_blast_furnace", auxiliaryBlastFurnaceNumber));
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.industrial_primitive_blast_furnace.tooltip.1"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("    CDDDC    ", "    CDDDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("AAAGDDDDDJFFF", "GGG D   D JJJ", " G  D   D  J ", " G  D   D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                    .aisle("AAAGDDDDDJFFF", "G GHD   DIJ J", "G G D   D J J", "G*G D   D J!J", "G G D   D J J", "G G  D D  J J", "     D D     ", "     D D     ", "     D D     ")
                    .aisle("AAAGDDDDDJFFF", "GGG D   D JJJ", " G  D   D  J ", " G  D   D  J ", " G   DDD   J ", " G    D    J ", "      D      ", "      D      ", "      D      ")
                    .aisle("    CDDDC    ", "    CDSDC    ", "    CDDDC    ", "     DDD     ", "             ", "             ", "             ", "             ", "             ")
                    .aisle("     DDD     ", "             ", "             ", "             ", "             ", "             ", "             ", "             ", "             ")
                    .where('S', EPMetaTileEntities.INDUSTRIAL_PRIMITIVE_BLAST_FURNACE, EnumFacing.SOUTH)
                    .where('C', getFrameState())
                    .where('D', getCasingState())
                    .where(' ', Blocks.AIR.getDefaultState());
            shapeInfo.add(builder.build());
            shapeInfo.add(builder
                    .where('A', getFireBoxState())
                    .where('G', getCasingState())
                    .where('H', getBoilerState())
                    .build());
            shapeInfo.add(builder
                    .where('F', getFireBoxState())
                    .where('I', getBoilerState())
                    .where('J', getCasingState())
                    .build());
        }
        return shapeInfo;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }
}
