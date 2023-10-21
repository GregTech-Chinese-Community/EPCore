package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class KevlarChain {
    public static void init() {
        //  Kevlar
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, CalciumChloride)
                .input(dust, ParaPhenylenediamine, 8)
                .input(dust, TerephthaloylChloride, 3)
                .fluidInputs(NMethylPyrrolidone.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Kevlar, 4)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(400)
                .EUt(VA[UHV])
                .CasingTier(5)
                .buildAndRegister();

        //  Para Phenylenediamine

        //  Methylamine + γ-Butyrolactone -> N-Methyl Pyrrolidone
       CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methylamine.getFluid(1000))
                .fluidInputs(GammaButyrolactone.getFluid(1000))
                .fluidOutputs(NMethylPyrrolidone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(240)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Methylamine

        //  γ-Butyrolactone
    }
}
