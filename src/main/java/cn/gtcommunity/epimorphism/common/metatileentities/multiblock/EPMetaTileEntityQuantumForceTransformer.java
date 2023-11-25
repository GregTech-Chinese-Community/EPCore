package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.EPAPI;
import cn.gtcommunity.epimorphism.api.block.impl.WrappedIntTier;
import cn.gtcommunity.epimorphism.api.capability.EPDataCode;
import cn.gtcommunity.epimorphism.api.pattern.EPTraceabilityPredicate;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.api.utils.EPUniverUtil;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockQuantumForceTransformerCasing;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import cn.gtcommunity.epimorphism.common.metatileentities.EPMetaTileEntities;
import gregtech.api.metatileentity.IFastRenderMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.MultiblockShapeInfo;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.shader.postprocessing.BloomEffect;
import gregtech.client.utils.BloomEffectUtil;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static gregtech.api.GTValues.*;

public class EPMetaTileEntityQuantumForceTransformer extends RecipeMapMultiblockController implements IFastRenderMetaTileEntity {

    private int ManipulatorCasingTier;
    private int ShieldingCoreCasingTier;
    private int GlassTier;
    private int tier;
    private static boolean init = false;
    private static List<IBlockState> finalListManipulatorCasing;
    private static List<IBlockState> finalListShieldingCoreCasing;
    private static List<IBlockState> finalListGlass;

