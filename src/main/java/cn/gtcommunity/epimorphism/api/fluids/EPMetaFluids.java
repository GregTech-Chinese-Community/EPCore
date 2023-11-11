package cn.gtcommunity.epimorphism.api.fluids;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import gregtech.api.fluids.MetaFluids;
import gregtech.api.fluids.fluidType.FluidTypes;

public class EPMetaFluids {

    public static void init() {
        setCustomTextures();
    }

    private static void setCustomTextures() {
        MetaFluids.setMaterialFluidTexture(EPMaterials.RawStarMatter, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.DimensionallyTranscendentResidue, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.HeavyLeptonMixture, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.HeavyQuarks, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.Gluons, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.Instantons, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.TemporalFluid, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.HiggsBosons, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.CosmicComputingMixture, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.BlazingPyrotheum, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.GelidCryotheum, FluidTypes.LIQUID);
        MetaFluids.setMaterialFluidTexture(EPMaterials.SuperheatedSteam, FluidTypes.GAS);
        MetaFluids.setMaterialFluidTexture(EPMaterials.SupercriticalSteam, FluidTypes.GAS);
        MetaFluids.setMaterialFluidTexture(EPMaterials.Infinity, FluidTypes.LIQUID);
    }
}
