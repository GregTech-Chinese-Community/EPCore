package cn.gtcommunity.epimorphism.common.metatileentities;

import cn.gtcommunity.epimorphism.api.utils.EPUtils;
import cn.gtcommunity.epimorphism.common.metatileentities.multiblock.*;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.integration.jei.multiblock.MultiblockInfoCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class EPMetaTileEntities {

    public static EPMetaTileEntitySonicator SONICATOR;
    public static EPMetaTileEntityCVDUnit CVD_UNIT;
    public static EPMetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static EPMetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static EPMetaTileEntityCatalyticReformer CATALYTIC_REFORMER;

    //  Range: 12300-13300
    private static <T extends MetaTileEntity> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 12300, mte);
    }

    public static void init() {


        //Multiblocks: Id 12300-13300
        SONICATOR=registerMultiMetaTileEntity(1, new EPMetaTileEntitySonicator(EPUtils.epId("sonicator")));
        CVD_UNIT= registerMultiMetaTileEntity(2, new EPMetaTileEntityCVDUnit(EPUtils.epId("cvd_unit")));
        NANOSCALE_FABRICATOR=registerMultiMetaTileEntity(3, new EPMetaTileEntityNanoscaleFabricator(EPUtils.epId("nanoscale_fabricator")));
        CRYSTALLIZATION_CRUCIBLE=registerMultiMetaTileEntity(4, new EPMetaTileEntityCrystallizationCrucible(EPUtils.epId("crystallization_crucible")));
        CATALYTIC_REFORMER=registerMultiMetaTileEntity(5, new EPMetaTileEntityCatalyticReformer(EPUtils.epId("catalytic_reformer")));
    }

    public static <T extends MetaTileEntity> T registerMetaTileEntity(int id, T sampleMetaTileEntity) {
        if (sampleMetaTileEntity instanceof IMultiblockAbilityPart abilityPart) {
            MultiblockAbility.registerMultiblockAbility(abilityPart.getAbility(), sampleMetaTileEntity);
        }
        if (sampleMetaTileEntity instanceof MultiblockControllerBase && Loader.isModLoaded(GTValues.MODID_JEI)) {
            if (((MultiblockControllerBase) sampleMetaTileEntity).shouldShowInJei()) {
                MultiblockInfoCategory.registerMultiblock((MultiblockControllerBase) sampleMetaTileEntity);
            }
        }
        GregTechAPI.MTE_REGISTRY.register(id, sampleMetaTileEntity.metaTileEntityId, sampleMetaTileEntity);
        return sampleMetaTileEntity;
    }
}
