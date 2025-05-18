package space.loop.teaks.data;

import org.apache.logging.log4j.Logger;

public class Tweaks {


    public String[] recipesToDisabler = {
            "herbalbrews:cauldron",
            "herbalbrews:cauldron_brewing/dummy_recipe"
    };

    public String[] itemsToHide = {
            "herbalbrews:cauldron"
    };

    public static void addEnchantments(Logger LOGGER){
        enchantmentsConfig.applyEnchantmentConfig(LOGGER);
    }
}
