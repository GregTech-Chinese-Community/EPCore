package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class DecayChamberRecipes {
    public static void init() {

        //  Quasi-fissioning Plasma -> Flerovium-Ytterbium Plasma
        DECAY_CHAMBER_RECIPES.recipeBuilder()
                .fluidInputs(QuasifissioningPlasma.getFluid(1000))
                .fluidOutputs(FleroviumYtterbiumPlasma.getFluid(1000))
                .EUt(VA[ZPM])
                .duration(160)
                .buildAndRegister();

        //  Flerovium-Ytterbium Plasma -> Metastable Flerovium + Ytterbium-178
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(FleroviumYtterbiumPlasma.getFluid(1000))
                .fluidOutputs(MetastableFlerovium.getFluid(288))
                .fluidOutputs(Ytterbium178.getFluid(288))
                .EUt(VA[EV])
                .duration(290)
                .buildAndRegister();

        //  Ytterbium-178 -> Hafnium
        DECAY_CHAMBER_RECIPES.recipeBuilder()
                .fluidInputs(Ytterbium178.getFluid(144))
                .fluidOutputs(Hafnium.getFluid(144))
                .EUt(VA[LuV])
                .duration(120)
                .buildAndRegister();

        //  Radium -> Radon
        DECAY_CHAMBER_RECIPES.recipeBuilder()
                .input(dust, Radium)
                .fluidOutputs(Radon.getFluid(1000))
                .EUt(VA[HV])
                .duration(180)
                .buildAndRegister();

        //  Lead-209 -> Bismuth-209
        DECAY_CHAMBER_RECIPES.recipeBuilder()
                .fluidInputs(Lead209.getFluid(L))
                .fluidOutputs(Bismuth209.getFluid(L))
                .EUt(VA[ZPM])
                .duration(240)
                .buildAndRegister();
    }
}
