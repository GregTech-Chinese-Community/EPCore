package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import net.minecraft.init.Items;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class DragonChain {
    public static void init() {

        //  TODO Dr, Dr+ and *Dr*

        //  Dragon Breath compatibility
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(Items.DRAGON_BREATH)
                .output(Items.GLASS_BOTTLE)
                .fluidOutputs(DragonBreath.getFluid(1000))
                .EUt(VA[HV])
                .duration(50)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(Items.GLASS_BOTTLE)
                .fluidInputs(DragonBreath.getFluid(1000))
                .output(Items.DRAGON_BREATH)
                .EUt(VA[ULV])
                .duration(100)
                .buildAndRegister();

        //  Draconium + Dragon Breath -> Concentrate Dragon Breath
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Draconium)
                .fluidInputs(DragonBreath.getFluid(1000))
                .fluidOutputs(ConcentrateDragonBreath.getFluid(1000))
                .EUt(VA[IV])
                .duration(240)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Awakened Draconium + Concentrate Dragon Breath + Radon -> Dragon Blood
        MIXER_RECIPES.recipeBuilder()
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
