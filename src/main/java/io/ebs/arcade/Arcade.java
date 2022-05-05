package io.ebs.arcade;

import io.ebs.arcade.gui.click.ClickGui;
import io.ebs.arcade.module.ModuleManager;
import me.bush.eventbus.bus.EventBus;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@net.minecraftforge.fml.common.Mod(modid = Arcade.MOD_ID, name = Arcade.NAME, version = Arcade.VERSION)
public class Arcade {
    public static Minecraft mc;
    public static final String NAME = "Arcade Client";
    public static final String MOD_ID = "arcade";
    public static final String VERSION = "1.0";
    public static final String TITLE = NAME + " " + VERSION;

    public static EventBus EVENT_BUS;
    public static ModuleManager moduleManager;
    public static ClickGui clickGui;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        mc = Minecraft.getMinecraft();
        EVENT_BUS = new EventBus();
        moduleManager = new ModuleManager();
        clickGui = new ClickGui();
        EVENT_BUS.subscribe(moduleManager);
    }
}