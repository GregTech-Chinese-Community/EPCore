package cn.gtcommunity.epimorphism.common.metatileentities.multiblock;

import cn.gtcommunity.epimorphism.api.recipe.EPRecipeMaps;
import cn.gtcommunity.epimorphism.client.renderer.texture.EPTextures;
import cn.gtcommunity.epimorphism.common.blocks.EPBlockMultiblockCasingB;
import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.IFastRenderMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.util.interpolate.Eases;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.shader.postprocessing.BloomEffect;
import gregtech.client.utils.BloomEffectUtil;
import gregtech.client.utils.RenderBufferHelper;
import gregtech.client.utils.RenderUtil;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class EPMetaTileEntityCompactCyclotron extends RecipeMapMultiblockController implements IFastRenderMetaTileEntity {

    private Integer color;

    static BloomEffectUtil.IBloomRenderFast RENDER_HANDLER = new BloomEffectUtil.IBloomRenderFast() {
        float lastBrightnessX;
        float lastBrightnessY;

        public int customBloomStyle() {
            return ConfigHolder.client.shader.fusionBloom.useShader ? ConfigHolder.client.shader.fusionBloom.bloomStyle : -1;
        }

        @SideOnly(Side.CLIENT)
        public void preDraw(BufferBuilder buffer) {
            BloomEffect.strength = (float)ConfigHolder.client.shader.fusionBloom.strength;
            BloomEffect.baseBrightness = (float)ConfigHolder.client.shader.fusionBloom.baseBrightness;
            BloomEffect.highBrightnessThreshold = (float)ConfigHolder.client.shader.fusionBloom.highBrightnessThreshold;
            BloomEffect.lowBrightnessThreshold = (float)ConfigHolder.client.shader.fusionBloom.lowBrightnessThreshold;
            BloomEffect.step = 1.0F;
            this.lastBrightnessX = OpenGlHelper.lastBrightnessX;
            this.lastBrightnessY = OpenGlHelper.lastBrightnessY;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
            GlStateManager.disableTexture2D();
        }

        @SideOnly(Side.CLIENT)
        public void postDraw(BufferBuilder buffer) {
            GlStateManager.enableTexture2D();
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, this.lastBrightnessX, this.lastBrightnessY);
        }
    };

    public EPMetaTileEntityCompactCyclotron(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EPRecipeMaps.CYCLOTRON_RECIPES);
    }
    
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new EPMetaTileEntityCompactCyclotron(this.metaTileEntityId);
    }

    @Nonnull
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("               ", "      CGC      ", "               ")
                .aisle("      CCC      ", "    GGAAAGG    ", "      CCC      ")
                .aisle("    CC   CC    ", "   CAACGCAAC   ", "    CC   CC    ")
                .aisle("   C       C   ", "  CKCG   GCKC  ", "   C       C   ")
                .aisle("  C         C  ", " GAC       CAG ", "  C         C  ")
                .aisle("  C         C  ", " GAG       GAG ", "  C         C  ")
                .aisle(" C           C ", "CAC         CAC", " C           C ")
                .aisle(" C           C ", "GAG         GAG", " C           C ")
                .aisle(" C           C ", "CAC         CAC", " C           C ")
                .aisle("  C         C  ", " GAG       GAG ", "  C         C  ")
                .aisle("  C         C  ", " GAC       CAG ", "  C         C  ")
                .aisle("   C       C   ", "  CKCG   GCKC  ", "   C       C   ")
                .aisle("    CC   CC    ", "   CAACGCAAC   ", "    CC   CC    ")
                .aisle("      CCC      ", "    GGAAAGG    ", "      CCC      ")
                .aisle("               ", "      CSC      ", "               ")
                .where('S', this.selfPredicate())
                .where('G', states(getGlassState()))
                .where('C', states(getCasingState())
                        .setMinGlobalLimited(88)
                        .or(autoAbilities(false, false, true, true, true, true, false))
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.INPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getInputAmperage() == 2;
                                })
                                .toArray(MetaTileEntity[]::new)).setExactLimit(1).setPreviewCount(1)))
                .where('K', states(getCoilState()))
                .where('A', air())
                .where(' ', any())
                .build();
    }

    private IBlockState getCasingState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.CYCLOTRON_CASING);
    }

    private IBlockState getCoilState() {
        return EPMetablocks.EP_MULTIBLOCK_CASING_B.getState(EPBlockMultiblockCasingB.CasingType.CYCLOTRON_COIL);
    }

    private IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return EPTextures.CYCLOTRON_CASING;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    protected ICubeRenderer getFrontOverlay() {
        return EPTextures.CYCLOTRON_OVERLAY;
    }

    public boolean hasMaintenanceMechanics() {
        return false;
    }

    protected void updateFormedValid() {
        super.updateFormedValid();
        if (this.recipeMapWorkable.isWorking() && this.color == null) {
            if (this.recipeMapWorkable.getPreviousRecipe() != null && this.recipeMapWorkable.getPreviousRecipe().getFluidOutputs().size() > 0) {
                int newColor = -16777216 | ((FluidStack)this.recipeMapWorkable.getPreviousRecipe().getFluidOutputs().get(0)).getFluid().getColor();
                if (!Objects.equals(this.color, newColor)) {
                    this.color = newColor;
                    this.writeCustomData(371, this::writeColor);
                }
            }
        } else if (!this.recipeMapWorkable.isWorking() && this.isStructureFormed() && this.color != null) {
            this.color = null;
            this.writeCustomData(371, this::writeColor);
        }
    }

    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.writeColor(buf);
    }

    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.readColor(buf);
    }

    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == 371) {
            this.readColor(buf);
        }

    }

    private void readColor(PacketBuffer buf) {
        this.color = buf.readBoolean() ? buf.readVarInt() : null;
    }

    private void writeColor(PacketBuffer buf) {
        buf.writeBoolean(this.color != null);
        if (this.color != null) {
            buf.writeVarInt(this.color);
        }
    }

    public void renderMetaTileEntity(double x, double y, double z, float partialTicks) {
        if (this.color != null && MinecraftForgeClient.getRenderPass() == 0) {
            int c = this.color;
            BloomEffectUtil.requestCustomBloom(RENDER_HANDLER, (buffer) -> {
                int color = (Integer) RenderUtil.colorInterpolator(c, -1).apply(Eases.EaseQuadIn.getInterpolation(Math.abs((float)Math.abs(this.getOffsetTimer() % 50L) + partialTicks - 25.0F) / 25.0F));
                float a = (float)(color >> 24 & 255) / 255.0F;
                float r = (float)(color >> 16 & 255) / 255.0F;
                float g = (float)(color >> 8 & 255) / 255.0F;
                float b = (float)(color & 255) / 255.0F;
                Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
                if (entity != null) {
                    buffer.begin(8, DefaultVertexFormats.POSITION_COLOR);
                    RenderBufferHelper.renderRing(buffer, x + (double)(this.getFrontFacing().getOpposite().getXOffset() * 7) + 0.5, y + 0.5, z + (double)(this.getFrontFacing().getOpposite().getZOffset() * 7) + 0.5, 6.0, 0.2, 10, 20, r, g, b, a, EnumFacing.Axis.Y);
                    Tessellator.getInstance().draw();
                }

            });
        }

    }

    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(this.getPos().offset(this.getFrontFacing().getOpposite()).offset(this.getFrontFacing().rotateY(), 6), this.getPos().offset(this.getFrontFacing().getOpposite(), 13).offset(this.getFrontFacing().rotateY().getOpposite(), 6));
    }

    public boolean shouldRenderInPass(int pass) {
        return pass == 0;
    }

    public boolean isGlobalRenderer() {
        return true;
    }

    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("epimorphism.machine.compact_cyclotron.tooltip.1"));
        tooltip.add(I18n.format("epimorphism.machine.compact_cyclotron.tooltip.2"));
        tooltip.add(I18n.format("epimorphism.machine.compact_cyclotron.tooltip.3"));
    }
}