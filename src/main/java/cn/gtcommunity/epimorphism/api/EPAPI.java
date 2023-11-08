package cn.gtcommunity.epimorphism.api;

import cn.gtcommunity.epimorphism.api.block.ICasingTierBlockState;
import cn.gtcommunity.epimorphism.api.block.IGlassTierBlockState;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTired;
import cn.gtcommunity.epimorphism.common.blocks.*;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;

import java.util.Arrays;
import java.util.stream.Collectors;

import static gregtech.api.GregTechAPI.HEATING_COILS;


public class EPAPI {
    public static final Object2ObjectMap<IBlockState, IGlassTierBlockState> EP_Glass = new Object2ObjectOpenHashMap<>();
//    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_ESSENTIA_CELLS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_MACHINE_CASING = new Object2ObjectOpenHashMap<>();
//    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_GLASS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_CP_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_CP_TUBE = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_PA_CASING = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> MAP_PA_INTERNAL_CASING = new Object2ObjectOpenHashMap<>();

    public static void APIBlockInit() {
        for (EPBlockGlassCasing.CasingType type : EPBlockGlassCasing.CasingType.values()) {
            if (!type.isOpticalGlass()) {
                EP_Glass.put(EPMetablocks.EP_GLASS_CASING.getState(type), type);
            }
        }
        for (EPBlockPMMACasing.CasingType type : EPBlockPMMACasing.CasingType.values()) {
            EP_Glass.put(EPMetablocks.EP_PMMA_CASING.getState(type), type);
        }
        for (BlockMachineCasing.MachineCasingType type : Arrays.stream(BlockMachineCasing.MachineCasingType.values()).filter((c)-> c.ordinal()<10).collect(Collectors.toList())) {
            MAP_MACHINE_CASING.put(MetaBlocks.MACHINE_CASING.getState(type),new WrappedIntTired(type,type.ordinal()));
        }

        for (EPBlockWireCoil.CoilType type : EPBlockWireCoil.CoilType.values()) {
            HEATING_COILS.put(EPMetablocks.EP_WIRE_COIL.getState(type), type);
        }

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

        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,1));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE,2));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,5));
        MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE,6));

        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK1, 1));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK2, 2));
        MAP_PA_CASING.put(EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3),
                new WrappedIntTired(EPBlockMultiblockCasingB.CasingType.PRECISE_ASSEMBLER_CASING_MK3, 3));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.LuV, 1));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.ZPM, 2));
        MAP_PA_INTERNAL_CASING.put(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV),
                new WrappedIntTired(BlockMachineCasing.MachineCasingType.UV, 3));

    }
}
