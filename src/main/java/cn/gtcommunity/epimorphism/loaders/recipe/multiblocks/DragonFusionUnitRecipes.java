package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class DragonFusionUnitRecipes {
    public static void init() {

        //  Draconium + Ichor Cloth -> Awakened Draconium

        //  Awakened Draconium -> Chaotic Draconium

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
