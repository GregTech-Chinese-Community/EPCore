package cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part;

import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityEnergyHatch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class EPMetaTileEntityEnergyHatch extends MetaTileEntityEnergyHatch implements IMultiblockAbilityPart<IEnergyContainer> {

    public EPMetaTileEntityEnergyHatch(ResourceLocation metaTileEntityId, int tier, int amperage, boolean isExport) {
        super(metaTileEntityId, tier, amperage, isExport);
    }

    @Override
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> subItems) {
        for (MetaTileEntityEnergyHatch hatch : EPMetaTileEntities.INPUT_ENERGY_HATCH_4A) {
            if (hatch != null) subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityEnergyHatch hatch : EPMetaTileEntities.INPUT_ENERGY_HATCH_16A) {
            if (hatch != null) subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityEnergyHatch hatch : EPMetaTileEntities.OUTPUT_ENERGY_HATCH_4A) {
            if (hatch != null) subItems.add(hatch.getStackForm());
        }

        for (MetaTileEntityEnergyHatch hatch : EPMetaTileEntities.OUTPUT_ENERGY_HATCH_16A) {
            if (hatch != null) subItems.add(hatch.getStackForm());
        }
    }
}
