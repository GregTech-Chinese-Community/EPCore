package cn.gtcommunity.epimorphism.api;

import cn.gtcommunity.epimorphism.api.block.ITier;
import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTier;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedTierWithMeta;
import cn.gtcommunity.epimorphism.common.blocks.*;
import gregtech.common.blocks.*;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

import java.util.Arrays;
import java.util.stream.Collectors;

import static gregtech.api.GregTechAPI.HEATING_COILS;

public class EPAPI {
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_GLASS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_GLASS_SHAPE_INFO = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_MACHINE_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_CP_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_CP_TUBE = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_PA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_PA_INTERNAL_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_CA_TIRED_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_QFT_MANIPULATOR = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_QFT_SHIELDING_CORE = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ITier> MAP_QFT_GLASS = new Object2ObjectOpenHashMap<>();

    public static void APIBlockInit() {
        //  HEATING_COILS Addition
        for (EPBlockWireCoil.CoilType type : EPBlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(EPMetablocks.EP_WIRE_COIL.getState(type), type);
        }

        //  EP_GLASS Init
        for (BlockGlassCasing.CasingType type : BlockGlassCasing.CasingType.values()) {
            MAP_GLASS.put(MetaBlocks.TRANSPARENT_CASING.getState(type), (ITierGlassBlockState)((Object)type));
        }
        for (EPBlockGlassCasing.CasingType type : EPBlockGlassCasing.CasingType.values()) {
            MAP_GLASS.put(EPMetablocks.EP_GLASS_CASING.getState(type), type);
        }
        for (EPBlockPMMACasing.CasingType type : EPBlockPMMACasing.CasingType.values()) {
            MAP_GLASS.put(EPMetablocks.EP_PMMA_CASING.getState(type), type);
        }
        for (EPBlockTransparentCasing.TransparentCasingType type : EPBlockTransparentCasing.TransparentCasingType.values()) {
            MAP_GLASS.put(EPMetablocks.EP_TRANSPARENT_CASING.getState(type), type);
        }
        for (EPBlockGlassCasingB.GlassType type : EPBlockGlassCasingB.GlassType.values()) {
            MAP_GLASS.put(EPMetablocks.EP_GLASS_CASING_B.getState(type), type);
        }
        MAP_GLASS.put(Blocks.GLASS.getDefaultState(), (ITierGlassBlockState) Blocks.GLASS);

        MAP_GLASS_SHAPE_INFO.putAll(MAP_GLASS);

        for (EnumDyeColor enumdyecolor : EnumDyeColor.values()) {
            MAP_GLASS.put(Blocks.STAINED_GLASS.getStateFromMeta(enumdyecolor.getMetadata()), new WrappedTierWithMeta((ITierGlassBlockState) Blocks.STAINED_GLASS, enumdyecolor.getMetadata()));
        }


        //  MAP_MACHINE_CASING Init
        for (BlockMachineCasing.MachineCasingType type : Arrays.stream(BlockMachineCasing.MachineCasingType.values()).filter((c)-> c.ordinal()<10).collect(Collectors.toList())) {
            MAP_MACHINE_CASING.put(MetaBlocks.MACHINE_CASING.getState(type),new WrappedIntTier(type,type.ordinal()));
        }

        //  MAP_CP_CASING Init
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS,1));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.STEEL_SOLID,2));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF,3));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN,4));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE,5));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST),
                new WrappedIntTier(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST,6));

        //  MAP_CP_TUBE Init
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE),
                new WrappedIntTier(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,1));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE),
                new WrappedIntTier(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE,2));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE),
                new WrappedIntTier(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,5));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE),
                new WrappedIntTier(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE,6));

        //  MAP_PA_CASING Init
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1),
                new WrappedIntTier(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1, 1));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2),
                new WrappedIntTier(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2, 2));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3),
                new WrappedIntTier(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3, 3));

        //  MAP_PA_INTERNAL_CASING Init
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTier(BlockMachineCasing.MachineCasingType.UV, 3));

        //  MAP_CA_TIRED_CASING Init
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.LV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.LV, 1));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.MV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.MV, 2));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.HV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.HV, 3));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.EV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.EV, 4));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.IV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.IV, 5));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.LuV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.LuV, 6));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM, 7));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.UV, 8));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UHV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.UHV, 9));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UEV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.UEV, 10));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UIV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.UIV, 11));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UXV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.UXV, 12));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.OpV),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.OpV, 13));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.MAX),
                new WrappedIntTier(EPBlockComponentAssemblyLineCasing.CasingTier.MAX, 14));

        //  MAP_QFT_MANIPULATOR Init
        MAP_QFT_MANIPULATOR.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_PULSE_MANIPULATOR_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_PULSE_MANIPULATOR_CASING, 1));
        MAP_QFT_MANIPULATOR.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_MANIPULATOR_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_MANIPULATOR_CASING, 2));
        MAP_QFT_MANIPULATOR.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_MANIPULATOR_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_MANIPULATOR_CASING, 3));
        MAP_QFT_MANIPULATOR.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.SUPRACAUSAL_CONTINUUM_MANIPULATOR_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.SUPRACAUSAL_CONTINUUM_MANIPULATOR_CASING, 4));

        //  MAP_QFT_SHIELDING_CORE Init
        MAP_QFT_SHIELDING_CORE.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_SHIELDING_CORE_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.NEUTRON_SHIELDING_CORE_CASING, 1));
        MAP_QFT_SHIELDING_CORE.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_SHIELDING_CORE_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.COSMIC_FABRIC_SHIELDING_CORE_CASING, 2));
        MAP_QFT_SHIELDING_CORE.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_SHIELDING_CORE_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.INFINITY_INFUSED_SHIELDING_CORE_CASING, 3));
        MAP_QFT_SHIELDING_CORE.put(EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.SUPRACAUSAL_CONTINUUM_SHIELDING_CORE_CASING),
                new WrappedIntTier(EPBlockQuantumForceTransformerCasing.CasingType.SUPRACAUSAL_CONTINUUM_SHIELDING_CORE_CASING, 4));

        //  MAP_QFT_GLASS Init
        MAP_QFT_GLASS.put(EPMetablocks.EP_GLASS_CASING_B.getState(EPBlockGlassCasingB.GlassType.FORCE_FIELD_CONSTRAINED_GLASS),
                new WrappedIntTier(EPBlockGlassCasingB.GlassType.FORCE_FIELD_CONSTRAINED_GLASS, 1));
        MAP_QFT_GLASS.put(EPMetablocks.EP_GLASS_CASING_B.getState(EPBlockGlassCasingB.GlassType.COSMIC_MICROWAVE_BACKGROUND_RADIATION_ABSORPTION_GLASS),
                new WrappedIntTier(EPBlockGlassCasingB.GlassType.COSMIC_MICROWAVE_BACKGROUND_RADIATION_ABSORPTION_GLASS, 2));
        MAP_QFT_GLASS.put(EPMetablocks.EP_GLASS_CASING_B.getState(EPBlockGlassCasingB.GlassType.SPACETIME_SUPERCONDENSER_GLASS),
                new WrappedIntTier(EPBlockGlassCasingB.GlassType.SPACETIME_SUPERCONDENSER_GLASS, 3));
        MAP_QFT_GLASS.put(EPMetablocks.EP_GLASS_CASING_B.getState(EPBlockGlassCasingB.GlassType.SUPRACAUSAL_LIGHT_CONE_GLASS),
                new WrappedIntTier(EPBlockGlassCasingB.GlassType.SUPRACAUSAL_LIGHT_CONE_GLASS, 4));
    }
}
