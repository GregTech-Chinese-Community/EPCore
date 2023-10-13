package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.client.textures.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IHeatingCoil;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.impl.HeatingCoilRecipeLogic;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.util.GTUtility;
import gregtech.api.util.TextFormattingUtil;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.BlazingPyrotheum;
import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;

public class EPMetaTileEntityBlazingBlastFurnace extends RecipeMapMultiblockController implements IHeatingCoil {
    private int blastFurnaceTemperature;
    protected static int heatingCoilLevel;
    protected int heatingCoilDiscount;

    public EPMetaTileEntityBlazingBlastFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, BLAST_RECIPES);
        this.recipeMapWorkable = new HeatingCoilRecipeLogic(this);
        this.recipeMapWorkable = new BlazingBlastRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity metaTileEntityHolder) {
        return new EPMetaTileEntityBlazingBlastFurnace(this.metaTileEntityId);
    }

    //  CoilType Context
    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        Object coilType = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.blastFurnaceTemperature = ((IHeatingCoilBlockStats) type).getCoilTemperature();
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
            this.heatingCoilDiscount = ((IHeatingCoilBlockStats) coilType).getEnergyDiscount();
        } else {
            this.blastFurnaceTemperature = BlockWireCoil.CoilType.CUPRONICKEL.getCoilTemperature();
            this.heatingCoilLevel = BlockWireCoil.CoilType.CUPRONICKEL.getLevel();
            this.heatingCoilDiscount = BlockWireCoil.CoilType.CUPRONICKEL.getEnergyDiscount();
        }

        this.blastFurnaceTemperature += 100 * Math.max(0, GTUtility.getTierByVoltage(getEnergyContainer().getInputVoltage()) - GTValues.MV);
    }

    //  Check recipe
    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe, boolean consumeIfSuccess) {
        return this.blastFurnaceTemperature >= recipe.getProperty(TemperatureProperty.getInstance(), 0);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(new String[]{"XXX", "CCC", "CCC", "XXX"})
                .aisle(new String[]{"XXX", "C#C", "C#C", "XMX"})
                .aisle(new String[]{"XSX", "CCC", "CCC", "XXX"})
                .where('S', this.selfPredicate())
                .where('X', states(new IBlockState[]{this.getCasingState()})
                        .setMinGlobalLimited(9)
                        .or(this.autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(new MultiblockAbility[]{MultiblockAbility.MUFFLER_HATCH}))
                .where('C', heatingCoils())
                .where('#', air())
                .build();
    }
    protected IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.ADVANCED_INVAR_CASING);
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("EEM", "CCC", "CCC", "XXX")
                    .aisle("FXD", "C#C", "C#C", "XHX")
                    .aisle("ISO", "CCC", "CCC", "XXX")
                    .where('S', EPMetaTileEntities.BLAZING_BLAST_FURNACE, EnumFacing.SOUTH)
                    .where('X', getCasingState())
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[5], EnumFacing.NORTH)
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.SOUTH)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[4], EnumFacing.SOUTH)
                    .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.WEST)
                    .where('D', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.EAST)
                    .where('H', MetaTileEntities.MUFFLER_HATCH[1], EnumFacing.UP)
                    .where('#', Blocks.AIR.getDefaultState())
                    .where('M', () -> {
                        return ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.ADVANCED_INVAR_CASING);
                    }, EnumFacing.NORTH);
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .forEach(entry -> {
                    if (finalBuilder != null) {
                        shapeInfo.add(finalBuilder.where('C', entry.getKey()).build());
                    }
                });
        return shapeInfo;
    }

    //  Tooltips
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.1"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.2"));
        tooltip.add(I18n.format("gregtech.machine.electric_blast_furnace.tooltip.3"));
        tooltip.add(I18n.format("epimorphism.machine.blazing_blast_furnace.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.blazing_blast_furnace.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.blazing_blast_furnace.tooltip.3"));
    }

    //  Display Texts
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        if (isStructureFormed()) {

            if (getInputFluidInventory() != null) {
                FluidStack LubricantStack = getInputFluidInventory().drain(BlazingPyrotheum.getFluid(Integer.MAX_VALUE), false);
                int liquidOxygenAmount = LubricantStack == null ? 0 : LubricantStack.amount;
                textList.add(new TextComponentTranslation("epimorphism.machine.blazing_blast_furnace.amount", TextFormattingUtil.formatNumbers((liquidOxygenAmount))));
                textList.add(new TextComponentTranslation("epimorphism.machine.blazing_blast_furnace.heat"));
            }
            textList.add(new TextComponentTranslation("gregtech.multiblock.blast_furnace.max_temperature", blastFurnaceTemperature)
                    .setStyle(new Style().setColor(TextFormatting.RED)));
            textList.add(new TextComponentTranslation("gregtech.multiblock.multi_furnace.heating_coil_level", heatingCoilLevel));
            textList.add(new TextComponentTranslation("gregtech.multiblock.multi_furnace.heating_coil_discount", heatingCoilDiscount));
        }
        super.addDisplayText(textList);
    }

    //  Warning
    @Override
    protected void addWarningText(List<ITextComponent> textList) {
        super.addWarningText(textList);
        if (isStructureFormed()) {
            FluidStack lubricantStack = getInputFluidInventory().drain(BlazingPyrotheum.getFluid(Integer.MAX_VALUE), false);
            if (lubricantStack == null || lubricantStack.amount == 0) {
                textList.add(new TextComponentTranslation("epimorphism.machine.blazing_blast_furnace.warning"));
            }
        }
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.ADVANCED_INVAR_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return Textures.BLAST_FURNACE_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public int getCurrentTemperature() {
        return this.blastFurnaceTemperature;
    }

    /**  getMaxParallel(int heatingCoilLevel)
     *     @param heatingCoilLevel the level to get the parallel for
     *     @return the max parallel for the heating coil level
     */
    public static int getMaxParallel(int heatingCoilLevel) {
        return heatingCoilLevel;
    }

    private final FluidStack BLAZING_STACK = BlazingPyrotheum.getFluid(2);

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        blastFurnaceTemperature = 0;
        heatingCoilLevel = 0;
        heatingCoilDiscount = 0;
    }

    protected class BlazingBlastRecipeLogic extends MultiblockRecipeLogic {

        private final EPMetaTileEntityBlazingBlastFurnace combustionEngine;
        public BlazingBlastRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
            this.combustionEngine = (EPMetaTileEntityBlazingBlastFurnace) tileEntity;
        }

        @Override
        public int getParallelLimit() {
            return getMaxParallel(heatingCoilLevel);
        }

        protected void updateRecipeProgress() {
            if (canRecipeProgress && drawEnergy(recipeEUt, true)) {
                IMultipleTankHandler inputTank = combustionEngine.getInputFluidInventory();
                if (BLAZING_STACK.isFluidStackIdentical(inputTank.drain(BLAZING_STACK, false))) {
                    inputTank.drain(BLAZING_STACK, true);
                    if (++progressTime > maxProgressTime) {
                        completeRecipe();
                    }
                }
                else return;
                drawEnergy(recipeEUt, false);
            }
        }
    }
}