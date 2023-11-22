package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTier;
import cn.gtcommunity.epimorphism.api.capability.EPDataCode;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.unification.EPMaterials;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiMapMultiblockController;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.*;

public class EPMetaTileEntityPreciseAssembler extends MultiMapMultiblockController {

    private int CasingTier;
    private int InternalCasingTier;
    private int tier;

    private static boolean init = false;
    private static List<IBlockState> finalListCasing;
    private static List<IBlockState> finalListInternalCasing;

    public EPMetaTileEntityPreciseAssembler(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{
                RecipeMaps.ASSEMBLER_RECIPES,
                EPRecipeMaps.PRECISE_ASSEMBLER_RECIPES
        });
        this.recipeMapWorkable = new PreciseAssemblerRecipeLogic(this);
        initMap();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityPreciseAssembler(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> ListCasing = EPAPI.MAP_PA_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<IBlockState> ListInternalCasing = EPAPI.MAP_PA_INTERNAL_CASING.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int maxLeng = EPUniverUtil.maxLength(new ArrayList<List<IBlockState>>() {{
            add(ListCasing);
            add(ListInternalCasing);
        }});
        finalListCasing = EPUniverUtil.consistentList(ListCasing, maxLeng);
        finalListInternalCasing = EPUniverUtil.consistentList(ListInternalCasing, maxLeng);

        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object CasingTier = context.get("PACasingTieredStats");
        Object InternalCasingTier = context.get("PAInternalCasingTieredStats");

        this.CasingTier = EPUniverUtil.getOrDefault(() -> CasingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) CasingTier).getIntTier(), 0);
        this.InternalCasingTier = EPUniverUtil.getOrDefault(() -> InternalCasingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) InternalCasingTier).getIntTier(), 0);

        this.tier = this.CasingTier = this.InternalCasingTier;

        this.writeCustomData(EPDataCode.EP_CHANNEL_4, buf -> buf.writeInt(this.CasingTier));
    }

    @Override
    public void update() {
        super.update();

        if (this.getWorld().isRemote && this.CasingTier == 0) {
            this.writeCustomData(EPDataCode.EP_CHANNEL_7, buf -> {});
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("DDDDDDDDD", "F       F", "F       F", "F       F", "DDDDDDDDD")
                .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "DDDDDDDDD")
                .aisle("CMMMMMMMC", "C       C", "C       C", "C       C", "DDDDDDDDD")
                .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "DDDDDDDDD")
                .aisle("DDDDSDDDD", "F       F", "F       F", "F       F", "DDDDDDDDD")
                .where('S', selfPredicate())
                .where('C', EPTraceabilityPredicate.EP_PA_CASING.get())
                .where('D', EPTraceabilityPredicate.EP_PA_CASING.get()
                        .setMinGlobalLimited(42)
                        .or(autoAbilities()))
                .where('F', states(getFrameState()))
                .where('G', states(getGlassState()))
                .where('M', EPTraceabilityPredicate.EP_PA_INTERNAL_CASING.get())
                .build();
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(EPMaterials.MARM200Steel).getBlock(EPMaterials.MARM200Steel);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS);
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.FUSION_REACTOR_OVERLAY;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return switch (this.CasingTier) {
            case (1) -> EPTextures.PRECISE_ASSEMBLER_CASING_MK1;
            case (2) -> EPTextures.PRECISE_ASSEMBLER_CASING_MK2;
            case (3) -> EPTextures.PRECISE_ASSEMBLER_CASING_MK3;
            default -> EPTextures.PRECISE_ASSEMBLER_CASING_MK1;
        };
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("ETCCCCCCC", "F       F", "F       F", "F       F", "XYZCCCCCC")
                    .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "CCCCCCCCC")
                    .aisle("CMMMMMMMC", "C       C", "C       C", "C       C", "CCCCOCCCC")
                    .aisle("CMMMMMMMC", "CGGGGGGGC", "CGGGGGGGC", "CGGGGGGGC", "CCCCCCCCC")
                    .aisle("CCCCSCCCC", "F       F", "F       F", "F       F", "CCCCCCCCC")
                    .where('S', EPMetaTileEntities.PRECISE_ASSEMBLER, EnumFacing.SOUTH)
                    .where('X', MetaTileEntities.ITEM_IMPORT_BUS[LuV], EnumFacing.NORTH)
                    .where('Y', MetaTileEntities.ITEM_EXPORT_BUS[LuV], EnumFacing.NORTH)
                    .where('Z', MetaTileEntities.FLUID_IMPORT_HATCH[LuV], EnumFacing.NORTH)
                    .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[LuV], EnumFacing.NORTH)
                    .where('T', () -> ConfigHolder.machines.enableMaintenance ? MetaTileEntities.MAINTENANCE_HATCH : MetaTileEntities.ENERGY_INPUT_HATCH[LuV], EnumFacing.NORTH)
                    .where('O', MetaTileEntities.MUFFLER_HATCH[LuV], EnumFacing.UP)
                    .where('G', getGlassState())
                    .where('F', getFrameState())
                    .where(' ', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListCasing.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('C', b);
                        finalBuilder.where('M', finalListInternalCasing.get(count.get()));
                        count.getAndIncrement();
                    }
                    return finalBuilder;
                })
                .filter(Objects::nonNull)
                .forEach(b -> shapeInfo.add(b.build()));
        return shapeInfo;
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == EPDataCode.EP_CHANNEL_4) {
            this.CasingTier = buf.readInt();
        }
        if (dataId == EPDataCode.EP_CHANNEL_7) {
            this.writeCustomData(EPDataCode.EP_CHANNEL_4, buf1 -> buf1.writeInt(this.CasingTier));
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.CasingTier);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.CasingTier = buf.readInt();
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.precise_assembler.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.precise_assembler.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.precise_assembler.tooltip.3"));
        tooltip.add(I18n.format("epimorphism.machine.precise_assembler.tooltip.4"));
        tooltip.add(I18n.format("epimorphism.machine.precise_assembler.tooltip.5"));
    }

    protected class PreciseAssemblerRecipeLogic extends MultiblockRecipeLogic {
        public PreciseAssemblerRecipeLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        /**
         * @return Check if machine in PA
         */
        private boolean isPrecise() {
            return this.getRecipeMap() == EPRecipeMaps.PRECISE_ASSEMBLER_RECIPES;
        }

        /**
         * @param maxProgress If machine in common assembler, then get half progress time.
         */
        public void setMaxProgress(int maxProgress) {
            if (isPrecise()) {
                this.maxProgressTime = maxProgress ;
            } else {
                this.maxProgressTime = maxProgress / 2;
            }
        }

        /**
         * @return If machine in PA, then no parallel, if machine in common assembler, then get 2^{CasingTier + 4} (Mk1:32, Mk2:64, Mk3:128) parallel.
         */
        @Override
        public int getParallelLimit() {
           if (isPrecise()) {
               return 1;
           } else {
               return (int) Math.pow(2, CasingTier + 4);
           }
        }
    }
}