    public EPMetaTileEntityQuantumForceTransformer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.QUANTUM_FORCE_TRANSFORMER_RECIPES);
        initMap();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new EPMetaTileEntityQuantumForceTransformer(metaTileEntityId);
    }

    private void initMap() {
        if (init) return;

        List<IBlockState> ListManipulatorCasing = EPAPI.MAP_QFT_MANIPULATOR.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<IBlockState> ListShieldingCoreCasing = EPAPI.MAP_QFT_SHIELDING_CORE.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<IBlockState> ListGlass = EPAPI.MAP_QFT_GLASS.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> ((WrappedIntTier) entry.getValue()).getIntTier()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int maxLeng = EPUniverUtil.maxLength(new ArrayList<List<IBlockState>>() {{
            add(ListManipulatorCasing);
            add(ListShieldingCoreCasing);
            add(ListGlass);
        }});

        finalListManipulatorCasing = EPUniverUtil.consistentList(ListManipulatorCasing, maxLeng);
        finalListShieldingCoreCasing = EPUniverUtil.consistentList(ListShieldingCoreCasing, maxLeng);
        finalListGlass = EPUniverUtil.consistentList(ListGlass, maxLeng);

        init = true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object ManipulatorCasingTier = context.get("QFTManipulatorCasingTieredStats");
        Object ShieldingCoreCasingTier = context.get("QFTShieldingCoreCasingTieredStats");
        Object GlassTier = context.get("QFTGlassTieredStats");

        this.ManipulatorCasingTier = EPUniverUtil.getOrDefault(() -> ManipulatorCasingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) ManipulatorCasingTier).getIntTier(), 0);
        this.ShieldingCoreCasingTier = EPUniverUtil.getOrDefault(() -> ShieldingCoreCasingTier instanceof WrappedIntTier,
                () -> ((WrappedIntTier) ShieldingCoreCasingTier).getIntTier(), 0);
        this.GlassTier = EPUniverUtil.getOrDefault(() -> GlassTier instanceof  WrappedIntTier,
                () -> ((WrappedIntTier) GlassTier).getIntTier(), 0);

        this.tier = this.ManipulatorCasingTier = this.ShieldingCoreCasingTier = this.GlassTier;

        this.writeCustomData(EPDataCode.EP_CHANNEL_8, buf -> buf.writeInt(this.ManipulatorCasingTier));
    }

    @Override
    public void update() {
        super.update();

        if (this.getWorld().isRemote && this.ManipulatorCasingTier == 0) {
            this.writeCustomData(EPDataCode.EP_CHANNEL_9, buf -> {});
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("    A     A    ", "    A     A    ", "    A     A    ", "   BA     AB   ", "   BABBABBAB   ", "   BAAAAAAAB   ", "   BBBBABBBB   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", "  A         A  ", "  A         A  ", "  B         B  ", "  BAAAAAAAAAB  ", "   AAABBBAAA   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", " A           A ", " A           A ", " B           B ", " BAA       AAB ", "  AA       AA  ", "    AA   AA    ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("A             A", "A             A", "A             A", "A             A", "A             A", "B             B", "BAA         AAB", " AA         AA ", "   AA     AA   ", "     BAAAB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("      HHH      ", "      EEE      ", "      EEE      ", "      EEE      ", "B     DDD     B", "B     EEE     B", "BA    DDD    AB", " A    EEE    A ", "  AA  EEE  AA  ", "    BAEEEAB    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "B    D   D    B", "B    ECCCE    B", "BA   D   D   AB", " A   ECCCE   A ", "  A  ECCCE  A  ", "   BAECCCEAB   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "A   EC   CE   A", "A   EC   CE   A", "A   D     D   A", "A   EC   CE   A", "BA  D     D  AB", "BB  EC   CE  BB", " B  EC   CE  B ", "  BAEC   CEAB  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "A   D     D   A", "A   EC   CE   A", "AA  D     D  AA", "AB  EC   CE  BA", " A  EC   CE  A ", "  AAEC   CEAA  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "A   EC   CE   A", "A   D     D   A", "A   EC   CE   A", "BA  D     D  AB", "BB  EC   CE  BB", " B  EC   CE  B ", "  BAEC   CEAB  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    HHHHHHH    ")
                .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "B    D   D    B", "B    ECCCE    B", "BA   D   D   AB", " A   ECCCE   A ", "  A  ECCCE  A  ", "   BAECCCEAB   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     HHHHH     ")
                .aisle("      HSH      ", "      EEE      ", "      EEE      ", "      EEE      ", "B     DDD     B", "B     EEE     B", "BA    DDD    AB", " A    EEE    A ", "  AA  EEE  AA  ", "    BAEEEAB    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      HHH      ")
                .aisle("A             A", "A             A", "A             A", "A             A", "A             A", "B             B", "BAA          AB", " AA         AA ", "   AA     AA   ", "     BAAAB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", " A           A ", " A           A ", " B           B ", " BA         AB ", "  AA       AA  ", "    AA   AA    ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("               ", "               ", "               ", "  A         A  ", "  A         A  ", "  B         B  ", "  BAAAAAAAAAB  ", "   AAABBBAAA   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .aisle("    A     A    ", "    A     A    ", "    A     A    ", "   BA     AB   ", "   BABBABBAB   ", "   BAAAAAAAB   ", "   BBBBABBBB   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                .where('S', this.selfPredicate())
                .where('A', EPTraceabilityPredicate.EP_QFT_MANIPULATOR.get())
                .where('B', EPTraceabilityPredicate.EP_QFT_SHIELDING_CORE.get())
                .where('C', states(getCoilState()))
                .where('D', states(getCasingState()))
                .where('E', EPTraceabilityPredicate.EP_QFT_GLASS.get())
                .where('H', states(getCasingState())
                        .setMinGlobalLimited(55)
                        .or(autoAbilities()))
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.QUANTUM_CONSTRAINT_CASING);
    }


    private IBlockState getCoilState() {
        return EPMetablocks.EP_QUANTUM_FORCE_TRANSFORMER_CASING.getState(EPBlockQuantumForceTransformerCasing.CasingType.QUANTUM_FORCE_TRANSFORMER_COIL);
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return EPTextures.CHEMICAL_PLANT_OVERLAY;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.QUANTUM_CONSTRAINT_CASING;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.quantum_force_transformer.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.quantum_force_transformer.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.quantum_force_transformer.tooltip.3"));
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        ArrayList<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
        MultiblockShapeInfo.Builder builder = null;
        if (Blocks.AIR != null) {
            builder = MultiblockShapeInfo.builder()
                    .aisle("    A     A    ", "    A     A    ", "    A     A    ", "   BA     AB   ", "   BABBABBAB   ", "   BAAAAAAAB   ", "   BBBBABBBB   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", "  A         A  ", "  A         A  ", "  B         B  ", "  BAAAAAAAAAB  ", "   AAABBBAAA   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", " A           A ", " A           A ", " B           B ", " BAA       AAB ", "  AA       AA  ", "    AA   AA    ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("A             A", "A             A", "A             A", "A             A", "A             A", "B             B", "BAA         AAB", " AA         AA ", "   AA     AA   ", "     BAAAB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("      WXH      ", "      EEE      ", "      EEE      ", "      EEE      ", "B     DDD     B", "B     EEE     B", "BA    DDD    AB", " A    EEE    A ", "  AA  EEE  AA  ", "    BAEEEAB    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      TTT      ")
                    .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "B    D   D    B", "B    ECCCE    B", "BA   D   D   AB", " A   ECCCE   A ", "  A  ECCCE  A  ", "   BAECCCEAB   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     TTTTT     ")
                    .aisle("    HHHHHHH    ", "    EC   CE    ", "A   EC   CE   A", "A   EC   CE   A", "A   D     D   A", "A   EC   CE   A", "BA  D     D  AB", "BB  EC   CE  BB", " B  EC   CE  B ", "  BAEC   CEAB  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    TTTTTTT    ")
                    .aisle("    UHHHHHV    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "A   D     D   A", "A   EC   CE   A", "AA  D     D  AA", "AB  EC   CE  BA", " A  EC   CE  A ", "  AAEC   CEAA  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    TTTTTTT    ")
                    .aisle("    HHHHHHH    ", "    EC   CE    ", "    EC   CE    ", "A   EC   CE   A", "A   D     D   A", "A   EC   CE   A", "BA  D     D  AB", "BB  EC   CE  BB", " B  EC   CE  B ", "  BAEC   CEAB  ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    D     D    ", "    EC   CE    ", "    EC   CE    ", "    ECCCCCE    ", "    TTTTTTT    ")
                    .aisle("     HHHHH     ", "     ECCCE     ", "     ECCCE     ", "B    ECCCE    B", "B    D   D    B", "B    ECCCE    B", "BA   D   D   AB", " A   ECCCE   A ", "  A  ECCCE  A  ", "   BAECCCEAB   ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     D   D     ", "     ECCCE     ", "     ECCCE     ", "     ECCCE     ", "     TTTTT     ")
                    .aisle("      YSZ      ", "      EEE      ", "      EEE      ", "      EEE      ", "B     DDD     B", "B     EEE     B", "BA    DDD    AB", " A    EEE    A ", "  AA  EEE  AA  ", "    BAEEEAB    ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      DDD      ", "      EEE      ", "      DDD      ", "      EEE      ", "      EEE      ", "      EEE      ", "      TTT      ")
                    .aisle("A             A", "A             A", "A             A", "A             A", "A             A", "B             B", "BAA          AB", " AA         AA ", "   AA     AA   ", "     BAAAB     ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", " A           A ", " A           A ", " B           B ", " BA         AB ", "  AA       AA  ", "    AA   AA    ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("               ", "               ", "               ", "  A         A  ", "  A         A  ", "  B         B  ", "  BAAAAAAAAAB  ", "   AAABBBAAA   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .aisle("    A     A    ", "    A     A    ", "    A     A    ", "   BA     AB   ", "   BABBABBAB   ", "   BAAAAAAAB   ", "   BBBBABBBB   ", "      BAB      ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .where('S', EPMetaTileEntities.QUANTUM_FORCE_TRANSFORMER, EnumFacing.SOUTH)
                    .where('X', MetaTileEntities.ENERGY_INPUT_HATCH[UHV], EnumFacing.NORTH)
                    .where('Y', MetaTileEntities.FLUID_IMPORT_HATCH[UHV], EnumFacing.SOUTH)
                    .where('Z', MetaTileEntities.FLUID_EXPORT_HATCH[UHV], EnumFacing.SOUTH)
                    .where('U', MetaTileEntities.ITEM_IMPORT_BUS[UHV], EnumFacing.WEST)
                    .where('V', MetaTileEntities.ITEM_EXPORT_BUS[UHV], EnumFacing.EAST)
                    .where('W', MetaTileEntities.MAINTENANCE_HATCH, EnumFacing.NORTH)
                    .where('C', getCoilState())
                    .where('D', getCasingState())
                    .where('H', getCasingState())
                    .where('T', getCasingState())
                    .where(' ', Blocks.AIR.getDefaultState());
        }
        MultiblockShapeInfo.Builder finalBuilder = builder;
        AtomicInteger count = new AtomicInteger();
        finalListManipulatorCasing.stream()
                .map(b -> {
                    if (finalBuilder != null) {
                        finalBuilder.where('A', b);
                        finalBuilder.where('B', finalListShieldingCoreCasing.get(count.get()));
                        finalBuilder.where('E', finalListGlass.get(count.get()));
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
        if (dataId == EPDataCode.EP_CHANNEL_8) {
            this.ManipulatorCasingTier = buf.readInt();
        }
        if (dataId == EPDataCode.EP_CHANNEL_9) {
            this.writeCustomData(EPDataCode.EP_CHANNEL_8, buf1 -> buf1.writeInt(this.ManipulatorCasingTier));
        }
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.ManipulatorCasingTier);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.ManipulatorCasingTier = buf.readInt();
    }

    @SideOnly(Side.CLIENT)
    private void renderForceField(BufferBuilder buffer, double x, double y, double z, int side, double minU, double maxU, double minV, double maxV) {

        switch (side) {
            case 0 -> {
                buffer.pos(x + 3, y, z + 7).tex(maxU, maxV).endVertex();
                buffer.pos(x + 3, y + 4, z + 7).tex(maxU, minV).endVertex();
                buffer.pos(x - 3, y + 4, z + 7).tex(minU, minV).endVertex();
                buffer.pos(x - 3, y, z + 7).tex(minU, maxV).endVertex();
            }
            case 1 -> {
                buffer.pos(x + 7, y, z + 4).tex(maxU, maxV).endVertex();
                buffer.pos(x + 7, y + 4, z + 4).tex(maxU, minV).endVertex();
                buffer.pos(x + 7, y + 4, z - 4).tex(minU, minV).endVertex();
                buffer.pos(x + 7, y, z - 4).tex(minU, maxV).endVertex();
            }
            case 2 -> {
                buffer.pos(x + 3, y, z - 7).tex(maxU, maxV).endVertex();
                buffer.pos(x + 3, y + 4, z - 7).tex(maxU, minV).endVertex();
                buffer.pos(x - 3, y + 4, z - 7).tex(minU, minV).endVertex();
                buffer.pos(x - 3, y, z - 7).tex(minU, maxV).endVertex();
            }
            case 3 -> {
                buffer.pos(x - 7, y, z + 4).tex(maxU, maxV).endVertex();
                buffer.pos(x - 7, y + 4, z + 4).tex(maxU, minV).endVertex();
                buffer.pos(x - 7, y + 4, z - 4).tex(minU, minV).endVertex();
                buffer.pos(x - 7, y, z - 4).tex(minU, maxV).endVertex();
            }
            case 4 -> {
                buffer.pos(x - 3, y, z + 7).tex(maxU, maxV).endVertex();
                buffer.pos(x - 3, y + 4, z + 7).tex(maxU, minV).endVertex();
                buffer.pos(x - 7, y + 4, z + 4).tex(minU, minV).endVertex();
                buffer.pos(x - 7, y, z + 4).tex(minU, maxV).endVertex();
            }
            case 5 -> {
                buffer.pos(x - 3, y, z - 7).tex(maxU, maxV).endVertex();
                buffer.pos(x - 3, y + 4, z - 7).tex(maxU, minV).endVertex();
                buffer.pos(x - 7, y + 4, z - 4).tex(minU, minV).endVertex();
                buffer.pos(x - 7, y, z - 4).tex(minU, maxV).endVertex();
            }
            case 6 -> {
                buffer.pos(x + 3, y, z + 7).tex(maxU, maxV).endVertex();
                buffer.pos(x + 3, y + 4, z + 7).tex(maxU, minV).endVertex();
                buffer.pos(x + 7, y + 4, z + 4).tex(minU, minV).endVertex();
                buffer.pos(x + 7, y, z + 4).tex(minU, maxV).endVertex();
            }
            case 7 -> {
                buffer.pos(x + 3, y, z - 7).tex(maxU, maxV).endVertex();
                buffer.pos(x + 3, y + 4, z - 7).tex(maxU, minV).endVertex();
                buffer.pos(x + 7, y + 4, z - 4).tex(minU, minV).endVertex();
                buffer.pos(x + 7, y, z - 4).tex(minU, maxV).endVertex();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderMetaTileEntity(double x, double y, double z, float partialTicks) {
        TextureAtlasSprite forceField = EPTextures.FORCE_FIELD;
        if (isActive() && MinecraftForgeClient.getRenderPass() == 0) {

            BloomEffectUtil.requestCustomBloom(RENDER_HANDLER, (buffer) -> {
                Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
                if (entity != null) {
                    double minU = forceField.getMinU();
                    double maxU = forceField.getMaxU();
                    double minV = forceField.getMinV();
                    double maxV = forceField.getMaxV();
                    double xBaseOffset = 3 * getFrontFacing().getOpposite().getXOffset();
                    double zBaseOffset = 3 * getFrontFacing().getOpposite().getZOffset();
                    GlStateManager.pushMatrix();
                    GlStateManager.disableCull();
                    GlStateManager.disableAlpha();
                    GlStateManager.enableBlend();
                    Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                    //Center O:  0,  0         1 ------- 8
                    //Corner 1:  7, -2        /           \
                    //Corner 2:  3, -6     2 /             \ 7
                    //Corner 3: -2, -6      |               |
                    //Corner 4: -6, -2      |       O       |
                    //Corner 5: -6,  3      |               |
                    //Corner 6: -2,  7     3 \             / 6
                    //Corner 7:  3,  7        \           /
                    //Corner 8:  7,  3         4 ------- 5
                    buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                    GlStateManager.translate(x + xBaseOffset + 0.5, 0 , z + zBaseOffset + 0.5);
                    if (zBaseOffset == 0) {
                        GlStateManager.rotate(90F, 0F, 1F, 0F);
                    }
                    for (int i = 0; i < 8; i++) {
                        renderForceField(buffer, 0, y, 0, i, minU, maxU, minV, maxV);
                    }
                    Tessellator.getInstance().draw();
                    GlStateManager.disableBlend();
                    GlStateManager.enableAlpha();
                    GlStateManager.enableCull();
                    GlStateManager.popMatrix();
                }
            });
        }
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        double xBaseOffset = 3 * getFrontFacing().getOpposite().getXOffset();
        double zBaseOffset = 3 * getFrontFacing().getOpposite().getZOffset();
        BlockPos pos = new BlockPos(this.getPos().getX() + xBaseOffset + 0.5, this.getPos().getY() , this.getPos().getZ() + zBaseOffset + 0.5);
        return new AxisAlignedBB(pos).grow(6, 6, 6);
    }

    @Override
    public boolean shouldRenderInPass(int pass) {
        return pass == 0;
    }

    @Override
    public boolean isGlobalRenderer() {
        return true;
    }

    static BloomEffectUtil.IBloomRenderFast RENDER_HANDLER = new BloomEffectUtil.IBloomRenderFast() {
        @Override
        public int customBloomStyle() {
            return 2;
        }

        float lastBrightnessX;
        float lastBrightnessY;

        @Override
        @SideOnly(Side.CLIENT)
        public void preDraw(BufferBuilder buffer) {
            BloomEffect.strength = 1.5F;
            BloomEffect.baseBrightness = 0.0F;
            BloomEffect.highBrightnessThreshold = 1.3F;
            BloomEffect.lowBrightnessThreshold = 0.3F;
            BloomEffect.step = 1;

            lastBrightnessX = OpenGlHelper.lastBrightnessX;
            lastBrightnessY = OpenGlHelper.lastBrightnessY;
            GlStateManager.color(1, 1, 1, 1);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void postDraw(BufferBuilder buffer) {
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastBrightnessX, lastBrightnessY);
        }
    };
}
