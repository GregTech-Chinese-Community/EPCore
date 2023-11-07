package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.capability.IHeatExchanger;
import cn.gtcommunity.epimorphism.api.capability.impl.HeatExchangerLogic;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.NoEnergyMultiblockController;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static gregtech.api.gui.widgets.AdvancedTextWidget.withHoverTextTranslate;
import static net.minecraft.util.text.TextFormatting.*;

public class EPMetaTileEntityLargeHeatExchanger extends NoEnergyMultiblockController implements IHeatExchanger {

    private final int maxInputFlowRate = 2000;
    private final int heatTime = 150;
    private int thresholdPercentage = 100;

    public EPMetaTileEntityLargeHeatExchanger(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.HEAT_EXCHANGE_RECIPES);
        this.recipeMapWorkable = new HeatExchangerLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityLargeHeatExchanger(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC", "CCC")
                .aisle("CIC", "CPC", "CPC", "CEC")
                .aisle("CSC", "CCC", "CCC", "CCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState())
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS)))
                .where('P', states(getBoilerState()))
                .where('I', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .build();
    }

    protected IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE);
    }

    protected IBlockState getBoilerState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.STABLE_TITANIUM_CASING;
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (isStructureFormed()) {
//            int efficiency = recipeLogic.getHeatScaled();
//            textList.add(new TextComponentTranslation("gregtech.multiblock.large_boiler.efficiency",
//                    (efficiency == 0 ? DARK_RED : efficiency <= 40 ? RED : efficiency == 100 ? GREEN : YELLOW).toString() + efficiency + "%"));
//            textList.add(new TextComponentTranslation("gregtech.multiblock.large_boiler.steam_output", recipeLogic.getLastTickSteam()));

            ITextComponent throttleText = new TextComponentTranslation("epimorphism.multiblock.large_heat_exchanger.threshold",
                    AQUA.toString() + getThrottle() + "%");
            withHoverTextTranslate(throttleText, "epimorphism.multiblock.large_heat_exchanger.threshold.tooltip");
            textList.add(throttleText);
        }
    }

    @Override
    @Nonnull
    protected Widget getFlexButton(int x, int y, int width, int height) {
        WidgetGroup group = new WidgetGroup(x, y, width, height);
        group.addWidget(new ClickButtonWidget(0, 0, 9, 18, "", this::decrementThreshold)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_MINUS)
                .setTooltipText("epimorphism.multiblock.large_heat_exchanger.threshold_decrement"));
        group.addWidget(new ClickButtonWidget(9, 0, 9, 18, "", this::incrementThreshold)
                .setButtonTexture(GuiTextures.BUTTON_THROTTLE_PLUS)
                .setTooltipText("epimorphism.multiblock.large_heat_exchanger.threshold_increment"));
        return group;
    }

    private void incrementThreshold(Widget.ClickData clickData) {
        this.thresholdPercentage = MathHelper.clamp(thresholdPercentage + 5, 25, 100);
    }

    private void decrementThreshold(Widget.ClickData clickData) {
        this.thresholdPercentage = MathHelper.clamp(thresholdPercentage - 5, 25, 100);
    }

    @Override
    public String[] getDescription() {
        return new String[]{I18n.format("epimorphism.multiblock.large_heat_exchanger.description")};
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.multiblock.large_heat_exchanger.heat_time_tooltip", heatTime));
        tooltip.add(I18n.format("epimorphism.multiblock.large_heat_exchanger.tooltip.base_import_fluid", maxInputFlowRate));
        tooltip.add(TooltipHelper.BLINKING_RED + I18n.format("epimorphism.multiblock.large_heat_exchanger.explosion_tooltip"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        data.setInteger("ThresholdPercentage", thresholdPercentage);
        return super.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        thresholdPercentage = data.getInteger("ThresholdPercentage");
        super.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(thresholdPercentage);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        thresholdPercentage = buf.readVarInt();
    }

    @Override
    public int getThrottle() {
        return thresholdPercentage;
    }

    @Override
    public int getMaxInputFlowRate() {
        return maxInputFlowRate;
    }

    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }

    @Override
    public boolean canVoidRecipeItemOutputs() {
        return true;
    }

    @Override
    public boolean canVoidRecipeFluidOutputs() {
        return true;
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
}
