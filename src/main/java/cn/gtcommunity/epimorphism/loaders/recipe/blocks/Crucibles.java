package cn.gtcommunity.epimorphism.loaders.recipe.blocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class Crucibles {
    public static void init() {

        //  Quartz Crucible
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, Quartzite, 5)
                .fluidInputs(SolderingAlloy.getFluid(L * 2)) // TODO find better adhesive
                .circuitMeta(5)
                .outputs(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.QUARTZ_CRUCIBLE))
                .EUt(VA[LV])
                .duration(1200)
                .buildAndRegister();

        //  Tungsten Crucible
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, Tungsten, 5)
                .fluidInputs(SolderingAlloy.getFluid(L * 2)) // TODO find better adhesive
                .circuitMeta(5)
                .outputs(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.TUNGSTEN_CRUCIBLE))
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        //  Graphite Crucible
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, Graphene, 5)
                .fluidInputs(SolderingAlloy.getFluid(L * 2)) // TODO find better adhesive
                .circuitMeta(5)
                .outputs(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.GRAPHITE_CRUCIBLE))
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Hexagonal Boron Nitride Crucible
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(plate, HexagonalBoronNitride, 5)
                .fluidInputs(SolderingAlloy.getFluid(L * 2)) // TODO find better adhesive
                .circuitMeta(5)
                .outputs(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.BORON_NITRIDE_CRUCIBLE))
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();
    }
}
