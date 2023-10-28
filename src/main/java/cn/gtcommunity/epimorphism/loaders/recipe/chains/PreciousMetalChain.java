package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import gregtech.api.unification.material.Materials;
import net.minecraft.init.Items;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PreciousMetalChain {

    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Materials.Glowstone, 2)
                .input(Items.DRAGON_BREATH, 2)
                .fluidInputs(Materials.Water.getFluid(1000))
                .EUt(16)
                .duration(6)
                .fluidOutputs(EPMaterials.DragonBreath.getFluid(2000))
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .fluidInputs(EPMaterials.DragonBreath.getFluid(5000))
                .input(dustSmall, Materials.Biotite, 2)
                .input(dustTiny, Materials.Tin)
                .EUt(8).duration(6)
                .fluidOutputs(EPMaterials.ConcentrateDragonBreath.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH, 8)
                .fluidInputs(Materials.AquaRegia.getFluid(1000))
                .EUt(32).duration(8)
                .fluidOutputs(EPMaterials.ConcentrateDragonBreath.getFluid(2000))
                .buildAndRegister();


    }

}
