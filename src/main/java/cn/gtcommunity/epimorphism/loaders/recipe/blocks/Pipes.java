package cn.gtcommunity.epimorphism.loaders.recipe.blocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockBoilerCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class Pipes {
    public static void init() {
        //  Polybenzimidazole Pipe
        ModHandler.addShapedRecipe(true, "polybenzimidazole_pipe", EPMetablocks.EP_BOILER_CASING.getItemVariant(EPBlockBoilerCasing.BoilerCasingType.POLYBENZIMIDAZOLE, 2),
                "XPX", "PFP", "XPX",
                'X', new UnificationEntry(plate, Polybenzimidazole),
                'P', new UnificationEntry(pipeNormalFluid, Polybenzimidazole),
                'F', new UnificationEntry(frameGt, Polybenzimidazole));

        //  Alloy Smelter Pipe
        ModHandler.addShapedRecipe(true, "alloy_smelter_pipe", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.ALLOY_SMELTING_PIPE_CASING, 2),
                "XPX", "PFP", "XPX",
                'X', new UnificationEntry(plate, HMS1J22Alloy),
                'P', new UnificationEntry(pipeNormalFluid, TungstenSteel),
                'F', new UnificationEntry(frameGt, EglinSteel));
    }
}
