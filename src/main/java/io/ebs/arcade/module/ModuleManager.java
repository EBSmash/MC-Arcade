package io.ebs.arcade.module;

import io.ebs.arcade.event.TickEvent;
import io.ebs.arcade.module.client.ClickGUI;
import io.ebs.arcade.module.client.DDR.DDR;
import io.ebs.arcade.module.client.Snake.Snake;
import io.ebs.arcade.module.client.beatsaber.BeatSaber;
import io.ebs.arcade.module.client.tetris.Tetris;
import me.bush.eventbus.annotation.EventListener;
import me.bush.eventbus.annotation.ListenerPriority;

import java.util.ArrayList;

public class ModuleManager {
    static ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new ClickGUI());
        modules.add(new Snake());
        modules.add(new Tetris());
        modules.add(new BeatSaber());

    }

    public static ArrayList<Module> getModules() {
        return modules;
    }

    @EventListener(priority = ListenerPriority.HIGHEST)
    public void onTick(TickEvent.Pre event) {
        for (Module module : modules) {
            module.tick();
        }
    }
}
