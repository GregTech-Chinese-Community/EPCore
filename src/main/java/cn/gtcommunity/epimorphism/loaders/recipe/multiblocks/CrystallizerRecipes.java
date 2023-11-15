package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CrystallizerRecipes {
    public static void init() {

        //  Silicon + Chlorine -> Silicon Tetrachloride
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(Chlorine.getFluid(4000))
                .circuitMeta(1)
                .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                .duration(300)
                .EUt(VA[LV])
                .buildAndRegister();

        //  Zinc + Silicon Tetrachloride -> Solar-Grade Silicon + Zinc + Chlorine (cycle)
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Zinc)
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .output(dust, SolarGradeSilicon)
                .output(dust, Zinc)
                .fluidOutputs(Chlorine.getFluid(4000))
                .duration(60)
                .blastFurnaceTemp(1784)
                .EUt(VA[MV])
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon, 32),
                                OreDictUnifier.get(dustSmall, GalliumArsenide),
                                IntCircuitIngredient.getIntegratedCircuit(2)});

        //  Solar-Grade Silicon + Gallium Arsenide -> Silicon boule
        CRYSTALLIZATION_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.QUARTZ_CRUCIBLE))
                .input(dust, SolarGradeSilicon, 32)
                .input(dustSmall, GalliumArsenide)
                .output(SILICON_BOULE)
                .EUt(VA[LV])
                .duration(9000)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Silicon, 64),
                                OreDictUnifier.get(dust, Phosphorus, 8),
                                OreDictUnifier.get(dustSmall, GalliumArsenide, 2)},
                new FluidStack[]{Nitrogen.getFluid(8000)});

        BLAST_RECIPES.recipeBuilder()
                .input(dust, SolarGradeSilicon, 64)
                .input(dust, Phosphorus, 8)
                .input(dustSmall, GalliumArsenide, 2)
                .fluidInputs(Nitrogen.getFluid(8000))
                .output(PHOSPHORUS_BOULE)
                .EUt(VA[HV])
                .duration(12000)
                .blastFurnaceTemp(2484)
                .buildAndRegister();

        //  Naquadah-droped Silicon Boule
        GTRecipeHandler.removeRecipesByInputs(BLAST_RECIPES,
                new ItemStack[]{OreDictUnifier.get(block, Silicon, 16),
                                OreDictUnifier.get(ingot, Naquadah),
                                OreDictUnifier.get(dust, GalliumArsenide)},
                new FluidStack[]{Argon.getFluid(8000)});

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.TUNGSTEN_CRUCIBLE))
                .input(block, SolarGradeSilicon, 16)
                .input(ingot, Naquadah)
                .input(dust, GalliumArsenide)
                .fluidInputs(Argon.getFluid(8000))
                .output(NAQUADAH_BOULE)
                .EUt(VA[EV])
                .duration(15000)
                .blastFurnaceTemp(5400)
                .buildAndRegister();
    }
}