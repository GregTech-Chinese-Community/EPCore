package cn.gtcommunity.epimorphism.api.utils;

import cn.gtcommunity.epimorphism.api.items.metaitem.stats.IEPDataItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EPDataManager {

    public static final String EPDATA_NBT_TAG = "EPData";
    public static final String EPDATA_ID_NBT_TAG = "EPDataId";

    private EPDataManager() {}

    /**
     * @param stackCompound the compound contained on the ItemStack to write to
     * @param researchId    the EPData
     */
    public static void writeResearchToNBT(@Nonnull NBTTagCompound stackCompound, @Nonnull String researchId) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString(EPDATA_ID_NBT_TAG, researchId);
        stackCompound.setTag(EPDATA_NBT_TAG, compound);
    }

    public static ItemStack writeResearchToNBT(@Nonnull ItemStack itemStack, @Nonnull String researchId) {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString(EPDATA_ID_NBT_TAG, researchId);
        if (itemStack.getTagCompound() != null) {
            itemStack.getTagCompound().setTag(EPDATA_NBT_TAG, compound);
        }else {
            itemStack.setTagCompound(new NBTTagCompound());
            itemStack.getTagCompound().setTag(EPDATA_NBT_TAG, compound);
        }
        return itemStack;
    }

    /**
     * @param stack the ItemStack to read from
     * @return the EPData id
     */
    @Nullable
    public static String readEPDataId(@Nonnull ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if (!hasEPDataTag(compound)) return null;

        NBTTagCompound researchCompound = compound.getCompoundTag(EPDATA_NBT_TAG);
        String researchId = researchCompound.getString(EPDATA_ID_NBT_TAG);
        return researchId.isEmpty() ? null : researchId;
    }

    /**
     * @param stack      the stack to check
     * @return if the stack is a EPData item
     */
    public static boolean isStackEPDataItem(@Nonnull ItemStack stack) {
        if (stack.getItem() instanceof MetaItem<?> metaItem) {
            MetaItem<?>.MetaValueItem valueItem = metaItem.getItem(stack);
            if (valueItem == null) return false;
            for (IItemBehaviour behaviour : valueItem.getBehaviours()) {
                if (behaviour instanceof IEPDataItem) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param stack the stack to check
     * @return if the stack has the EPData NBTTagCompound
     */
    public static boolean hasEPDataTag(@Nonnull ItemStack stack) {
        return hasEPDataTag(stack.getTagCompound());
    }

    /**
     * @param compound the compound to check
     * @return if the tag has the EPData NBTTagCompound
     */
    private static boolean hasEPDataTag(@Nullable NBTTagCompound compound) {
        if (compound == null || compound.isEmpty()) return false;
        return compound.hasKey(EPDATA_NBT_TAG, Constants.NBT.TAG_COMPOUND);
    }
}
