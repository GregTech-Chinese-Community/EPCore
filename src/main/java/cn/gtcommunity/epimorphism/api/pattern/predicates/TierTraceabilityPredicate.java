package cn.gtcommunity.epimorphism.api.pattern.predicates;

import cn.gtcommunity.epimorphism.api.block.ICasingTierBlockState;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.pattern.BlockWorldState;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.state.IBlockState;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TierTraceabilityPredicate extends TraceabilityPredicate {
//    static {
//        MAP_ESSENTIA_CELLS = new Object2ObjectOpenHashMap<>();
//        MAP_MACHINE_CASING = new Object2ObjectOpenHashMap<>();
//        MAP_GLASS = new Object2ObjectOpenHashMap<>();
//        MAP_CP_CASING = new Object2ObjectOpenHashMap<>();
//        MAP_CP_TUBE = new Object2ObjectOpenHashMap<>();
//
//
//        for(GCMetaCells.MetalCellType type : GCMetaCells.MetalCellType.values()){
//            TiredTraceabilityPredicate.MAP_ESSENTIA_CELLS.put(GCMetaBlocks.GC_ESSENTIA_CELLS.getState(type),type);
//        }
//        for(GCMetaGlasses.CasingType type : GCMetaGlasses.CasingType.values()){
//            TiredTraceabilityPredicate.MAP_GLASS.put(GCMetaBlocks.TRANSPARENT_CASING.getState(type),type);
//        }
//        for(GCMetaGlasses1.CasingType type : GCMetaGlasses1.CasingType.values()){
//            TiredTraceabilityPredicate.MAP_GLASS.put(GCMetaBlocks.TRANSPARENT_CASING1.getState(type),type);
//        }
//
//        TiredTraceabilityPredicate.MAP_GLASS.put(Blocks.GLASS.getDefaultState(), (ICasingTierBlockState) Blocks.GLASS);
//        for(int i = 0; i< EnumDyeColor.values().length; i++){
//            IBlockState defaultState = Blocks.STAINED_GLASS.getDefaultState();
//            TiredTraceabilityPredicate.MAP_GLASS.put(defaultState.cycleProperty(BlockStainedGlass.COLOR), (ICasingTierBlockState) Blocks.STAINED_GLASS);
//        }






//    }

//    public static final Object2ObjectOpenHashMap<IBlockState,ICasingTierBlockState> MAP_ESSENTIA_CELLS;
//    public static final Object2ObjectOpenHashMap<IBlockState,ICasingTierBlockState> MAP_MACHINE_CASING;
//    public static final Object2ObjectOpenHashMap<IBlockState,ICasingTierBlockState> MAP_GLASS;
//    public static final Object2ObjectOpenHashMap<IBlockState,ICasingTierBlockState> MAP_CP_CASING;
//    public static final Object2ObjectOpenHashMap<IBlockState,ICasingTierBlockState> MAP_CP_TUBE;


//    public static TraceabilityPredicate MACHINE_CASINGS = new TiredTraceabilityPredicate(MAP_MACHINE_CASING,"MachineCasingType",null);

//    public static TraceabilityPredicate ESSENTIA_CELLS = new TiredTraceabilityPredicate(MAP_ESSENTIA_CELLS,"ESS_CELL","gc.multiblock.pattern.error.essentia")
//            .addTooltips("gc.multiblock.pattern.error.essentia");

//    public static TraceabilityPredicate CP_CASING = new TiredTraceabilityPredicate(MAP_CP_CASING,
//            Comparator.comparing((s) -> ((WrappedIntTired)MAP_CP_CASING.get(s)).getIntTier()),"ChemicalPlantCasing",null);
//    public static TraceabilityPredicate CP_TUBE = new TiredTraceabilityPredicate(MAP_CP_TUBE,
//            Comparator.comparing((s) -> ((WrappedIntTired)MAP_CP_TUBE.get(s)).getIntTier()),"ChemicalPlantTube",null);

//    public static TraceabilityPredicate GLASS = new TiredTraceabilityPredicate(MAP_GLASS,
//            Comparator.comparing((s) -> ((ITiredGlass)MAP_GLASS.get(s)).getGlassTier()),"Glass",null);

    private final Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> map;
    private final String name;

    private final String errorKey;

    private Supplier<BlockInfo[]> candidatesCache;

    private final Comparator<IBlockState> comparator;


    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> map, String name, @Nullable String errorKey){
        this(map,Comparator.comparing((s) -> map.get(s).getName()),name,errorKey);
    }

    public TierTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ICasingTierBlockState> map, Comparator<IBlockState> comparator, String name, @Nullable String errorKey){
        super();
        this.map = map;
        this.name = name;
        if(errorKey == null){
            this.errorKey = "gregtech.multiblock.pattern.error.casing";
        }
        else{
            this.errorKey = errorKey;
        }
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;

    }

    private Predicate<BlockWorldState> predicate(){
        return  (blockWorldState) -> {
            IBlockState blockState = blockWorldState.getBlockState();
            if (map.containsKey(blockState)) {
                ICasingTierBlockState stats = map.get(blockState);
                Object tier = stats.getTire();
                Object current = blockWorldState.getMatchContext().getOrPut(name, tier);
                if (!current.equals(tier)) {
                    blockWorldState.setError(new PatternStringError(errorKey));
                    return false;
                } else {
                    blockWorldState.getMatchContext().getOrPut(name+"TiredStats",stats);
                    if(blockState.getBlock() instanceof VariantActiveBlock){
                        (blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>())).add(blockWorldState.getPos());
                    }
                    return true;
                }
            } else {
                return false;
            }
        };
    }

    private Supplier<BlockInfo[]> candidates(){
        if(candidatesCache == null) {
            candidatesCache = () -> map.keySet().stream()
                    .sorted(comparator)
                    .map(type -> new BlockInfo(type, null,map.get(type).getInfo()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }
}
