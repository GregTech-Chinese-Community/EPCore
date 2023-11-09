package cn.gtcommunity.epimorphism.api.pattern.predicates;

import cn.gtcommunity.epimorphism.api.block.ITier;
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

public class TierStateTraceabilityPredicate extends TraceabilityPredicate {
    private final Object2ObjectOpenHashMap<IBlockState, ITier> map;
    private final String name;

    private final String errorKey;

    private Supplier<BlockInfo[]> candidatesCache;

    private final Comparator<IBlockState> comparator;
    private final Predicate<IBlockState> predicate;


    public TierStateTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITier> map, String name, @Nullable String errorKey){
        this(map, Comparator.comparing((s) -> map.get(s).getName()), BlockState -> true, name, errorKey);
    }

    public TierStateTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITier> map, Predicate<IBlockState> predicate, String name, @Nullable String errorKey){
        this(map, Comparator.comparing((s) -> map.get(s).getName()), predicate, name, errorKey);
    }

    public TierStateTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITier> map, Comparator<IBlockState> comparator, Predicate<IBlockState> predicate, String name, @Nullable String errorKey){
        super();
        this.map = map;
        this.name = name;
        if(errorKey == null){
            this.errorKey = "gregtech.multiblock.pattern.error.casing";
        }
        else{
            this.errorKey = errorKey;
            this.addTooltips(this.errorKey);
        }
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;
        this.predicate = predicate;
    }

    private Predicate<BlockWorldState> predicate(){
        return  (blockWorldState) -> {
            IBlockState blockState = blockWorldState.getBlockState();
            if (map.containsKey(blockState)) {
                ITier stats = map.get(blockState);
                Object currentStats = blockWorldState.getMatchContext().getOrPut(name, stats);
                if (!currentStats.equals(stats)) {
                    blockWorldState.setError(new PatternStringError(errorKey));
                    return false;
                } else {
                    blockWorldState.getMatchContext().getOrPut(name + "TiredStats", stats);
                    if (blockState.getBlock() instanceof VariantActiveBlock) {
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
                    .filter(predicate)
                    .sorted(comparator)
                    .map(type -> new BlockInfo(type, null,map.get(type).getInfo()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }
}
