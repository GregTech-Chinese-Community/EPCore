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

        //  Separation Electromagnet
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MAGNETRON.getStackForm())
                .input(plate, NiobiumNitride, 4)
                .input(stickLong, VanadiumGallium)
                .input(foil, Polybenzimidazole, 16)
                .input(wireFine, YttriumBariumCuprate, 32)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .outputs(SEPARATION_ELECTROMAGNET.getStackForm())
                .EUt(VA[ZPM])
                .duration(600)
                .buildAndRegister();

        //  Degenerated Rhenium (UHV): Rhenium ingot -> 1kL Degenerate Rhenium Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(ingot, Rhenium)
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getFluid(1000))
                .EUt(VA[UHV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UV]) - (10 * V[ZPM])))
                .buildAndRegister();

        //  Degenerate Rhenium (UIV): Rhenium dense plate -> 10kL Degenerate Rhenium Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plateDense, Rhenium)
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.NAQUADRIA_CHARGE))
                .fluidOutputs(DegenerateRhenium.getFluid(10000))
                .EUt(VA[UIV])
                .duration(20)
                .temperature(BigInteger.valueOf((10 * V[UHV]) - (10 * V[UV])))
                .buildAndRegister();

        //  Degenerate Rhenium plasma Containment Cell
        CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(DegenerateRhenium.getFluid(1000))
                .outputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(VA[LuV])
                .duration(20)
                .buildAndRegister();

        //  Degenerate Rhenium plate -> Quark Gluon Plasma
        STELLAR_FURNACE_RECIPES.recipeBuilder()
                .input(plate, DegenerateRhenium)
                .inputs(EPMetablocks.EP_EXPLOSIVE_BLOCK.getItemVariant(EPBlockExplosive.CasingType.LEPTONIC_CHARGE))
                .fluidOutputs(QuarkGluonPlasma.getFluid(1000))
                .EUt(VA[UEV])
                .duration(60)
                .temperature(BigInteger.valueOf((10 * V[UHV]) - (10 * V[UV])))
                .buildAndRegister();

        //  Quark Gluon Plasma -> Heavy Quarks + Light Quarks + Gluons
        CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(SEPARATION_ELECTROMAGNET)
                .fluidInputs(QuarkGluonPlasma.getFluid(1000))
                .fluidOutputs(HeavyQuarks.getFluid(200))
                .fluidOutputs(Gluons.getFluid(200))
                .fluidOutputs(LightQuarks.getFluid(600))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  Heavy Lepton Mixture (Check Altitude, when >0:5/tick, >20:10/tick, >40:20/tick, >60:30/tick, >80:40/tick)
        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(0)
                .fluidOutputs(HeavyLeptonMixture.getFluid(5))
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidOutputs(HeavyLeptonMixture.getFluid(10))
                .EUt((int) V[UHV])
                .duration(1)
                .Altitude(20)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidOutputs(HeavyLeptonMixture.getFluid(20))
                .EUt((int) V[UHV])
                .duration(1)
                .Altitude(40)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidOutputs(HeavyLeptonMixture.getFluid(30))
                .EUt((int) V[UHV])
                .duration(1)
                .Altitude(60)
                .buildAndRegister();

        COSMIC_RAY_DETECTOR_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .fluidOutputs(HeavyLeptonMixture.getFluid(40))
                .Altitude(80)
                .EUt((int) V[UHV])
                .duration(1)
                .buildAndRegister();

        //  TODO three metastable materials + D + Light-Heavy Quarks --Advanced Fusion--> Heavy Quark Degenerate Matter

        //  TODO other components of Cosmic Computing Mixture

        //  Instantons

        //  Temporal Fluid

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
                .temperature(BigInteger.valueOf(Long.MAX_VALUE))
                .buildAndRegister();
    }
}
