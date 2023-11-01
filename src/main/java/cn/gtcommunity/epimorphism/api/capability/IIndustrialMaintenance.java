package cn.gtcommunity.epimorphism.api.capability;

import gregtech.api.capability.IMaintenanceHatch;
import gregtech.api.metatileentity.multiblock.IMaintenance;

public interface IIndustrialMaintenance extends IMaintenanceHatch {
    void addListenerList(IMaintenance controller);

    void removeListenerList(IMaintenance controller);
}
