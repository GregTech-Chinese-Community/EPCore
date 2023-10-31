package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SpintronicCircuits {
    public static void init() {
        //  Spintronic Board
        CVD_RECIPES.recipeBuilder()
                .input(plate, CarbonNanotube)
                .input(foil, Phosphorene, 4)
                .output(SPINTRONIC_BOARD)
                .duration(40)
                .EUt(VA[UEV])
                .temperature(3580)
                .glassTier(9)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Spintronic Circuit Board
        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000), EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(SPINTRONIC_BOARD)
                    .input(foil, Fullerene, 16)
                    .fluidInputs(stack)
                    .output(SPINTRONIC_CIRCUIT_BOARD)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(210)
                    .EUt(VA[LuV])
                    .buildAndRegister();
        }

        //  STTRAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, ErbiumDopedZBLANGlass, 2)
                .input(plate, PraseodymiumDopedZBLANGlass, 2)
                .input(foil, Vibranium, 8)
                .input(wireFine, PedotPSS, 16)
                .output(SPIN_TRANSFER_TORQUE_MEMORY, 2)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  MDNAND
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(NAND_MEMORY_CHIP)
                .input(dust, PedotTMA, 2)
                .input(foil, Abyssalloy, 8)
                .input(wireFine, CarbonNanotube, 16)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Quantum Dot
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Selenium)
                .output(dust, CadmiumSelenide, 2)
                .EUt(VA[EV])
                .duration(120)
                .buildAndRegister();

        //  Spintronic SMDs
        CVD_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 4)
                .input(gem, HexagonalBoronNitride)
                .output(SPINTRONIC_RESISTOR, 16)
                .fluidInputs(Kevlar.getFluid(L * 2))
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .temperature(2984)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, CarbonNanotube, 8)
                .input(plate, AmorphousBoronNitride)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_TRANSISTOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_RECIPES.recipeBuilder()
                .input(wireGtSingle, CarbonNanotube, 2)
                .input(plate, CubicBoronNitride)
                .fluidInputs(Kevlar.getFluid(L / 4))
                .output(SPINTRONIC_CAPACITOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .temperature(2755)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, CadmiumSelenide)
                .input(wireFine, CarbonNanotube, 4)
                .fluidInputs(Kevlar.getFluid(L / 2))
                .output(SPINTRONIC_DIODE, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATER_RECIPES.recipeBuilder()
                .input(ring, Fullerene)
                .input(wireFine, ThalliumCopperChloride, 4)
                .fluidInputs(Kevlar.getFluid(L))
                .output(SPINTRONIC_INDUCTOR, 16)
                .duration(160)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  ESR Computation Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(plate, PlutoniumPhosphide, 2)
                .input(plate, BismuthFerrite)
                .input(foil, BismuthChalcogenide, 2)
                .input(TOPOLOGICAL_INSULATOR_TUBE)
                .input(BOSE_EINSTEIN_CONDENSATE)
                .input(wireFine, ThalliumCopperChloride, 24)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(ESR_COMPUTATION_UNIT)
                .duration(600)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Topological Insulator Tube
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(dust, Bismuth)
                .input(dust, Antimony)
                .input(dust, Tellurium, 2)
                .input(dust, Sulfur)
                .notConsumable(plate, CadmiumSulfide)
                .output(dust, BismuthChalcogenide, 5)
                .duration(80)
                .EUt(VA[UV])
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cadmium)
                .input(dust, Tellurium, 2)
                .fluidInputs(Mercury.getFluid(2000))
                .circuitMeta(5)
                .output(dust, MercuryCadmiumTelluride, 5)
                .duration(400)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(wireFine, MercuryCadmiumTelluride, 16)
                .input(spring, CarbonNanotube)
                .output(TOPOLOGICAL_INSULATOR_TUBE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Bose-Einstein Condensate
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FIELD_GENERATOR_IV)
                .input(HELIUM_NEON_LASER)
                .input(plate, Trinium, 2)
                .input(cableGtSingle, Europium, 2)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS, 2))
                .output(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .duration(80)
                .EUt(VA[UV])
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT)
                .input(dust, Rubidium, 8)
                .output(BOSE_EINSTEIN_CONDENSATE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(20)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Spintronic Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ESR_COMPUTATION_UNIT)
                .input(CRYSTAL_SYSTEM_ON_CHIP)
                .input(SPINTRONIC_RESISTOR, 8)
                .input(SPINTRONIC_CAPACITOR, 8)
                .input(SPINTRONIC_TRANSISTOR, 8)
                .input(wireFine, CarbonNanotube, 8)
                .output(SPINTRONIC_PROCESSOR, 2)
                .duration(200)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Spintronic Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_PROCESSOR, 2)
                .input(SPINTRONIC_INDUCTOR, 6)
                .input(SPINTRONIC_CAPACITOR, 12)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 24)
                .input(wireFine, CarbonNanotube, 16)
                .output(SPINTRONIC_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Spintronic Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(SPINTRONIC_CIRCUIT_BOARD)
                .input(SPINTRONIC_ASSEMBLY, 2)
                .input(SPINTRONIC_DIODE, 8)
                .input(SPINTRONIC_NAND_MEMORY_CHIP, 16)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(wireFine, CarbonNanotube, 24)
                .input(foil, Fullerene, 32)
                .input(plate, PlutoniumPhosphide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Polyetheretherketone.getFluid(L * 6))
                .fluidInputs(Neutronium.getFluid(L * 3))
                .output(SPINTRONIC_COMPUTER)
                .duration(400)
                .EUt(VA[UEV])
                .research(b -> b
                        .researchStack(SPINTRONIC_ASSEMBLY.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UEV])
                        .duration(32000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Fullerene, 2)
                .input(SPINTRONIC_COMPUTER, 2)
                .input(SPINTRONIC_DIODE, 16)
                .input(SPINTRONIC_CAPACITOR, 16)
                .input(SPINTRONIC_TRANSISTOR, 16)
                .input(SPINTRONIC_RESISTOR, 16)
                .input(SPINTRONIC_INDUCTOR, 16)
                .input(foil, CarbonNanotube, 16)
                .input(SPIN_TRANSFER_TORQUE_MEMORY, 32)
                .input(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 16)//  TODO new UIV superconductor
                .input(plate, NeptuniumAluminide, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(CarbonNanotube.getFluid(L * 15))//  TODO Zylon
                .fluidInputs(Kevlar.getFluid(L * 12))
                .fluidInputs(Neutronium.getFluid(L * 9))
                .output(SPINTRONIC_MAINFRAME)
                .duration(1600)
                .EUt(VA[UIV])
                .research(b -> b
                        .researchStack(SPINTRONIC_COMPUTER.getStackForm())
                        .CWUt(768)
                        .EUt(VA[UIV])
                        .duration(32000))
                .buildAndRegister();
    }
}
