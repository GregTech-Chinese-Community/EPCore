package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class DragonFusionUnitRecipes {
    public static void init() {

        //  Draconium + Ichorium + Taranium Plasma -> Awakened Draconium
        DRAGON_FUSION_UNIT_RECIPES.recipeBuilder()
                .input(dust, Draconium)
                .fluidInputs(Ichorium.getFluid(L))
                .fluidInputs(Taranium.getPlasma(L))
                .output(dust, AwakenedDraconium)
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Awakened Draconium -> Chaotic Draconium
        DRAGON_FUSION_UNIT_RECIPES.recipeBuilder()
                .input(dust, AwakenedDraconium)
                .fluidInputs(VoidMetal.getFluid(L))
                .fluidInputs(CrystalMatrix.getFluid(L))
                .output(dust, ChaoticDraconium)
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  Awakened Draconium + Concentrate Dragon Breath + Radon -> Dragon Blood
        DRAGON_FUSION_UNIT_RECIPES.recipeBuilder()
                .input(dust, AwakenedDraconium)
                .fluidInputs(ConcentrateDragonBreath.getFluid(1000))
                .fluidInputs(Radon.getFluid(1000))
                .output(dust, Ash)
                .fluidOutputs(DragonBlood.getFluid(1000))
                .EUt(VA[UHV])
                .duration(400)
                .buildAndRegister();
    }
}
