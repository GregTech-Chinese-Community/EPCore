package cn.gtcommunity.epimorphism.api.unification.materials;

import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class EPMaterialPropertyAddition {
    public static void init() {
        //  Properties
        Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        Iodine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, VA[EV], 1200));
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        SodiumHydroxide.setProperty(PropertyKey.FLUID, new FluidProperty());
        AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());

        //  IconSets
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        //  Flags
        Rhenium.addFlags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE);
        Nickel.addFlags(GENERATE_FOIL);
        Titanium.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);
        Tungsten.addFlags(GENERATE_FINE_WIRE);
        RhodiumPlatedPalladium.addFlags(GENERATE_FRAME);
        HSSE.addFlags(GENERATE_DOUBLE_PLATE);
        Stellite100.addFlags(GENERATE_DOUBLE_PLATE);
        MaragingSteel300.addFlags(GENERATE_DOUBLE_PLATE);
        TitaniumTungstenCarbide.addFlags(GENERATE_DOUBLE_PLATE);
        WatertightSteel.addFlags(GENERATE_DOUBLE_PLATE);
        HSLASteel.addFlags(GENERATE_DOUBLE_PLATE);

        Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
        Tantalite.addFlags(DISABLE_DECOMPOSITION);
        Molybdenite.addFlags(DISABLE_DECOMPOSITION);
        OreProperty oreProp = Molybdenite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);
        Powellite.addFlags(DISABLE_DECOMPOSITION);
        Wulfenite.addFlags(DISABLE_DECOMPOSITION);

        RockSalt.addFlags(DISABLE_DECOMPOSITION);
        Salt.addFlags(DISABLE_DECOMPOSITION);

        Pollucite.addFlags(DISABLE_DECOMPOSITION);
        Pollucite.getProperty(PropertyKey.ORE).setOreByProducts(Aluminium, Potassium, Caesium, Pollucite);

        //  Fluid Temperatures
        FluidProperty prop = new FluidProperty();
        prop.setFluidTemperature(332);
        SodiumBisulfate.setProperty(PropertyKey.FLUID, prop);

        //  Wire Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) V[UIV]);
    }
}