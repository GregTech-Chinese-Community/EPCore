package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import net.minecraft.init.Items;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PreciousMetalChain {

    public static void init() {

        //  Glowstone + Dragon Breath (vanilla) + Water -> Dragon Breath (gregtech)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Glowstone, 2)
                .input(Items.DRAGON_BREATH, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(DragonBreath.getFluid(2000))
                .EUt(16)
                .duration(6)
                .buildAndRegister();

        //  Concentrate Dragon Breath: Dragon Breath + Biotite + Tin -> Concentrate Dragon Breath
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(DragonBreath.getFluid(5000))
                .input(dustSmall, Biotite, 2)
                .input(dustTiny, Tin)
                .fluidOutputs(ConcentrateDragonBreath.getFluid(1000))
                .EUt(8)
                .duration(6)
                .buildAndRegister();

        //  Concentrate Dragon Breath: Dragon Breath + Aqua Regia -> Concentrate Dragon Breath
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH, 8)
                .fluidInputs(AquaRegia.getFluid(1000))
                .fluidOutputs(ConcentrateDragonBreath.getFluid(2000))
                .EUt(32)
                .duration(8)
                .buildAndRegister();
    }

}
