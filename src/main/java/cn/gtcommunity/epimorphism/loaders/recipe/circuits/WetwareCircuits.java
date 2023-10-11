package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.LuV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.NiobiumTitanium;
import static gregtech.api.unification.material.Materials.SterileGrowthMedium;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;

public class WetwareCircuits {
    public static void init() {
        //  Delete original recipe
        GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
                        MULTILAYER_FIBER_BOARD.getStackForm(16),
                        PETRI_DISH.getStackForm(),
                        ELECTRIC_PUMP_LuV.getStackForm(),
                        SENSOR_IV.getStackForm(),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV),
                        OreDictUnifier.get(foil, NiobiumTitanium, 16)},
                new FluidStack[]{SterileGrowthMedium.getFluid(4000)});

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, KaptonK, 16)
                .input(PETRI_DISH)
                .input(ELECTRIC_PUMP_LuV)
                .input(SENSOR_IV)
                .input(circuit, MarkerMaterials.Tier.IV)
                .input(foil, NiobiumTitanium, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_BOARD, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .duration(1200)
                .EUt(VA[LuV])
                .buildAndRegister();
    }
}
