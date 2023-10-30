package cn.gtcommunity.epimorphism.loaders.recipe.components;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockActiveMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing.CasingType.*;
import static cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class MachineComponents {

    public static void init() {
        Components();
        Machines();
        Materials();
    }

    private static void Components() {
        ElectricMotor();
        ConveyorModule();
        ElectricPiston();
        RobotArm();
        ElectricPump();
        Emitter();
        Sensor();
        FieldGenerator();
    }

    private static void ElectricMotor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 8)
                .input(wireFine, SiliconCarbide, 64)
                .input(wireFine, SiliconCarbide, 64)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_MOTOR_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(ELECTRIC_MOTOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Hdcs, 4)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 8)
                .input(wireFine, Abyssalloy, 64)
                .input(wireFine, Abyssalloy, 64)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 6))
                .fluidInputs(Lubricant.getFluid(3000))//  TODO Biological Lubricant?
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_MOTOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(ELECTRIC_MOTOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void ConveyorModule() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(plate, Adamantium, 2)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(screw, Adamantium, 4)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(StyreneButadieneRubber.getFluid(L * 24))
                .fluidInputs(Vibranium.getFluid(L))
                .output(CONVEYOR_MODULE_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(CONVEYOR_MODULE_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(plate, Hdcs, 2)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 16)
                .input(screw, Hdcs, 4)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 6)) // TODO Biological Soldering Alloy?
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(StyreneButadieneRubber.getFluid(L * 24))
                .fluidInputs(ChaoticDraconium.getFluid(L * 2))
                .output(CONVEYOR_MODULE_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(CONVEYOR_MODULE_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void ElectricPiston() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(stick, Adamantium, 4)
                .input(gear, Draconium)
                .input(gearSmall, Draconium, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PISTON_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(ELECTRIC_PISTON_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 4)
                .input(ring, Hdcs, 4)
                .input(round, Hdcs, 16)
                .input(stick, Hdcs, 4)
                .input(gear, Neutronium)
                .input(gearSmall, Neutronium, 2)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 6))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_PISTON_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(ELECTRIC_PISTON_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void RobotArm() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Adamantium, 4)
                .input(gear, Adamantium)
                .input(gearSmall, Adamantium, 3)
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(ELECTRIC_PISTON_UHV)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ROBOT_ARM_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(ROBOT_ARM_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Hdcs, 4)
                .input(gear, Hdcs)
                .input(gearSmall, Hdcs, 3)
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(ELECTRIC_PISTON_UEV)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ROBOT_ARM_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(ROBOT_ARM_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void ElectricPump() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(pipeLargeFluid, Duranium)
                .input(plate, Adamantium, 2)
                .input(screw, Adamantium, 8)
                .input(ring, SiliconeRubber, 16)
                .input(rotor, Draconium)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PUMP_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(ELECTRIC_PUMP_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(pipeLargeFluid, Neutronium) // TODO find new pipeLargeFluid
                .input(plate, Hdcs, 2)
                .input(screw, Hdcs, 8)
                .input(ring, SiliconeRubber, 16)
                .input(rotor, Neutronium)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_PUMP_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(ELECTRIC_PUMP_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void Emitter() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(stickLong, Adamantium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Vibranium, 64)
                .input(foil, Vibranium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Vibranium.getFluid(L))
                .output(EMITTER_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(EMITTER_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(ELECTRIC_MOTOR_UEV)
                .input(stickLong, Hdcs, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, ChaoticDraconium, 64)
                .input(foil, ChaoticDraconium, 32)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(EMITTER_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(EMITTER_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void Sensor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Naquadria, 64)
                .input(foil, Naquadria, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Vibranium.getFluid(L))
                .output(SENSOR_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(SENSOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Abyssalloy, 64)
                .input(foil, Abyssalloy, 32)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(SENSOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(SENSOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void FieldGenerator() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, Adamantium, 6)
                .input(GRAVI_STAR)
                .input(EMITTER_UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, PedotPSS, 64)
                .input(wireFine, PedotPSS, 64)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Vibranium.getFluid(L))
                .output(FIELD_GENERATOR_UHV)
                .duration(1200)
                .EUt(400000)
                .research(b -> b
                        .researchStack(FIELD_GENERATOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(8000))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(plate, Hdcs, 6)
                .input(GRAVI_STAR)
                .input(EMITTER_UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(wireFine, PedotTMA, 64)
                .input(wireFine, PedotTMA, 64)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(FIELD_GENERATOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .research(b -> b
                        .researchStack(FIELD_GENERATOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(12000))
                .buildAndRegister();
    }

    private static void Machines() {
        //  Substrate Casings
        ModHandler.addShapedRecipe(true, "substrate_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Palladium),
                'R', new UnificationEntry(stick, RedSteel),
                'F', new UnificationEntry(frameGt, BlueSteel)
        );
        ModHandler.addShapedRecipe(true, "advanced_substrate_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.ADVANCED_SUBSTRATE_CASING),
                "PPP", "RFR", "R R",
                'P', new UnificationEntry(plate, Ruridit),
                'R', new UnificationEntry(stick, Duranium),
                'F', new UnificationEntry(frameGt, NaquadahAlloy)
        );

        //  Drill Head
        ModHandler.addShapedRecipe(true, "industrial_drill_head", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.DRILL_HEAD),
                "PGP", "MHM", "SSS",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'G', new UnificationEntry(gear, Orichalcum),
                'M', ELECTRIC_MOTOR_UV.getStackForm(),
                'H', HULL[UV].getStackForm(),
                'S', COMPONENT_GRINDER_TUNGSTEN.getStackForm()
        );

        //  Naquadria Casing
        ModHandler.addShapedRecipe(true, "naquadria_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.NAQUADRIA_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, Naquadria),
                'T', new UnificationEntry(plate, Trinium),
                'F', new UnificationEntry(frameGt, Orichalcum));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, Naquadria, 4)
                .input(plate, Trinium, 2)
                .input(frameGt, Orichalcum)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.NAQUADRIA_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

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
        //  Mill Ball Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel)
                .inputs(ITEM_IMPORT_BUS[EV].getStackForm())
                .input(gear, Titanium, 4)
                .input(COMPONENT_GRINDER_TUNGSTEN, 4)
                .input(wireFine, Tungsten, 32)
                .fluidInputs(BlueSteel.getFluid(1152))
                .outputs(MULTIPART_BALL_HATCH.getStackForm())
                .EUt(7680)
                .duration(1600)
                .buildAndRegister();
        //  Catalyst Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium)
                .inputs(ITEM_IMPORT_BUS[HV].getStackForm())
                .input(gear, StainlessSteel, 4)
                .input(FLUID_CELL_LARGE_TITANIUM, 4)
                .input(wireFine, Electrum, 32)
                .fluidInputs(BlackSteel.getFluid(1152))
                .outputs(MULTIPART_CATALYST_HATCH.getStackForm())
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();
        //  Buffer Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .inputs(ITEM_IMPORT_BUS[IV].getStackForm())
                .input(ELECTRIC_PUMP_IV, 4)
                .input(SENSOR_IV, 4)
                .input(wireFine, Naquadah, 32)
                .fluidInputs(TitaniumTungstenCarbide.getFluid(1152))
                .outputs(MULTIPART_BUFFER_HATCH.getStackForm())
                .EUt(VA[IV])
                .duration(1800)
                .buildAndRegister();
    }

    private static void Materials() {
        //  Silicon Carbide
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .input(dust, Silicon)
                .circuitMeta(1)
                .output(dust, SiliconCarbide, 2)
                .duration(300)
                .EUt(VA[UV])
                .buildAndRegister();

        //  HDCS
        MIXER_RECIPES.recipeBuilder()
                .input(dust, TungstenSteel, 12)
                .input(dust, HSSS, 9)
                .input(dust, HSSG, 6)
                .input(dust, Ruridit, 3)
                .input(dust, MagnetoResonatic, 2)
                .input(dust, Plutonium241)
                .output(dust, Hdcs, 33)
                .EUt(VA[UHV])
                .duration(1600)
                .buildAndRegister();

        //  Abyssalloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, StainlessSteel, 5)
                .input(dust, TungstenCarbide, 5)
                .input(dust, Nichrome, 5)
                .input(dust, IncoloyMA956, 5)
                .input(dust, Germanium)
                .input(dust, Iodine)
                .fluidInputs(Radon.getFluid(1000))
                .output(dust, Abyssalloy, 23)
                .EUt(VA[UHV])
                .duration(1200)
                .buildAndRegister();
    }
}
