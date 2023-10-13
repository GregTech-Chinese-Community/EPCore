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

import static cn.gtcommunity.epimorphism.api.utils.EPUtils.epId;

public class EPMetaTileEntities {

    public static EPMetaTileEntitySonicator SONICATOR;
    public static EPMetaTileEntityCVDUnit CVD_UNIT;
    public static EPMetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static EPMetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static EPMetaTileEntityCatalyticReformer CATALYTIC_REFORMER;

    public static EPMetaTileEntityBlazingBlastFurnace BLAZING_BLAST_FURNACE;

    //  Range: 12300-13300
    private static <T extends MetaTileEntity> T registerMultiMetaTileEntity(int id, T mte) {
        return registerMetaTileEntity(id + 12300, mte);
    }

    public static void init() {

        //  Range: 12300-13300
        SONICATOR = registerMultiMetaTileEntity(1, new EPMetaTileEntitySonicator(epId("sonicator")));
        CVD_UNIT = registerMultiMetaTileEntity(2, new EPMetaTileEntityCVDUnit(epId("cvd_unit")));
        NANOSCALE_FABRICATOR = registerMultiMetaTileEntity(3, new EPMetaTileEntityNanoscaleFabricator(epId("nanoscale_fabricator")));
        CRYSTALLIZATION_CRUCIBLE = registerMultiMetaTileEntity(4, new EPMetaTileEntityCrystallizationCrucible(epId("crystallization_crucible")));
        CATALYTIC_REFORMER = registerMultiMetaTileEntity(5, new EPMetaTileEntityCatalyticReformer(epId("catalytic_reformer")));

        //  Range: 13300-14300
        BLAZING_BLAST_FURNACE = registerMultiMetaTileEntity(1000, new EPMetaTileEntityBlazingBlastFurnace(epId("blazing_blast_furnace")));
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
