package cn.gtcommunity.epimorphism.loaders.formula;

import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.util.List;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BufferFormula {

    public static void addBuffer() {
        //  Item
        addItem(OreDictUnifier.get(dust, SodiumHydroxide), 3.15, 13.55);

        //  Fluid
        addFluid(SulfuricAcid.getFluid(), -3.15, 1.55);
    }
    private static void addItem(ItemStack stack, double phChange, double phLimit) {
        EPMetaTileEntityBufferHatch.BufferItemMap.put(EPUniverUtil.stackToInt(stack), new double[] {phChange, phLimit});
    }

    private static void addFluid(Fluid fluid, double phChange, double phLimit) {
        EPMetaTileEntityBufferHatch.BufferFluidMap.put(fluid.getName(), new double[] {phChange, phLimit});
    }
}
