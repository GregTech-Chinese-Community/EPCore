package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.material.MarkerMaterials;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class FullereneChain {
    public static void init() {
        //  Butane + Bromine -> Bromobutane + Hydrofluoric Acid
        ULTRAVIOLET_LAMP_CHAMBER_RECIPES.recipeBuilder()
                .notConsumable(craftingLens, MarkerMaterials.Color.Brown)
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .fluidOutputs(Bromobutane.getFluid(1000))
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .EUt(7680)
                .duration(350)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Sodium Hydroxide + Bromobutane -> Sodium Bromide + Butanol
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(Bromobutane.getFluid(1000))
                .output(dust, SodiumBromide, 2)
                .fluidOutputs(Butanol.getFluid(1000))
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(VA[HV])
                .duration(120)
                .buildAndRegister();

        //  Sodium Bromide + Hydrogen Cyanide + Ethylbenzene + Bromine -> Cyanonaphthalene + Sodium + Hydrobromic Acid + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(BLACKLIGHT)
                .input(dust, SodiumBromide, 3)
                .fluidInputs(HydrogenCyanide.getFluid(1000))
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .fluidInputs(Bromine.getFluid(2000))
                .output(dust, Cyanonaphthalene, 19)
                .output(dust, Sodium, 3)
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(VA[EV])
                .duration(80)
                .CasingTier(3)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Tin Chloride + Cyanonaphthalene + Hydrochloric Acid + Water -> Naphthaldehyde + Ammonium Chloride + Chlorine
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, TinChloride)
                .input(dust, Cyanonaphthalene, 19)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Naphthaldehyde.getFluid(1000))
                .fluidOutputs(AmmoniumChloride.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .EUt(VA[LuV])
                .duration(360)
                .CasingTier(4)
                .buildAndRegister();

        //  Iodine + Triphenylphosphine + Naphthaldehyde + Ethylbenzene + Oxygen -> Methylbenzophenanthrene + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, Iodine)
                .notConsumable(dust, Triphenylphosphine)
                .fluidInputs(Naphthaldehyde.getFluid(1000))
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, Methylbenzophenanthrene, 33)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(VA[ZPM])
                .duration(800)
                .CasingTier(5)
                .buildAndRegister();

        //  BismuthVanadate + Butane + Oxygen -> Maleic Anhydride + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, BismuthVanadate)
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(7000))
                .fluidOutputs(MaleicAnhydride.getFluid(1000))
                .fluidOutputs(Water.getFluid(4000))
                .EUt(VA[HV])
                .duration(480)
                .CasingTier(3)
                .buildAndRegister();

        //  Rhodium Plated Palladium + Maleic Anhydride + Hydrogen + Water -> Succinic Acid
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .notConsumable(dust, RhodiumPlatedPalladium)
                .fluidInputs(MaleicAnhydride.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, SuccinicAcid, 14)
                .EUt(VA[EV])
                .duration(600)
                .CasingTier(4)
                .buildAndRegister();

        //  Succinic Acid + Ammonia -> Succinimide + Water
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SuccinicAcid, 14)
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, Succinimide, 12)
                .fluidOutputs(Water.getFluid(2000))
                .temperature(2100)
                .EUt(VA[MV])
                .duration(800)
                .buildAndRegister();

        //  Succinimide + Bromine -> Bromo Succinimide + Hydrobromic Acid
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Succinimide, 12)
                .fluidInputs(Bromine.getFluid(2000))
                .circuitMeta(2)
                .output(dust, BromoSuccinimide, 12)
                .fluidOutputs(HydrobromicAcid.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        //  Methylbenzophenanthrene + Bromo Succinimide + Potassium Cyanide -> Benzophenanthrenylacetonitrile + Potassium Bromide + Succinimide
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Methylbenzophenanthrene, 33)
                .input(dust, BromoSuccinimide, 12)
                .input(dust, PotassiumCyanide, 3)
                .output(dust, Benzophenanthrenylacetonitrile, 34)
                .output(dust, PotassiumBromide, 2)
                .output(dust, Succinimide, 12)
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Benzophenanthrenylacetonitrile + Ti-Al Catalyst -> Geodesic Polyarene
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, Benzophenanthrenylacetonitrile, 64)
                .input(dust, Benzophenanthrenylacetonitrile, 38)
                .notConsumable(dust, TiAlCatalyst)
                .output(dust, GeodesicPolyarene)
                .fluidOutputs(Ammonia.getFluid(3000))
                .EUt(VA[UEV])
                .duration(2400)
                .CasingTier(5)
                .buildAndRegister();

        //  Geodesic Polyarene + Platinum -> Fullerene + Hydrogen
        PYROLYSE_RECIPES.recipeBuilder()
                .input(dust, GeodesicPolyarene)
                .input(foil, Platinum)
                .output(dust, Fullerene)
                .fluidOutputs(Hydrogen.getFluid(500))
                .duration(10)
                .EUt(VA[UEV])
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fullerene Ingot
        EXTRUDER_RECIPES.recipeBuilder()
                .input(dust, Fullerene)
                .notConsumable(SHAPE_EXTRUDER_INGOT)
                .output(ingot, Fullerene)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        //  Ti-Al Catalyst
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Titanium)
                .input(dust, Aluminium)
                .output(dust, TiAlCatalyst, 2)
                .duration(120)
                .EUt(VA[MV])
                .buildAndRegister();
    }
}
