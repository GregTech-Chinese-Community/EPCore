package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class KevlarChain {
    public static void init() {
        //  Para Xylene = Chlorine -> Bistrichloromethylbenzene + Hydrogen
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(6000))
                .fluidOutputs(Bistrichloromethylbenzene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(200)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Bromine + Acetylene -> Tetrabromoethane
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(4000))
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidOutputs(Tetrabromoethane.getFluid(1000))
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Titanium + Manganese + Co/AC-AB Catalyst + Acetone + Para Xylene + Tetrabromoethane + Air -> Terephthalic Acid + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(foil, Titanium, 10)
                .notConsumable(dust, Manganese)
                .notConsumable(dust, CoACABCatalyst)
                .notConsumable(Acetone.getFluid(1))
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Tetrabromoethane.getFluid(50))
                .fluidInputs(Air.getFluid(12000))
                .output(dust, TerephthalicAcid, 3)
                .fluidOutputs(Water.getFluid(2000))
                .duration(240)
                .EUt(VA[ZPM])
                .CasingTier(5)
                .buildAndRegister();

        //  Terephthalic Acid + Bistrichloromethylbenzene -> Terephthaloyl Chloride + HydrochloricAcid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TerephthalicAcid, 3)
                .fluidInputs(Bistrichloromethylbenzene.getFluid(1000))
                .output(dust, TerephthaloylChloride, 6)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        //  Butene + Hypochlorous Acid + Water -> Butanediol + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidInputs(HypochlorousAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Butanediol.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(60)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Copper + Butanediol -> γ-Butyrolactone
        BREWING_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .fluidInputs(Butanediol.getFluid(1000))
                .fluidOutputs(GammaButyrolactone.getFluid(1000))
                .duration(120)
                .EUt(VA[EV])
                .buildAndRegister();

        //  Methylamine + γ-Butyrolactone -> N-Methyl Pyrrolidone + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methylamine.getFluid(1000))
                .fluidInputs(GammaButyrolactone.getFluid(1000))
                .fluidOutputs(NMethylPyrrolidone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(240)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Calcium Chloride + Para Phenylenediamine + Terephthaloyl Chloride + N-Methyl Pyrrolidone + Sulfuric Acid -> Kevlar + Hydrochloric Acid
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, CalciumChloride)
                .input(dust, ParaPhenylenediamine, 8)
                .input(dust, TerephthaloylChloride, 3)
                .fluidInputs(NMethylPyrrolidone.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(500))
                .output(dust, Kevlar, 4)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(400)
                .EUt(VA[UEV])
                .CasingTier(5)
                .buildAndRegister();

        //  Easy Calcium Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Calcium)
                .fluidInputs(Chlorine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, CalciumChloride, 3)
                .duration(80)
                .EUt(VA[LV])
                .buildAndRegister();
    }
}
