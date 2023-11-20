package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import gregtech.api.unification.material.MarkerMaterials;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps.*;
import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.*;

public class ComponentAssemblyLineRecipes {
    public static void init() {
        Motor();
        Piston();
        ConveyorModule();
        Pump();
        RobotArm();
        Emitter();
        Sensor();
        FieldGenerator();
    }

    private static void Motor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Lead, 16)
                .output(ELECTRIC_MOTOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Iron, 64)
                .input(stickLong, IronMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 8)
                .input(stickLong, Steel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Copper, 16)
                .output(ELECTRIC_MOTOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Copper, 8)
                .input(stickLong, Aluminium, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Cupronickel, 32)
                .output(ELECTRIC_MOTOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Silver, 16)
                .input(stickLong, StainlessSteel, 64)
                .input(stickLong, SteelMagnetic, 32)
                .input(wireGtHex, Electrum, 32)
                .output(ELECTRIC_MOTOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Aluminium, 16)
                .input(stickLong, Titanium, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Kanthal, 32)
                .output(ELECTRIC_MOTOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tungsten, 16)
                .input(stickLong, TungstenSteel, 64)
                .input(stickLong, NeodymiumMagnetic, 32)
                .input(wireGtHex, Graphene, 32)
                .output(ELECTRIC_MOTOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 64))
                .fluidInputs(Ruridit.getFluid(L * 8 * 64))
                .output(ELECTRIC_MOTOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 64 * 2))
                .fluidInputs(Europium.getFluid(L * 12 * 64))
                .output(ELECTRIC_MOTOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumMagnetic, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 64 * 2))
                .fluidInputs(Americium.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 2 * 64))
                .fluidInputs(SiliconCarbide.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Infinity, 64)
                .input(stickLong, Infinity, 64)
                .input(stickLong, Infinity, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 2 * 64))
                .fluidInputs(Abyssalloy.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, WhiteDwarfMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64) //  Ring
                .input(cableGtHex, CosmicNeutronium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(448000))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 32 + L * 64)) // Ring + Round
                .fluidInputs(Legendarium.getFluid(L * 64))
                .fluidInputs(RutheniumTriniumAmericiumNeutronate.getFluid(L * 16 * 64))
                .output(ELECTRIC_MOTOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();


        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void Piston() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, WroughtIron, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 32)
                .input(gearSmall, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .output(ELECTRIC_PISTON_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Steel, 64)
                .input(cableGtHex, Tin, 8)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 32)
                .input(gearSmall, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .output(ELECTRIC_PISTON_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Aluminium, 64)
                .input(cableGtHex, Copper, 8)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 32)
                .input(gearSmall, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .output(ELECTRIC_PISTON_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, StainlessSteel, 64)
                .input(cableGtHex, Gold, 8)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 32)
                .input(gearSmall, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .output(ELECTRIC_PISTON_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Titanium, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 32)
                .input(gearSmall, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .output(ELECTRIC_PISTON_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, TungstenSteel, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 32)
                .input(gearSmall, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .output(ELECTRIC_PISTON_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(cableGtHex, NiobiumTitanium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Round (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_LUV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(cableGtHex, VanadiumGallium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 4 * 64 + L * 2 * 64))  //  Gear (576 * 64) + Round (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(cableGtHex, YttriumBariumCuprate, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 4 * 64))
                .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64))
                .fluidInputs(Draconium.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Infinity, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Infinity, 64)
                .input(stickLong, Infinity, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Hdcs.getFluid(L * 4 * 64))
                .fluidInputs(Neutronium.getFluid(L * 4 * 64 + L * 2 * 64)) //  Gear (576 * 64) + Small Gear (144 * 2 * 64)
                .output(ELECTRIC_PISTON_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, Legendarium, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(cableGtHex, CosmicNeutronium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(7000 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(L * 2 * 64))
                .output(ELECTRIC_PISTON_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void ConveyorModule() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .input("wool", 64)
                .circuitMeta(1)
                .output(CONVEYOR_MODULE_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(pipeTinyFluid, Bronze, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_ULV, 64)
                    .EUt(VA[ULV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tin, 4)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Copper, 4)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .CasingTier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Gold, 4)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .CasingTier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 6 * 64),
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Aluminium, 4)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .CasingTier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 6 * 64),
                StyreneButadieneRubber.getFluid(L * 6 * 64),
                NitrileButadieneRubber.getFluid(L * 6 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 6 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tungsten, 4)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .circuitMeta(1)
                    .fluidInputs(new FluidStack[]{stack})
                    .output(CONVEYOR_MODULE_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .CasingTier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 8 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 8 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(Lubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 32)) //  Round + (1 Ingot -> 8 Bolt -> 8 Screw)
                    .output(CONVEYOR_MODULE_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .CasingTier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 16 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 16 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(Lubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 32)) //  Round + (1 Ingot -> 8 Bolt -> 8 Screw)
                    .output(CONVEYOR_MODULE_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .CasingTier(ZPM)
                    .buildAndRegister();
        }
        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                StyreneButadieneRubber.getFluid(L * 24 * 64),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 24 * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(Lubricant.getFluid(L * 4 * 64))
                    .fluidInputs(Lubricant.getFluid(64000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(Tritanium.getFluid(L * 4 * 64 + L * 32))
                    .output(CONVEYOR_MODULE_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .CasingTier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 32 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 32))
                .output(CONVEYOR_MODULE_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Infinity, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Infinity, 64)
                .input(stickLong, Infinity, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 40 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 2 * 64))
                .fluidInputs(Hdcs.getFluid(L * 2 * 64))
                .fluidInputs(Infinity.getFluid(L * 2 * 64))
                .output(CONVEYOR_MODULE_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, Legendarium, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 32)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 32)
                .input(cableGtHex, CosmicNeutronium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(7000 * 64))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 48 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 4 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(L * 2 * 64))
                .output(CONVEYOR_MODULE_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void Pump() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 16)
                .input("wool", 64)
                .input("wool", 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .fluidInputs(Copper.getFluid(L * 3 * 64))
                .fluidInputs(WroughtIron.getFluid(L * 4 * 64))
                .output(ELECTRIC_PUMP_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(pipeTinyFluid, Bronze, 64)
                    .input(stickLong, WroughtIron, 16)
                    .input(ELECTRIC_MOTOR_ULV, 64)
                    .fluidInputs(Copper.getFluid(L * 3 * 64))
                    .fluidInputs(WroughtIron.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_ULV, 64)
                    .EUt(VA[ULV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  LV (15s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tin, 4)
                    .input(stickLong, Tin, 16)
                    .input(ELECTRIC_MOTOR_LV, 64)
                    .fluidInputs(Bronze.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Tin.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_LV, 64)
                    .EUt(VA[LV])
                    .duration(300)
                    .CasingTier(LV)
                    .buildAndRegister();
        }

        //  MV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Copper, 4)
                    .input(stickLong, Bronze, 16)
                    .input(ELECTRIC_MOTOR_MV, 64)
                    .fluidInputs(Steel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Bronze.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_MV, 64)
                    .EUt(VA[MV])
                    .duration(600)
                    .CasingTier(MV)
                    .buildAndRegister();
        }

        //  HV (30s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Gold, 4)
                    .input(stickLong, Steel, 16)
                    .input(ELECTRIC_MOTOR_HV, 64)
                    .fluidInputs(StainlessSteel.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(Steel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_HV, 64)
                    .EUt(VA[HV])
                    .duration(600)
                    .CasingTier(HV)
                    .buildAndRegister();
        }

        //  EV (45s)
        for (FluidStack stack : new FluidStack[]{
                Rubber.getFluid(L * 32),
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Aluminium, 4)
                    .input(stickLong, StainlessSteel, 16)
                    .input(ELECTRIC_MOTOR_EV, 64)
                    .fluidInputs(Titanium.getFluid(L * 3 * 64)) // PipeNormalFluid
                    .fluidInputs(StainlessSteel.getFluid(L * 4 * 64)) // Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_EV, 64)
                    .EUt(VA[EV])
                    .duration(900)
                    .CasingTier(EV)
                    .buildAndRegister();
        }

        //  IV (45s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 32),
                StyreneButadieneRubber.getFluid(L * 32),
                NitrileButadieneRubber.getFluid(L * 32),
                PolyPhosphonitrileFluoroRubber.getFluid(L * 32)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(cableGtHex, Tungsten, 4)
                    .input(stickLong, TungstenSteel, 16)
                    .input(ELECTRIC_MOTOR_IV, 64)
                    .fluidInputs(TungstenSteel.getFluid(L * 3 * 64 + L * 4 * 64)) // PipeNormalFluid + Rotor
                    .fluidInputs(new FluidStack[]{stack})
                    .output(ELECTRIC_PUMP_IV, 64)
                    .EUt(VA[IV])
                    .duration(900)
                    .CasingTier(IV)
                    .buildAndRegister();
        }

        //  LuV (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 64),
                NitrileButadieneRubber.getFluid(L * 64)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_LuV, 64)
                    .input(plateDouble, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(stickLong, HSSS, 64)
                    .input(cableGtHex, NiobiumTitanium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 64))
                    .fluidInputs(Lubricant.getFluid(16000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(NiobiumTitanium.getFluid(L * 64)) //  PipeSmallFluid
                    .fluidInputs(HSSS.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_LuV, 64)
                    .EUt(VA[LuV])
                    .duration(1200)
                    .CasingTier(LuV)
                    .buildAndRegister();
        }

        //  ZPM (60s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 128),
                NitrileButadieneRubber.getFluid(L * 128)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_ZPM, 64)
                    .input(plateDouble, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(stickLong, Osmiridium, 64)
                    .input(cableGtHex, VanadiumGallium, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                    .fluidInputs(Lubricant.getFluid(32000))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Polybenzimidazole.getFluid(L * 3 * 64)) //  pipeNormalFluid
                    .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) // Rotor
                    .output(ELECTRIC_PUMP_ZPM, 64)
                    .EUt(VA[ZPM])
                    .duration(1200)
                    .CasingTier(ZPM)
                    .buildAndRegister();
        }

        //  UV (75s)
        for (FluidStack stack : new FluidStack[]{
                SiliconeRubber.getFluid(L * 256),
                NitrileButadieneRubber.getFluid(L * 256)}) {
            COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                    .input(ELECTRIC_MOTOR_UV, 64)
                    .input(plateDouble, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(stickLong, Tritanium, 64)
                    .input(cableGtHex, YttriumBariumCuprate, 8)
                    .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                    .fluidInputs(Lubricant.getFluid(64000))
                    .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                    .fluidInputs(new FluidStack[]{stack})
                    .fluidInputs(Naquadah.getFluid(L * 6 * 64)) //  PipeLargeFluid
                    .fluidInputs(NaquadahAlloy.getFluid(L * 4 * 64)) //  Rotor
                    .output(ELECTRIC_PUMP_UV, 64)
                    .EUt(VA[UV])
                    .duration(1500)
                    .CasingTier(UV)
                    .buildAndRegister();
        }

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(cableGtHex, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(NitrileButadieneRubber.getFluid(L * 512))
                .fluidInputs(Duranium.getFluid(L * 6 * 64)) // PipeLargeFluid
                .fluidInputs(Draconium.getFluid(L * 4 * 64)) // Rotor
                .output(ELECTRIC_PUMP_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Infinity, 64)
                .input(cableGtHex, CarbonNanotube, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(NitrileButadieneRubber.getFluid(L * 1024))
                .fluidInputs(Lafium.getFluid(L * 6 * 64)) //  PipeLargeFluid
                .fluidInputs(Neutronium.getFluid( L * 4 * 64)) //  Rotor
                .output(ELECTRIC_PUMP_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, Legendarium, 64)
                .input(cableGtHex, CosmicNeutronium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Lubricant.getFluid(7000 * 64))
                .fluidInputs(PolyPhosphonitrileFluoroRubber.getFluid(L * 48 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 4 * 64))
                .fluidInputs(Neutronium.getFluid(L * 6 * 64))
                .output(ELECTRIC_PUMP_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void RobotArm() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_PISTON_ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .output(ROBOT_ARM_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(stickLong, WroughtIron, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_MOTOR_ULV, 64)
                .input(ELECTRIC_PISTON_ULV, 64)
                .input(WRAP_CIRCUIT_ULV)
                .output(ROBOT_ARM_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tin, 12)
                .input(stickLong, Steel, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_MOTOR_LV, 64)
                .input(ELECTRIC_PISTON_LV, 64)
                .input(WRAP_CIRCUIT_LV)
                .output(ROBOT_ARM_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Copper, 12)
                .input(stickLong, Aluminium, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_MOTOR_MV, 64)
                .input(ELECTRIC_PISTON_MV, 64)
                .input(WRAP_CIRCUIT_MV)
                .output(ROBOT_ARM_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Gold, 12)
                .input(stickLong, StainlessSteel, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_MOTOR_HV, 64)
                .input(ELECTRIC_PISTON_HV, 64)
                .input(WRAP_CIRCUIT_HV)
                .output(ROBOT_ARM_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Aluminium, 12)
                .input(stickLong, Titanium, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_MOTOR_EV, 64)
                .input(ELECTRIC_PISTON_EV, 64)
                .input(WRAP_CIRCUIT_EV)
                .output(ROBOT_ARM_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(cableGtHex, Tungsten, 12)
                .input(stickLong, TungstenSteel, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_MOTOR_IV, 64)
                .input(ELECTRIC_PISTON_IV, 64)
                .input(WRAP_CIRCUIT_IV)
                .output(ROBOT_ARM_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(stickLong, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(ELECTRIC_PISTON_LUV, 64)
                .input(WRAP_CIRCUIT_LuV)
                .input(WRAP_CIRCUIT_IV, 2)
                .input(WRAP_CIRCUIT_EV, 4)
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Lubricant.getFluid(16000))
                .fluidInputs(HSSS.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Osmiridium,  64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(stickLong, Osmiridium, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(ELECTRIC_PISTON_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM)
                .input(WRAP_CIRCUIT_LuV, 2)
                .input(WRAP_CIRCUIT_IV, 4)
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Lubricant.getFluid(32000))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Tritanium,  64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(stickLong, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(ELECTRIC_PISTON_UV, 64)
                .input(WRAP_CIRCUIT_UV)
                .input(WRAP_CIRCUIT_ZPM, 2)
                .input(WRAP_CIRCUIT_LuV, 4)
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(Lubricant.getFluid(64000))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(Tritanium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(stickLong, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(ELECTRIC_PISTON_UHV, 64)
                .input(WRAP_CIRCUIT_UHV)
                .input(WRAP_CIRCUIT_UV, 2)
                .input(WRAP_CIRCUIT_ZPM, 4)
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Lubricant.getFluid(192000))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(Adamantium.getFluid(L * 4 * 64 + L * 3 * 64)) //  Gear + 3 Small Gear
                .output(ROBOT_ARM_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Hdcs, 64)
                .input(stickLong, Infinity, 64)
                .input(stickLong, Infinity, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(ELECTRIC_PISTON_UEV, 64)
                .input(WRAP_CIRCUIT_UEV)
                .input(WRAP_CIRCUIT_UHV, 2)
                .input(WRAP_CIRCUIT_UV, 4)
                .input(cableGtHex, CarbonNanotube, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 20 * 64))
                .fluidInputs(Lubricant.getFluid(320000))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Infinity.getFluid(L * 4 * 64))// gear
                .fluidInputs(Hdcs.getFluid(L * 3 * 64)) //3 Small Gear
                .output(ROBOT_ARM_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(ELECTRIC_PISTON_UIV, 64)
                .input(WRAP_CIRCUIT_UIV)
                .input(WRAP_CIRCUIT_UEV, 2)
                .input(WRAP_CIRCUIT_UHV, 4)
                .input(cableGtHex, CosmicNeutronium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 24 * 64))
                .fluidInputs(Lubricant.getFluid(7000 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 2 * 64))
                .fluidInputs(Legendarium.getFluid(L * 4 * 64))
                .fluidInputs(MagnetoHydrodynamicallyConstrainedStarMatter.getFluid(L * 3 * 64))
                .output(ROBOT_ARM_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void Emitter() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iron, 64)
                .input(stickLong, Iron, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(gem, Sapphire, 64)
                .circuitMeta(1)
                .output(EMITTER_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iron, 64)
                .input(stickLong, Iron, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(pipeTinyFluid, Bronze, 64)
                .input(WRAP_CIRCUIT_ULV, 2)
                .input(gem, Sapphire, 64)
                .circuitMeta(1)
                .output(EMITTER_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .circuitMeta(1)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Brass, 64)
                .input(stickLong, Brass, 64)
                .input(cableGtHex, Tin, 8)
                .input(WRAP_CIRCUIT_LV, 2)
                .input(gem, Quartzite, 64)
                .circuitMeta(1)
                .output(EMITTER_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .circuitMeta(1)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Electrum, 64)
                .input(stickLong, Electrum, 64)
                .input(cableGtHex, Copper, 8)
                .input(WRAP_CIRCUIT_MV, 2)
                .input(gemFlawless, Emerald, 64)
                .circuitMeta(1)
                .output(EMITTER_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .circuitMeta(1)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Chrome, 64)
                .input(stickLong, Chrome, 64)
                .input(cableGtHex, Gold, 8)
                .input(WRAP_CIRCUIT_HV, 2)
                .input(ENDER_EYE, 64)
                .circuitMeta(1)
                .output(EMITTER_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .circuitMeta(1)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Platinum, 64)
                .input(stickLong, Platinum, 64)
                .input(cableGtHex, Aluminium, 8)
                .input(WRAP_CIRCUIT_EV, 2)
                .input(QUANTUM_EYE, 64)
                .circuitMeta(1)
                .output(EMITTER_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .circuitMeta(1)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iridium, 64)
                .input(stickLong, Iridium, 64)
                .input(cableGtHex, Tungsten, 8)
                .input(WRAP_CIRCUIT_IV, 2)
                .input(QUANTUM_STAR, 64)
                .circuitMeta(1)
                .output(EMITTER_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 2)
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Ruridit.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 2)
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Osmiridium.getFluid(L * 4 * 64)) //  4 * Long Stick
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(EMITTER_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 2)
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64)) // Foil + Recipe fluids
                .fluidInputs(Tritanium.getFluid(L * 4 * 64)) //  4 * Long Stick
                .output(EMITTER_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 2)
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64 + L * 24 * 64))   // Foil + Recipe fluids
                .fluidInputs(Adamantium.getFluid(L * 4 * 64)) //  4 * Long Stick
                .output(EMITTER_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 2)
                .input(cableGtHex, CarbonNanotube, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64 + L * 24 * 64)) // Foil + Recipe fluids
                .fluidInputs(Hdcs.getFluid(L * 2 * 64)) //  2 * Long Stick
                .fluidInputs(Infinity.getFluid(L * 2 * 64)) // 2 * Long Stick
                .output(EMITTER_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(stickLong, Legendarium, 64)
                .input(stickLong, Legendarium, 64)
                .inputs(UNSTABLE_STAR.getStackForm(64))
                .input(WRAP_CIRCUIT_UIV, 2)
                .input(cableGtHex, CosmicNeutronium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 64))
                .fluidInputs(AstralTitanium.getFluid(L * 24 * 64))
                .output(EMITTER_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void Sensor() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iron, 32)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(gem, Sapphire, 64)
                .output(SENSOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iron, 32)
                .input(plateDouble, WroughtIron, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(WRAP_CIRCUIT_ULV)
                .input(gem, Sapphire, 64)
                .output(SENSOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Brass, 32)
                .input(plateDouble, Steel, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV)
                .input(gem, Quartzite, 64)
                .output(SENSOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Electrum, 32)
                .input(plateDouble, Aluminium, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV)
                .input(gemFlawless, Emerald, 64)
                .output(SENSOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Chrome, 32)
                .input(plateDouble, StainlessSteel, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV)
                .input(ENDER_EYE, 64)
                .output(SENSOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Platinum, 32)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV)
                .input(QUANTUM_EYE, 64)
                .output(SENSOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Iridium, 32)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV)
                .input(QUANTUM_STAR, 64)
                .output(SENSOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 64)
                .input(ELECTRIC_MOTOR_LuV, 64)
                .input(plateDouble, Ruridit, 64)
                .input(plateDouble, Ruridit, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_LuV, 2)
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 2 * 64))
                .fluidInputs(Palladium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 64)
                .input(ELECTRIC_MOTOR_ZPM, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(plateDouble, Osmiridium, 64)
                .input(QUANTUM_STAR, 64)
                .input(QUANTUM_STAR, 64)
                .input(WRAP_CIRCUIT_ZPM, 2)
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(Trinium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 64)
                .input(ELECTRIC_MOTOR_UV, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UV, 2)
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(Naquadria.getFluid(L * 24 * 64 + L * 4 * 64))// Foil + Recipe fluids
                .output(SENSOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 64)
                .input(ELECTRIC_MOTOR_UHV, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UHV, 2)
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(AwakenedDraconium.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Infinity, 64)
                .input(ELECTRIC_MOTOR_UEV, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Infinity, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(WRAP_CIRCUIT_UEV, 2)
                .input(cableGtHex, CarbonNanotube, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 32 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(Abyssalloy.getFluid(L * 24 * 64)) //  Foil (64 + 32 -> 16 * 4 + 8 * 4)
                .output(SENSOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Legendarium, 64)
                .input(ELECTRIC_MOTOR_UIV, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, Legendarium, 64)
                .input(UNSTABLE_STAR, 64)
                .input(WRAP_CIRCUIT_UIV, 2)
                .input(cableGtHex, CarbonNanotube, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 64 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 64))
                .fluidInputs(CelestialTungsten.getFluid(L * 24 * 64))
                .output(SENSOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }

    private static void FieldGenerator() {

        //  ULV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(gem, Ruby, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(circuit, MarkerMaterials.Tier.ULV, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .output(FIELD_GENERATOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(gem, Ruby, 64)
                .input(plateDouble, WroughtIron, 64)
                .input(WRAP_CIRCUIT_ULV, 2)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .input(pipeLargeFluid, Lead, 64)
                .output(FIELD_GENERATOR_ULV, 64)
                .EUt(VA[ULV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  LV (15s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(circuit, MarkerMaterials.Tier.LV, 64)
                .input(cableGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_PEARL, 64)
                .input(plateDouble, Steel, 64)
                .input(WRAP_CIRCUIT_LV, 2)
                .input(cableGtHex, ManganesePhosphide, 64)
                .output(FIELD_GENERATOR_LV, 64)
                .EUt(VA[LV])
                .duration(300)
                .CasingTier(LV)
                .buildAndRegister();

        //  MV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(circuit, MarkerMaterials.Tier.MV, 64)
                .input(cableGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ENDER_EYE, 64)
                .input(plateDouble, Aluminium, 64)
                .input(WRAP_CIRCUIT_MV, 2)
                .input(cableGtHex, MagnesiumDiboride, 64)
                .output(FIELD_GENERATOR_MV, 64)
                .EUt(VA[MV])
                .duration(600)
                .CasingTier(MV)
                .buildAndRegister();

        //  HV (30s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(circuit, MarkerMaterials.Tier.HV, 64)
                .input(cableGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_EYE, 64)
                .input(plateDouble, StainlessSteel, 64)
                .input(WRAP_CIRCUIT_HV, 2)
                .input(cableGtHex, MercuryBariumCalciumCuprate, 64)
                .output(FIELD_GENERATOR_HV, 64)
                .EUt(VA[HV])
                .duration(600)
                .CasingTier(HV)
                .buildAndRegister();

        //  EV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(circuit, MarkerMaterials.Tier.EV, 64)
                .input(cableGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(NETHER_STAR, 64)
                .input(plateDouble, Titanium, 64)
                .input(plateDouble, Titanium, 64)
                .input(WRAP_CIRCUIT_EV, 2)
                .input(cableGtHex, UraniumTriplatinum, 64)
                .output(FIELD_GENERATOR_EV, 64)
                .EUt(VA[EV])
                .duration(900)
                .CasingTier(EV)
                .buildAndRegister();

        //  IV (45s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(circuit, MarkerMaterials.Tier.IV, 64)
                .input(cableGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(plateDouble, TungstenSteel, 64)
                .input(WRAP_CIRCUIT_IV, 2)
                .input(cableGtHex, SamariumIronArsenicOxide, 64)
                .output(FIELD_GENERATOR_IV, 64)
                .EUt(VA[IV])
                .duration(900)
                .CasingTier(IV)
                .buildAndRegister();

        //  LuV (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(plateDouble, HSSS, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_LuV, 64)
                .input(EMITTER_LuV, 64)
                .input(WRAP_CIRCUIT_LuV, 2)
                .input(cableGtHex, NiobiumTitanium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 4 * 64))
                .fluidInputs(IndiumTinBariumTitaniumCuprate.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_LuV, 64)
                .EUt(VA[LuV])
                .duration(1200)
                .CasingTier(LuV)
                .buildAndRegister();

        //  ZPM (60s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(plateDouble, NaquadahAlloy, 64)
                .input(QUANTUM_STAR, 64)
                .input(EMITTER_ZPM, 64)
                .input(EMITTER_ZPM, 64)
                .input(WRAP_CIRCUIT_ZPM, 2)
                .input(cableGtHex, VanadiumGallium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 8 * 64))
                .fluidInputs(UraniumRhodiumDinaquadide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_ZPM, 64)
                .EUt(VA[ZPM])
                .duration(1200)
                .CasingTier(ZPM)
                .buildAndRegister();

        //  UV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(plateDouble, Tritanium, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UV, 64)
                .input(EMITTER_UV, 64)
                .input(WRAP_CIRCUIT_UV, 2)
                .input(cableGtHex, YttriumBariumCuprate, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 12 * 64))
                .fluidInputs(Naquadria.getFluid(L * 4 * 64))
                .fluidInputs(EnrichedNaquadahTriniumEuropiumDuranide.getFluid(L * 16 * 64)) // Fine Wire (1 Ingot -> 8, 16 * 8 -> 64 * 2)
                .output(FIELD_GENERATOR_UV, 64)
                .EUt(VA[UV])
                .duration(1500)
                .CasingTier(UV)
                .buildAndRegister();

        //  UHV (75s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(plateDouble, Adamantium, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UHV, 64)
                .input(EMITTER_UHV, 64)
                .input(WRAP_CIRCUIT_UHV, 2)
                .input(cableGtHex, Europium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 16 * 64))
                .fluidInputs(Vibranium.getFluid(L * 64))
                .fluidInputs(PedotPSS.getFluid(L * 16 * 64))
                .output(FIELD_GENERATOR_UHV, 64)
                .EUt(VA[UHV])
                .duration(1500)
                .CasingTier(UHV)
                .buildAndRegister();

        //  UEV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium, 64)
                .input(plateDouble, Hdcs, 64)
                .input(plateDouble, Infinity, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(GRAVI_STAR, 64)
                .input(EMITTER_UEV, 64)
                .input(EMITTER_UEV, 64)
                .input(WRAP_CIRCUIT_UEV, 2)
                .input(cableGtHex, CarbonNanotube, 16)
                .fluidInputs(SolderingAlloy.getFluid(20 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(ChaoticDraconium.getFluid(L * 64))
                .fluidInputs(PedotTMA.getFluid(L * 16 * 64))
                .fluidInputs(Hdcs.getFluid(L * 2 * 32)) // 32 double plate
                .fluidInputs(Infinity.getFluid(L * 2 * 32)) // 32 double plate
                .output(FIELD_GENERATOR_UEV, 64)
                .EUt(VA[UEV])
                .duration(1800)
                .CasingTier(UEV)
                .buildAndRegister();

        //  UIV (90s)
        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, NeutronStarCoreMaterial, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 64)
                .input(plateDouble, MagnetoHydrodynamicallyConstrainedStarMatter, 32)
                .input(plateDouble, Legendarium, 64)
                .input(plateDouble, Legendarium, 32)
                .input(UNSTABLE_STAR, 64)
                .input(EMITTER_UIV, 64)
                .input(EMITTER_UIV, 64)
                .input(WRAP_CIRCUIT_UIV, 2)
                .input(cableGtHex, CosmicNeutronium, 16)
                .fluidInputs(SolderingAlloy.getFluid(L * 24 * 64))
                .fluidInputs(Zylon.getFluid(L * 4 * 64))
                .fluidInputs(Polyetheretherketone.getFluid(L * 2 * 64))
                .fluidInputs(BlackDwarfMatter.getFluid(L * 64))
                .fluidInputs(SuperheavyHAlloy.getFluid(L * 16 * 64))
                .output(FIELD_GENERATOR_UIV, 64)
                .EUt(VA[UIV])
                .duration(1800)
                .CasingTier(UIV)
                .buildAndRegister();

        //  UXV (105s)

        //  OpV (120s)

        //  MAX (135s)
    }
}