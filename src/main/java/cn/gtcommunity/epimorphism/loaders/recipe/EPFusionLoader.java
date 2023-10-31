package cn.gtcommunity.epimorphism.loaders.recipe;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class EPFusionLoader {
    public static void init() {
        //  (Mk III) Americium + Naquadria -> Orichalcum
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(128))
                .fluidInputs(Naquadria.getFluid(128))
                .fluidOutputs(Orichalcum.getFluid(32))
                .EUToStart(600000000L)
                .duration(200)
                .EUt(VA[LuV] * 3)
                .buildAndRegister();

        //  (Mk II) Europium + Unstable Adamantium -> Adamantium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Europium.getFluid(16))
                .fluidInputs(AdamantiumUnstable.getFluid(16))
                .fluidOutputs(Adamantium.getPlasma(16))
                .EUToStart(300000000L)
                .duration(32)
                .EUt(VA[LuV])
                .buildAndRegister();

        //  (Mk III) Orichalcum + Unstable Vibranium -> Vibranium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Orichalcum.getFluid(L))
                .fluidInputs(VibraniumUnstable.getFluid(L))
                .fluidOutputs(Vibranium.getPlasma(L))
                .EUToStart(620000000L)
                .duration(64)
                .EUt(VA[ZPM] * 2)
                .buildAndRegister();

        //  (Mk III) Americium + Neon -> Dubnium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Americium.getFluid(16))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Dubnium.getFluid(125))
                .EUt(VA[UV])
                .duration(160)
                .EUToStart(380000000L)
                .buildAndRegister();

        //  (Mk III) Plutonium-244 + Calcium -> Seaborgium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(16))
                .fluidInputs(Calcium.getFluid(32))
                .fluidOutputs(Seaborgium.getFluid(48))
                .EUt(VA[ZPM])
                .duration(320)
                .EUToStart(400000000L)
                .buildAndRegister();

        //  (Mk I) Plutonium-244 + Neon -> Rutherfordium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(16))
                .fluidInputs(Neon.getFluid(16))
                .fluidOutputs(Rutherfordium.getFluid(16))
                .EUt(VA[LuV])
                .duration(180)
                .EUToStart(150000000L)
                .buildAndRegister();

        //  (Mk IV) Plutonium-244 + Titanium -> Livermorium
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Plutonium244.getFluid(32))
                .fluidInputs(Titanium.getFluid(32))
                .fluidOutputs(Livermorium.getFluid(64))
                .EUt(VA[UV])
                .duration(600)
                .EUToStart(650000000L)
                .buildAndRegister();
    }
}
