package cn.gtcommunity.epimorphism.api.fluids;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import gregtech.api.fluids.MetaFluids;
import gregtech.api.fluids.fluidType.FluidTypes;

public class EPMetaFluids {

    public static void init() {
        setCustomTextures();
    }

    private static void setCustomTextures() {
        MetaFluids.setMaterialFluidTexture(EPMaterials.SuperheatedSteam, FluidTypes.GAS);
        MetaFluids.setMaterialFluidTexture(EPMaterials.SupercriticalSteam, FluidTypes.GAS);
    }
}
