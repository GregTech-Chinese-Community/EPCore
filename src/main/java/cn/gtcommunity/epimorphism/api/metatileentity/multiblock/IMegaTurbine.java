package cn.gtcommunity.epimorphism.api.metatileentity.multiblock;

import cn.gtcommunity.epimorphism.api.capability.IReinforcedRotorHolder;

import java.util.List;

public interface IMegaTurbine {
    //  这个接口是为了给转子仓和涡轮解耦用的，不太有用，可能会删除
    List<IReinforcedRotorHolder> getRotorHolders();
    int getMode();
}
