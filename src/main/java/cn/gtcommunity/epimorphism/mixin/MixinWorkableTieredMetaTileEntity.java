package cn.gtcommunity.epimorphism.mixin;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.capability.pollution.PollutionMapManager;
import cn.gtcommunity.epimorphism.api.capability.pollution.PollutionProvider;
import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.WorkableTieredMetaTileEntity;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MTETrait.class, remap = false)
public abstract class MixinWorkableTieredMetaTileEntity {

    @Final
    @Shadow
    protected MetaTileEntity metaTileEntity;

    @Inject(
            method = "update()V",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    public void update(CallbackInfo ci) {
        if (metaTileEntity instanceof WorkableTieredMetaTileEntity metaTileEntity) {
            int pollution = PollutionMapManager.getPollutionByMap(metaTileEntity.getRecipeMap());
            Chunk chunk = metaTileEntity.getWorld().getChunk(metaTileEntity.getPos());
            if (chunk.hasCapability(PollutionProvider.pollution, null)) {
                chunk.getCapability(PollutionProvider.pollution, null).addPollution(pollution);
            }
        }
    }

}
