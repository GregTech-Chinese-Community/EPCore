package cn.gtcommunity.epimorphism.loaders.formula;

import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.part.EPMetaTileEntityBufferHatch;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class BufferFormula {
    public static void addBuffer() {
       /* EPMetaTileEntityBufferHatch.BufferItemMap.put()*/
        EPMetaTileEntityBufferHatch.BufferFluidMap.put(SulfuricAcid.getFluid().toString(), -3.15);
    }
}
