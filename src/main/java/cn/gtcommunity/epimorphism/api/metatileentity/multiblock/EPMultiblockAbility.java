package cn.gtcommunity.epimorphism.api.metatileentity.multiblock;

import cn.gtcommunity.epimorphism.api.capability.*;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;

public class EPMultiblockAbility {

    public static final MultiblockAbility<IBuffer> BUFFER_MULTIBLOCK_ABILITY = new MultiblockAbility<>("buffer");
    public static final MultiblockAbility<IBall> GRINDBALL_MULTIBLOCK_ABILITY = new MultiblockAbility<>("ball");
    public static final MultiblockAbility<ICatalyst> CATALYST_MULTIBLOCK_ABILITY = new MultiblockAbility<>("catalyst");
    public static final MultiblockAbility<IIndustrialMaintenance> INDUSTRIAL_MAINTENANCE_MULTIBLOCK_ABILITY = new MultiblockAbility<>("industrial_maintenance");
    public static final MultiblockAbility<IReinforcedRotorHolder> REINFORCED_ROTOR_MULTIBLOCK_ABILITY = new MultiblockAbility<>("reinforced_rotor");
}
