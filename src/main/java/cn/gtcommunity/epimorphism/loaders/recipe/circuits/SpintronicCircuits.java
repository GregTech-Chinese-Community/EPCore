package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
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

        //  TODO New NOR

        //  TODO Other recipes
    }
}
