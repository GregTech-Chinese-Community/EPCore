package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockActiveMultiblockCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;

import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import gregtech.api.recipes.ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.items.EPMetaItems.*;
import static cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockHermeticCasing.HermeticCasingsType.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;

public class MetaTileEntityRecipes {
    public static void init() {
        VanillaMachineRecipes();
        EPMachineRecipes();
        GCYMOverrideRecipes();
    }

    private static void VanillaMachineRecipes() {
        HullRecipes();
        EnergyHatchRecipes();
    }

    private static void HullRecipes() {
        //  UHV Hull
        ModHandler.removeRecipeByName("gregtech:casing_uhv");
        ModHandler.addShapedRecipe(true, "casing_uhv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Draconium));

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, IntCircuitIngredient.getIntegratedCircuit(8), OreDictUnifier.get(plate, Neutronium, 8));
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Draconium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(cableGtSingle, Europium, 2), MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV)},
                new FluidStack[]{Polybenzimidazole.getFluid(288)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV))
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(Polyetheretherketone.getFluid(288))
                .output(MetaTileEntities.HULL[9])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        ModHandler.removeRecipeByName("gregtech:hermetic_casing_max");
        ModHandler.addShapedRecipe(true, "hermetic_casing_max", MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV),
                "PPP", "PFP", "PPP",
                'P', new UnificationEntry(OrePrefix.plate, Draconium),
                'F', new UnificationEntry(OrePrefix.pipeLargeFluid, Duranium));

        ModHandler.removeRecipeByName("gregtech:quantum_chest_uhv");
        ModHandler.addShapedRecipe(true, "quantum_chest_uhv", MetaTileEntities.QUANTUM_CHEST[9].getStackForm(),
                "CPC", "PHP", "CFC",
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(OrePrefix.plate, Draconium),
                'F', FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaTileEntities.HULL[9].getStackForm());

        ModHandler.removeRecipeByName("gregtech:quantum_tank_uhv");
        ModHandler.addShapedRecipe(true, "quantum_tank_uhv", MetaTileEntities.QUANTUM_TANK[9].getStackForm(),
                "CGC", "PHP", "CUC",
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.UHV),
                'P', new UnificationEntry(OrePrefix.plate, Draconium),
                'U', ELECTRIC_PUMP_UV.getStackForm(),
                'G', FIELD_GENERATOR_UV.getStackForm(),
                'H', MetaBlocks.HERMETIC_CASING.getItemVariant(HERMETIC_UHV));

        //  UEV Hulls
        ModHandler.addShapedRecipe(true, "casing_uev", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, Neutronium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Neutronium, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UEV))
                .input(cableGtSingle, CarbonNanotube, 2)
                .fluidInputs(Polyetheretherketone.getFluid(288))
                .output(MetaTileEntities.HULL[10])
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        //  UIV Hulls
        ModHandler.addShapedRecipe(true, "casing_uiv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV),
                "PPP", "PwP", "PPP",
                'P', new UnificationEntry(plate, NeutronStarCoreMaterial));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, NeutronStarCoreMaterial, 8)
                .circuitMeta(8)
                .outputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UIV))
                .input(cableGtSingle, CosmicNeutronium, 2)
                .fluidInputs(Zylon.getFluid(288))
                .output(MetaTileEntities.HULL[11])
                .EUt(16)
                .duration(50)
                .buildAndRegister();
    }

    private static void EnergyHatchRecipes() {
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(),
                        OreDictUnifier.get(cableGtSingle, Europium, 4),
                        ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                        OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                        OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000),
                        SolderingAlloy.getFluid(5760)});

        //  FIXME Research can run in actual testing, but because the original research was not deleted, two identical researches appeared...
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(cableGtSingle, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_INPUT_HATCH[UHV])
                .duration(1000)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_INPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLY_LINE_RECIPES,
                new ItemStack[]{MetaTileEntities.HULL[UHV].getStackForm(),
                                OreDictUnifier.get(spring, Europium, 4),
                                ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                                OreDictUnifier.get(circuit, MarkerMaterials.Tier.UHV),
                                OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 2)},
                new FluidStack[]{SodiumPotassium.getFluid(12000), SolderingAlloy.getFluid(5760)});

        //  FIXME Research can run in actual testing, but because the original research was not deleted, two identical researches appeared...
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[UHV])
                .input(spring, Europium, 4)
                .input(NANO_PIC_CHIP, 2)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(VOLTAGE_COIL_UHV, 2)
                .fluidInputs(SodiumPotassium.getFluid(12000))
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .output(ENERGY_OUTPUT_HATCH[UHV])
                .duration(1000)
                .EUt(VA[UHV])
                .stationResearch(b -> b
                        .researchStack(ENERGY_OUTPUT_HATCH[UV].getStackForm())
                        .CWUt(128)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  TODO Other Transformers and Energy Hatches (e.g. 4A, 16A, 64A).
    }

    private static void EPMachineRecipes() {
        //  Dryer recipes
        MetaTileEntityLoader.registerMachineRecipe(true, DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL
        );

        //  Vacuum Chamber recipes
        ModHandler.addShapedRecipe(true, "steam_vacuum_chamber_bronze", STEAM_VACUUM_CHAMBER[0].getStackForm(),
                "GCG", "PHP", "GWG",
                'W', new UnificationEntry(pipeTinyFluid, Bronze),
                'C', GLASS_TUBE.getStackForm(),
                'P', ELECTRIC_PUMP_ULV.getStackForm(),
                'G', "blockGlass",
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.BRONZE_HULL));

        ModHandler.addShapedRecipe(true, "steam_vacuum_chamber_steel", STEAM_VACUUM_CHAMBER[1].getStackForm(),
                "GCG", "PHP", "GWG",
                'W', new UnificationEntry(pipeTinyFluid, TinAlloy),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV),
                'P', ELECTRIC_PUMP_ULV.getStackForm(),
                'G', "blockGlass",
                'H', MetaBlocks.STEAM_CASING.getItemVariant(BlockSteamCasing.SteamCasingType.STEEL_HULL));

        MetaTileEntityLoader.registerMachineRecipe(true, VACUUM_CHAMBER,
                "GCG", "PHP", "GWG",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'P', CraftingComponent.PUMP,
                'G', CraftingComponent.GLASS,
                'H', CraftingComponent.HULL);

        //  Naquadah Reactor recipes
        MetaTileEntityLoader.registerMachineRecipe(true, NAQUADAH_REACTOR,
                "RCR", "FHF", "WCW",
                'R', CraftingComponent.STICK_RADIOACTIVE,
                'C', CraftingComponent.CIRCUIT,
                'F', CraftingComponent.FIELD_GENERATOR,
                'W', CraftingComponent.CABLE,
                'H', CraftingComponent.HULL);

        //  Component Assembler recipes
        MetaTileEntityLoader.registerMachineRecipe(true, COMPONENT_ASSEMBLER,
                "PPP", "CHR", "WXW",
                'P', CraftingComponent.PLATE,
                'H', CraftingComponent.HULL,
                'C', CraftingComponent.CONVEYOR,
                'R', CraftingComponent.ROBOT_ARM,
                'W', CraftingComponent.CABLE,
                'X', CraftingComponent.CIRCUIT);

        //  Crystallization crucible
        ModHandler.addShapedRecipe(true, "crystallization_crucible", CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', new UnificationEntry(plateDouble, MolybdenumDisilicide),
                'L', new UnificationEntry(pipeNormalFluid, Titanium),
                'H', MetaTileEntities.HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, Titanium)
        );

        //  Nanoscale Fabricator
        ModHandler.addShapedRecipe(true, "nanoscale_fabricator", NANOSCALE_FABRICATOR.getStackForm(),
                "KSK", "EHE", "CFC",
                'K', new UnificationEntry(cableGtSingle, Europium),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm(),
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'F', FIELD_GENERATOR_UHV.getStackForm()
        );

        //  CVD Unit
        ModHandler.addShapedRecipe(true, "cvd_unit", CVD_UNIT.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, BlueSteel),
                'K', new UnificationEntry(cableGtSingle, Aluminium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', MetaTileEntities.HULL[EV].getStackForm(),
                'S', SENSOR_EV.getStackForm(),
                'E', EMITTER_EV.getStackForm()
        );

        //  Burner Reactor
        ModHandler.addShapedRecipe(true, "burner_reactor", BURNER_REACTOR.getStackForm(),
                "KRK", "IHI", "CMC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, TungstenSteel),
                'I', new UnificationEntry(pipeSmallFluid, Tungsten),
                'H', MetaTileEntities.HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'M', ELECTRIC_MOTOR_IV.getStackForm()
        );

        //  Cryogenic Reactor
        ModHandler.addShapedRecipe(true, "cryogenic_reactor", CRYOGENIC_REACTOR.getStackForm(),
                "KRK", "IHI", "CWC",
                'K', new UnificationEntry(cableGtSingle, Platinum),
                'R', new UnificationEntry(rotor, Titanium),
                'I', new UnificationEntry(pipeSmallFluid, StainlessSteel),
                'H', MetaTileEntities.HULL[IV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'W', ELECTRIC_PUMP_IV.getStackForm()
        );

        //  Sonicator
        ModHandler.addShapedRecipe(true, "sonicator", SONICATOR.getStackForm(),
                "LFL", "PHP", "CPC",
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'F', FIELD_GENERATOR_UV.getStackForm(),
                'P', ELECTRIC_PUMP_UV.getStackForm(),
                'H', MetaTileEntities.HULL[UV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV)
        );

        //  Catalytic Reformer
        ModHandler.addShapedRecipe(true, "catalytic_reformer", CATALYTIC_REFORMER.getStackForm(),
                "MCM", "PHP", "MKM",
                'M', new UnificationEntry(pipeNormalFluid, StainlessSteel),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'P', ELECTRIC_PUMP_EV.getStackForm(),
                'H', MetaTileEntities.HULL[EV].getStackForm(),
                'K', new UnificationEntry(cableGtDouble, Aluminium)
        );

        //  Isa Mill
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, IncoloyMA956)
                .inputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.ISA_MILL_CASING_GEARBOX, 4))
                .input(COMPONENT_GRINDER_TUNGSTEN, 16)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(gear, Inconel625, 8)
                .input(plate, Inconel625, 32)
                .input(plateDouble, HSSE, 8)
                .input(plateDouble, Stellite100, 8)
                .input(screw, HSSG, 64)
                .input(wireFine, NiobiumTitanium, 64)
                .input(wireFine, NiobiumTitanium, 64)
                .input(foil, Titanium, 32)
                .fluidInputs(Zeron100.getFluid(2304))
                .fluidInputs(Trinium.getFluid(4608))
                .fluidInputs(HastelloyC276.getFluid(4608))
                .output(ISA_MILL)
                .EUt(VA[LuV])
                .duration(3200)
                .scannerResearch(b -> b
                        .researchStack(LARGE_MACERATOR.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        //  Flotation Factory
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyX)
                .inputs(EPMetablocks.EP_MILL_CASING.getItemVariant(EPBlockMillCasing.CasingType.FLOTATION_CASING_GEARBOX, 4))
                .input(CONVEYOR_MODULE_LuV, 8)
                .input(ELECTRIC_PUMP_LuV, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(gear, HastelloyN, 8 )
                .input(plate, HastelloyN, 32)
                .input(plateDouble, Osmiridium, 8)
                .input(plateDouble, MaragingSteel300, 8)
                .input(screw, Trinium, 32)
                .input(wireFine, YttriumBariumCuprate, 64)
                .input(wireFine, YttriumBariumCuprate, 64)
                .input(foil, NiobiumNitride, 32)
                .fluidInputs(WatertightSteel.getFluid(2304))
                .fluidInputs(NaquadahEnriched.getFluid(4608))
                .fluidInputs(TitaniumTungstenCarbide.getFluid(4608))
                .output(FLOTATION_FACTORY)
                .EUt(VA[LuV])
                .duration(3200)
                .scannerResearch(b -> b
                        .researchStack(LARGE_DISTILLERY.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        //  Chemical Plant
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, StainlessSteel)
                .input(gear, Aluminium, 8)
                .input(plate, AnnealedCopper, 16)
                .input(cableGtQuadruple, Electrum, 4)
                .fluidInputs(BlackSteel.getFluid(1152))
                .output(CHEMICAL_PLANT)
                .EUt(VA[MV])
                .duration(2400)
                .buildAndRegister();

        //  Ion Implantater
        ModHandler.addShapedRecipe(true, "ion_implantater", ION_IMPLANTATER.getStackForm(),
                "WCW", "EHP", "WKW",
                'E', EMITTER_UHV.getStackForm(),
                'P', ELECTRIC_PUMP_UHV.getStackForm(),
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'K', new UnificationEntry(cableGtSingle, Europium),
                'W', new UnificationEntry(plate, Adamantium));

        //  Plasma CVD Unit
        ModHandler.addShapedRecipe(true, "plasma_cvd_unit", PLASMA_CVD.getStackForm(),
                "PKP", "CHC", "ESE",
                'P', new UnificationEntry(plate, Vibranium),
                'K', new UnificationEntry(cableGtSingle, SiliconCarbide),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'S', SENSOR_UHV.getStackForm(),
                'E', EMITTER_UHV.getStackForm());

        //  Laser CVD Unit
        ModHandler.addShapedRecipe(true, "laser_cvd_unit", LASER_CVD.getStackForm(),
                "EOE", "CHC", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UEV),
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'P', new UnificationEntry(plate, Orichalcum),
                'E', EMITTER_UHV.getStackForm(),
                'O', OPTICAL_FIBER.getStackForm()
        );

        //  Large Naquadah Reactor
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Vibranium, 4)
                .input(ELECTRIC_PISTON_UV, 2)
                .input(ELECTRIC_PUMP_UV, 2)
                .input(FIELD_GENERATOR_UV, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(plate, Trinium, 4)
                .input(plateDouble, Naquadria, 4)
                .input(gear, Tritanium, 4)
                .input(gearSmall, Tritanium, 8)
                .input(foil, UraniumRhodiumDinaquadide, 64)
                .input(wireFine, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .input(cableGtOctal, YttriumBariumCuprate, 16)
                .fluidInputs(Trinaquadalloy.getFluid(5760))
                .fluidInputs(HSSS.getFluid(5760))
                .fluidInputs(Naquadria.getFluid(1440))
                .output(LARGE_NAQUADAH_REACTOR)
                .EUt(VA[UV])
                .duration(4800)
                .stationResearch(b -> b
                        .researchStack(NAQUADAH_REACTOR[2].getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  Fuel Refine Factory
        ModHandler.addShapedRecipe(true, "fuel_refine_factory", FUEL_REFINE_FACTORY.getStackForm(),
                "RFR", "CHC", "PWP",
                'H', MetaTileEntities.HULL[UHV].getStackForm(),
                'P', ELECTRIC_PUMP_UHV,
                'F', new UnificationEntry(pipeHugeFluid, Lafium),
                'R', new UnificationEntry(rotor, Draconium),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'W', new UnificationEntry(cableGtQuadruple, SiliconCarbide));

        //  Hyper Core Mk I
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Darmstadtium)
                .input(plate, Orichalcum, 4)
                .input(EMITTER_UHV, 2)
                .input(SENSOR_UHV, 2)
                .input(FIELD_GENERATOR_UHV, 2)
                .input(screw, Dubnium, 16)
                .fluidInputs(Naquadah.getFluid(144))
                .outputs(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getItemVariant(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.HYPER_CORE_MK1))
                .EUt(VA[UHV])
                .duration(1200)
                .buildAndRegister();

        //  Hyper Core Mk II
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Draconium)
                .input(plate, Adamantium, 4)
                .input(EMITTER_UEV, 2)
                .input(SENSOR_UEV, 2)
                .input(FIELD_GENERATOR_UEV, 2)
                .input(screw, Rutherfordium, 16)
                .fluidInputs(Trinium.getFluid(144))
                .outputs(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getItemVariant(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.HYPER_CORE_MK2))
                .EUt(VA[UEV])
                .duration(1200)
                .buildAndRegister();

        //  Hyper Core Mk III
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(plate, Vibranium, 4)
                .input(EMITTER_UIV, 2)
                .input(SENSOR_UIV, 2)
                .input(FIELD_GENERATOR_UIV, 2)
                .input(screw, Livermorium, 16)
                .fluidInputs(Tritanium.getFluid(144))
                .outputs(EPMetablocks.EP_ACTIVE_MULTIBLOCK_CASING.getItemVariant(EPBlockActiveMultiblockCasing.ActiveMultiblockCasingType.HYPER_CORE_MK3))
                .EUt(VA[UIV])
                .duration(1200)
                .buildAndRegister();

        //  Hyper Reactor Mk I
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(LARGE_NAQUADAH_REACTOR)
                .input(frameGt, BlackPlutonium, 4)
                .input(pipeLargeFluid, Lafium, 4)
                .input(ELECTRIC_PUMP_UHV, 16)
                .input(FIELD_GENERATOR_UHV, 16)
                .input(circuit, MarkerMaterials.Tier.UEV, 8)
                .input(NANO_PIC_CHIP, 32)
                .input(rotor, Draconium, 8)
                .input(plate, BlackTitanium, 8)
                .input(stick, Americium, 64)
                .input(spring, YttriumBariumCuprate, 32)
                .input(screw, Dubnium, 32)
                .input(wireGtQuadruple, QuantumAlloy, 16)
                .fluidInputs(Stellite100.getFluid(5760))
                .fluidInputs(Zeron100.getFluid(5760))
                .fluidInputs(Polyetheretherketone.getFluid(2880))
                .fluidInputs(Tritanium.getFluid(1440))
                .output(HYPER_REACTOR_MK1)
                .EUt(VA[UHV])
                .duration(6400)
                .stationResearch(b -> b
                        .researchStack(LARGE_NAQUADAH_REACTOR.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        //  TODO Hyper Reactor Mk II (Require higher fluid pipe and frame...)
        //  TODO Hyper Reactor Mk III (Require higher fluid pipe and frame...)

        //  Industrial Drill
        ModHandler.addShapedRecipe(true, "industrial_drill", INDUSTRIAL_DRILL.getStackForm(),
                "PKP", "CHC", "MMM",
                'P', ELECTRIC_PISTON_UV.getStackForm(),
                'K', new UnificationEntry(cableGtQuadruple, YttriumBariumCuprate),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UHV),
                'H', MetaTileEntities.HULL[UV].getStackForm(),
                'M', ELECTRIC_MOTOR_UV.getStackForm());

        //  Roaster
        ModHandler.addShapedRecipe(true, "roaster", ROASTER.getStackForm(),
                "KSK", "CHC", "PPP",
                'K', new UnificationEntry(cableGtQuadruple, Platinum),
                'S', new UnificationEntry(spring, Tungsten),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'H', MetaTileEntities.HULL[EV].getStackForm(),
                'P', new UnificationEntry(plate, TitaniumCarbide)
        );

        //  Fracker
        ModHandler.addShapedRecipe(true, "fracker", FRACKER.getStackForm(),
                "CLC", "GHG", "PPP",
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.UV),
                'L', new UnificationEntry(pipeLargeFluid, Naquadah),
                'G', new UnificationEntry(gear, NaquadahAlloy),
                'H', MetaTileEntities.HULL[ZPM].getStackForm(),
                'P', ELECTRIC_PUMP_ZPM.getStackForm()
        );

        //  Large Vacuum Chamber
        ModHandler.addShapedRecipe(true, "large_vacuum_chamber", LARGE_VACUUM_CHAMBER.getStackForm(),
                "GXG", "PCQ", "GWG",
                'C', VACUUM_CHAMBER[5].getStackForm(),
                'P', ELECTRIC_PUMP_IV.getStackForm(),
                'Q', FLUID_REGULATOR_IV.getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'W', new UnificationEntry(cableGtSingle, Platinum),
                'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS));

        //  Vacuum Drying Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HastelloyC276)
                .input(VOLTAGE_COIL_LuV, 4)
                .input(ELECTRIC_PISTON_LUV, 8)
                .input(FLUID_REGULATOR_LUV, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 8)
                .input(gear, Rhodium, 8)
                .input(plate, HSSS, 32)
                .input(plateDouble, Ruthenium, 8)
                .input(plateDouble, TitaniumCarbide, 8)
                .input(screw, Platinum, 32)
                .input(wireFine, Naquadah, 64)
                .input(cableGtQuadruple, NiobiumTitanium, 8)
                .fluidInputs(HastelloyX.getFluid(2304))
                .fluidInputs(NaquadahAlloy.getFluid(4608))
                .fluidInputs(Titanium.getFluid(4608))
                .outputs(VACUUM_DRYING_FURNACE.getStackForm())
                .EUt(VA[LuV])
                .duration(3200)
                .scannerResearch(b -> b
                        .researchStack(DRYER[LuV].getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .buildAndRegister();

        //  Plasma Condenser
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, HSSS)
                .input(plate, RhodiumPlatedPalladium, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(ELECTRIC_MOTOR_UV, 4)
                .input(ELECTRIC_PUMP_UV, 4)
                .input(SENSOR_UV, 4)
                .input(gear, TungstenCarbide, 4)
                .input(screw, Inconel792, 16)
                .fluidInputs(SolderingAlloy.getFluid(1440))
                .fluidInputs(BlueSteel.getFluid(2880))
                .fluidInputs(CobaltBrass.getFluid(2880))
                .outputs(PLASMA_CONDENSER.getStackForm())
                .EUt(VA[UV])
                .duration(3000)
                .stationResearch(b -> b
                        .researchStack(VACUUM_FREEZER.getStackForm())
                        .CWUt(30)
                        .EUt(VA[ZPM]))
                .buildAndRegister();

        //  Stellar Containment Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MaragingSteel250)
                .input(plate, Hdcs, 4)
                .inputs(VOLTAGE_COIL_ZPM.getStackForm(4))
                .input(screw, IncoloyMA813, 16)
                .fluidInputs(Inconel792.getFluid(576))
                .outputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.STELLAR_CONTAINMENT_CASING, 2))
                .EUt(VA[UEV])
                .duration(50)
                .buildAndRegister();

        //  Stellar Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Hdcs, 16)
                .inputs(VOLTAGE_COIL_UV.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.UEV, 8)
                .input(plate, IncoloyMA813, 4)
                .input(plateDouble, IncoloyMA956, 4)
                .input(gear, Tritanium, 4)
                .input(gearSmall, Tritanium, 6)
                .input(screw, Adamantium, 32)
                .input(wireFine, Abyssalloy, 64)
                .input(wireFine, Abyssalloy, 64)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Lubricant.getFluid(5760))
                .fluidInputs(Seaborgium.getFluid(L * 2))
                .outputs(STELLAR_FURNACE.getStackForm())
                .stationResearch(b -> b
                        .researchStack(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.STELLAR_CONTAINMENT_CASING))
                        .CWUt(128)
                        .EUt(VA[UEV]))
                .EUt(VA[UEV])
                .duration(3000)
                .buildAndRegister();

        //  Blazing Blast Furnace
        ModHandler.addShapedRecipe(true, "blazing_blast_furnace", BLAZING_BLAST_FURNACE.getStackForm(),
                "GXG", "RHR", "PWP",
                'G', new UnificationEntry(gear, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', ELECTRIC_BLAST_FURNACE.getStackForm(),
                'R', ROBOT_ARM_IV.getStackForm(),
                'P', new UnificationEntry(plate, AusteniticStainlessSteel904L),
                'W', VOLTAGE_COIL_IV.getStackForm());

        //  Cryogenic Freezer
        ModHandler.addShapedRecipe(true, "cryogenic_freezer", CRYOGENIC_FREEZER.getStackForm(),
                "SXS", "EHE", "PWP",
                'S', new UnificationEntry(spring, HSSG),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'H', VACUUM_FREEZER.getStackForm(),
                'E', ELECTRIC_PUMP_IV.getStackForm(),
                'P', new UnificationEntry(plate, TanmolyiumBetaC),
                'W', new UnificationEntry(cableGtSingle, Platinum));

        //  Fermentation Tank
        ModHandler.addShapedRecipe(true, "fermentation_tank", FERMENTATION_TANK.getStackForm(),
                "GPG", "SHS", "WOW",
                'H', FERMENTER[LuV].getStackForm(),
                'S', new UnificationEntry(spring, Naquadah),
                'G', MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS),
                'P', ELECTRIC_PUMP_LuV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, NiobiumTitanium),
                'O', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV));

        //  Mega Alloy Blast Furnace
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, AusteniticStainlessSteel904L, 4)
                .inputs(ALLOY_BLAST_SMELTER.getStackForm(16))
                .input(circuit, MarkerMaterials.Tier.LuV, 16)
                .input(plateDouble, HMS1J79Alloy, 4)
                .input(plateDouble, HastelloyC59, 4)
                .input(gear, HY1301, 4)
                .input(gearSmall, TanmolyiumBetaC, 16)
                .input(wireGtQuadruple, NiobiumTitanium, 4)
                .fluidInputs(SolderingAlloy.getFluid(5760))
                .fluidInputs(Inconel792.getFluid(2880))
                .fluidInputs(MARM200CeSteel.getFluid(1440))
                .fluidInputs(Lubricant.getFluid(3000))
                .outputs(MEGA_ALLOY_BLAST_SMELTER.getStackForm())
                .scannerResearch(b -> b
                        .researchStack(ALLOY_BLAST_SMELTER.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Universal Processing Unit
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MaragingSteel250)
                .input(FIELD_GENERATOR_LuV, 2)
                .inputs(COMPRESSOR[LuV].getStackForm())
                .inputs(LATHE[LuV].getStackForm())
                .inputs(POLARIZER[LuV].getStackForm())
                .inputs(FERMENTER[LuV].getStackForm())
                .inputs(EXTRACTOR[LuV].getStackForm())
                .inputs(CANNER[LuV].getStackForm())
                .inputs(LASER_ENGRAVER[LuV].getStackForm())
                .inputs(AUTOCLAVE[LuV].getStackForm())
                .inputs(FLUID_SOLIDIFIER[LuV].getStackForm())
                .input(plate, HSSS, 4)
                .input(cableGtQuadruple, Platinum, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Osmiridium.getFluid(L * 16))
                .fluidInputs(VanadiumGallium.getFluid(L * 8))
                .outputs(GENERAL_PROCESSING_PLANT.getStackForm())
                .scannerResearch(b -> b
                        .researchStack(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.GENERAL_PROCESSING_CASING))
                        .EUt(IV)
                        .duration(3600))
                .EUt(VA[LuV])
                .duration(6000)
                .buildAndRegister();

        //  Mega Steam Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(LARGE_STEAM_TURBINE.getStackForm())
                .input(plate, WatertightSteel, 8)
                .input(circuit, MarkerMaterials.Tier.LuV, 4)
                .input(ELECTRIC_PUMP_IV, 2)
                .input(FLUID_REGULATOR_IV, 2)
                .input(gear, TanmolyiumBetaC, 4)
                .input(screw, MARM200Steel, 16)
                .fluidInputs(BlueSteel.getFluid(576))
                .outputs(MEGA_STEAM_TURBINE.getStackForm())
                .EUt(VA[IV])
                .duration(1200)
                .buildAndRegister();

        //  Mega Gas Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(LARGE_GAS_TURBINE.getStackForm())
                .input(plate, TantalumCarbide, 8)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(ELECTRIC_PUMP_LuV, 2)
                .input(FLUID_REGULATOR_LUV, 2)
                .input(rotor, Staballoy, 4)
                .input(screw, IncoloyMA813, 16)
                .fluidInputs(Naquadah.getFluid(576))
                .outputs(MEGA_GAS_TURBINE.getStackForm())
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Mega Plasma Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(LARGE_PLASMA_TURBINE.getStackForm())
                .input(plate, HMS1J79Alloy, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FLUID_REGULATOR_ZPM, 2)
                .input(spring, Pikyonium64B, 4)
                .input(screw, Trinium, 16)
                .outputs(MEGA_PLASMA_TURBINE.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Precise Assembler
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(LARGE_ASSEMBLER.getStackForm())
                .input(frameGt, MARM200Steel, 4)
                .input(ROBOT_ARM_IV, 2)
                .input(CONVEYOR_MODULE_IV, 2)
                .input(plate, Stellite100, 4)
                .input(gear, TanmolyiumBetaC, 8)
                .input(cableGtQuadruple, Naquadah, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 6))
                .fluidInputs(Lubricant.getFluid(3000))
                .fluidInputs(HastelloyN.getFluid(L * 2))
                .outputs(PRECISE_ASSEMBLER.getStackForm())
                .scannerResearch(b -> b
                        .researchStack(LARGE_ASSEMBLER.getStackForm())
                        .EUt(VA[IV])
                        .duration(1200))
                .EUt(VA[LuV])
                .duration(1200)
                .buildAndRegister();

        //  Component Assembly Line
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(ASSEMBLY_LINE.getStackForm())
                .input(frameGt, Cinobite, 4)
                .inputs(PRECISE_ASSEMBLER.getStackForm(4))
                .inputs(COMPONENT_ASSEMBLER[IV].getStackForm(16))
                .input(ROBOT_ARM_UV, 4)
                .input(CONVEYOR_MODULE_UV, 4)
                .input(plateDouble, IncoloyMA813, 8)
                .input(plateDouble, Pikyonium64B, 4)
                .input(gear, TitanSteel)
                .input(gearSmall, TitanSteel, 3)
                .input(wireGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(Lubricant.getFluid(16000))
                .outputs(COMPONENT_ASSEMBLY_LINE.getStackForm())
                .EUt(VA[UV])
                .duration(1200)
                .stationResearch(b -> b
                        .researchStack(COMPONENT_ASSEMBLER[IV].getStackForm())
                        .CWUt(32)
                        .EUt(VA[UV]))
                .buildAndRegister();

        //  TODO Large Circuit Assembly Line

        //  Cyclotron
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, MARM200Steel)
                .inputs(EPMetablocks.EP_MULTIBLOCK_CASING_B.getItemVariant(EPBlockMultiblockCasingB.CasingType.CYCLOTRON_CASING, 2))
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(plate, Pikyonium64B, 4)
                .input(FIELD_GENERATOR_ZPM, 4)
                .inputs(NEUTRON_REFLECTOR.getStackForm(2))
                .input(cableGtQuadruple, VanadiumGallium, 2)
                .fluidInputs(HY1301.getFluid(L * 4))
                .outputs(CYCLOTRON.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

        //  Dissolution Tank
        ModHandler.addShapedRecipe(true, "dissolution_tank", DISSOLUTION_TANK.getStackForm(),
                "WSW", "PHP", "WDW",
                'H', HULL[EV].getStackForm(),
                'D', TUNGSTENSTEEL_DRUM.getStackForm(),
                'P', ELECTRIC_PUMP_EV.getStackForm(),
                'S', new UnificationEntry(spring, TungstenSteel),
                'W', new UnificationEntry(cableGtSingle, Tungsten));

        //  Digester
        ModHandler.addShapedRecipe(true, "digester", DIGESTER.getStackForm(),
                "WXW", "PHP", "WCW",
                'H', HULL[EV].getStackForm(),
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.EV),
                'C', VOLTAGE_COIL_EV.getStackForm(),
                'W', new UnificationEntry(cableGtSingle, Tungsten),
                'P', ELECTRIC_PUMP_EV.getStackForm());

        //  Supercritical Steam Turbine
        ModHandler.addShapedRecipe(true, "supercritical_steam_turbine", SUPERCRITICAL_STEAM_TURBINE.getStackForm(),
                "XPX", "GHG", "FPF",
                'X', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'P', new UnificationEntry(plate, MARM200CeSteel),
                'G', new UnificationEntry(gear, TungstenCarbide),
                'H', HULL[LuV].getStackForm(),
                'F', new UnificationEntry(pipeLargeFluid, Inconel792));

        //  Mega Supercritical Steam Turbine
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(SUPERCRITICAL_STEAM_TURBINE.getStackForm())
                .input(plate, IncoloyMA813, 4)
                .input(plate, Pikyonium64B, 4)
                .input(circuit, MarkerMaterials.Tier.ZPM, 8)
                .input(ELECTRIC_PUMP_ZPM, 2)
                .input(FLUID_REGULATOR_ZPM, 2)
                .input(gear, HY1301, 4)
                .input(screw, Tantalloy61, 16)
                .fluidInputs(HMS1J79Alloy.getFluid(L * 4))
                .outputs(MEGA_SUPERCRITICAL_STEAM_TURBINE.getStackForm())
                .EUt(VA[ZPM])
                .duration(1200)
                .buildAndRegister();

    }

    private static void GCYMOverrideRecipes() {

        //  FIXME If add Mega EBF and VF, should bring it to UV or ZPM...
        //  GCYM Nerf
        ModHandler.removeRecipeByName("gcym:mega_blast_furnace");
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium, 4)
                .input(BLAZING_BLAST_FURNACE, 16)
                .input(FIELD_GENERATOR_UHV, 4)
                .input(VOLTAGE_COIL_UV, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .input(plate, Draconium, 16)
                .input(plateDouble, Vibranium, 16)
                .input(plateDouble, TitaniumTungstenCarbide, 16)
                .input(cableGtHex, SiliconCarbide, 16)
                .fluidInputs(IncoloyMA956.getFluid(5760))
                .fluidInputs(HastelloyC276.getFluid(5760))
                .fluidInputs(Naquadria.getFluid(1440))
                .output(MEGA_BLAST_FURNACE)
                .EUt(VA[UHV])
                .duration(3600)
                .stationResearch(b -> b
                        .researchStack(BLAZING_BLAST_FURNACE.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();

        ModHandler.removeRecipeByName("gcym:mega_vacuum_freezer");
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Orichalcum, 4)
                .input(CRYOGENIC_FREEZER, 4)
                .input(FIELD_GENERATOR_UHV, 4)
                .input(VOLTAGE_COIL_UV, 4)
                .input(circuit, MarkerMaterials.Tier.UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UV, 16)
                .input(plate, Draconium, 16)
                .input(plateDouble, Taranium, 16)
                .input(plateDouble, WatertightSteel, 16)
                .input(cableGtHex, SiliconCarbide, 16)
                .fluidInputs(HastelloyX.getFluid(5760))
                .fluidInputs(MaragingSteel300.getFluid(2880))
                .fluidInputs(Trinium.getFluid(1440))
                .output(MEGA_VACUUM_FREEZER)
                .EUt(VA[UHV])
                .duration(3600)
                .stationResearch(b -> b
                        .researchStack(CRYOGENIC_FREEZER.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV]))
                .buildAndRegister();
    }
}
