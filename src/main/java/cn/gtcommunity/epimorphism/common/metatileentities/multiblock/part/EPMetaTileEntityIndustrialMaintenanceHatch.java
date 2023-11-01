package cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part;

import cn.gtcommunity.epimorphism.api.capability.EPMultiblockAbilities;
import cn.gtcommunity.epimorphism.api.capability.IIndustrialMaintenance;
import cn.gtcommunity.epimorphism.api.items.toolitem.EPToolClasses;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.items.toolitem.ToolHelper;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.gui.widget.among_us.FixWiringTaskWidget;
import gregtech.common.inventory.handlers.TapeItemStackHandler;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.*;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static gregtech.api.capability.GregtechDataCodes.*;

public class EPMetaTileEntityIndustrialMaintenanceHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IIndustrialMaintenance>, IIndustrialMaintenance {

    private ItemStackHandler itemStackHandler;
    private boolean isTaped;

    // Used to store state temporarily if the Controller is broken
    private byte maintenanceProblems = -1;
    private int timeActive = -1;

    private List<IMaintenance> list = new ArrayList<>();

    private BigDecimal durationMultiplier = BigDecimal.ONE;
    private static final Function<Double, Double> TIME_ACTION = (d) -> {
        if (d < 1.0)
            return -20.0 * d + 21;
        else
            return -8.0 * d + 9;
    };

