package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class KaptonChain {
    public static void init() {

        //  Para Xylene + Chloromethane -> Durene + Hydrochloric Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(2000))
                .output(dust, Durene, 24)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();

        //  Durene + Oxygen -> Pyromellitic Dianhydride + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Durene, 4)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, PyromelliticDianhydride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(30)
                .EUt(VA[HV])
                .buildAndRegister();

        //   Nitrobenzene + Hydrogen -> Aminophenol + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrobenzene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .circuitMeta(1)
                .fluidOutputs(Aminophenol.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(300)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Tin dust + Aniline + Phenol + Hydrochloric Acid -> Oxydianiline + Methane
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, Tin)
                .fluidInputs(Aniline.getFluid(2000))
                .fluidInputs(Phenol.getFluid(1000))
                .notConsumable(HydrochloricAcid.getFluid(1))
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Methane.getFluid(2000))
                .duration(100)
                .EUt(VA[ZPM])
                .CasingTier(4)
                .buildAndRegister();

        //  Saltpeter + Aminonphenol + Nitrochlorobenzene + Water + Dimethylformamide -> Oxydianiline + Oxygen + Hydrochloric Acid
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, Saltpeter)
                .fluidInputs(Aminophenol.getFluid(1000))
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(Dimethylformamide.getFluid(1))
                .output(dust, Oxydianiline, 27)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .duration(200)
                .EUt(VA[HV])
                .CasingTier(2)
                .buildAndRegister();

        //  Phthalic Anhydride + Palladium -> Biphenyl Tetracarboxylic Acid Dianhydride + Hydrogen
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .notConsumable(dust, Palladium)
                .output(dust, BiphenylTetracarboxylicAcidDianhydride, 28)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(200)
                .EUt(VA[HV])
                .CasingTier(3)
                .buildAndRegister();

        //  Nitrochlorobenzene + Ammonia -> Nitroaniline + Ammonium Chloride
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitrochlorobenzene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Nitroaniline.getFluid(1000))
                .output(dust, AmmoniumChloride, 2)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Nitroaniline + Hydrogen -> Para Phenylenediamine + Water
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Nitroaniline.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, ParaPhenylenediamine, 16)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Pyromellitic Dianhydride + Oxydianiline -> Kapton-K
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PyromelliticDianhydride, 2)
                .input(dust, Oxydianiline, 3)
                .fluidOutputs(KaptonK.getFluid(L))
                .duration(30)
                .EUt(VA[IV])
                .buildAndRegister();

        //  Biphenyl Tetracarboxylic Acid Dianhydride + Para Phenylenediamine + Kapton-K -> Kapton-E
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, BiphenylTetracarboxylicAcidDianhydride, 2)
                .input(dust, ParaPhenylenediamine)
                .fluidInputs(KaptonK.getFluid(L))
                .fluidOutputs(KaptonE.getFluid(L))
                .duration(30)
                .EUt(VA[ZPM])
                .buildAndRegister();

        //  Dimethylformamide (LuV): Dimethylamine + Carbon Monoxide -> Dimethylformamide
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(Dimethylformamide.getFluid(1000))
                .duration(200)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  Dimethylamine + Hydrochloric Acid -> Dimethylamine Hydrochloride
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(DimethylamineHydrochloride.getFluid(1000))
                .EUt(VA[EV])
                .duration(60)
                .buildAndRegister();

        //  Dimethylformamide (EV): Potassium Formate + Dimethylamine Hydrochloride -> Rock Salt + Dimethylformamide + Hydrogen
        BURNER_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumFormate, 1)
                .fluidInputs(DimethylamineHydrochloride.getFluid(1000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(Dimethylformamide.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(VA[EV])
                .duration(120)
                .temperature(1488)
                .buildAndRegister();

        //  Rock Salt + Methanol -> Potassium Formate + Chlorine
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, RockSalt, 2)
                .fluidInputs(Methanol.getFluid(1000))
                .output(dust, PotassiumFormate)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(240)
                .temperature(980)
                .buildAndRegister();
    }
}
