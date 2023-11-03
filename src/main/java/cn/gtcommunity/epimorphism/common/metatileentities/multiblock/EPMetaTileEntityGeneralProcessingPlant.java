package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.capability.EPMultiblockAbilities;
import cn.gtcommunity.epimorphism.api.capability.IIndustrialMaintenance;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.GTValues;
import gregtech.api.capability.IMaintenanceHatch;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Tuple;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class EPMetaTileEntityGeneralProcessingPlant extends MultiMapMultiblockController {

    private int timeActive;
    private IMaintenanceHatch maintenanceHatch;
    // Used for tracking if this is the initial state of the machine, for maintenance hatches which automatically fix initial issues.
    private boolean initialMaintenanceDone;

    // Used for data preservation with Maintenance Hatch
//    private boolean storedTaped = false;
    public EPMetaTileEntityGeneralProcessingPlant(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                EPRecipeMaps.GENERAL_RECIPES_A,
                EPRecipeMaps.GENERAL_RECIPES_B,
                EPRecipeMaps.GENERAL_RECIPES_C
        });
        this.recipeMapWorkable = new GeneralRecipeLogic(this);
        this.maintenance_problems = 0b0000000;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityGeneralProcessingPlant(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        if (this.hasMaintenanceMechanics() && ConfigHolder.machines.enableMaintenance) { // nothing extra if no maintenance
            if (getAbilities(EPMultiblockAbilities.INDUSTRIAL_MAINTENANCE_MULTIBLOCK_ABILITY).isEmpty())
                return;
            maintenanceHatch = getAbilities(EPMultiblockAbilities.INDUSTRIAL_MAINTENANCE_MULTIBLOCK_ABILITY).get(0);
            if (maintenanceHatch.startWithoutProblems() && !initialMaintenanceDone) {
                this.maintenance_problems = (byte) 0b1111111;
                this.initialMaintenanceDone = true;
            }
            readMaintenanceData(maintenanceHatch);
            ((IIndustrialMaintenance)maintenanceHatch).addListenerList(this);
        }
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        if (maintenanceHatch != null) {
            ((IIndustrialMaintenance)maintenanceHatch).removeListenerList(this);
        }
        maintenanceHatch = null;
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                .aisle("GGBGBGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                .aisle("GGGBGGG", " T L T ", " T   T ", " T B T ", " T B T ", "EGGMGGE")
                .aisle("GGBGBGG", " TB BT ", " T   T ", " T   T ", " T   T ", "GGGGGGG")
                .aisle("GGGGGGG", " PTTTP ", " PTTTP ", " PTTTP ", " PTTTP ", "GGGGGGG")
                .aisle("GGGGGGG", "F     F", "F     F", "F     F", "F     F", "GGGEGGG")
                .aisle(" CCSCC ", "       ", "       ", "       ", "       ", "       ")
                .where('S', selfPredicate())
                .where('C', autoAbilities(false, false, true, true, true, true, false))
                .where('G', states(getCasingAState()))
                .where('M', abilities(EPMultiblockAbilities.INDUSTRIAL_MAINTENANCE_MULTIBLOCK_ABILITY))
                .where('E',states(getCasingAState()).or(abilities(MultiblockAbility.INPUT_ENERGY)))
                .where('B', states(getGearBoxState()))
                .where('P', states(getCasingBState()))
                .where('L', states(getSubstrateState()))
                .where('T', states(getGlassState()))
                .where('F', states(getFrameState()))
                .build();

    }

    private static IBlockState getCasingAState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.MARAGING_STEEL_CASING);
    }

    private static IBlockState getCasingBState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.GENERAL_PROCESSING_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(EPMaterials.MaragingSteel250).getBlock(EPMaterials.MaragingSteel250);
    }

    private static IBlockState getGearBoxState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STEEL_GEARBOX);
    }

    private static IBlockState getSubstrateState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING.getState(EPBlockMultiblockCasing.CasingType.ADVANCED_SUBSTRATE_CASING);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.MARAGING_STEEL_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.tooltip.3"));
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.shift_tooltip.1"));
            tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.shift_tooltip.2"));
            tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.shift_tooltip.3"));
            tooltip.add(I18n.format("epimorphism.multiblock.general_processing_plant.shift_tooltip.4"));
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.hold_shift"));
        }
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    //  添加电烙铁，未来可能会优化结构

    /**
     * Used to cause a single random maintenance problem
     */
    @Override
    public void causeMaintenanceProblems() {
        this.maintenance_problems &= ~(1 << ((int) (GTValues.RNG.nextFloat() * 6)));
        this.getWorld().playSound(null, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), this.getBreakdownSound(), SoundCategory.BLOCKS, 1.f, 1.f);
    }

    /**
     * @return the byte value representing the maintenance problems
     */
    @Override
    public byte getMaintenanceProblems() {
        return ConfigHolder.machines.enableMaintenance ? maintenance_problems : 0b1111111;
    }

    /**
     * @return the amount of maintenance problems the multiblock has
     */
    @Override
    public int getNumMaintenanceProblems() {
        return ConfigHolder.machines.enableMaintenance ? 7 - Integer.bitCount(maintenance_problems) : 0;
    }

    /**
     * @return whether the multiblock has any maintenance problems
     */
    @Override
    public boolean hasMaintenanceProblems() {
        return ConfigHolder.machines.enableMaintenance && this.maintenance_problems < 127;
    }

    /**
     * reads maintenance data from a maintenance hatch
     *
     * @param hatch is the hatch to read the data from
     */
    private void readMaintenanceData(IMaintenanceHatch hatch) {
        if (hatch.hasMaintenanceData()) {
            Tuple<Byte, Integer> data = hatch.readMaintenanceData();
            this.maintenance_problems = data.getFirst();
            this.timeActive = data.getSecond();
        }
    }
    @Override
    protected void addMaintenanceText(List<ITextComponent> textList) {
        if (hasMaintenanceProblems()) {
            ITextComponent hoverEventTranslation = new TextComponentTranslation("gregtech.multiblock.universal.has_problems");

            if (((this.maintenance_problems) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.wrench", "\n"));

            if (((this.maintenance_problems >> 1) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.screwdriver", "\n"));

            if (((this.maintenance_problems >> 2) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.soft_mallet", "\n"));

            if (((this.maintenance_problems >> 3) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.hard_hammer", "\n"));

            if (((this.maintenance_problems >> 4) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.wire_cutter", "\n"));

            if (((this.maintenance_problems >> 5) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("gregtech.multiblock.universal.problem.crowbar", "\n"));

            if (((this.maintenance_problems >> 6) & 1) == 0)
                hoverEventTranslation.appendSibling(new TextComponentTranslation("epimorphism.multiblock.universal.problem.soldering_iron", "\n"));

            textList.add(hoverEventTranslation.setStyle(new Style().setColor(TextFormatting.RED)));
        }
    }

    protected class GeneralRecipeLogic extends MultiblockRecipeLogic {
        public GeneralRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        @Override
        protected void modifyOverclockPre(@Nonnull int[] values, @Nonnull IRecipePropertyStorage storage) {
            super.modifyOverclockPre(values, storage);
            values[0] *= 0.8;
            values[1] *= 0.4;
        }

        @Override
        public int getParallelLimit() {
            return GTUtility.getFloorTierByVoltage(getMaxVoltage()) * 2;
        }
    }
}
