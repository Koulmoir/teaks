package space.loop.teaks.data;

import java.util.EnumMap;
import java.util.Map;

enum Enchantments{
    SLIDE, DASH, BOUNCY, BRIMSTONE, WARP, PHASING, CHAOS, BURY, STRAFE, GRAPPLE
}

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
}
