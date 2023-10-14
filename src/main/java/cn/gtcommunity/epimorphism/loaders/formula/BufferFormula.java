package cn.gtcommunity.epimorphism.loaders.formula;

import cn.gtcommunity.epimorphism.api.utils.EPLog;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BufferFormula {
    public static void addBuffer() {
        EPMetaTileEntityBufferHatch.BufferItemMap.put(OreDictUnifier.get(dust, SodiumHydroxide).getTranslationKey(), 3.15);
        EPMetaTileEntityBufferHatch.BufferFluidMap.put(SulfuricAcid.getFluid().toString(), -3.15);
    }
}
