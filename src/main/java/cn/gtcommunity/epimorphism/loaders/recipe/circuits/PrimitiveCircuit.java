package cn.gtcommunity.epimorphism.loaders.recipe.circuits;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class PrimitiveCircuit {
    public static void init() {
        //  Delete glass tube -> vacuum tube
        ModHandler.removeRecipeByName("gregtech:vacuum_tube");
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2), IntCircuitIngredient.getIntegratedCircuit(1)});
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2)},
                new FluidStack[]{RedAlloy.getFluid(18)});
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, AnnealedCopper, 2)},
                new FluidStack[]{RedAlloy.getFluid(18)});

        //  ULV Glue recipe
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .input(STICKY_RESIN, 4)
                .notConsumable(stickLong, Iron)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Glue.getFluid(200))
                .EUt(8)
                .duration(1200)
                .buildAndRegister();

        //  Glass Tube -> Vacuum Tube Component
        ModHandler.addShapedRecipe(true, "vacuum_tube_component", VACUUM_TUBE_COMPONENT.getStackForm(2),
                "FGF", "WWW",
                'F', new UnificationEntry(foil, Gold),
                'W', new UnificationEntry(wireGtSingle, Lead),
                'G', GLASS_TUBE.getStackForm());

        //  Vacuum Tube Component + Steel Ring + Copper fine wire -> Vacuum Tube
        VACUUM_CHAMBER_RECIPES.recipeBuilder()
                .inputs(VACUUM_TUBE_COMPONENT.getStackForm())
                .input(ring, Steel, 2)
                .input(wireFine, Copper, 4)
                .fluidInputs(Glue.getFluid(500))
                .outputs(VACUUM_TUBE.getStackForm())
                .EUt(8)
                .duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(VACUUM_TUBE_COMPONENT.getStackForm())
                .input(wireFine, Copper, 4)
                .outputs(VACUUM_TUBE.getStackForm(2))
                .EUt(VA[LV])
                .duration(120)
                .buildAndRegister();
    }
}
