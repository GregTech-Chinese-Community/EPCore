package cn.gtcommunity.epimorphism.api.capability;

import java.util.Optional;

public interface ICatalyst {
    Optional<String> getName();

    default void consumeCatalyst(int amount){

    }
}
