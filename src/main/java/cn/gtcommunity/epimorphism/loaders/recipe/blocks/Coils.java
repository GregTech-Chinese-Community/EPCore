package cn.gtcommunity.epimorphism.loaders.recipe.blocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockWireCoil;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class Coils {

    /**
     * @param tier Based on the original duration formula of CEu, with a rounding of 5
     * @return New coil recipe duration
     */
    private static int resultDuration(int tier) {
        return (45 + tier * 5) * 20;
    }

    /**
     * @param tier Based on the original EUt formula of CEu
     * @return New coil EUt (based on UV tier)
     */
    private static int resultEUt(int tier) {
        return VA[UV + tier];
    }

    public static void init() {

        //  TODO New coil blocks recipe, use Mica Insulator...

        //  Adamantium Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Adamantium, 8)
                .input(foil, AwakenedDraconium, 8)
                .fluidInputs(Tritanium.getFluid(L))
                .outputs(EPMetablocks.EP_WIRE_COIL.getItemVariant(EPBlockWireCoil.CoilType.ADAMANTIUM))
                .EUt(resultEUt(1))
                .duration(resultDuration(1))
                .buildAndRegister();
    }
}
