package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.GlassTierMultiblockController;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.*;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
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
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class EPMetaTileEntityMegaOilCrackingUnit extends GlassTierMultiblockController {

    private int coilTier;
    protected int heatingCoilLevel;

    private static boolean init = false;
    private static List<IBlockState> finalListCoil;
    private static List<IBlockState> finalListGlass;

    public EPMetaTileEntityMegaOilCrackingUnit(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.CRACKING_RECIPES);
        this.recipeMapWorkable = new MegaCrackingUnitWorkableHandler(this);
        initMap();
    }
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityMegaOilCrackingUnit(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> listCoil = GregTechAPI.HEATING_COILS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().getTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        List<IBlockState> listGlass = EPAPI.MAP_GLASS_SHAPE_INFO.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> (int) entry.getValue().getTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int maxLeng = EPUniverUtil.maxLength(new ArrayList<List<IBlockState>>() {{
            add(listCoil);
            add(listGlass);
        }});
        finalListCoil = EPUniverUtil.consistentList(listCoil, maxLeng);
        finalListGlass = EPUniverUtil.consistentList(listGlass, maxLeng);

        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object type = context.get("CoilType");
        if (type instanceof IHeatingCoilBlockStats) {
            this.coilTier = ((IHeatingCoilBlockStats) type).getTier();
            this.heatingCoilLevel = ((IHeatingCoilBlockStats) type).getLevel();
        } else {
            this.coilTier = 0;
            this.heatingCoilLevel = 1;
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        this.coilTier = -1;
        this.heatingCoilLevel = 0;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle(
                        "CCCCCCCCCCCCC",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC"
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " CGGGGGGGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EAAAAAAAAAD ",
                        " EALALALALAD ",
                        " EAAAAAAAAAD ",
                        " GALALALALAG ",
                        " CGGGEEEGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " EALALALALAD ",
                        " GALALALALAG ",
                        " CGGGEEEGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " EAAAAAAAAAD ",
                        " EALALALALAD ",
                        " EAAAAAAAAAD ",
                        " GALALALALAG ",
                        " CGGGEEEGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " GALALALALAG ",
                        " CGGGGGGGGGC "
                )
                .aisle(
                        "CCCCCCCCCCCCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC",
                        "CCGGGGGGGGGCC"
                )
                .aisle(
                        "CCCCCCSCCCCCC",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C ",
                        " C         C "
                )
                .where('S', selfPredicate())
                .where('C', states(getCasingState()).setMinGlobalLimited(190)
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH)))
                .where('G', EPTraceabilityPredicate.EP_GLASS.get())
                .where('L', TraceabilityPredicate.HEATING_COILS.get())
                .where('D', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS)))
                .where('E', states(getCasingState())
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)))
                .where(' ', any())
                .where('A', air())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.CLEAN_STAINLESS_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.CRACKING_UNIT_OVERLAY;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.mega_oil_cracking_unit.tooltip.3"));
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
                textList.add(2, new TextComponentTranslation("epimorphism.machine.multiblock.max_parallel", getMaxParallel(heatingCoilLevel)));
                textList.add(2, new TextComponentTranslation("epimorphism.machine.multiblock.max_voltage", voltageName));
                textList.add(new TextComponentTranslation("gregtech.multiblock.cracking_unit.energy", 100 - 10 * coilTier));
            }
        }
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle(
                            "CCCCCCJHCCCCC",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC"
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " CGGGGGGGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " CAAAAAAAAAC ",
                            " CALALALALAC ",
                            " CAAAAAAAAAC ",
                            " GALALALALAG ",
                            " CGGGCCCGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " CALALALALAC ",
                            " DALALALALAN ",
                            " CALALALALAC ",
                            " GALALALALAG ",
                            " CGGGCVCGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " CAAAAAAAAAC ",
                            " CALALALALAC ",
                            " CAAAAAAAAAC ",
                            " GALALALALAG ",
                            " CGGGCCCGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " GALALALALAG ",
                            " CGGGGGGGGGC "
                    )
                    .aisle(
                            "CCCCCCCCCCCCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC",
                            "CCGGGGGGGGGCC"
                    )
                    .aisle(
                            "CCCCCCSKCCCCC",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC ",
                            " CAAAAAAAAAC "
                    )
                    .where('S', EPMetaTileEntities.MEGA_OIL_CRACKING_UNIT, EnumFacing.SOUTH)
                    .where('C', getCasingState())
                    .where('V', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.UP)
                    .where('D', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.WEST)
                    .where('N', MetaTileEntities.FLUID_EXPORT_HATCH[4], EnumFacing.EAST)
                    .where('K', MetaTileEntities.ITEM_IMPORT_BUS[4], EnumFacing.SOUTH)
                    .where('H', MetaTileEntities.ENERGY_INPUT_HATCH[5], EnumFacing.NORTH)
                    .where('A', Blocks.AIR.getDefaultState())
                    .where('J', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : getCasingState(), EnumFacing.NORTH);
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListCoil.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('L', b);
                        finalBuilder.where('G', finalListGlass.get(count.get()));
                        count.getAndIncrement();
                    }
                    return finalBuilder;
                })
                .filter(Objects::nonNull)
                .forEach(b -> shapeInfo.add(b.build()));
        return shapeInfo;
    }

    @Override
    public SoundEvent getBreakdownSound() {
        return GTSoundEvents.BREAKDOWN_ELECTRICAL;
    }

    protected int getCoilTier() {
        return this.coilTier;
    }

    /**  getMaxParallel(int heatingCoilLevel)
     *     @param heatingCoilLevel the level to get the parallel for
     *     @return the max parallel for the heating coil level
     */
    public static int getMaxParallel(int heatingCoilLevel) {
        return heatingCoilLevel * 4;
    }

    private class MegaCrackingUnitWorkableHandler extends MultiblockRecipeLogic {

        public MegaCrackingUnitWorkableHandler(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        public int getParallelLimit() {
            return getMaxParallel(heatingCoilLevel);
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
        protected void modifyOverclockPost(int[] resultOverclock, @Nonnull IRecipePropertyStorage storage) {
            super.modifyOverclockPost(resultOverclock, storage);

            int coilTier = ((EPMetaTileEntityMegaOilCrackingUnit) metaTileEntity).getCoilTier();
            if (coilTier <= 0)
                return;

            resultOverclock[0] *= 1.0f - coilTier * 0.1; // each coil above cupronickel (coilTier = 0) uses 10% less energy
            resultOverclock[0] = Math.max(1, resultOverclock[0]);
        }
    }
}
