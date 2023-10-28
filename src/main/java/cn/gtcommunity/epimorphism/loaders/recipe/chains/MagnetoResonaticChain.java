package cn.gtcommunity.epimorphism.loaders.recipe.chains;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class MagnetoResonaticChain {
    public static void init() {

        //  Yttrium + Sulfuric Acid -> Yttrium Trioxide + Hydrogen Sulfide + Oxygen
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Yttrium, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .circuitMeta(1)
                .output(dust, YttriumTrioxide, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(VA[HV])
                .duration(200)
                .buildAndRegister();

        //  Yttrium Trioxide + Zirconium + Oxygen -> Cubic Zirconia
        CVD_RECIPES.recipeBuilder()
                .notConsumable(dust, YttriumTrioxide)
                .input(dust, Zirconium)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(gem, CubicZirconia)
                .EUt(VA[IV])
                .duration(600)
                .glassTier(6)
                .temperature(1132)
                .buildAndRegister();

        //  Tellurium + Bismuth + Sulfuric Acid -> Bismuth Tellurite
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Tellurium, 3)
                .input(dust, Bismuth, 2)
                .notConsumable(SulfuricAcid.getFluid(1))
                .output(dust, BismuthTellurite, 5)
                .EUt(VA[MV])
                .duration(160)
                .buildAndRegister();

        //  Banded Iron + Silicon Dioxide + Silicon + Oxygen -> Prasiolite + Ash
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BandedIron)
                .input(dust, SiliconDioxide, 8)
                .input(dust, Silicon, 2)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, Prasiolite, 2)
                .output(dustTiny, Ash, 2)
                .EUt(VA[MV])
                .duration(800)
                .buildAndRegister();

        //  Magneto Resonatic
        MIXER_RECIPES.recipeBuilder()
                .input(dust, BismuthTellurite, 4)
                .input(dust, Prasiolite, 3)
                .input(dust, CubicZirconia, 1)
                .input(dust, SteelMagnetic, 1)
                .output(dust, MagnetoResonatic, 9)
                .EUt(VA[MV])
                .duration(80)
                .buildAndRegister();
    }
}
