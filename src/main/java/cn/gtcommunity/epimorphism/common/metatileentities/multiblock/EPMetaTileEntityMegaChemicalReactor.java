package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.core.sound.GTSoundEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EPMetaTileEntityMegaChemicalReactor extends GlassTierMultiblockController {
    public EPMetaTileEntityMegaChemicalReactor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.LARGE_CHEMICAL_RECIPES);
        this.recipeMapWorkable = new MegaChemicalReactorWorkableHandler(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityMegaChemicalReactor(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC").setRepeatable(7)
                .aisle("CCCCC", "CGGGC", "CGSGC", "CGGGC", "CCCCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()).setMinGlobalLimited(65).or(autoAbilities()))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('L', states(getCoilState()))
                .where('P', states(getBoilerState()))
                .where('A', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING);
    }

    private static IBlockState getCoilState() {
        return MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_COIL);
    }

    private static IBlockState getBoilerState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.INERT_PTFE_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.LARGE_CHEMICAL_REACTOR_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
        tooltip.add(I18n.format("epimorphism.machine.mega_chemical_reactor.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.mega_chemical_reactor.tooltip.2"));
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
            IEnergyContainer energyContainer = this.recipeMapWorkable.getEnergyContainer();
            if (energyContainer != null && energyContainer.getEnergyCapacity() > 0L) {
                long maxVoltage = Math.max(energyContainer.getInputVoltage(), energyContainer.getOutputVoltage());
                int voltage = Math.min(GTUtility.getFloorTierByVoltage(maxVoltage), getGlassTier());
                String voltageName = GTValues.VNF[voltage];
                textList.add(2, new TextComponentTranslation("epimorphism.machine.multiblock.max_parallel", 256));
                textList.add(1, new TextComponentTranslation("epimorphism.machine.multiblock.max_voltage", voltageName));
            }
        }
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = MultiblockShapeInfo.builder()
                .aisle("CEMCC", "CCCCC", "CCCCC", "CCCCC", "CCCCC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("CPCPC", "GAAAG", "GALAG", "GAAAG", "CPCPC")
                .aisle("IFFOK", "CGGGC", "CGSGC", "CGGGC", "CCCCC")
                .where('S', EPMetaTileEntities.MEGA_CHEMICAL_REACTOR, EnumFacing.SOUTH)
                .where('C', getCasingState())
                .where('L', getCoilState())
                .where('P', getBoilerState())
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.SOUTH)
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.SOUTH)
                .where('O', MetaTileEntities.ITEM_EXPORT_BUS[4], EnumFacing.SOUTH)
                .where('K', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[5], EnumFacing.NORTH)
                .where('M', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH)
                .where('A', Blocks.AIR.getDefaultState());
        EPAPI.MAP_GLASS_SHAPE_INFO.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> (int) entry.getValue().getTier()))
                .forEach(entry -> shapeInfo.add(builder.where('G', entry.getKey()).build()));
        return shapeInfo;
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    private class MegaChemicalReactorWorkableHandler extends MultiblockRecipeLogic {
        public MegaChemicalReactorWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity, true);
        }

        @Override
        protected long getMaxVoltage() {
            return Math.min(GTValues.V[((GlassTierMultiblockController)this.metaTileEntity).getGlassTier()], super.getMaxVoltage());
        }

        @Override
        protected long getMaxParallelVoltage() {
            return super.getMaxVoltage();
        }

        @Override
        public int getParallelLimit() {
            return 256;
        }
    }
}
