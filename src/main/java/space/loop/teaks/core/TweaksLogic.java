package space.loop.teaks.core;

import space.loop.teaks.data.Enchantments;
import space.loop.teaks.data.Tweaks;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class TweaksLogic {
    final Logger LOGGER = LogManager.getLogger("Loopy Teaks");
    String[] defaultEnchantmentsConfigBlacklist = new Tweaks().defaultEnchancementsConfig;
    EnumMap<Enchantments, String> defaultEnchantTweaks = new Tweaks().EnchantTweaks;

    //LOGGER.info(FabricLoader.getInstance().getConfigDir());

    //gives back the enchant tweaks raw strings


    public void initialConfiguration(){

        //checks if the enchancements config file exists
        File enchancementConfigFile = new File(FabricLoader.getInstance().getConfigDir()+"/enchancement.json");
        if (enchancementConfigFile.exists()) {
            LOGGER.info("Enchancement config file found! Configuring...");
        } else {
            LOGGER.info("Enchancement config file not found! Please add Enchancements for full immersion");
        }
    }

}
