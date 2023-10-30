package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class IndustrialDrillRecipes {
    public static void init() {
        DRILLING_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.BEDROCK))
                .chancedOutput(dust, Bedrock, 100, 0)
                .fluidOutputs(BedrockSmoke.getFluid(100))
                .duration(100)
                .EUt(VA[UHV])
                .buildAndRegister();
    }
}