package space.loop.teaks.core;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.command.ServerCommandSource;
import space.loop.teaks.data.Enchantments;
import space.loop.teaks.data.Tweaks;
import space.loop.teaks.Teaks;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.server.MinecraftServer;
import com.mojang.brigadier.context.CommandContext;

import java.io.File;
import java.util.EnumMap;

public class TweaksLogic {
    final Logger LOGGER = LogManager.getLogger("Loopy Teaks");
    String[] defaultEnchantmentsConfigBlacklist = new Tweaks().defaultEnchancementsConfig;
    EnumMap<Enchantments, String> enchantTweaks = new Tweaks().EnchantTweaks;

    CommandContext<ServerCommandSource> context;

    public void initialConfiguration(){

        //checks if the enchancements config file exists
        File enchancementConfigFile = new File(FabricLoader.getInstance().getConfigDir()+"/enchancement.json");
        if (enchancementConfigFile.exists()) {
            LOGGER.info("Enchancement config file found! Configuring...");
        } else {
            LOGGER.info("Enchancement config file not found! Please add Enchancements for full immersion");
        }
        //This needs to be tested but idfk how lol gonna just have to believe in it
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            Teaks.recipeDisabler(server, LOGGER);
        });

    }

}
