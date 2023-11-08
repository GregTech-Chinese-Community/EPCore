package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import gregtech.api.unification.material.MarkerMaterials;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.*;

public class ComponentAssemblerRecipes {
    public static void init() {
        Motor();
        Piston();
        Conveyor();
        Pump();
        RobotArm();
        Emitter();
        Sensor();
        FieldGenerator();
    }

    private static void Motor() {

        //  TODO rework motor recipes

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 2)
                .input(stick, WroughtIron, 2)
                .input(stick, IronMagnetic)
                .input(wireGtSingle, Lead, 4)
                .output(ELECTRIC_MOTOR_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin, 2)
                .input(stick, Iron, 2)
                .input(stick, IronMagnetic)
                .input(wireGtSingle, Copper, 4)
                .output(ELECTRIC_MOTOR_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin, 2)
                .input(stick, Steel, 2)
                .input(stick, SteelMagnetic)
                .input(wireGtSingle, Copper, 4)
                .output(ELECTRIC_MOTOR_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper, 2)
                .input(stick, Aluminium, 2)
                .input(stick, SteelMagnetic)
                .input(wireGtDouble, Cupronickel, 4)
                .output(ELECTRIC_MOTOR_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtDouble, Silver, 2)
                .input(stick, StainlessSteel, 2)
                .input(stick, SteelMagnetic)
                .input(wireGtDouble, Electrum, 4)
                .output(ELECTRIC_MOTOR_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtDouble, Aluminium, 2)
                .input(stick, Titanium, 2)
                .input(stick, NeodymiumMagnetic)
                .input(wireGtDouble, Kanthal, 4)
                .output(ELECTRIC_MOTOR_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtDouble, Tungsten, 2)
                .input(stick, TungstenSteel, 2)
                .input(stick, NeodymiumMagnetic)
                .input(wireGtDouble, Graphene, 4)
                .output(ELECTRIC_MOTOR_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Piston() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, WroughtIron, 2)
                .input(pipeTinyFluid, Bronze, 2)
                .input(plate, WroughtIron, 3)
                .input(gearSmall, WroughtIron)
                .input(ELECTRIC_MOTOR_ULV)
                .output(ELECTRIC_PISTON_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Steel, 2)
                .input(cableGtSingle, Tin, 2)
                .input(plate, Steel, 3)
                .input(gearSmall, Steel)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PISTON_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Aluminium, 2)
                .input(cableGtSingle, Copper, 2)
                .input(plate, Aluminium, 3)
                .input(gearSmall, Aluminium)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PISTON_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, StainlessSteel, 2)
                .input(cableGtSingle, Gold, 2)
                .input(plate, StainlessSteel, 3)
                .input(gearSmall, StainlessSteel)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PISTON_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Titanium, 2)
                .input(cableGtSingle, Aluminium, 2)
                .input(plate, Titanium, 3)
                .input(gearSmall, Titanium)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PISTON_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, TungstenSteel, 2)
                .input(cableGtSingle, Tungsten, 2)
                .input(plate, TungstenSteel, 3)
                .input(gearSmall, TungstenSteel)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PISTON_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Conveyor() {
        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze)
                .input(ELECTRIC_MOTOR_ULV, 2)
                .input("wool", 6)
                .circuitMeta(1)
                .output(CONVEYOR_MODULE_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6),
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(pipeTinyFluid, Bronze)
                    .input(ELECTRIC_MOTOR_ULV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_ULV)
                    .EUt(VA[ULV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  LV
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6),
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tin)
                    .input(ELECTRIC_MOTOR_LV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  MV
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6),
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Copper)
                    .input(ELECTRIC_MOTOR_MV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  HV
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6),
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Gold)
                    .input(ELECTRIC_MOTOR_HV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  EV
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6),
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Aluminium)
                    .input(ELECTRIC_MOTOR_EV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }

        //  IV
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 6),
                StyreneButadieneRubber.getFluid(L * 6)}) {
            COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                    .input(cableGtSingle, Tungsten)
                    .input(ELECTRIC_MOTOR_IV, 2)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }
    }

    private static void Pump() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze)
                .input(pipeNormalFluid, Copper)
                .input(screw, WroughtIron)
                .input(rotor, WroughtIron)
                .input("wool", 2)
                .input(ELECTRIC_MOTOR_ULV)
                .output(ELECTRIC_PUMP_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze)
                .input(pipeNormalFluid, Copper)
                .input(screw, WroughtIron)
                .input(rotor, WroughtIron)
                .input(ring, Rubber, 2)
                .input(ELECTRIC_MOTOR_ULV)
                .output(ELECTRIC_PUMP_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze)
                .input(pipeNormalFluid, Copper)
                .input(screw, WroughtIron)
                .input(rotor, WroughtIron)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_ULV)
                .output(ELECTRIC_PUMP_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze)
                .input(pipeNormalFluid, Copper)
                .input(screw, WroughtIron)
                .input(rotor, WroughtIron)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_ULV)
                .output(ELECTRIC_PUMP_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, Rubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin)
                .input(pipeNormalFluid, Bronze)
                .input(screw, Tin)
                .input(rotor, Tin)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_LV)
                .output(ELECTRIC_PUMP_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, Rubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper)
                .input(pipeNormalFluid, Steel)
                .input(screw, Bronze)
                .input(rotor, Bronze)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_MV)
                .output(ELECTRIC_PUMP_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, Rubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold)
                .input(pipeNormalFluid, StainlessSteel)
                .input(screw, Steel)
                .input(rotor, Steel)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_HV)
                .output(ELECTRIC_PUMP_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, Rubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium)
                .input(pipeNormalFluid, Titanium)
                .input(screw, StainlessSteel)
                .input(rotor, StainlessSteel)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_EV)
                .output(ELECTRIC_PUMP_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, SiliconeRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten)
                .input(pipeNormalFluid, TungstenSteel)
                .input(screw, TungstenSteel)
                .input(rotor, TungstenSteel)
                .input(ring, StyreneButadieneRubber, 2)
                .input(ELECTRIC_MOTOR_IV)
                .output(ELECTRIC_PUMP_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void RobotArm() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 3)
                .input(stick, WroughtIron, 2)
                .input(ELECTRIC_MOTOR_ULV, 2)
                .input(ELECTRIC_PISTON_ULV)
                .input(circuit, MarkerMaterials.Tier.ULV)
                .output(ROBOT_ARM_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin, 3)
                .input(stick, Steel, 2)
                .input(ELECTRIC_MOTOR_LV, 2)
                .input(ELECTRIC_PISTON_LV)
                .input(circuit, MarkerMaterials.Tier.LV)
                .output(ROBOT_ARM_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Copper, 3)
                .input(stick, Aluminium, 2)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input(ELECTRIC_PISTON_MV)
                .input(circuit, MarkerMaterials.Tier.MV)
                .output(ROBOT_ARM_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Gold, 3)
                .input(stick, StainlessSteel, 2)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input(ELECTRIC_PISTON_HV)
                .input(circuit, MarkerMaterials.Tier.HV)
                .output(ROBOT_ARM_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Aluminium, 3)
                .input(stick, Titanium, 2)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input(ELECTRIC_PISTON_EV)
                .input(circuit, MarkerMaterials.Tier.EV)
                .output(ROBOT_ARM_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tungsten, 3)
                .input(stick, TungstenSteel, 2)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input(ELECTRIC_PISTON_IV)
                .input(circuit, MarkerMaterials.Tier.IV)
                .output(ROBOT_ARM_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Emitter() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, TinAlloy, 4)
                .input(pipeTinyFluid, Bronze, 2)
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(gem, Sapphire)
                .circuitMeta(1)
                .output(EMITTER_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Brass, 4)
                .input(cableGtSingle, Tin, 2)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(gem, Quartzite)
                .circuitMeta(1)
                .output(EMITTER_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Electrum, 4)
                .input(cableGtSingle, Copper, 2)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(gemFlawless, Emerald)
                .circuitMeta(1)
                .output(EMITTER_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Chrome, 4)
                .input(cableGtSingle, Gold, 2)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(ENDER_EYE)
                .circuitMeta(1)
                .output(EMITTER_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Platinum, 4)
                .input(cableGtSingle, Aluminium, 2)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(QUANTUM_EYE)
                .circuitMeta(1)
                .output(EMITTER_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Iridium, 4)
                .input(cableGtSingle, Tungsten, 2)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(QUANTUM_STAR)
                .circuitMeta(1)
                .output(EMITTER_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void Sensor() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, TinAlloy)
                .input(plate, WroughtIron, 4)
                .input(circuit, MarkerMaterials.Tier.ULV)
                .input(gem, Sapphire)
                .output(SENSOR_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Brass)
                .input(plate, Steel, 4)
                .input(circuit, MarkerMaterials.Tier.LV)
                .input(gem, Quartzite)
                .output(SENSOR_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Electrum)
                .input(plate, Aluminium, 4)
                .input(circuit, MarkerMaterials.Tier.MV)
                .input(gemFlawless, Emerald)
                .output(SENSOR_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Chrome)
                .input(plate, StainlessSteel, 4)
                .input(circuit, MarkerMaterials.Tier.HV)
                .input(ENDER_EYE)
                .output(SENSOR_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Platinum)
                .input(plate, Titanium, 4)
                .input(circuit, MarkerMaterials.Tier.EV)
                .input(QUANTUM_EYE)
                .output(SENSOR_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Iridium)
                .input(plate, TungstenSteel, 4)
                .input(circuit, MarkerMaterials.Tier.IV)
                .input(QUANTUM_STAR)
                .output(SENSOR_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }

    private static void FieldGenerator() {

        //  ULV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(gem, Ruby)
                .input(plate, WroughtIron, 2)
                .input(circuit, MarkerMaterials.Tier.ULV, 2)
                .input(pipeLargeFluid, Lead, 4)
                .output(FIELD_GENERATOR_ULV)
                .EUt(VA[ULV])
                .duration(20)
                .buildAndRegister();

        //  LV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENDER_PEARL)
                .input(plate, Steel, 2)
                .input(circuit, MarkerMaterials.Tier.LV, 2)
                .input(wireGtQuadruple, ManganesePhosphide, 4)
                .output(FIELD_GENERATOR_LV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  MV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(ENDER_EYE)
                .input(plate, Aluminium, 2)
                .input(circuit, MarkerMaterials.Tier.MV, 2)
                .input(wireGtQuadruple, MagnesiumDiboride, 4)
                .output(FIELD_GENERATOR_MV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  HV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE)
                .input(plate, StainlessSteel, 2)
                .input(circuit, MarkerMaterials.Tier.HV, 2)
                .input(wireGtQuadruple, MercuryBariumCalciumCuprate, 4)
                .output(FIELD_GENERATOR_HV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  EV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(NETHER_STAR)
                .input(plateDouble, Titanium, 2)
                .input(circuit, MarkerMaterials.Tier.EV, 2)
                .input(wireGtQuadruple, UraniumTriplatinum, 4)
                .output(FIELD_GENERATOR_EV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();

        //  IV
        COMPONENT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .input(plateDouble, TungstenSteel, 2)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(wireGtQuadruple, SamariumIronArsenicOxide, 4)
                .output(FIELD_GENERATOR_IV)
                .EUt(VA[LV])
                .duration(20)
                .buildAndRegister();
    }
}