    public EPMetaTileEntityIndustrialMaintenanceHatch(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, 4);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityIndustrialMaintenanceHatch(metaTileEntityId);
    }

    @Override
    protected void initializeInventory() {
        super.initializeInventory();
        this.itemStackHandler = new TapeItemStackHandler(1);
        this.itemInventory = itemStackHandler;
    }

    @Override
    public void clearMachineInventory(NonNullList<ItemStack> itemBuffer) {
        super.clearMachineInventory(itemBuffer);
        clearInventory(itemBuffer, itemStackHandler);
    }

    /**
     * Fixes the maintenance problems of this hatch's Multiblock Controller
     * @param entityPlayer the player performing the fixing
     */
    private void fixMaintenanceProblems(@Nullable EntityPlayer entityPlayer) {
        if (!(this.getController() instanceof IMaintenance))
            return;

        if (!((IMaintenance) this.getController()).hasMaintenanceProblems())
            return;

        if (entityPlayer != null) {
            // Fix automatically on slot click by player in Creative Mode
            if (entityPlayer.capabilities.isCreativeMode) {
                fixAllMaintenanceProblems();
                return;
            }
            // Then for every slot in the player's main inventory, try to duct tape fix
            for (int i = 0; i < entityPlayer.inventory.mainInventory.size(); i++) {
                if (consumeDuctTape(new ItemStackHandler(entityPlayer.inventory.mainInventory), i)) {
                    fixAllMaintenanceProblems();
                    setTaped(true);
                    return;
                }
            }
            // Lastly for each problem the multi has, try to fix with tools
            fixProblemsWithTools(((IMaintenance) this.getController()).getMaintenanceProblems(), entityPlayer);
        }
    }

    @Override
    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (getController() instanceof IMaintenance && ((IMaintenance) getController()).hasMaintenanceProblems()) {
            if (consumeDuctTape(playerIn, playerIn.getHeldItem(hand))) {
                fixAllMaintenanceProblems();
                setTaped(true);
                return true;
            }
        }
        return super.onRightClick(playerIn, hand, facing, hitResult);
    }

    /**
     *
     * Handles duct taping for manual and auto-taping use
     *
     * @param handler is the handler to get duct tape from
     * @param slot is the inventory slot to check for tape
     * @return true if tape was consumed, else false
     */
    private boolean consumeDuctTape(@Nullable IItemHandler handler, int slot) {
        if (handler == null)
            return false;
        return consumeDuctTape(null, handler.getStackInSlot(slot));
    }

    private boolean consumeDuctTape(@Nullable EntityPlayer player, ItemStack itemStack) {
        if (!itemStack.isEmpty() && itemStack.isItemEqual(MetaItems.DUCT_TAPE.getStackForm())) {
            if (player == null || !player.capabilities.isCreativeMode) {
                itemStack.shrink(1);
            }
            return true;
        }
        return false;
    }

    /**
     * Attempts to fix a provided maintenance problem with a tool in the player's
     * inventory, if the tool exists.
     *
     * @param problems Problem Flags
     * @param entityPlayer Target Player which their inventory would be scanned for tools to fix
     */
    private void fixProblemsWithTools(byte problems, EntityPlayer entityPlayer) {
        List<String> toolsToMatch = Arrays.asList(new String[7]);
        boolean proceed = false;
        for (byte index = 0; index < 7; index++) {
            if (((problems >> index) & 1) == 0) {
                proceed = true;
                switch (index) {
                    case 0:
                        toolsToMatch.set(0, ToolClasses.WRENCH);
                        break;
                    case 1:
                        toolsToMatch.set(1, ToolClasses.SCREWDRIVER);
                        break;
                    case 2:
                        toolsToMatch.set(2, ToolClasses.SOFT_MALLET);
                        break;
                    case 3:
                        toolsToMatch.set(3, ToolClasses.HARD_HAMMER);
                        break;
                    case 4:
                        toolsToMatch.set(4, ToolClasses.WIRE_CUTTER);
                        break;
                    case 5:
                        toolsToMatch.set(5, ToolClasses.CROWBAR);
                        break;
                    case 6:
                        toolsToMatch.set(6, EPToolClasses.BENDING_CYLINDER);
                        break;
                }
            }
        }
        if (!proceed) {
            return;
        }

        for (int i = 0; i < toolsToMatch.size(); i++) {
            String toolToMatch = toolsToMatch.get(i);
            if (toolToMatch != null) {
                // Try to use the item in the player's "hand" (under the cursor)
                ItemStack heldItem = entityPlayer.inventory.getItemStack();
                if (ToolHelper.isTool(heldItem, toolToMatch)) {
                    fixProblemWithTool(i, heldItem, entityPlayer);

                    if (toolsToMatch.stream().allMatch(Objects::isNull)) {
                        return;
                    }
                }

                // Then try all the remaining inventory slots
                for (ItemStack itemStack : entityPlayer.inventory.mainInventory) {
                    if (ToolHelper.isTool(itemStack, toolToMatch)) {
                        fixProblemWithTool(i, itemStack, entityPlayer);

                        if (toolsToMatch.stream().allMatch(Objects::isNull)) {
                            return;
                        }
                    }
                }

                for (ItemStack stack : entityPlayer.inventory.mainInventory) {
                    if (ToolHelper.isTool(stack, toolToMatch)) {
                        ((IMaintenance) this.getController()).setMaintenanceFixed(i);
                        ToolHelper.damageItemWhenCrafting(stack, entityPlayer);
                        if (toolsToMatch.stream().allMatch(Objects::isNull)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void fixProblemWithTool(int problemIndex, ItemStack stack, EntityPlayer player) {
        for (IMaintenance controller : list) {
            controller.setMaintenanceFixed(problemIndex);
            ToolHelper.damageItemWhenCrafting(stack, player);
        }
        setTaped(false);
    }

    /**
     * Fixes every maintenance problem of the controller
     */
    public void fixAllMaintenanceProblems() {
        for (IMaintenance controller : list) {
            EPLog.logger.info(list.size());
            for (int i = 0; i < 7; i++) controller.setMaintenanceFixed(i);
        }
    }

    @Override
    public boolean isFullAuto() {
        return false;
    }

    @Override
    public void setTaped(boolean b) {

    }

    @Override
    public void storeMaintenanceData(byte maintenanceProblems, int timeActive) {
        this.maintenanceProblems = maintenanceProblems;
        this.timeActive = timeActive;
        if (!getWorld().isRemote) {
            writeCustomData(STORE_MAINTENANCE, buf -> {
                buf.writeByte(maintenanceProblems);
                buf.writeInt(timeActive);
            });
        }
    }

    @Override
    public boolean hasMaintenanceData() {
        return false;
    }

    @Override
    public Tuple<Byte, Integer> readMaintenanceData() {
        Tuple<Byte, Integer> data = new Tuple<>(this.maintenanceProblems, this.timeActive);
        storeMaintenanceData((byte) -1, -1);
        return data;
    }

    @Override
    public double getDurationMultiplier() {
        return durationMultiplier.doubleValue();
    }

    @Override
    public double getTimeMultiplier() {
        return BigDecimal.valueOf(TIME_ACTION.apply(durationMultiplier.doubleValue()))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public boolean startWithoutProblems() {
        return false;
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (shouldRenderOverlay()) {
            (isTaped ? Textures.MAINTENANCE_OVERLAY_TAPED : Textures.MAINTENANCE_OVERLAY)
                    .renderSided(getFrontFacing(), renderState, translation, pipeline);
        }
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, 176, 18 * 3 + 98)
                .label(5, 5, getMetaFullName())
                .bindPlayerInventory(entityPlayer.inventory, GuiTextures.SLOT, 7, 18 * 3 + 16);

        if (GTValues.FOOLS.get()) {
            builder.widget(new FixWiringTaskWidget(48, 15, 80, 50)
                    .setOnFinished(this::fixAllMaintenanceProblems)
                    .setCanInteractPredicate(this::isAttachedToMultiBlock));
        } else {
            builder.widget(new SlotWidget(itemStackHandler, 0, 89 - 10, 18 - 1)
                            .setBackgroundTexture(GuiTextures.SLOT, GuiTextures.DUCT_TAPE_OVERLAY).setTooltipText("gregtech.machine.maintenance_hatch_tape_slot.tooltip"))
                    .widget(new ClickButtonWidget(89 - 10 - 1, 18 * 2 + 3, 20, 20, "", data -> fixMaintenanceProblems(entityPlayer))
                            .setButtonTexture(GuiTextures.MAINTENANCE_ICON).setTooltipText("gregtech.machine.maintenance_hatch_tool_slot.tooltip"));
        }
        return builder.build(getHolder(), entityPlayer);
    }

    @Override
    public MultiblockAbility<IIndustrialMaintenance> getAbility() {
        return EPMultiblockAbilities.INDUSTRIAL_MAINTENANCE_MULTIBLOCK_ABILITY;
    }

    @Override
    public void registerAbilities(List<IIndustrialMaintenance> list) {
        list.add(this);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("IsTaped", isTaped);
        data.setTag("tapeInventory", itemStackHandler.serializeNBT());
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        isTaped = data.getBoolean("IsTaped");
        if (data.hasKey("tapeInventory", Constants.NBT.TAG_COMPOUND)) {
            this.itemStackHandler.deserializeNBT(data.getCompoundTag("tapeInventory"));
        }
        // Legacy Inventory Handler Support
        if (data.hasKey("ImportInventory", Constants.NBT.TAG_COMPOUND)) {
            GTUtility.readItems(itemStackHandler, "ImportInventory", data);
            data.removeTag("ImportInventory");
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(isTaped);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        isTaped = buf.readBoolean();
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == STORE_MAINTENANCE) {
            this.maintenanceProblems = buf.readByte();
            this.timeActive = buf.readInt();
            markDirty();
        } else if (dataId == IS_TAPED) {
            this.isTaped = buf.readBoolean();
            scheduleRenderUpdate();
            markDirty();
        } else if (dataId == MAINTENANCE_MULTIPLIER) {
            this.durationMultiplier = BigDecimal.valueOf(buf.readDouble());
            markDirty();
        }
    }

    @Override
    public boolean canPartShare() {
        return true;
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        if (ConfigHolder.machines.enableMaintenance) {
            super.getSubItems(creativeTab, subItems);
        }
    }

    @Override
    public void addListenerList(IMaintenance controller) {
        list.add(controller);
    }

    @Override
    public void removeListenerList(IMaintenance controller) {
        list.remove(controller);
    }
}
