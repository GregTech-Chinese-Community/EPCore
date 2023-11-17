package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import gregtech.api.metatileentity.multiblock.CleanroomType;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class PowerIntCircuitChain {
    public static void init() {

        //  Niobium + Chlorine -> Niobium Pentachloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Niobium)
                .fluidInputs(Chlorine.getFluid(5000))
                .circuitMeta(5)
                .output(dust, NiobiumPentachloride, 6)
                .EUt(VA[MV])
                .duration(290)
                .buildAndRegister();

        //  Niobium Pentachloride + Lithium Hydride -> Lithium Niobate + Sulfuric Acid (chlorine cycle, 5HCl -> Cl5 -> NbCl5)
        BLAST_RECIPES.recipeBuilder()
                .input(dust, NiobiumPentachloride, 6)
                .input(dust, LithiumHydride, 2)
                .notConsumable(dust, Hafnium)
                .fluidInputs(HydrogenPeroxide.getFluid(2000))
                .output(ingotHot, LithiumNiobate, 6)
                .fluidOutputs(SulfuricAcid.getFluid(5000))
                .EUt(VA[HV])
                .duration(320)
                .blastFurnaceTemp(4500)
                .buildAndRegister();

        //  Lithium Niobate Lens (plate recipe)
        LATHE_RECIPES.recipeBuilder()
                .input(plate, LithiumNiobate)
                .output(lens, LithiumNiobate)
                .output(dustSmall, LithiumNiobate)
                .EUt(VA[MV])
                .duration(1200)
                .buildAndRegister();

        //  Nano PIC
        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(DUBNIUM_WAFER)
                .notConsumable(lens, LithiumNiobate)
                .output(NANO_PIC_WAFER)
                .EUt(VA[UV])
                .duration(20)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .fluidInputs(Water.getFluid(1000))
                .output(NANO_PIC_CHIP, 2)
                .EUt(VA[ZPM])
                .duration(1800)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(NANO_PIC_CHIP, 2)
                .EUt(VA[ZPM])
                .duration(1350)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(NANO_PIC_WAFER)
                .fluidInputs(Lubricant.getFluid(250))
                .output(NANO_PIC_CHIP, 2)
                .EUt(VA[ZPM])
                .duration(900)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }
}
