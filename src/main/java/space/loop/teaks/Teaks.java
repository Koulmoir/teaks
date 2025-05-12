package space.loop.teaks;

import net.fabricmc.api.ModInitializer;
import space.loop.teaks.core.TweaksLogic;
public class Teaks implements ModInitializer {

    String modId="teaks";

    @Override
    public void onInitialize() {
        //starts up the initial configuration
        TweaksLogic Logic = new TweaksLogic();
        Logic.initialConfiguration();
    }
}
