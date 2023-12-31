package cn.gtcommunity.epimorphism.loaders.recipe.components;

import cn.gtcommunity.epimorphism.common.blocks.*;
import cn.gtcommunity.epimorphism.common.items.EPMetaItems;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.init.Items;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing.CasingType.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtechfoodoption.GTFOMaterialHandler.LithiumCarbonate;

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

        //  TODO New Motor recipe use coil
        ModHandler.addShapedRecipe(true, "electric_motor.ulv", ELECTRIC_MOTOR_ULV.getStackForm(),
                "CWR", "WMW", "RWC",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'W', new UnificationEntry(wireGtSingle, Lead),
                'M', new UnificationEntry(stick, IronMagnetic),
                'R', new UnificationEntry(stick, WroughtIron));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 8)
                .input(wireFine, SiliconCarbide, 64)
                .input(wireFine, SiliconCarbide, 64)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_MOTOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Hdcs, 2)
                .input(stickLong, Infinity, 2)
                .input(ring, Hdcs, 2)
                .input(ring, Infinity, 2)
                .input(round, Hdcs, 4)
                .input(round, Infinity, 4)
                .input(wireFine, Abyssalloy, 64)
                .input(wireFine, Abyssalloy, 64)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))//  TODO Biological Lubricant?
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_MOTOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, WhiteDwarfMatter)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(stickLong, Legendarium, 2)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(ring, Legendarium, 2)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(round, Legendarium, 4)
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 64)
                .input(wireFine, RutheniumTriniumAmericiumNeutronate, 64)
                .input(cableGtSingle, CosmicNeutronium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))//  TODO Biological Lubricant?
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2))
                .output(ELECTRIC_MOTOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void ConveyorModule() {
        ModHandler.addShapedRecipe(true, "conveyor_module.ulv", CONVEYOR_MODULE_ULV.getStackForm(),
                "RRR", "MCM", "RRR",
                'R', "wool",
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'C', new UnificationEntry(pipeTinyFluid, Bronze));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(plate, Adamantium, 2)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(screw, Adamantium, 4)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 32))
                .fluidInputs(Vibranium.getFluid(L))
                .output(CONVEYOR_MODULE_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(plate, Infinity, 2)
                .input(ring, Hdcs, 2)
                .input(ring, Infinity, 2)
                .input(round, Hdcs, 8)
                .input(round, Infinity, 8)
                .input(screw, Hdcs, 2)
                .input(screw, Infinity, 2)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16)) // TODO Biological Soldering Alloy?
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 40))
                .fluidInputs(ChaoticDraconium.getFluid(L * 2))
                .output(CONVEYOR_MODULE_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV, 2)
                .input(plate, Legendarium, 2)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(ring, Legendarium, 2)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 8)
                .input(round, Legendarium, 8)
                .input(screw, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(screw, Legendarium, 2)
                .input(cableGtSingle, CosmicNeutronium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 48))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 4))
                .output(CONVEYOR_MODULE_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(CONVEYOR_MODULE_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void ElectricPiston() {

        ModHandler.addShapedRecipe(true, "electric_piston.ulv", ELECTRIC_PISTON_ULV.getStackForm(),
                "PPP", "CRR", "CMG",
                'P', new UnificationEntry(plate, WroughtIron),
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'R', new UnificationEntry(stick, WroughtIron),
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'G', new UnificationEntry(gearSmall, WroughtIron));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(ring, Adamantium, 4)
                .input(round, Adamantium, 16)
                .input(stick, Adamantium, 4)
                .input(gear, Draconium)
                .input(gearSmall, Draconium, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PISTON_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 2)
                .input(plate, Infinity, 2)
                .input(ring, Hdcs, 2)
                .input(ring, Infinity, 2)
                .input(round, Hdcs, 8)
                .input(round, Infinity, 8)
                .input(stick, Hdcs, 2)
                .input(stick, Infinity, 2)
                .input(gear, Neutronium)
                .input(gearSmall, Neutronium, 2)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_PISTON_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(plate, Legendarium, 2)
                .input(ring, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(ring, Legendarium, 2)
                .input(round, MagnetoHydrodynamicallyConstrainedStarMatter, 8)
                .input(round, Legendarium, 8)
                .input(stick, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(stick, Legendarium, 2)
                .input(gear, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(gearSmall, Legendarium, 2)
                .input(cableGtSingle, CosmicNeutronium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2))
                .output(ELECTRIC_PISTON_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PISTON_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void RobotArm() {

        ModHandler.addShapedRecipe(true, "robot_arm.ulv", ROBOT_ARM_ULV.getStackForm(),
                "CCC", "MRM", "PXR",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'M', ELECTRIC_MOTOR_ULV.getStackForm(),
                'R', new UnificationEntry(stick, WroughtIron),
                'P', ELECTRIC_PISTON_ULV.getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

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
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ROBOT_ARM_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Hdcs, 2)
                .input(stickLong, Infinity, 2)
                .input(gear, Infinity)
                .input(gearSmall, Hdcs, 3)
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(ELECTRIC_PISTON_UEV)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ROBOT_ARM_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(stickLong, Legendarium, 2)
                .input(gear, Legendarium)
                .input(gearSmall, MagnetoHydrodynamicallyConstrainedStarMatter, 3)
                .input(ELECTRIC_MOTOR_UIV, 2)
                .input(ELECTRIC_PISTON_UIV)
                .input(circuit, MarkerMaterials.Tier.UIV)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(cableGtSingle, CosmicNeutronium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 24))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2))
                .output(ROBOT_ARM_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ROBOT_ARM_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void ElectricPump() {

        ModHandler.addShapedRecipe(true, "electric_pump.ulv", ELECTRIC_PUMP_ULV.getStackForm(),
                "SXR", "dPw", "RMC",
                'S', new UnificationEntry(screw, WroughtIron),
                'X', new UnificationEntry(rotor, WroughtIron),
                'P', new UnificationEntry(pipeNormalFluid, Copper),
                'R', "wool",
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'M', ELECTRIC_MOTOR_ULV.getStackForm());

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(pipeLargeFluid, Duranium)
                .input(plate, Adamantium, 2)
                .input(screw, Adamantium, 8)
                .input(ring, NitrileButadieneRubber, 32)
                .input(rotor, Draconium)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(Vibranium.getFluid(L))
                .output(ELECTRIC_PUMP_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(pipeLargeFluid, Lafium)
                .input(plate, Hdcs, 2)
                .input(screw, Hdcs, 4)
                .input(screw, Infinity, 4)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, Neutronium)
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Lubricant.getFluid(5000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(ELECTRIC_PUMP_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV)
                .input(pipeLargeFluid, Neutronium) //TODO Find better material
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(screw, MagnetoHydrodynamicallyConstrainedStarMatter, 4)
                .input(screw, Legendarium, 4)
                .input(ring, NitrileButadieneRubber, 64)
                .input(rotor, NeutronStarCoreMaterial)
                .input(cableGtSingle, CosmicNeutronium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(7000))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2))
                .output(ELECTRIC_PUMP_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_PUMP_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void Emitter() {

        ModHandler.addShapedRecipe(true, "emitter.ulv", EMITTER_ULV.getStackForm(),
                "CRX", "RGR", "XRC",
                'R', new UnificationEntry(stick, TinAlloy),
                'C', new UnificationEntry(pipeTinyFluid, Bronze),
                'G', new UnificationEntry(gem, Sapphire),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(stickLong, Adamantium, 4)
                .input(GRAVI_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Vibranium, 64)
                .input(foil, Vibranium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(EMITTER_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs)
                .input(ELECTRIC_MOTOR_UEV)
                .input(stickLong, Hdcs, 2)
                .input(stickLong, Infinity, 2)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, ChaoticDraconium, 64)
                .input(foil, ChaoticDraconium, 32)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(EMITTER_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter)
                .input(ELECTRIC_MOTOR_UIV)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(stickLong, Legendarium, 2)
                .input(UNSTABLE_STAR)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(foil, AstralTitanium, 64)
                .input(foil, AstralTitanium, 32)
                .input(cableGtSingle, CosmicNeutronium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(BlackDwarfMatter.getFluid(L))
                .output(EMITTER_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(EMITTER_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void Sensor() {

        ModHandler.addShapedRecipe(true, "sensor.ulv", SENSOR_ULV.getStackForm(),
                "P G", "PR ", "XPP",
                'P', new UnificationEntry(plate, WroughtIron),
                'R', new UnificationEntry(stick, TinAlloy),
                'G', new UnificationEntry(gem, Sapphire),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Adamantium, 4)
                .input(GRAVI_STAR, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, AwakenedDraconium, 64)
                .input(foil, AwakenedDraconium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(SENSOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, Hdcs, 2)
                .input(plate, Infinity, 2)
                .input(GRAVI_STAR, 4)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Abyssalloy, 64)
                .input(foil, Abyssalloy, 32)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(SENSOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium)
                .input(ELECTRIC_MOTOR_UIV)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 2)
                .input(plate, Legendarium, 2)
                .input(UNSTABLE_STAR)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(foil, CelestialTungsten, 64)
                .input(foil, CelestialTungsten, 32)
                .input(cableGtSingle, CosmicNeutronium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(BlackDwarfMatter.getFluid(L))
                .output(SENSOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(SENSOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
                .buildAndRegister();
    }

    private static void FieldGenerator() {

        ModHandler.addShapedRecipe(true, "field_generator.ulv", FIELD_GENERATOR_ULV.getStackForm(),
                "WPW", "XGX", "WPW",
                'W', new UnificationEntry(pipeLargeFluid, Lead),
                'P', new UnificationEntry(plate, WroughtIron),
                'G', new UnificationEntry(gem, Ruby),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV));

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .input(plate, Adamantium, 6)
                .input(GRAVI_STAR, 2)
                .input(EMITTER_UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, PedotPSS, 64)
                .input(wireFine, PedotPSS, 64)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 16))
                .fluidInputs(Vibranium.getFluid(L))
                .output(FIELD_GENERATOR_UHV)
                .duration(1200)
                .EUt(400000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UV.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(plate, Hdcs, 3)
                .input(plate, Infinity, 3)
                .input(GRAVI_STAR, 4)
                .input(EMITTER_UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(wireFine, PedotTMA, 64)
                .input(wireFine, PedotTMA, 64)
                .input(cableGtSingle, CarbonNanotube, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(ChaoticDraconium.getFluid(L))
                .output(FIELD_GENERATOR_UEV)
                .duration(1800)
                .EUt(2000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UHV.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NeutronStarCoreMaterial)
                .input(plate, MagnetoHydrodynamicallyConstrainedStarMatter, 3)
                .input(plate, Legendarium, 3)
                .input(UNSTABLE_STAR)
                .input(EMITTER_UIV, 2)
                .input(circuit, MarkerMaterials.Tier.UIV, 2)
                .input(wireFine, SuperheavyHAlloy, 64)
                .input(wireFine, SuperheavyHAlloy, 64)
                .input(cableGtSingle, CosmicNeutronium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 24))
                .fluidInputs(Zylon.getFluid(L * 4))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2))
                .fluidInputs(BlackDwarfMatter.getFluid(L))
                .output(FIELD_GENERATOR_UIV)
                .duration(2400)
                .EUt(8000000)
                .stationResearch(b -> b
                        .researchStack(FIELD_GENERATOR_UEV.getStackForm())
                        .CWUt(256)
                        .EUt(VA[UEV]))
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
        ModHandler.addShapedRecipe("component_grinder_boron_nitride", EPMetaItems.BORON_NITRIDE_GRINDER.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, CubicBoronNitride),
                'D', new UnificationEntry(plateDouble, Vibranium),
                'G', new UnificationEntry(gem, CubicHeterodiamond));

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

        //  Talonite Casing
        ModHandler.addShapedRecipe(true, "talonite_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.TALONITE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Talonite),
                'F', new UnificationEntry(frameGt, Stellite));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Talonite, 6)
                .input(frameGt, Stellite)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.TALONITE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Hyper Casing
        ModHandler.addShapedRecipe(true, "hyper_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.HYPER_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, BlackPlutonium),
                'T', new UnificationEntry(plate, BlackTitanium),
                'F', new UnificationEntry(frameGt, Tritanium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, BlackPlutonium, 4)
                .input(plate, BlackTitanium, 2)
                .input(frameGt, Tritanium)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.HYPER_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Quantum Casing
        ModHandler.addShapedRecipe(true, "quantum_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.QUANTUM_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, QuantumAlloy),
                'F', new UnificationEntry(frameGt, Trinaquadalloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, QuantumAlloy, 6)
                .input(frameGt, Trinaquadalloy)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.QUANTUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Tritanium Casing
        ModHandler.addShapedRecipe(true, "tritanium_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.TRITANIUM_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, Tritanium),
                'F', new UnificationEntry(frameGt, HSSS));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Tritanium, 6)
                .input(frameGt, HSSS)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.TRITANIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Maraging Steel-250 Casing
        ModHandler.addShapedRecipe(true, "maraging_steel_250_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.MARAGING_STEEL_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, MaragingSteel300),
                'T', new UnificationEntry(plate, MaragingSteel250),
                'F', new UnificationEntry(frameGt, HSSE));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, MaragingSteel300, 4)
                .input(plate, MaragingSteel250, 2)
                .input(frameGt, HSSE)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.MARAGING_STEEL_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Universal Processing Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Staballoy)
                .input(plate, Staballoy, 4)
                .input(plate, TungstenSteel, 4)
                .input(spring, MolybdenumDisilicide, 2)
                .input(wireFine, Platinum, 16)
                .fluidInputs(BlueSteel.getFluid(288))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.GENERAL_PROCESSING_CASING, 2))
                .EUt(VA[HV])
                .duration(600)
                .buildAndRegister();

        //  Babbitt Alloy Casing
        ModHandler.addShapedRecipe(true, "babbitt_alloy_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.BABBITT_ALLOY_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, BabbittAlloy),
                'F', new UnificationEntry(frameGt, BabbittAlloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, BabbittAlloy, 6)
                .input(frameGt, BabbittAlloy)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.BABBITT_ALLOY_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Vacuum Casing
        ModHandler.addShapedRecipe(true, "vacuum_casing", EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.VACUUM_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, RedSteel),
                'T', new UnificationEntry(plate, TitaniumCarbide),
                'F', new UnificationEntry(frameGt, CobaltBrass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, RedSteel, 4)
                .input(plate, TitaniumCarbide, 2)
                .input(frameGt, CobaltBrass)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.VACUUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Zirconium Carbide Casing
        ModHandler.addShapedRecipe(true, "zirconium_carbide_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.ZIRCONIUM_CARBIDE_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, ZirconiumCarbide),
                'F', new UnificationEntry(frameGt, ZirconiumCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, ZirconiumCarbide, 6)
                .input(frameGt, ZirconiumCarbide)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.ZIRCONIUM_CARBIDE_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Hastelloy-X78 Casing
        ModHandler.addShapedRecipe(true, "hastelloy_x78_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.HASTELLOYX78_CASING, 2),
                "PhP", "TFT","PwP",
                'P', new UnificationEntry(plateDouble, HastelloyX),
                'T', new UnificationEntry(plate, HastelloyX78),
                'F', new UnificationEntry(frameGt, HastelloyX78));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, HastelloyX, 4)
                .input(plate, HastelloyX78, 2)
                .input(frameGt, HastelloyX78)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.HASTELLOYX78_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Supercritical Fluid Turbine Casing
        ModHandler.addShapedRecipe(true, "supercritical_fluid_turbine_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.SUPERCRITICAL_FLUID_TURBINE_CASING, 2),
                "TPT", "RFR", "TPT",
                'T', new UnificationEntry(plate, IncoloyMA956),
                'P', new UnificationEntry(plateDouble, WatertightSteel),
                'R', new UnificationEntry(rotor, MARM200Steel),
                'F', new UnificationEntry(frameGt, MARM200Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, IncoloyMA956, 4)
                .input(rotor, MARM200Steel, 2)
                .input(plateDouble, WatertightSteel, 2)
                .input(frameGt, MARM200Steel)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.SUPERCRITICAL_FLUID_TURBINE_CASING, 2))
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  Corrosion Casing
        ModHandler.addShapedRecipe(true, "corrosion_casing", EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.CORROSION_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, AusteniticStainlessSteel904L),
                'F', new UnificationEntry(frameGt, AusteniticStainlessSteel904L));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, AusteniticStainlessSteel904L, 6)
                .input(frameGt, AusteniticStainlessSteel904L)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.CORROSION_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  PA Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.LuV))
                .inputs(ROBOT_ARM_EV.getStackForm(2))
                .input(plateDouble, MARM200CeSteel, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM)
                .input(gearSmall, Stellite, 8)
                .input(cableGtQuadruple, Naquadah, 2)
                .input(screw, HSSG, 32)
                .fluidInputs(BlackSteel.getFluid(576))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1, 4))
                .EUt(VA[IV])
                .duration(800)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.ZPM))
                .inputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1))
                .inputs(ROBOT_ARM_IV.getStackForm(2))
                .input(plateDouble, HastelloyC59, 2)
                .input(circuit, MarkerMaterials.Tier.UV)
                .input(gearSmall, TanmolyiumBetaC, 8)
                .input(cableGtQuadruple, Tritanium, 2)
                .input(screw, HSSE, 32)
                .fluidInputs(Zeron100.getFluid(576))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2, 4))
                .EUt(VA[LuV])
                .duration(800)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UV))
                .inputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2))
                .inputs(ROBOT_ARM_LuV.getStackForm(2))
                .input(plateDouble, HMS1J79Alloy, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(gearSmall, HY1301, 8)
                .input(cableGtQuadruple, SiliconCarbide, 2)
                .input(screw, HSSS, 32)
                .fluidInputs(IncoloyMA813.getFluid(576))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3, 4))
                .EUt(VA[ZPM])
                .duration(800)
                .buildAndRegister();

        //  Advanced Invar Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF))
                .circuitMeta(6)
                .fluidInputs(AusteniticStainlessSteel904L.getFluid(L * 2))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.ADVANCED_INVAR_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Aluminum Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF))
                .circuitMeta(6)
                .fluidInputs(TanmolyiumBetaC.getFluid(L * 2))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.ADVANCED_ALUMINIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Advanced Filter Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium)
                .inputs(MetaBlocks.CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CasingType.FILTER_CASING))
                .input(ELECTRIC_MOTOR_UV)
                .input(rotor, Iridium)
                .inputs(ITEM_FILTER.getStackForm(4))
                .inputs(FLUID_FILTER.getStackForm(4))
                .input(stickLong, Iridium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(EPMetablocks.EP_CLEANROOM_CASING.getItemVariant(EPBlockCleanroomCasing.CasingType.ADVANCED_FILTER_CASING))
                .EUt(VA[LuV])
                .duration(600)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Component Assembly Line Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Steel, 1)
                .input(plateDense, Steel, 4)
                .input(ROBOT_ARM_LV, 4)
                .input(ELECTRIC_PISTON_LV, 8)
                .input(ELECTRIC_MOTOR_LV, 10)
                .input(gear, Steel, 4)
                .input(wireGtQuadruple, Tin, 6)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.LV, 4))
                .EUt(VA[LV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium, 1)
                .input(plateDense, Aluminium, 4)
                .input(ROBOT_ARM_MV, 4)
                .input(ELECTRIC_PISTON_MV, 8)
                .input(ELECTRIC_MOTOR_MV, 10)
                .input(gear, Aluminium, 4)
                .input(wireGtQuadruple, Copper, 6)
                .input(circuit, MarkerMaterials.Tier.MV, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.MV, 4))
                .EUt(VA[MV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel, 1)
                .input(plateDense, StainlessSteel, 4)
                .input(ROBOT_ARM_HV, 4)
                .input(ELECTRIC_PISTON_HV, 8)
                .input(ELECTRIC_MOTOR_HV, 10)
                .input(gear, StainlessSteel, 4)
                .input(wireGtQuadruple, Gold, 6)
                .input(circuit, MarkerMaterials.Tier.HV, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.HV, 4))
                .EUt(VA[HV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Titanium, 1)
                .input(plateDense, Titanium, 4)
                .input(ROBOT_ARM_EV, 4)
                .input(ELECTRIC_PISTON_EV, 8)
                .input(ELECTRIC_MOTOR_EV, 10)
                .input(gear, Titanium, 4)
                .input(wireGtQuadruple, Aluminium, 6)
                .input(circuit, MarkerMaterials.Tier.EV, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.EV, 4))
                .EUt(VA[EV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, TungstenSteel, 1)
                .input(plateDense, TungstenSteel, 4)
                .input(ROBOT_ARM_IV, 4)
                .input(ELECTRIC_PISTON_IV, 8)
                .input(ELECTRIC_MOTOR_IV, 10)
                .input(gear, TungstenSteel, 4)
                .input(wireGtQuadruple, Tungsten, 6)
                .input(circuit, MarkerMaterials.Tier.IV, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 16)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.IV, 4))
                .EUt(VA[IV])
                .duration(320)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .input(plateDense, RhodiumPlatedPalladium, 6)
                .input(ROBOT_ARM_LuV, 8)
                .input(ELECTRIC_PISTON_LUV, 10)
                .input(ELECTRIC_MOTOR_LuV, 16)
                .input(gear, RhodiumPlatedPalladium, 4)
                .input(gearSmall, RhodiumPlatedPalladium, 16)
                .input(cableGtQuadruple, NiobiumTitanium, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(Zeron100.getFluid(1728))
                .fluidInputs(TanmolyiumBetaC.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.LuV, 4))
                .EUt(VA[LuV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.IV))
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .input(plateDense, NaquadahAlloy, 6)
                .input(ROBOT_ARM_ZPM, 8)
                .input(ELECTRIC_PISTON_ZPM, 10)
                .input(ELECTRIC_MOTOR_ZPM, 16)
                .input(gear, NaquadahAlloy, 4)
                .input(gearSmall, NaquadahAlloy, 16)
                .input(cableGtQuadruple, VanadiumGallium, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(MARM200CeSteel.getFluid(1728))
                .fluidInputs(HastelloyC59.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM, 4))
                .EUt(VA[ZPM])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.LuV))
                        .EUt(VA[LuV])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plateDense, Darmstadtium, 6)
                .input(ROBOT_ARM_UV, 8)
                .input(ELECTRIC_PISTON_UV, 10)
                .input(ELECTRIC_MOTOR_UV, 16)
                .input(gear, Darmstadtium, 4)
                .input(gearSmall, Darmstadtium, 16)
                .input(cableGtQuadruple, YttriumBariumCuprate, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(HMS1J79Alloy.getFluid(1728))
                .fluidInputs(Pikyonium64B.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.UV, 4))
                .EUt(VA[UV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM))
                        .EUt(VA[ZPM])
                        .duration(1200))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Draconium)
                .input(plateDense, Draconium, 6)
                .input(ROBOT_ARM_UHV, 8)
                .input(ELECTRIC_PISTON_UHV, 10)
                .input(ELECTRIC_MOTOR_UHV, 16)
                .input(gear, Draconium, 4)
                .input(gearSmall, Draconium, 16)
                .input(cableGtQuadruple, Europium, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .fluidInputs(SolderingAlloy.getFluid(3456))
                .fluidInputs(TitanSteel.getFluid(1728))
                .fluidInputs(Cinobite.getFluid(864))
                .fluidInputs(Lubricant.getFluid(4000))
                .outputs(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.UHV, 4))
                .EUt(VA[UHV])
                .duration(600)
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getItemVariant(EPBlockComponentAssemblyLineCasing.CasingTier.UV))
                        .EUt(VA[UV])
                        .duration(1200))
                .buildAndRegister();

        //  TODO UEV-MAX Component Assembly Line Casings

        //  Grinder Balls
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, Soapstone, 4)
                .outputs(GRINDBALL_SOAPSTONE.getStackForm())
                .EUt(VA[MV])
                .duration(300)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, Aluminium, 4)
                .outputs(GRINDBALL_ALUMINIUM.getStackForm())
                .EUt(VA[MV])
                .duration(300)
                .buildAndRegister();

        //  Isa Mill
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[IV], 2)
                .input(plate, Inconel625, 4)
                .input(ring, Inconel625, 8)
                .input(bolt, Inconel625, 16)
                .input(plate, HSSE, 8)
                .fluidInputs(Titanium.getFluid(8 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(ISA_MILL_CASING, 2))
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
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.ISA_MILL_CASING_GEARBOX, 2))
                .EUt(32720)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))
                .input(frameGt, MaragingSteel300)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(bolt, Inconel625, 8)
                .fluidInputs(NiobiumTitanium.getFluid(4 * L))
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.ISA_MILL_CASING_PIPE, 2))
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
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING, 2))
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
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING_GEARBOX, 2))
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
                .outputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING_PIPE, 2))
                .EUt(23760)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.EXTREME_ENGINE_INTAKE_CASING))
                .input(frameGt, HastelloyN)
                .input(rotor, HastelloyN, 4)
                .input(plate, HSSS, 4)
                .input(ring, HSSE, 16)
                .input(bolt, HSSG, 16)
                .fluidInputs(Stellite100.getFluid(2 * L))
                .outputs(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getItemVariant(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.FLOTATION_INTAKE_CASING, 2))
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
                .duration(600)
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
                .duration(600)
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
                .duration(600)
                .buildAndRegister();

        //  Reinforced Rotor Holder
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, RhodiumPlatedPalladium)
                .inputs(ROTOR_HOLDER[3].getStackForm())
                .input(ELECTRIC_MOTOR_LuV, 2)
                .input(rotor, Staballoy, 4)
                .input(stickLong, Titanium, 2)
                .input(wireFine, Platinum, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(REINFORCED_ROTOR_HOLDER[0].getStackForm())
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy)
                .inputs(ROTOR_HOLDER[4].getStackForm())
                .input(ELECTRIC_MOTOR_ZPM, 2)
                .input(rotor, Inconel792, 4)
                .input(stickLong, TungstenSteel, 2)
                .input(wireFine, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(REINFORCED_ROTOR_HOLDER[1].getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .inputs(ROTOR_HOLDER[5].getStackForm())
                .input(ELECTRIC_MOTOR_UV, 2)
                .input(rotor, Inconel625, 4)
                .input(stickLong, RhodiumPlatedPalladium, 2)
                .input(wireFine, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(REINFORCED_ROTOR_HOLDER[2].getStackForm())
                .EUt(VA[UV])
                .duration(1200)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Draconium)
                .inputs(REINFORCED_ROTOR_HOLDER[2].getStackForm())
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(CONVEYOR_MODULE_UHV, 2)
                .input(rotor, Adamantium, 4)
                .input(stickLong, HSSS, 2)
                .input(wireFine, YttriumBariumCuprate, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .outputs(REINFORCED_ROTOR_HOLDER[3].getStackForm())
                .EUt(VA[UHV])
                .duration(1200)
                .scannerResearch(b -> b
                        .researchStack(REINFORCED_ROTOR_HOLDER[2].getStackForm())
                        .EUt(VA[UV])
                        .duration(600))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Fullerene)
                .inputs(REINFORCED_ROTOR_HOLDER[3].getStackForm())
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(CONVEYOR_MODULE_UEV, 2)
                .input(rotor, Neutronium, 4) // TODO may be find better material
                .input(stickLong, Osmiridium, 2)
                .input(wireFine, ThalliumCopperChloride, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .outputs(REINFORCED_ROTOR_HOLDER[4].getStackForm())
                .EUt(VA[UEV])
                .duration(1200)
                .scannerResearch(b -> b
                        .researchStack(REINFORCED_ROTOR_HOLDER[3].getStackForm())
                        .EUt(VA[UHV])
                        .duration(1200))
                .buildAndRegister();

        //  TODO UIV Reinforced Rotor Holder

        //  Industrial Maintenance Hatch
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MAINTENANCE_HATCH.getStackForm())
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(EMITTER_LuV)
                .input(SENSOR_LuV)
                .input(cableGtSingle, Platinum, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(INDUSTRIAL_MAINTENANCE_HATCH.getStackForm())
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Iridium Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID))
                .fluidInputs(Iridium.getFluid(288))
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.IRIDIUM_CASING))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  COMET Casings
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, IncoloyMA956)
                .input(plate, IncoloyDS, 8)
                .input(stickLong, EglinSteel, 4)
                .input(ELECTRIC_PISTON_HV, 2)
                .input(screw, Inconel690, 4)
                .fluidInputs(ZirconiumCarbide.getFluid(L * 2))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.CYCLOTRON_CASING, 2))
                .EUt(VA[ZPM])
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NICHROME))
                .input(FIELD_GENERATOR_EV)
                .input(plate, Inconel625, 4)
                .input(bolt, Tantalloy61, 16)
                .input(screw, Incoloy020, 32)
                .fluidInputs(HG1223.getFluid(L * 2))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.CYCLOTRON_COIL))
                .EUt(VA[ZPM])
                .duration(200)
                .buildAndRegister();

        //  Supercritical Fluid Turbine Shaft Block
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel)
                .input(plate, MARM200CeSteel, 4)
                .input(plate, Staballoy, 4)
                .input(stickLong, EglinSteel, 8)
                .input(wireFine, Nichrome, 16)
                .fluidInputs(IncoloyMA956.getFluid(L * 2))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.SUPERCRITICAL_FLUID_TURBINE_SHAFT_BLOCK))
                .EUt(VA[IV])
                .duration(50)
                .buildAndRegister();

        //  Cosmic Ray Detector Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyC59)
                .input(FIELD_GENERATOR_LuV)
                .input(NEUTRON_REFLECTOR)
                .input(plate, ZirconiumCarbide, 4)
                .input(plate, RhodiumPlatedPalladium, 4)
                .fluidInputs(Tantalloy61.getFluid(L * 4))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING.getItemVariant(EPBlockMultiblockCasing.CasingType.REFLECTIVE_CASING, 2))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Draconium Casing
        ModHandler.addShapedRecipe(true, "draconium_casing", EPMetablocks.EP_MULTIBLOCK_CASING_C.getItemVariant(EPBlockMultiblockCasingC.CasingType.DRACONIUM_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, Draconium),
                'F', new UnificationEntry(frameGt, Draconium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Draconium, 6)
                .input(frameGt, Draconium)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_C.getItemVariant(EPBlockMultiblockCasingC.CasingType.DRACONIUM_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Dragon Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL))
                .input(plate, Draconium, 4)
                .input(VOLTAGE_COIL_UV, 2)
                .input(wireFine, SiliconCarbide, 4)
                .fluidInputs(ConcentrateDragonBreath.getFluid(L * 4))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_C.getItemVariant(EPBlockMultiblockCasingC.CasingType.DRAGON_FUSION_COIL, 2))
                .EUt(VA[UV])
                .duration(100)
                .buildAndRegister();

        //  Dragon Fusion Unit
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(HULL[UV].getStackForm())
                .input(frameGt, Draconium, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(plate, Ichorium, 8)
                .input(FIELD_GENERATOR_UV, 2)
                .input(cableGtQuadruple, YttriumBariumCuprate, 4)
                .fluidInputs(Taranium.getFluid(L * 4))
                .outputs(DRAGON_FUSION_UNIT.getStackForm())
                .EUt(VA[UV])
                .duration(600)
                .buildAndRegister();

        //  PCB Factory Casings

        //  T1
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Iridium)
                .input(EMITTER_IV, 2)
                .input(plate, Osmiridium, 4)
                .input(wireFine, Ruridit, 4)
                .fluidInputs(TinAlloy.getFluid(L * 2)) // TODO Photoresist?
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING, 2))
                .EUt(VA[IV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  T2
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Trinium)
                .input(EMITTER_LuV, 2)
                .input(plate, NaquadahAlloy, 4)
                .input(wireFine, Europium, 4)
                .fluidInputs(TinAlloy.getFluid(L * 2)) // TODO Photoresist?
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING, 2))
                .EUt(VA[ZPM])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  T3
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium)
                .input(EMITTER_ZPM, 2)
                .input(plate, Orichalcum, 4)
                .input(wireFine, Mithril, 4)
                .fluidInputs(TinAlloy.getFluid(L * 2)) // TODO Photoresist?
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.RADIATION_PROOF_SCAN_FRAMEWORK_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Water Cooled
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium)
                .input(ELECTRIC_PUMP_HV, 2)
                .input(FIELD_GENERATOR_HV, 2)
                .input(plate, TungstenSteel, 8)
                .input(pipeTinyFluid, Titanium, 16)
                .input(screw, StainlessSteel, 8)
                .fluidInputs(PCBCoolant.getFluid(L * 2))
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.WATER_COOLED_MACHINE_CASING, 2))
                .EUt(VA[EV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Infinity Cooled
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Infinity)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(FIELD_GENERATOR_UV, 2)
                .input(plate, Hypogen, 8)
                .input(pipeTinyFluid, Lafium, 16)
                .input(screw, AusteniticStainlessSteel904L, 8)
                .fluidInputs(PCBCoolant.getFluid(L * 4))
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.INFINITY_COOLED_MACHINE_CASING, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Biological
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Europium)
                .input(ELECTRIC_MOTOR_UV)
                .input(SENSOR_UV)
                .input(plate, IncoloyMA956, 4)
                .input(rotor, Inconel792, 2)
                .input(wireFine, MercuryCadmiumTelluride, 4)
                .fluidInputs(SterileGrowthMedium.getFluid(L * 2))
                .outputs(EPMetablocks.EP_PCB_FACTORY_CASING.getItemVariant(EPBlockPCBFactoryCasing.CasingType.BIOLOGICAL_STERILE_MACHINE_CASING, 2))
                .EUt(VA[UV])
                .duration(100)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        //  HG-1223 Casing
        ModHandler.addShapedRecipe(true, "hg_1223_casing", EPMetablocks.EP_MULTIBLOCK_CASING_C.getItemVariant(EPBlockMultiblockCasingC.CasingType.HG_1223_CASING, 2),
                "PhP", "PFP","PwP",
                'P', new UnificationEntry(plate, HG1223),
                'F', new UnificationEntry(frameGt, RhodiumPlatedPalladium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HG1223, 6)
                .input(frameGt, RhodiumPlatedPalladium)
                .circuitMeta(6)
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_C.getItemVariant(EPBlockMultiblockCasingC.CasingType.HG_1223_CASING, 2))
                .EUt(VA[LV])
                .duration(50)
                .buildAndRegister();

        //  Quantum Force Transformer Casings

        //  Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum)
                .input(plate, Tritanium, 4)
                .input(FIELD_GENERATOR_LuV)
                .input(wireFine, QuantumAlloy, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.QUANTUM_CONSTRAINT_CASING, 2))
                .EUt(VA[UHV])
                .duration(100)
                .buildAndRegister();

        //  Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(EPMetablocks.EP_WIRE_COIL.getItemVariant(EPBlockWireCoil.CoilType.ADAMANTIUM))// TODO May be infinity coil?
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL, 2))
                .input(plateDouble, Pikyonium64B, 2)
                .input(wireFine, Europium, 16)
                .fluidInputs(GelidCryotheum.getFluid(1440))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.QUANTUM_FORCE_TRANSFORMER_COIL))
                .EUt(VA[UHV])
                .duration(150)
                .buildAndRegister();

        //  T1
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS))
                .input(plate, Draconium, 2)
                .input(FIELD_GENERATOR_LuV)
                .input(NEUTRON_REFLECTOR, 4)
                .fluidInputs(Naquadah.getFluid(L * 2))
                .outputs(EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.FORCE_FIELD_CONSTRAINED_GLASS))
                .EUt(VA[UHV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum, 4)
                .input(plate, NaquadahAlloy, 4)
                .input(EMITTER_UV, 4)
                .input(plateDouble, Osmiridium, 2)
                .input(plateDouble, Trinium, 2)
                .input(QUANTUM_ANOMALY)
                .input(cableGtQuadruple, QuantumAlloy, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Thulium.getFluid(1440))
                .fluidInputs(Neptunium.getFluid(500))
                .fluidInputs(Fermium.getFluid(500))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_PULSE_MANIPULATOR_CASING))
                .scannerResearch(b -> b
                        .researchStack(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS))
                        .EUt(VA[UHV])
                        .duration(1200))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackPlutonium, 4)
                .input(plateDouble, PlatinumGroupAlloy, 4)
                .input(FIELD_GENERATOR_UV)
                .input(plateDouble, Draconium, 16)
                .input(screw, Vibranium, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_SHIELDING_CORE_CASING))
                .scannerResearch(b -> b
                        .researchStack(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                        .EUt(VA[UHV])
                        .duration(1200))
                .EUt(VA[UHV])
                .duration(200)
                .buildAndRegister();

        //  T2
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS))
                .input(plate, Neutronium, 2)
                .input(FIELD_GENERATOR_ZPM)
                .input(NEUTRON_REFLECTOR, 4)
                .fluidInputs(Trinium.getFluid(L * 2))
                .outputs(EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.COSMIC_MICROWAVE_BACKGROUND_RADIATION_ABSORPTION_GLASS))
                .EUt(VA[UEV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium, 4)
                .input(plate, Darmstadtium, 4)
                .input(EMITTER_UHV, 4)
                .input(plateDouble, Tritanium, 2)
                .input(plateDouble, Naquadria, 2)
                .input(QUANTUM_ANOMALY)
                .input(METASTABLE_SELF_HEALING_ADHESIVE, 4)
                .input(cableGtQuadruple, Grisium, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Ytterbium.getFluid(1440))
                .fluidInputs(Tennessine.getFluid(500))
                .fluidInputs(Livermorium.getFluid(500))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_MANIPULATOR_CASING))
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_PULSE_MANIPULATOR_CASING))
                        .EUt(VA[UEV])
                        .duration(1200))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, BlackTitanium, 4)
                .input(plateDouble, Infinity, 4)
                .input(FIELD_GENERATOR_UHV)
                .input(plateDouble, ChaoticDraconium, 16)
                .input(screw, CelestialTungsten, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(AstralTitanium.getFluid(500))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_SHIELDING_CORE_CASING))
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_SHIELDING_CORE_CASING))
                        .EUt(VA[UEV])
                        .duration(1200))
                .EUt(VA[UEV])
                .duration(200)
                .buildAndRegister();

        //  T3
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS))
                .input(plate, NeutronStarCoreMaterial, 2)
                .input(FIELD_GENERATOR_UV)
                .input(NEUTRON_REFLECTOR, 4)
                .fluidInputs(Taranium.getFluid(L * 2))
                .outputs(EPMetablocks.EP_GLASS_CASING_B.getItemVariant(EPBlockGlassCasingB.GlassType.SPACETIME_SUPERCONDENSER_GLASS))
                .EUt(VA[UIV])
                .duration(20)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NeutronStarCoreMaterial, 4)
                .input(plate, Draconium, 4)
                .input(EMITTER_UEV, 4)
                .input(plateDouble, Adamantium, 2)
                .input(plateDouble, Abyssalloy, 2)
                .input(QUANTUM_ANOMALY)
                .input(HYPERDIMENSIONAL_TACHYON_CONDENSED_MATTER, 4)
                .input(cableGtQuadruple, FullereneSuperconductor, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lutetium.getFluid(1440))
                .fluidInputs(MetastableOganesson.getFluid(500))
                .fluidInputs(MetastableHassium.getFluid(500))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_MANIPULATOR_CASING))
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_MANIPULATOR_CASING))
                        .EUt(VA[UIV])
                        .duration(1200))
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium, 4)
                .input(plateDouble, Hypogen, 4)
                .input(FIELD_GENERATOR_UEV)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 16)
                .input(screw, SuperheavyLAlloy, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(SuperheavyHAlloy.getFluid(500))
                .outputs(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_SHIELDING_CORE_CASING))
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getItemVariant(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_SHIELDING_CORE_CASING))
                        .EUt(VA[UIV])
                        .duration(1200))
                .EUt(VA[UIV])
                .duration(200)
                .buildAndRegister();

        //  TODO T4

        //  Fusion Casing Mk IV
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UHV])
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                .input(VOLTAGE_COIL_UHV, 2)
                .input(FIELD_GENERATOR_UV)
                .input(plate, Tritanium, 6)
                .fluidInputs(Polyetheretherketone.getFluid(576))
                .outputs(EPMetablocks.EP_BLOCK_FUSION_CASING.getItemVariant(EPBlockFusionCasing.CasingType.CASING_FUSION_MKIV, 2))
                .EUt(VA[UHV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Casing Mk V
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UEV])
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                .input(VOLTAGE_COIL_UEV, 2)
                .input(FIELD_GENERATOR_UHV)
                .input(plate, Infinity, 6)
                .fluidInputs(Kevlar.getFluid(576))
                .outputs(EPMetablocks.EP_BLOCK_FUSION_CASING.getItemVariant(EPBlockFusionCasing.CasingType.CASING_FUSION_MKV, 2))
                .EUt(VA[UEV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        //  Fusion Casing Mk VI
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(HULL[UIV])
                .inputs(MetaBlocks.FUSION_CASING.getItemVariant(BlockFusionCasing.CasingType.FUSION_COIL))
                .input(VOLTAGE_COIL_UIV, 2)
                .input(FIELD_GENERATOR_UEV)
                .input(plate, Hypogen, 6)
                .fluidInputs(Zylon.getFluid(576))
                .outputs(EPMetablocks.EP_BLOCK_FUSION_CASING.getItemVariant(EPBlockFusionCasing.CasingType.CASING_FUSION_MKVI, 2))
                .EUt(VA[UIV])
                .duration(100)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

    }

    private static void Materials() {

        //  Unstable Star
        //  TODO Require Space Environment?
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(GRAVI_STAR)
                .fluidInputs(Rhugnor.getFluid(144))
                .output(UNSTABLE_STAR)
                .EUt(VA[UV])
                .duration(480)
                .buildAndRegister();

        //  Blazing Pyrotheum
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Redstone)
                .input(dust, Sulfur)
                .fluidInputs(Blaze.getFluid(L * 2))
                .fluidOutputs(BlazingPyrotheum.getFluid(4000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BlazingPyrotheum.getFluid(4000))
                .output(dust, Redstone)
                .output(dust, Sulfur)
                .fluidOutputs(Blaze.getFluid(L * 2))
                .EUt(VA[LV])
                .duration(240)
                .buildAndRegister();

        //  Gelid Cryotheum
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Electrotine)
                .input(Items.SNOWBALL)
                .fluidInputs(Ice.getFluid(2000))
                .fluidOutputs(GelidCryotheum.getFluid(4000))
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GelidCryotheum.getFluid(4000))
                .output(dust, Electrotine)
                .output(Items.SNOWBALL)
                .fluidOutputs(Ice.getFluid(2000))
                .EUt(VA[LV])
                .duration(240)
                .buildAndRegister();

        //  Helium-Neon Gas
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(1000))
                .fluidInputs(Neon.getFluid(1000))
                .fluidOutputs(HeliumNeon.getFluid(1000))
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        //  Babbitt Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Tin, 5)
                .input(dust, Lead, 36)
                .input(dust, Antimony, 8)
                .input(dust, Astatine)
                .circuitMeta(32)
                .output(dust, BabbittAlloy, 50)
                .EUt(VA[HV])
                .duration(1200)
                .buildAndRegister();

        //  Zirconium Carbide
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Zirconium, 1)
                .input(dust, Carbon, 1)
                .circuitMeta(2)
                .output(dust, ZirconiumCarbide, 2)
                .EUt(VA[EV])
                .duration(220)
                .buildAndRegister();

        //  Eglin Steel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Iron, 4)
                .input(dust, Kanthal)
                .input(dust, Invar, 5)
                .circuitMeta(10)
                .output(dust, EglinSteelBase, 10)
                .EUt(VA[MV])
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, EglinSteelBase, 10)
                .input(dust, Sulfur)
                .input(dust, Silicon)
                .input(dust, Carbon)
                .circuitMeta(13)
                .output(dust, EglinSteel, 13)
                .EUt(VA[MV])
                .duration(120)
                .buildAndRegister();

        //  Staballoy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Uranium238, 9)
                .input(dust, Titanium, 1)
                .circuitMeta(10)
                .output(dust, Staballoy, 10)
                .EUt(VA[MV])
                .duration(340)
                .buildAndRegister();

        //  Tanmolyium Beta-C
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Titanium, 5)
                .input(dust, Molybdenum, 5)
                .input(dust, Vanadium, 2)
                .input(dust, Chrome, 3)
                .input(dust, Aluminium)
                .circuitMeta(5)
                .output(dust, TanmolyiumBetaC, 16)
                .EUt(VA[IV])
                .duration(120)
                .buildAndRegister();

        //  MAR-Ce-M200 Steel
        MIXER_RECIPES.recipeBuilder()
                .input(dust, MARM200Steel, 18)
                .input(dust, Cerium)
                .output(dust, MARM200CeSteel, 19)
                .EUt(VA[IV])
                .duration(350)
                .buildAndRegister();

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

        //  Superheavy-H Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Copernicium)
                .input(dust, Nihonium)
                .input(dust, MetastableFlerovium)
                .input(dust, Moscovium)
                .input(dust, Livermorium)
                .input(dust, MetastableOganesson)
                .fluidInputs(Tennessine.getFluid(L))
                .output(dust, SuperheavyHAlloy, 7)
                .EUt(VA[UEV])
                .duration(120)
                .buildAndRegister();

        //  Superheavy-L Alloy
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Rutherfordium)
                .input(dust, Dubnium)
                .input(dust, Seaborgium)
                .input(dust, Bohrium)
                .input(dust, MetastableHassium)
                .input(dust, Meitnerium)
                .fluidInputs(Darmstadtium.getFluid(L))
                .fluidInputs(Roentgenium.getFluid(L))
                .output(dust, SuperheavyLAlloy, 8)
                .EUt(VA[UEV])
                .duration(120)
                .buildAndRegister();

        //  Lithium Titanate
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(DinitrogenTetroxide.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, TitaniumNitrate, 17)
                .fluidOutputs(Chlorine.getFluid(4000))
                .EUt(VA[EV])
                .duration(230)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, TitaniumNitrate, 17)
                .input(dust, SodiumHydroxide, 6)
                .inputs(LithiumCarbonate.getItemStack(6))
                .output(dust, LithiumTitanate, 6)
                .output(dust, SodaAsh, 6)
                .fluidOutputs(NitricAcid.getFluid(4000))
                .EUt(VA[EV])
                .duration(320)
                .blastFurnaceTemp(3100)
                .buildAndRegister();
    }
}
