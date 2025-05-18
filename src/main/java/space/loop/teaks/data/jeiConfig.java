package space.loop.teaks.data;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class jeiConfig {
    File jeiConfigFile = FabricLoader.getInstance().getConfigDir().resolve("jei/blacklist.cfg").toFile();
    Tweaks tweaks = new Tweaks();
    String[] itemsToHide = tweaks.itemsToHide;
    public void init(Logger LOGGER){
        try {
            for (String itemToHide : itemsToHide) {
                Files.write(jeiConfigFile.toPath(), itemToHide.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            LOGGER.error(e);
            LOGGER.error(e.getStackTrace());
        }
    }
}
