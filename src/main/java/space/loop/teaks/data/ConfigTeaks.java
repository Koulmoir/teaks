package space.loop.teaks.data;

import eu.midnightdust.lib.config.MidnightConfig;


public class ConfigTeaks extends MidnightConfig {
    @Entry(name="Enable Enchancment Tweaks (Requires Restart)")
    public static boolean enchantTweaks = true;
    @Entry(name="Enable Recipe Tweaks (Doesn't require Restart)")
    public static boolean recipeTweaks = true;
    @Entry(name="Enable JEI/Item Tweaks (Requires Restart?)")
    public static boolean itemTweaks = true;

}
