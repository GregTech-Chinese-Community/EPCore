package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class GrapheneChain {
    public static void init() {

        //  Delete original recipes
        GTRecipeHandler.removeRecipesByInputs(MIXER_RECIPES,
                OreDictUnifier.get(dust, Graphite),
                OreDictUnifier.get(dust, Carbon, 4),
                OreDictUnifier.get(dust, Silicon),
                IntCircuitIngredient.getIntegratedCircuit(1));

        //  Graphite -> Graphene Oxide
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(dust, SodiumHydroxide)
                .output(dust, GrapheneOxide)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Graphite + NitrationMixture -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(NitrationMixture.getFluid(2000))
                .notConsumable(MAGNETRON.getStackForm())
                .output(dust, Graphene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .fluidOutputs(NitricAcid.getFluid(1000))
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Graphene Oxide + Hydrazine + Argon -> Graphene
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, GrapheneOxide)
                .fluidInputs(Hydrazine.getFluid(100))
                .fluidInputs(Argon.getFluid(50))
                .output(dust, Graphene)
                .duration(100)
                .EUt(VA[HV])
                .buildAndRegister();

        //  Ammonia + HydrogenPeroxide -> Hydrazine
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .fluidOutputs(Hydrazine.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(80)
                .EUt(VA[HV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Beryllium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, BerylliumOxide, 2)
                .duration(60)
                .EUt(VA[LV])
                .buildAndRegister();
        //  Magnetron
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, BerylliumOxide, 64)
                .input(ring, BerylliumOxide, 64)
                .input(plate, HSLASteel, 6)
                .inputs(VACUUM_TUBE.getStackForm())
                .outputs(MAGNETRON.getStackForm())
                .duration(600)
                .EUt(VA[IV])
                .buildAndRegister();
    }
}
