package cn.gtcommunity.epimorphism.loaders.recipe.blocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockCrucibleCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.stack.UnificationEntry;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class Crucibles {
    public static void init() {
        ModHandler.addShapedRecipe(true, "quartz_crucible", EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.QUARTZ_CRUCIBLE),
                "P P", "PhP", "PPP",
                'P', new UnificationEntry(plate, Quartzite)
        );

        ModHandler.addShapedRecipe(true, "tungsten_crucible", EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.TUNGSTEN_CRUCIBLE),
                "P P", "PhP", "PPP",
                'P', new UnificationEntry(plate, Tungsten)
        );

        ModHandler.addShapedRecipe(true, "graphite_crucible", EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.GRAPHITE_CRUCIBLE),
                "P P", "PhP", "PPP",
                'P', new UnificationEntry(plate, Graphene)
        );

        ModHandler.addShapedRecipe(true, "hexagonal_boron_nitride_crucible", EPMetablocks.EP_CRUCIBLE_CASING.getItemVariant(EPBlockCrucibleCasing.CrucibleType.BORON_NITRIDE_CRUCIBLE),
                "P P", "PhP", "PPP",
                'P', new UnificationEntry(plate, HexagonalBoronNitride)
        );
    }
}
