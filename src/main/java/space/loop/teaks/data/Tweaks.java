package space.loop.teaks.data;

import org.apache.logging.log4j.Logger;

public class Tweaks {

    public String[] recipesToDisabler = {
            "herbalbrews:cauldron",
            "herbalbrews:cauldron_brewing/dummy_recipe"
    };

    public String[] itemsToHide = {
            "herbalbrews:cauldron",
            "perfectbirbs:bearded_reedling_plushie",
            "perfectbirbs:cisticola_plushie",
            "perfectbirbs:blue_footed_booby_plushie"
    };

    public static void addEnchantments(Logger LOGGER){
        //DO NOT LOOK IN HERE
        enchantmentsConfig.applyEnchantmentConfig(LOGGER);
    }
}
