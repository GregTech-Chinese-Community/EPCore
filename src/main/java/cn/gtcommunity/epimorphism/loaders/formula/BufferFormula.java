package cn.gtcommunity.epimorphism.loaders.formula;

import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import gregtech.api.unification.OreDictUnifier;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BufferFormula {
    private static final double[] SODIUM_HYDROXIDE = {3.15, 13.55};
    private static final double[] SULFURIC_ACID = {-3.15, 1.55};

    public static void addBuffer() {
        EPMetaTileEntityBufferHatch.BufferItemMap.put(OreDictUnifier.get(dust, SodiumHydroxide).getTranslationKey(),SODIUM_HYDROXIDE);
        EPMetaTileEntityBufferHatch.BufferFluidMap.put(SulfuricAcid.getFluid().toString(), SULFURIC_ACID);
    }
}
