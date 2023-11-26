package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class CosmicCircuits {
    public static void init() {

        //  Cosmic Board
        //  TODO Require Space Environment?
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, DegenerateRhenium, 3)
                .input(plate, HeavyQuarkDegenerateMatter, 2)
                .input(wireFine, Infinity, 6)
                .fluidInputs(CosmicComputingMixture.getFluid(1000))
                .output(COSMIC_INFORMATION_MODULE)
                .EUt(VA[UIV])
                .duration(350)
                .buildAndRegister();

        //  Cladded Optical Fiber Core
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(wireFine, ZBLANGlass)
                .input(plate, GSTGlass)
                .input(plate, Zylon, 2)
                .output(CLADDED_OPTICAL_FIBER_CORE)
                .EUt(VA[LuV])
                .duration(600)
                .buildAndRegister();

        //  Caesium + Iodine -> Caesium Iodide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Caesium)
                .input(dust, Iodine)
                .output(dust, CaesiumIodide, 2)
                .EUt(VA[MV])
                .duration(340)
                .buildAndRegister();

        //  Caesium Iodide + Thallium + Thulium -> Tl-Tm-droped Caesium Iodide
        BLAST_RECIPES.recipeBuilder()
                .input(dust, CaesiumIodide)
                .input(dustSmall, Thallium, 2)
                .input(dustSmall, Thulium, 2)
                .output(dust, TlTmDropedCaesiumIodide, 2)
                .EUt(VA[HV])
                .duration(260)
                .blastFurnaceTemp(2853)
                .buildAndRegister();

        //  Anthracene
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HighlyPurifiedCoalTar.getFluid(20))
                .circuitMeta(0)
                .fluidOutputs(Anthracene.getFluid(5))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Dimethylnaphthalene
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Naphthalene.getFluid(1000))
                .fluidInputs(Methanol.getFluid(2000))
                .fluidOutputs(Dimethylnaphthalene.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[EV])
                .duration(240)
                .buildAndRegister();

        //  Acetylating Reagent
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChloride, 6)
                .fluidInputs(Acetylene.getFluid(3000))
                .fluidInputs(Trimethylchlorosilane.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(AcetylatingReagent.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .fluidOutputs(HydrochloricAcid.getFluid(3000))
                .EUt(VA[IV])
                .duration(350)
                .buildAndRegister();

        //  Iodine Monochloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Iodine)
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(IodineMonochloride.getFluid(1000))
                .EUt(VA[MV])
                .duration(240)
                .buildAndRegister();

        //  Rh-Re-Nq Catalyst
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Rhodium)
                .input(dust, Rhenium)
                .input(dust, Naquadah)
                .output(dust, RhReNqCatalyst, 3)
                .EUt(VA[ZPM])
                .duration(260)
                .buildAndRegister();

        //  Dihydroiodotetracene
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, RhReNqCatalyst)
                .input(dust, BromoSuccinimide, 12)
                .fluidInputs(Dimethylnaphthalene.getFluid(1000))
                .fluidInputs(AcetylatingReagent.getFluid(1000))
                .fluidInputs(IodineMonochloride.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, MagnesiumChlorideBromide, 6)
                .output(dust, Succinimide, 12)
                .fluidOutputs(Dihydroiodotetracene.getFluid(1000))
                .fluidOutputs(Trimethylchlorosilane.getFluid(1000))
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(290)
                .CasingTier(4)
                .buildAndRegister();

        //  Dichlorodicyanobenzoquinone
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(10000))
                .fluidInputs(HydrogenCyanide.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(Dichlorodicyanobenzoquinone.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(8000))
                .EUt(VA[LuV])
                .duration(250)
                .buildAndRegister();

        //  Dichlorodicyanohydroquinone -> Dichlorodicyanobenzoquinone cycle
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, Vanadium)
                .fluidInputs(Dichlorodicyanohydroquinone.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(Dichlorodicyanobenzoquinone.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[EV])
                .duration(250)
                .buildAndRegister();

        //  Isopropyl Alcohol
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, SodiumPhosphomolybdate)
                .notConsumable(dust, SodiumPhosphotungstate)
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(IsopropylAlcohol.getFluid(1000))
                .EUt(VA[LuV])
                .duration(100)
                .buildAndRegister();

        //  Tetracene
        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(lens, Prasiolite)
                .notConsumable(dust, Rutile) // TODO Nanoparticles?
                .fluidInputs(Dihydroiodotetracene.getFluid(2000))
                .fluidInputs(Dichlorodicyanobenzoquinone.getFluid(2000))
                .fluidInputs(IsopropylAlcohol.getFluid(1000))
                .output(dust, Tetracene, 60)
                .output(dust, Iodine, 2)
                .fluidOutputs(Acetone.getFluid(1000))
                .fluidOutputs(Dichlorodicyanohydroquinone.getFluid(2000))
                .EUt(VA[UV])
                .duration(260)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Polycyclic Aromatic Mixture
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Tetracene, 2)
                .fluidInputs(Anthracene.getFluid(1000))
                .output(dust, PolycyclicAromaticMixture, 3)
                .EUt(VA[IV])
                .duration(240)
                .buildAndRegister();

        //  Cadmium Tungstate
        BLAST_RECIPES.recipeBuilder()
                .input(dust, TungstenTrioxide, 4)
                .input(dust, CadmiumSulfide, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, CadmiumTungstate, 6)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(VA[EV])
                .duration(320)
                .blastFurnaceTemp(2800)
                .buildAndRegister();

        //  Bismuth Germanate
        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .notConsumable(lens, NdYAG)
                .fluidInputs(BismuthNitrateSolution.getFluid(4000))
                .output(dust, BismuthGermanate, 33)
                .output(dust, Potash, 18)
                .fluidOutputs(NitrogenDioxide.getFluid(12000))
                .fluidOutputs(Water.getFluid(4000))
                .EUt(VA[UV])
                .duration(80)
                .buildAndRegister();

        //  Scintillator Crystal
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, Vibranium, 2)
                .input(dust, TlTmDropedCaesiumIodide)
                .input(dust, PolycyclicAromaticMixture)
                .input(dust, CadmiumTungstate)
                .input(dust, BismuthGermanate)
                .output(SCINTILLATOR_CRYSTAL)
                .EUt(VA[UHV])
                .duration(280)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Scintillator
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SCINTILLATOR_CRYSTAL)
                .input(SEPARATION_ELECTROMAGNET)
                .input(plate, Zylon, 2)
                .input(screw, Hdcs, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Kevlar.getFluid(L * 4))
                .output(SCINTILLATOR)
                .EUt(VA[UHV])
                .duration(120)
                .CasingTier(3)
                .buildAndRegister();

        //  Nuclear Clock
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SCINTILLATOR)
                .input(SENSOR_UIV, 2)
                .input(ND_YAG_LASER, 2)
                .input(lens, YttriumVanadateLuTm)
                .fluidInputs(Adamantium.getFluid(L * 9))
                .fluidInputs(Thorium.getFluid(L))
                .output(NUCLEAR_CLOCK)
                .EUt(VA[UEV])
                .duration(35)
                .CasingTier(3)
                .buildAndRegister();

        //  Closed Time-like Curve Guidance Unit
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(NUCLEAR_CLOCK)
                .input(TOOL_DATA_MODULE)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 16)
                .input(wireFine, Grisium, 8)
                .fluidInputs(Zylon.getFluid(L * 10))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L))
                .output(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .EUt(VA[UIV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        //  Manifold Oscillatory Power Cell
        DIMENSIONAL_OSCILLATOR_RECIPES.recipeBuilder()
                .input(QUANTUM_ANOMALY)
                .input(plate, HeavyQuarkDegenerateMatter)
                .fluidInputs(FreeElectronGas.getFluid(16000))
                .fluidInputs(Taranium.getFluid(L * 4))
                .output(MANIFOLD_OSCILLATORY_POWER_CELL, 16)
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  Closed Time-like Curve Computational Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT)
                .input(MANIFOLD_OSCILLATORY_POWER_CELL, 4)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(plate, AstralTitanium, 4)
                .input(plate, CelestialTungsten, 4)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(wireFine, CosmicNeutronium, 16)
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 4))
                .fluidInputs(SuperheavyLAlloy.getFluid(L * 4))
                .fluidInputs(CosmicComputingMixture.getFluid(L * 2))
                .fluidInputs(CosmicNeutronium.getFluid(L))
                .output(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
                .stationResearch(b -> b
                        .researchStack(CLOSED_TIMELIKE_CURVE_GUIDANCE_UNIT.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(576))
                .EUt(VA[UIV])
                .duration(1000)
                .buildAndRegister();

        //  Cosmic Circuit Board
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(frameGt, BlackTitanium)
                .input(CLOSED_TIMELIKE_CURVE_COMPUTATIONAL_UNIT)
                .input(CLADDED_OPTICAL_FIBER_CORE, 8)
                .input(BOSE_EINSTEIN_CONDENSATE, 4)
                .input(wireGtSingle, BlackDwarfMatter, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Zylon.getFluid(L * 10))
                .fluidInputs(QuantumAlloy.getFluid(L * 4))
                .fluidInputs(WhiteDwarfMatter.getFluid(L * 2))
                .output(HOLOGRAPHIC_INFORMATION_IMC)
                .stationResearch(b -> b
                        .researchStack(COSMIC_INFORMATION_MODULE.getStackForm())
                        .EUt(VA[UIV])
                        .CWUt(1024))
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  Cosmic SMDs
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 8)
                .input(plate, DegenerateRhenium)
                .input(plate, MetastableHassium)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_TRANSISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyLAlloy, 4)
                .input(dust, LanthanumFullereneNanotube)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(COSMIC_RESISTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(4960)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_RECIPES.recipeBuilder()
                .input(wireFine, SuperheavyHAlloy, 8)
                .input(plate, Rhugnor)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_CAPACITOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .temperature(5630)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATER_RECIPES.recipeBuilder()
                .input(ring, Legendarium)
                .input(wireFine, Infinity, 4)
                .fluidInputs(FullerenePolymerMatrix.getFluid(L * 2))
                .output(COSMIC_INDUCTOR, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, BETSPerrhenate)
                .input(dust, BoronFranciumMixture)
                .input(wireFine, CosmicNeutronium, 8)
                .fluidInputs(Zylon.getFluid(L * 2))
                .output(COSMIC_DIODE, 32)
                .EUt(VA[UEV])
                .duration(160)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Processor
        //  TODO Require Space Environment?
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(HOLOGRAPHIC_INFORMATION_IMC)
                .input(INTRAVITAL_SOC)
                .input(COSMIC_RESISTOR, 8)
                .input(COSMIC_CAPACITOR, 8)
                .input(COSMIC_TRANSISTOR, 8)
                .input(wireFine, CosmicNeutronium, 8)
                .solderMultiplier(1)
                .output(COSMIC_PROCESSOR, 2)
                .EUt(VA[UIV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Cosmic Assembly
        //  TODO Require Space Environment?
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(COSMIC_INFORMATION_MODULE)
                .input(COSMIC_PROCESSOR, 2)
                .input(COSMIC_INDUCTOR, 6)
                .input(COSMIC_CAPACITOR, 12)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 24) //TODO new RAM
                .input(wireFine, CosmicNeutronium, 8)
                .solderMultiplier(2)
                .output(COSMIC_ASSEMBLY, 2)
                .EUt(VA[UIV])
                .duration(400)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
