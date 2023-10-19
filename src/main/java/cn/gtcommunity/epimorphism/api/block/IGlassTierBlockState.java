package cn.gtcommunity.epimorphism.api.block;

import gregtech.api.GTValues;

import javax.annotation.Nonnull;

public interface IGlassTierBlockState {

    @Nonnull
    String getName();

    int getGlassTier();

    default long getTireVoltage(){
        return GTValues.V[getGlassTier()];
    }

    default String getTireName(){
        return GTValues.VN[getGlassTier()];
    }

    default String getTireNameColored(){
        return GTValues.VNF[getGlassTier()];
    }

}
