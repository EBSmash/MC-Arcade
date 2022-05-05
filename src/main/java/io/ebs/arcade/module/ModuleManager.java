package io.ebs.arcade.module;

import io.ebs.arcade.event.TickEvent;
import io.ebs.arcade.module.client.ClickGUI;
import io.ebs.arcade.module.client.Snake;
import me.bush.eventbus.annotation.EventListener;
import me.bush.eventbus.annotation.ListenerPriority;

import java.util.ArrayList;

public class ModuleManager {
    static ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new ClickGUI());
        modules.add(new Snake());

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