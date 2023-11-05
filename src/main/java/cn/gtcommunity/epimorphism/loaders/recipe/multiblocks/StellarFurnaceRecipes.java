package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;

public class StellarFurnaceRecipes {
    public static void init() {

        //  Cosmic Computing Mixture
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyLeptonMixture.getFluid(32000))
                .fluidInputs(HeavyQuarks.getFluid(8000))
                .fluidInputs(Gluons.getFluid(8000))
                .fluidInputs(Instantons.getFluid(4000))
                .fluidInputs(TemporalFluid.getFluid(4000))
                .fluidInputs(HiggsBosons.getFluid(4000))
                .fluidOutputs(CosmicComputingMixture.getFluid(60000))
                .EUt(VA[UEV])
                .duration(1200)
                .temperature(2147483647)
                .buildAndRegister();

        //  MHCSM (UEV)
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(RawStarMatter.getFluid(L * 32))
                .fluidInputs(CosmicComputingMixture.getFluid(L * 16))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 8))
                .fluidInputs(WhiteDwarfMatter.getFluid(L * 8))
                .fluidOutputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 16))
                .fluidOutputs(DimensionallyTranscendentResidue.getFluid(L * 16))
                .EUt(VA[UEV])
                .duration(1200)
                .temperature(6000000)
                .buildAndRegister();

        //  TODO MHCSM (UXV): use infinity and...?
    }
}
