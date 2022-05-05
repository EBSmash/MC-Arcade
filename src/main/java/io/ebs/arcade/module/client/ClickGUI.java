package io.ebs.arcade.module.client;

import io.ebs.arcade.Arcade;
import io.ebs.arcade.module.Category;
import io.ebs.arcade.module.Module;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Graphical User Interface for Configuring the client", Category.ARCADE, Keyboard.KEY_O);
        setKey(Keyboard.KEY_O);

    }

    public void onEnable() {
        mc.displayGuiScreen(Arcade.clickGui);
        toggle();
    }
}
