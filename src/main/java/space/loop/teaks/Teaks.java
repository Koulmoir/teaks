package space.loop.teaks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Teaks implements ModInitializer {

    @Override
    public void onInitialize() {
        final Logger LOGGER = LogManager.getLogger("Loopy Teaks");
        //LOGGER.info(FabricLoader.getInstance().getConfigDir());
        //checks if the enchancements config file exists
        File enchancementConfigFile = new File(FabricLoader.getInstance().getConfigDir()+"/enchancement.json");
        if (enchancementConfigFile.exists()) {
            LOGGER.info("Enchancement config file found! Configuring...");
        } else {
            LOGGER.info("Enchancement config file not found! Please add Enchancements for full immersion");
        }
    }
}
