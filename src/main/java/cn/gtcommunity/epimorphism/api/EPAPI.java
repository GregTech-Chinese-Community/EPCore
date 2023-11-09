package cn.gtcommunity.epimorphism.api;

import cn.gtcommunity.epimorphism.api.block.ITier;
import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTired;
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
            MAP_GLASS.put(Blocks.STAINED_GLASS.getStateFromMeta(enumdyecolor.getMetadata()), (ITierGlassBlockState) Blocks.STAINED_GLASS);
        }


        //  MAP_MACHINE_CASING Init
        for (BlockMachineCasing.MachineCasingType type : Arrays.stream(BlockMachineCasing.MachineCasingType.values()).filter((c)-> c.ordinal()<10).collect(Collectors.toList())) {
            MAP_MACHINE_CASING.put(MetaBlocks.MACHINE_CASING.getState(type),new WrappedIntTired(type,type.ordinal()));
        }

        //  MAP_CP_CASING Init
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS,1));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.STEEL_SOLID,2));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF,3));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN,4));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE,5));
        MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST,6));

        //  MAP_CP_TUBE Init
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,1));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE,2));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,5));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE,6));

        //  MAP_PA_CASING Init
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1, 1));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2, 2));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3, 3));

        //  MAP_PA_INTERNAL_CASING Init
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.UV, 3));

        //  MAP_CA_TIRED_CASING Init
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.LV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.LV, 1));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.MV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.MV, 2));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.HV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.HV, 3));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.EV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.EV, 4));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.IV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.IV, 5));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.LuV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.LuV, 6));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.ZPM, 7));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.UV, 8));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UHV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.UHV, 9));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UEV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.UEV, 10));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UIV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.UIV, 11));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.UXV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.UXV, 12));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.OpV),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.OpV, 13));
        MAP_CA_TIRED_CASING.put(EPMetablocks.EP_COMPONENT_ASSEMBLY_LINE_CASING.getState(EPBlockComponentAssemblyLineCasing.CasingTier.MAX),
                new WrappedIntTired(EPBlockComponentAssemblyLineCasing.CasingTier.MAX, 14));
    }
}
