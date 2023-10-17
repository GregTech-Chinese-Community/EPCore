package cn.gtcommunity.epimorphism.api.capability;

public interface IBall {
    boolean hasBall();

    int getGrinderTier();

    void damageGrinder(int amount);
}
