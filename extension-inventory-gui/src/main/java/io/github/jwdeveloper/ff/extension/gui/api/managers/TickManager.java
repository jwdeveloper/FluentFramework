package io.github.jwdeveloper.ff.extension.gui.api.managers;

import io.github.jwdeveloper.ff.core.spigot.events.implementation.EventGroup;
import io.github.jwdeveloper.ff.extension.gui.api.FluentInventory;
import io.github.jwdeveloper.ff.extension.gui.api.events.GuiTickEvent;
import org.bukkit.entity.Player;

public interface TickManager {

    void start(Player player, FluentInventory inventory, EventGroup<GuiTickEvent> eventGroup);

    void stop();
}
