package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class EPMaterialPropertyAddition {
    public static void init() {
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rhenium.addFlags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE);

        Nickel.addFlags(GENERATE_FOIL);
    }
}