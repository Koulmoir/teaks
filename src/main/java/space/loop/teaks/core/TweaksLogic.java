package space.loop.teaks.core;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import space.loop.teaks.data.Tweaks;
import space.loop.teaks.Teaks;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import space.loop.teaks.data.ConfigTeaks;
import space.loop.teaks.data.jeiConfig;

import java.io.File;
import java.util.EnumMap;

public class TweaksLogic {
    final Logger LOGGER = LogManager.getLogger("Loopy Teaks");

    public void initialConfiguration(){

        //checks if the enchancements config file exists
        File enchancementConfigFile = new File(FabricLoader.getInstance().getConfigDir()+"/enchancement.json");
        if (enchancementConfigFile.exists() && ConfigTeaks.enchantTweaks) {
            LOGGER.info("Enchancement config file found! Configuring...");
            Tweaks.addEnchantments(LOGGER);
        } else {
            LOGGER.info("Enchancement config file not found! Please add Enchancements for full immersion");
        }
        //This needs to be tested but idfk how lol gonna just have to believe in it
        //Note:Works for now DO NOT TOUCH
        if (ConfigTeaks.recipeTweaks) {
            ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
                Teaks.recipeDisabler(server, LOGGER);
            });
        }
        //TODO:Fix this piece of shit
        if (ConfigTeaks.itemTweaks){
            jeiConfig jeiConfig = new jeiConfig();
            jeiConfig.init(LOGGER);
        }

    }

}
