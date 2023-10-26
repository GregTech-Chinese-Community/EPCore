package cn.gtcommunity.epimorphism.loaders.recipe.multiblocks;

import cn.gtcommunity.epimorphism.common.blocks.EPBlockMillCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;

import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import gregtech.api.recipes.ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static cn.gtcommunity.epimorphism.api.unification.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities.*;
import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregicality.multiblocks.common.metatileentities.GCYMMetaTileEntities.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class MetaTileEntityRecipes {
    public static void init() {
        //  UHV Hull
        ModHandler.removeRecipeByName("gregtech:casing_uhv");
        ModHandler.addShapedRecipe(true, "epimorphism:casing_uhv", MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UHV),
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

        //  UEV Hull
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

        //  Dryer recipes
        MetaTileEntityLoader.registerMachineRecipe(true, DRYER,
                "WCW", "SHS", "WCW",
                'W', CraftingComponent.CABLE,
                'C', CraftingComponent.CIRCUIT,
                'S', CraftingComponent.SPRING,
                'H', CraftingComponent.HULL
        );

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
                .EUt(30720)
                .duration(12000)
                .research(b -> b
                        .researchStack(LARGE_MACERATOR.getStackForm())
                        .CWUt(30)
                        .EUt(VA[LuV])
                        .duration(12000))
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
                .EUt(30720)
                .duration(12000)
                .research(b -> b
                        .researchStack(LARGE_DISTILLERY.getStackForm())
                        .CWUt(30)
                        .EUt(VA[LuV])
                        .duration(12000))
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
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Adamantium)
                .inputs(MetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.FUSION_GLASS, 16))
                .input(ELECTRIC_PISTON_UHV, 8)
                .input(EMITTER_UHV, 8)
                .input(ELECTRIC_PUMP_UHV, 8)
                .input(circuit, MarkerMaterials.Tier.UHV, 4)
                .input(circuit, MarkerMaterials.Tier.UV, 8)
                .input(plate, HSSS, 16)
                .input(plateDouble, TitaniumTungstenCarbide, 32)
                .input(plateDouble, HSLASteel, 32)
                .input(wireFine, YttriumBariumCuprate, 64)
                .input(wireFine, YttriumBariumCuprate, 64)
                .input(cableGtQuadruple, SiliconCarbide, 4)
                .fluidInputs(Orichalcum.getFluid(5760))
                .fluidInputs(Zeron100.getFluid(5760))
                .fluidInputs(PolychlorinatedBiphenyl.getFluid(2880))
                .output(ION_IMPLANTATER)
                .EUt(VA[UV])
                .duration(6400)
                .research(b -> b
                        .researchStack(LARGE_ENGRAVER.getStackForm())
                        .CWUt(64)
                        .EUt(VA[UV])
                        .duration(12800))
                .buildAndRegister();

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
                .research(b -> b
                        .researchStack(BLAZING_BLAST_FURNACE.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(24000))
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
                .research(b -> b
                        .researchStack(CRYOGENIC_FREEZER.getStackForm())
                        .CWUt(128)
                        .EUt(VA[UHV])
                        .duration(24000))
                .buildAndRegister();
    }
}
