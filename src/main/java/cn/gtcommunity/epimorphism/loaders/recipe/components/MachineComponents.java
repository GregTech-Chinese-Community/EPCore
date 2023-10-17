package cn.gtcommunity.epimorphism.loaders.recipe.components;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockActiveMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing.CasingType.ISA_MILL_CASING;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ELECTRIC_PUMP_LuV;

public class MachineComponents {

    public static void init() {
        //  Isa Mill
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[IV], 2)
                .input(plate, Inconel625, 4)
                .input(ring, Inconel625, 8)
                .input(bolt, Inconel625, 16)
                .input(plate, HSSE, 8)
                .fluidInputs(Titanium.getFluid(8 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(ISA_MILL_CASING))
                .EUt(1920)
                .duration(480)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(gear, Inconel625, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, HSSE, 16)
                .input(MetaItems.COMPONENT_GRINDER_TUNGSTEN, 4)
                .fluidInputs(Zeron100.getFluid(2 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.ISA_MILL_CASING_GEARBOX))
                .EUt(32720)
                .duration(1200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))
                .input(frameGt, MaragingSteel300)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(bolt, Inconel625, 8)
                .fluidInputs(NiobiumTitanium.getFluid(4 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.ISA_MILL_CASING_PIPE))
                .EUt(28560)
                .duration(680)
                .buildAndRegister();

        //  Flotation Factory
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[EV], 2)
                .input(plate, Nichrome, 4)
                .input(plate, WatertightSteel, 4)
                .input(stickLong, HSSG, 2)
                .input(bolt, HastelloyN, 16)
                .fluidInputs(StainlessSteel.getFluid(8 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING))
                .EUt(4480)
                .duration(1080)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HSSG)
                .input(plate, HSSG, 4)
                .input(gear, HastelloyN, 3)
                .input(gearSmall, HSSG, 6)
                .input(bolt, TungstenCarbide, 16)
                .fluidInputs(HastelloyX.getFluid(2 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING_GEARBOX))
                .EUt(11300)
                .duration(580)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE))
                .input(frameGt, WatertightSteel)
                .input(plate, HastelloyC276, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(bolt, HastelloyN, 8)
                .fluidInputs(VanadiumGallium.getFluid(4 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING_PIPE))
                .EUt(23760)
                .duration(1200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING))
                .input(frameGt, HastelloyN)
                .input(rotor, HastelloyN, 4)
                .input(plate, HSSS, 4)
                .input(ring, HSSE, 16)
                .input(bolt, HSSG, 16)
                .fluidInputs(Stellite100.getFluid(2 * L))
                .outputs(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getItemVariant(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.FLOTATION_INTAKE_CASING))
                .EUt(VA[5])
                .duration(880)
                .buildAndRegister();

    }
}
