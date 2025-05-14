package space.loop.teaks.data;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Tweaks {
    public EnumMap<Enchantments, String> EnchantTweaks = new EnumMap<>(Map.of(
            Enchantments.BOUNCY, "enchancement:bouncy",
            Enchantments.BURY, "enchancement:bury",
            Enchantments.CHAOS, "enchancement:chaos",
            Enchantments.DASH, "enchancement:dash",
            Enchantments.BRIMSTONE, "enchancement:brimstone",
            Enchantments.GRAPPLE, "enchancement:grapple",
            Enchantments.PHASING, "enchancement:phasing",
            Enchantments.SLIDE, "enchancement:slide",
            Enchantments.STRAFE, "enchancement:strafe",
            Enchantments.WARP, "enchancement:warp"
    ));

    public String[] defaultEnchancementsConfig = {
            "minecraft:aqua_affinity",
            "minecraft:bane_of_arthropods",
            "minecraft:binding_curse",
            "minecraft:blast_protection",
            "minecraft:depth_strider",
            "minecraft:feather_falling",
            "minecraft:fire_protection",
            "minecraft:flame",
            "minecraft:fortune",
            "minecraft:frost_walker",
            "minecraft:impaling",
            "minecraft:infinity",
            "minecraft:knockback",
            "minecraft:looting",
            "minecraft:loyalty",
            "minecraft:lure",
            "minecraft:mending",
            "minecraft:multishot",
            "minecraft:piercing",
            "minecraft:power",
            "minecraft:projectile_protection",
            "minecraft:protection",
            "minecraft:punch",
            "minecraft:quick_charge",
            "minecraft:respiration",
            "minecraft:sharpness",
            "minecraft:smite",
            "minecraft:soul_speed",
            "minecraft:sweeping",
            "minecraft:swift_sneak",
            "minecraft:thorns",
            "minecraft:unbreaking",
            "minecraft:vanishing_curse",
            "spectrum:indestructible",
            "spectrum:autosmelt"
    };

    public String[] recipesToDisabler = {
            "herbalbrews:cauldron",
            "herbalbrews:cauldron_brewing/dummy_recipe"
    };

    String getEnchantString(Enchantments enchantment){
        return EnchantTweaks.get(enchantment);
    }

    String[] getEnchantStringArrayList(){
        ArrayList<String> Array = new ArrayList<String>();
        for (Enchantments enchant : Enchantments.values()){
            Array.add(getEnchantString(enchant));
        }
        String[] array1 = new String[Array.size()];
        return Array.toArray(array1);
    }

    List<String> getCurrentEnchantConfig(Logger LOGGER){
        List<String> ListCurrentConfig = new ArrayList<String>();
         File config = FabricLoader.getInstance().getConfigDir().resolve("enchancement.json").toFile();

         try(FileReader configReader = new FileReader(config)){
             Gson json = new Gson();
             JsonElement rootE = JsonParser.parseReader(configReader);
             JsonObject rootO = rootE.getAsJsonObject();
             JsonArray disallowedEnchantsJsonArray = rootO.getAsJsonArray("disallowedEnchantments");
             //Carefull!! I have no idea what this does!!!
             Type stringListType = new TypeToken<List<String>>() {}.getType();
             //Carefull!! I have no idea what this does!!!
             ListCurrentConfig = json.fromJson(disallowedEnchantsJsonArray, stringListType);
             return ListCurrentConfig;


         } catch (Exception e) {
             LOGGER.error(e.getStackTrace());
             return ListCurrentConfig;
         }

    }
    //TODO:Add a function for modifying the Config

}
