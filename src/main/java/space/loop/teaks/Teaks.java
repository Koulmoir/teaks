package space.loop.teaks;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.Recipe;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.Logger;
import space.loop.teaks.core.TweaksLogic;
import space.loop.teaks.data.ConfigTeaks;
import space.loop.teaks.data.Tweaks;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class Teaks implements ModInitializer {

    public static ReentrantLock lock = new ReentrantLock();
    public static Tweaks Tweaks = new Tweaks();
    String modId="teaks";

    @Override
    public void onInitialize() {
        //This basically creates a versionof the TweaksLogic class that can be worked with
        TweaksLogic Logic = new TweaksLogic();
        //this calls the function initialConfiguration() through this previously defined class
        Logic.initialConfiguration();
        //This starts the configuration file so we can work with user made configs
        MidnightConfig.init(modId, ConfigTeaks.class);
    }

    public static void recipeDisabler(MinecraftServer server, Logger LOGGER){
        //this code was "inspired" by the recipe disabler mod 🙏🙏🙏


        new Thread(()-> {
            lock.lock();
            LOGGER.info("Removing broken items...");
            for (String e : Tweaks.recipesToDisabler){
                String[] tID = e.split(":");
                LOGGER.info(String.format("Removing recipe: %s", e));
                Collection<Recipe<?>> recipes = server.getRecipeManager().values();
                recipes.removeIf(
                        r -> Pattern.matches(tID[0],r.getId().getNamespace()) &&
                                Pattern.matches(tID[1], r.getId().getPath())
                );
                server.getRecipeManager().setRecipes(recipes);
                lock.unlock();
            }
        }).start();
    }
    //What I'm about to do is a magical thing know by many as 💫 Bullshit 💫 (I'm pushing this onto me tomorrow)
    //TODO:Recipe whitelister by mod id (wllahi I'm cokked)
}

