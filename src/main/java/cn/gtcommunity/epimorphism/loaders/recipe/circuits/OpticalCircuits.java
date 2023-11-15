package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class OpticalCircuits {
    public static void init() {
        //  Optical Board
        CVD_RECIPES.recipeBuilder()
                .input(plate, GalliumNitride)
                .input(foil, Americium, 4)
                .output(OPTICAL_BOARD)
                .duration(40)
                .EUt(VA[UHV])
                .temperature(980)
                .glassTier(8)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Circuit Board
        for (FluidStack stack : new FluidStack[]{TetramethylammoniumHydroxide.getFluid(4000), EDP.getFluid(1000)}) {
            CHEMICAL_RECIPES.recipeBuilder()
                    .input(OPTICAL_BOARD)
                    .input(foil, Americium, 64)
                    .fluidInputs(stack)
                    .output(OPTICAL_CIRCUIT_BOARD)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(210)
                    .EUt(VA[IV])
                    .buildAndRegister();
        }

        //  ZBLAN Glasses
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 5)
                .input(dust, Barium, 2)
                .input(dust, Lanthanum)
                .input(dust, Aluminium)
                .input(dust, Sodium, 2)
                .fluidInputs(Fluorine.getFluid(6200))
                .circuitMeta(5)
                .fluidOutputs(ZBLANGlass.getFluid(L * 11))
                .blastFurnaceTemp(1073)
                .duration(1800)
                .EUt(VA[HV])
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Erbium)
                .output(ingot, ErbiumDopedZBLANGlass, 2)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(ingot, ZBLANGlass)
                .input(dust, Praseodymium)
                .output(ingot, PraseodymiumDopedZBLANGlass, 2)
                .duration(200)
                .EUt(VA[HV])
                .buildAndRegister();

        //  PRAM
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RANDOM_ACCESS_MEMORY)
                .input(plate, GSTGlass, 2)
                .input(foil, Americium, 8)
                .output(PHASE_CHANGE_MEMORY, 4)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  ACNOR
        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(NOR_MEMORY_CHIP)
                .input(OPTICAL_FIBER, 2)
                .input(foil, Trinium, 8)
                .output(OPTICAL_NOR_MEMORY_CHIP, 4)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Fiber: Germanium Tetrachloride + Phosphory Chloride + Silicon Tetrachloride -> Optical Fiber
        LASER_CVD_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(250))
                .fluidInputs(PhosphorylChloride.getFluid(250))
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .notConsumable(SHAPE_EXTRUDER_WIRE)
                .output(OPTICAL_FIBER, 8)
                .duration(400)
                .EUt(VA[LuV])
                .temperature(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Dielectric Mirror: Erbium-doped ZBLAN Glass + Praseodymium-doped ZBLAN Glass + Tantalum Pentoxide -> Dielectric Mirror
        MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .input(foil, Polybenzimidazole)
                .input(dust, ErbiumDopedZBLANGlass, 2)
                .input(dust, PraseodymiumDopedZBLANGlass, 2)
                .input(dust, TantalumPentoxide, 7)
                .output(DIELECTRIC_MIRROR)
                .duration(600)
                .EUt(VA[LuV])
                .temperature(2820)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Empty Laser
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(DIELECTRIC_MIRROR)
                .input(plate, SterlingSilver, 2)
                .input(ring, TungstenSteel, 2)
                .input(cableGtSingle, Platinum, 2)
                .fluidInputs(BorosilicateGlass.getFluid(L * 2))
                .output(EMPTY_LASER_ASSEMBLY)
                .duration(100)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Helium Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(Helium.getFluid(1000))
                .output(HELIUM_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Neon Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(Neon.getFluid(1000))
                .output(NEON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Argon Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(Argon.getFluid(1000))
                .output(ARGON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Krypton Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(Krypton.getFluid(1000))
                .output(KRYPTON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Xenon Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(Xenon.getFluid(1000))
                .output(XENON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Helium-Neon Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .fluidInputs(HeliumNeon.getFluid(1000))
                .output(HELIUM_NEON_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Nd:YAG Laser
        CANNER_RECIPES.recipeBuilder()
                .input(EMPTY_LASER_ASSEMBLY)
                .input(gem, NdYAG)
                .output(ND_YAG_LASER)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical SMDs
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Naquadah, 4)
                .input(dust, CadmiumSulfide)
                .output(OPTICAL_RESISTOR, 16)
                .fluidInputs(KaptonE.getFluid(L * 2))
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Iridium, 8)
                .input(foil, Germanium)
                .fluidInputs(KaptonE.getFluid(L))
                .output(OPTICAL_TRANSISTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        LASER_CVD_RECIPES.recipeBuilder()
                .input(OPTICAL_FIBER, 2)
                .input(plate, ErbiumDopedZBLANGlass)
                .fluidInputs(KaptonE.getFluid(L / 4))
                .output(OPTICAL_CAPACITOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .temperature(487)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Terbium)
                .input(wireFine, BorosilicateGlass, 4)
                .fluidInputs(KaptonE.getFluid(L / 2))
                .output(OPTICAL_DIODE, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ION_IMPLANTATER_RECIPES.recipeBuilder()
                .input(dust, Silver, 4)
                .input(plate, PMMA)
                .fluidInputs(KaptonE.getFluid(L))
                .output(OPTICAL_INDUCTOR, 16)
                .duration(160)
                .EUt(VA[UV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Laser Control Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(HELIUM_LASER)
                .input(NEON_LASER)
                .input(ARGON_LASER)
                .input(KRYPTON_LASER)
                .input(XENON_LASER)
                .input(ND_YAG_LASER)
                .input(lens, Diamond, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_LASER_CONTROL_UNIT)
                .duration(600)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(HELIUM_NEON_LASER)
                .input(ARGON_LASER)
                .input(KRYPTON_LASER)
                .input(XENON_LASER)
                .input(ND_YAG_LASER)
                .input(lens, Diamond, 2)
                .fluidInputs(SolderingAlloy.getFluid(L))
                .output(OPTICAL_LASER_CONTROL_UNIT)
                .duration(600)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical SoC
        MIXER_RECIPES.recipeBuilder()
                .input(dust, ManganeseDifluoride, 3)
                .input(dust, ZincSulfide, 2)
                .input(dust, TantalumPentoxide, 7)
                .input(dust, Rutile, 3)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(ElectrolyteReflectorMixture.getFluid(1000))
                .EUt(VA[UHV])
                .duration(270)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.BORON_NITRIDE_CRUCIBLE))
                .input(dust, StrontiumCarbonate, 64)
                .input(dust, Bohrium, 8)
                .output(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
                .EUt(VA[ZPM])
                .duration(120)
                .blastFurnaceTemp(6000)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_BOHRIUM_BOULE)
                .fluidInputs(Lubricant.getFluid(300)) // TODO Biological Lubricant?
                .outputs(STRONTIUM_CARBONATE_BOHRIUM_WAFER.getStackForm(6))
                .EUt(VA[EV])
                .duration(200)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_BOHRIUM_WAFER)
                .fluidInputs(ElectrolyteReflectorMixture.getFluid(200))
                .output(STRONTIUM_CARBONATE_OPTICAL_WAFER)
                .EUt(VA[UV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical SoC
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(STRONTIUM_CARBONATE_OPTICAL_WAFER)
                .input(plate, PedotTMA)
                .input(lens, Celestite, 2)
                .input(dust, ZBLANGlass, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .fluidInputs(TinAlloy.getFluid(L * 2))
                .output(OPTICAL_IMC_BOARD, 2)
                .EUt(VA[UEV])
                .duration(400)
                .CasingTier(3)
                .buildAndRegister();

        PRECISE_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_IMC_BOARD)
                .input(UHASOC_CHIP, 2)
                .input(OPTICAL_FIBER, 4)
                .fluidInputs(Glowstone.getFluid(L * 2))
                .output(PHOTOELECTRON_SOC)
                .EUt(VA[UEV])
                .duration(200)
                .CasingTier(3)
                .buildAndRegister();

        //  Optical Processor
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_LASER_CONTROL_UNIT)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT)
                .input(OPTICAL_RESISTOR, 8)
                .input(OPTICAL_CAPACITOR, 8)
                .input(OPTICAL_TRANSISTOR, 8)
                .input(OPTICAL_FIBER, 8)
                .output(OPTICAL_PROCESSOR, 2)
                .solderMultiplier(1)
                .duration(200)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(PHOTOELECTRON_SOC)
                .input(wireFine, PedotPSS, 8)
                .input(bolt, Adamantium, 8)
                .output(OPTICAL_PROCESSOR, 2)
                .solderMultiplier(1)
                .duration(100)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Assembly
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_PROCESSOR, 2)
                .input(OPTICAL_INDUCTOR, 6)
                .input(OPTICAL_CAPACITOR, 12)
                .input(PHASE_CHANGE_MEMORY, 24)
                .input(OPTICAL_FIBER, 16)
                .output(OPTICAL_ASSEMBLY, 2)
                .solderMultiplier(2)
                .duration(400)
                .EUt(VA[UHV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Optical Computer
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(OPTICAL_CIRCUIT_BOARD)
                .input(OPTICAL_ASSEMBLY, 2)
                .input(OPTICAL_DIODE, 8)
                .input(OPTICAL_NOR_MEMORY_CHIP, 16)
                .input(PHASE_CHANGE_MEMORY, 32)
                .input(OPTICAL_FIBER, 24)
                .input(foil, KaptonE, 32)
                .input(plate, Tritanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Draconium.getFluid(L * 3))
                .output(OPTICAL_COMPUTER)
                .duration(400)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(OPTICAL_ASSEMBLY.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  Optical Mainframe
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Draconium, 2)
                .input(OPTICAL_COMPUTER, 2)
                .input(OPTICAL_DIODE, 16)
                .input(OPTICAL_CAPACITOR, 16)
                .input(OPTICAL_TRANSISTOR, 16)
                .input(OPTICAL_RESISTOR, 16)
                .input(OPTICAL_INDUCTOR, 16)
                .input(foil, KaptonE, 64)
                .input(PHASE_CHANGE_MEMORY, 32)
                .input(wireGtDouble, Grisium, 16)
                .input(plate, Tritanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Kevlar.getFluid(L * 12))
                .fluidInputs(Polyetheretherketone.getFluid(L * 9))
                .fluidInputs(Draconium.getFluid(L * 6))
                .output(OPTICAL_MAINFRAME)
                .duration(1200)
                .EUt(VA[UEV])
                .stationResearch(b -> b
                        .researchStack(OPTICAL_COMPUTER.getStackForm())
                        .CWUt(384)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }
}
