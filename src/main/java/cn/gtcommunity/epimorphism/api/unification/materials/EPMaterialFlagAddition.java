package cn.gtcommunity.epimorphism.api.unification.materials;

import cn.gtcommunity.epimorphism.api.unification.material.info.EPMaterialFlags;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;

import static gregtech.api.unification.material.Materials.*;

public class EPMaterialFlagAddition {

    public static void init() {
        /*
        *  Coils for Motor wires
        *  Copper      | LV Motor
        *  Cupronickel | MV Motor
        *  Electrum    | HV Motor
        *  Kanthal     | EV Motor
        *  Graphene    | IV Motor
        *  Ruridit     | LuV Motor
        *  Europium    | ZPM Motor
        *  Americium   | UV Motor
         */
        Materials.Copper.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Cupronickel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Electrum.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Kanthal.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Graphene.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Ruridit.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Europium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Americium.addFlags(EPMaterialFlags.GENERATE_COIL);

        /*
        *  Coils for CEu Vanilla coils
        *  Lead          | ULV Coil
        *  Steel         | LV Coil
        *  Aluminium     | MV Coil
        *  BlackSteel    | HV Coil
        *  TungstenSteel | EV Coil
        *  Iridium       | IV Coil
        *  Osmiridium    | LuV Coil
        *  Europium      | ZPM Coil (see above)
        *  Tritanium     | UV Coil
         */
        Materials.Lead.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Steel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Aluminium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.BlackSteel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.TungstenSteel.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Iridium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Osmiridium.addFlags(EPMaterialFlags.GENERATE_COIL);
        Materials.Tritanium.addFlags(EPMaterialFlags.GENERATE_COIL);

        /*
        *  Curved Plate for Minecraft Vanilla items
        *  Iron    | bucket, hopper, armors
         */
        Materials.Iron.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);

        /*
        *  Curved Plate for CEu Vanilla Fluid Pipes
        *  Aluminium
        *  Bronze
        *  Chrome
        *  Copper
        *  Duranium
        *  Europium
        *  Gold
        *  Iridium
        *  Lead
        *  Naquadah
        *  Neutronium
        *  NiobiumTitanium
        *  Polyethylene            (x)
        *  Polybenzimidazole       (x)
        *  Polytetrafluoroethylene (x)
        *  Potin
        *  Stainless Steel
        *  Steel
        *  Tin Alloy
        *  Titanium
        *  Tungsten
        *  Tungsten Carbide
        *  TungstenSteel
        *  VanadiumSteel
         */
        Materials.Aluminium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Bronze.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Chrome.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Copper.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Duranium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Europium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Gold.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Iridium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Lead.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Naquadah.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Neutronium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.NiobiumTitanium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        // Materials.Polyethylene.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        // Materials.Polybenzimidazole.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        // Materials.Polytetrafluoroethylene.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Potin.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.StainlessSteel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Steel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.TinAlloy.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Titanium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Tungsten.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.TungstenCarbide.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.TungstenSteel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.VanadiumSteel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);

        /*
         *  Curved Plate for CEu Vanilla Item Pipes
         *  Americium
         *  Magnalium
         *  Sterling Silver
         *  Tin
         *  Cupronickel
         *  Black Bronze
         *  Cobalt Brass
         *  Electrum
         *  Cobalt
         *  Platinum
         *  Brass
         *  Osmium
         *  Ultimet
         *  Osmiridium
         *  Nickel
         *  Polyvinyl Chloride (x)
         *  Rose Gold
         */
        Materials.Americium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Magnalium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.SterlingSilver.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Tin.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Cupronickel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.BlackBronze.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.CobaltBrass.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Electrum.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Cobalt.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Platinum.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Brass.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Osmium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Ultimet.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Osmiridium.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.Nickel.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        // Materials.PolyvinylChloride.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);
        Materials.RoseGold.addFlags(EPMaterialFlags.GENERATE_CURVED_PLATE);

        // Disable Crystallization
        Monazite.addFlags(EPMaterialFlags.DISABLE_CRYSTALLIZATION);

        // Crystallizable
        Sapphire.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Ruby.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Emerald.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Olivine.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Amethyst.addFlags(MaterialFlags.CRYSTALLIZABLE);
        Opal.addFlags(MaterialFlags.CRYSTALLIZABLE);
    }
}
