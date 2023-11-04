package cn.gtcommunity.epimorphism.api.capability;

import java.util.List;

public interface IMegaTurbine {
    List<IReinforcedRotorHolder> getRotorHolders();
    int getMode();
}
