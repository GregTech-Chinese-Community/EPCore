package cn.gtcommunity.epimorphism.api.pattern;

import cn.gtcommunity.epimorphism.api.block.ITierGlassBlockState;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTier;
import cn.gtcommunity.epimorphism.api.metatileentity.multiblock.EPMultiblockAbility;
import cn.gtcommunity.epimorphism.api.pattern.predicates.TierStateTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.pattern.predicates.TierTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockFireboxCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static cn.gtcommunity.epimorphism.api.EPAPI.*;

public class EPTraceabilityPredicate {

    //  Same Block State Traceability Predicates
    public static Supplier<TraceabilityPredicate> EP_GLASS = () -> new TierStateTraceabilityPredicate(MAP_GLASS, "Glass", "epimorphism.multiblock.pattern.error.glasses");
    public static Supplier<TraceabilityPredicate> EP_OPTICAL_GLASS = () -> new TierStateTraceabilityPredicate(MAP_GLASS,
            state -> ((ITierGlassBlockState)MAP_GLASS.get(state)).isOpticalGlass(), "Glass", "epimorphism.multiblock.pattern.error.glasses");
    public static Supplier<TraceabilityPredicate> EP_GLASS_NO_OPTICAL = () -> new TierStateTraceabilityPredicate(MAP_GLASS,
            state -> !((ITierGlassBlockState)MAP_GLASS.get(state)).isOpticalGlass(), "Glass", "epimorphism.multiblock.pattern.error.glasses");
    public static Supplier<TraceabilityPredicate> ROTOR_HOLDER = () -> new TraceabilityPredicate(blockWorldState -> {
        TileEntity tileEntity = blockWorldState.getTileEntity();
        if (tileEntity instanceof IGregTechTileEntity) {
            List<ResourceLocation> list = MultiblockAbility.REGISTRY.get(EPMultiblockAbility.REINFORCED_ROTOR_MULTIBLOCK_ABILITY).stream()
                    .map(mte -> mte.metaTileEntityId)
                    .collect(Collectors.toList());
            MetaTileEntity mte = ((IGregTechTileEntity)tileEntity).getMetaTileEntity();
            if (list.contains(mte.metaTileEntityId)) {
                int tier = ((ITieredMetaTileEntity) mte).getTier();
                Object currentTier = blockWorldState.getMatchContext().getOrPut("RotorHolderTier", tier);
                if (!currentTier.equals(tier)) {
                    blockWorldState.setError(new PatternStringError("epimorphism.multiblock.pattern.error.rotor_holder"));
                    return false;
                }
                Set<IMultiblockPart> partsFound = blockWorldState.getMatchContext().getOrCreate("MultiblockParts", HashSet::new);
                partsFound.add((IMultiblockPart) mte);
                return true;
            }
        }
        return false;
    }, () -> MultiblockAbility.REGISTRY.get(EPMultiblockAbility.REINFORCED_ROTOR_MULTIBLOCK_ABILITY).stream()
            .sorted(Comparator.comparingInt(mte -> ((ITieredMetaTileEntity) mte).getTier()))
            .map(mte -> new BlockInfo(MetaBlocks.MACHINE.getDefaultState(), EPUniverUtil.getTileEntity(mte)))
            .toArray(BlockInfo[]::new))
            .addTooltips("epimorphism.multiblock.pattern.error.rotor_holder");

    public static Supplier<TraceabilityPredicate> FIRE_BOX = () -> new TraceabilityPredicate(blockWorldState -> {
            IBlockState blockState = blockWorldState.getBlockState();
            if ((blockState.getBlock() instanceof BlockFireboxCasing BlockFireboxCasing)) {
                BlockFireboxCasing.FireboxCasingType casingType = BlockFireboxCasing.getState(blockState);
                Object currentCasingType = blockWorldState.getMatchContext().getOrPut("CasingType", casingType);
                if (!currentCasingType.toString().equals(casingType.toString())) {
                    blockWorldState.setError(new PatternStringError("epimorphism.multiblock.pattern.error.fire_boxes"));
                    return false;
                }
                blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
                return true;
            }
            return false;
        }, () -> ArrayUtils.addAll(Arrays.stream(BlockFireboxCasing.FireboxCasingType.values())
                .map(type -> new BlockInfo(MetaBlocks.BOILER_FIREBOX_CASING.getState(type), null)).toArray(BlockInfo[]::new)))
                .addTooltips("epimorphism.multiblock.pattern.error.fire_boxes");

    //  Tier Traceability Predicates
    public static Supplier<TierTraceabilityPredicate> EP_MACHINE_CASINGS = () -> new TierTraceabilityPredicate(MAP_MACHINE_CASING,"MachineCasingType",null);
    public static Supplier<TierTraceabilityPredicate> EP_CP_CASING = () -> new TierTraceabilityPredicate(MAP_CP_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier)MAP_CP_CASING.get(s)).getIntTier()),"ChemicalPlantCasing",null);
    public static Supplier<TierTraceabilityPredicate> EP_CP_TUBE = () -> new TierTraceabilityPredicate(MAP_CP_TUBE,
            Comparator.comparing((s) -> ((WrappedIntTier)MAP_CP_TUBE.get(s)).getIntTier()),"ChemicalPlantTube",null);
    public static Supplier<TierTraceabilityPredicate> EP_PA_CASING = () -> new TierTraceabilityPredicate(MAP_PA_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier)MAP_PA_CASING.get(s)).getIntTier()), "PACasing", null);
    public static Supplier<TierTraceabilityPredicate> EP_PA_INTERNAL_CASING = () -> new TierTraceabilityPredicate(MAP_PA_INTERNAL_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier)MAP_PA_INTERNAL_CASING.get(s)).getIntTier()), "PAInternalCasing", null);
    public static Supplier<TierTraceabilityPredicate> EP_CA_TIERED_CASING = () -> new TierTraceabilityPredicate(MAP_CA_TIRED_CASING,
            Comparator.comparing((s) -> ((WrappedIntTier)MAP_CA_TIRED_CASING.get(s)).getIntTier()), "CATieredCasing", null);

    //  Utils
    public static Supplier<BlockInfo[]> getCandidates(IBlockState... allowedStates) {
        return () -> Arrays.stream(allowedStates).map(state -> new BlockInfo(state, null)).toArray(BlockInfo[]::new);
    }
}
