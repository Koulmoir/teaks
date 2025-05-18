package space.loop.teaks.data;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resource.Resource;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import static java.nio.charset.StandardCharsets.UTF_8;

public class enchantmentsConfig {
    public static String enchantmentConfig = "{\n" +
            "  \"disallowedEnchantments\": [\n" +
            "    \"minecraft:aqua_affinity\",\n" +
            "    \"minecraft:bane_of_arthropods\",\n" +
            "    \"minecraft:binding_curse\",\n" +
            "    \"minecraft:blast_protection\",\n" +
            "    \"minecraft:depth_strider\",\n" +
            "    \"minecraft:feather_falling\",\n" +
            "    \"minecraft:fire_protection\",\n" +
            "    \"minecraft:flame\",\n" +
            "    \"minecraft:fortune\",\n" +
            "    \"minecraft:frost_walker\",\n" +
            "    \"minecraft:impaling\",\n" +
            "    \"minecraft:infinity\",\n" +
            "    \"minecraft:knockback\",\n" +
            "    \"minecraft:looting\",\n" +
            "    \"minecraft:loyalty\",\n" +
            "    \"minecraft:lure\",\n" +
            "    \"minecraft:mending\",\n" +
            "    \"minecraft:multishot\",\n" +
            "    \"minecraft:piercing\",\n" +
            "    \"minecraft:power\",\n" +
            "    \"minecraft:projectile_protection\",\n" +
            "    \"minecraft:protection\",\n" +
            "    \"minecraft:punch\",\n" +
            "    \"minecraft:quick_charge\",\n" +
            "    \"minecraft:respiration\",\n" +
            "    \"minecraft:sharpness\",\n" +
            "    \"minecraft:smite\",\n" +
            "    \"minecraft:soul_speed\",\n" +
            "    \"minecraft:sweeping\",\n" +
            "    \"minecraft:swift_sneak\",\n" +
            "    \"minecraft:thorns\",\n" +
            "    \"minecraft:unbreaking\",\n" +
            "    \"minecraft:vanishing_curse\",\n" +
            "    \"spectrum:indestructible\",\n" +
            "    \"spectrum:autosmelt\",\n" +
            "    \"enchancement:warp\",\n" +
            "    \"enchancement:strafe\",\n" +
            "    \"enchancement:slide\",\n" +
            "    \"enchancement:phasing\",\n" +
            "    \"enchancement:grapple\",\n" +
            "    \"enchancement:brimstone\",\n" +
            "    \"enchancement:dash\",\n" +
            "    \"enchancement:chaos\",\n" +
            "    \"enchancement:bury\",\n" +
            "    \"enchancement:bouncy\"\n" +
            "  ],\n" +
            "  \"invertedList\": false,\n" +
            "  \"overhaulEnchantingTable\": true,\n" +
            "  \"allowTreasureEnchantmentsInEnchantingTable\": false,\n" +
            "  \"singleLevelMode\": true,\n" +
            "  \"enchantmentLimit\": 1,\n" +
            "  \"accurateFishingBobbers\": true,\n" +
            "  \"allTridentsHaveLoyalty\": true,\n" +
            "  \"arrowsDropOnHit\": true,\n" +
            "  \"channelingIgnitesOnMelee\": true,\n" +
            "  \"channelingWorksWhenNotThundering\": true,\n" +
            "  \"crossbowsPullFromInventory\": true,\n" +
            "  \"drownedUseHeldTrident\": true,\n" +
            "  \"enchantedChestplatesIncreaseAirMobility\": true,\n" +
            "  \"fasterBows\": true,\n" +
            "  \"fireAspectWorksAsFlintAndSteel\": true,\n" +
            "  \"freeEnchantedBookMerging\": true,\n" +
            "  \"luckOfTheSeaHasLure\": true,\n" +
            "  \"negateEnderPearlDamage\": true,\n" +
            "  \"projectilesBypassCooldown\": true,\n" +
            "  \"projectilesNegateVelocity\": true,\n" +
            "  \"randomMobEnchantments\": true,\n" +
            "  \"rebalanceArmor\": true,\n" +
            "  \"safeChanneling\": true,\n" +
            "  \"tridentsReturnFromVoid\": true,\n" +
            "  \"weakerFireAspect\": true,\n" +
            "  \"weakerGoldenApple\": true,\n" +
            "  \"weakerPotions\": true,\n" +
            "  \"weaponEnchantmentCooldownRequirement\": 0.7,\n" +
            "  \"maxExtractingBlocks\": 64,\n" +
            "  \"maxLumberjackBlocks\": 1024,\n" +
            "  \"maxLumberjackHorizontalLength\": 7,\n" +
            "  \"coyoteBiteTicks\": 3,\n" +
            "  \"unbreakingChangesFlag\": 0,\n" +
            "  \"enchantmentDescriptions\": true,\n" +
            "  \"coloredEnchantmentNames\": true,\n" +
            "  \"allowDuplicateKeybindings\": \"VANILLA_AND_ENCHANCEMENT\",\n" +
            "  \"singlePressStrafe\": false\n" +
            "}";
    public static void applyEnchantmentConfig(Logger LOGGER){
        Path enchantmentsConfig = FabricLoader.getInstance().getConfigDir().resolve("enchancement.json");
        InputStream enchancementConfigStream = new ByteArrayInputStream(enchantmentConfig.getBytes(UTF_8));
        try{
            Files.deleteIfExists(enchantmentsConfig);
            Files.createFile(enchantmentsConfig);
            Files.writeString(enchantmentsConfig, enchantmentConfig, StandardOpenOption.WRITE);
            //Files.copy(enchancementConfigStream,enchantmentsConfig,StandardCopyOption.REPLACE_EXISTING);
            LOGGER.info("Configured Successfully!");
        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getStackTrace());
        }
    }
}
