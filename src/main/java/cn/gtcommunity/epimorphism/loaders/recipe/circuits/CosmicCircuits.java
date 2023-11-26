package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

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
