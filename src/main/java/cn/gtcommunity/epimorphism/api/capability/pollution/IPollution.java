package cn.gtcommunity.epimorphism.api.capability.pollution;

public interface IPollution {

    long getPollution();
    void setPollution(long newAmount);
    void addPollution(long amount);
    void minusPollution(long amount);

    default int getPollutionLevel() {
        if (getPollution() >= 400000 && getPollution() < 500000) return 1;
        if (getPollution() >= 500000 && getPollution() < 750000) return 2;
        if (getPollution() >= 750000 && getPollution() < 1000000) return 3;
        if (getPollution() >= 1000000 && getPollution() < 2000000) return 4;
        return 0;
    }

}
