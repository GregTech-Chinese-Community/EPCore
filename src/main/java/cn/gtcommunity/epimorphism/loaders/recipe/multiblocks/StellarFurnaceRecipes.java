package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockExplosive;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;

import java.math.BigInteger;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class StellarFurnaceRecipes {
    public static void init() {

        //  A few hint: Rhenium + Naquadria Charge -> Degenerate Rhenium -> Quark Gluon Plasma (and others) -> QCD Charge

        //  Degenerated Rhenium
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Rhenium)
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getFluid(1000))
                .EUt(VA[UHV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(DegenerateRhenium.getFluid(1000))
                .outputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();

        //  Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, DegenerateRhenium)
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.LEPTONIC_CHARGE))
                .fluidOutputs(QuarkGluonPlasma.getFluid(1000))
                .EUt(VA[UEV])
                .duration(60)
                .temperature(BigInteger.valueOf((10 * V[UHV]) - (10 * V[UV])))
                .buildAndRegister();

        //  TODO QGP Centrifuge


        //  TODO other components of Cosmic Computing Mixture

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
                .temperature(BigInteger.valueOf((long) Math.pow(V[MAX], V[MAX])))
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
                .temperature(BigInteger.valueOf(10 * V[UEV]- 10 * V[UHV]))
                .buildAndRegister();

        //  TODO MHCSM (UXV): use infinity and...?
    }
}
