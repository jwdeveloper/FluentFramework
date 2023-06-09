package io.github.jwdeveloper.ff.core.spigot.commands.api.services;

import io.github.jwdeveloper.ff.core.spigot.commands.implementation.events.CommandEvent;
import io.github.jwdeveloper.ff.core.spigot.commands.implementation.events.ConsoleCommandEvent;
import io.github.jwdeveloper.ff.core.spigot.commands.implementation.events.PlayerCommandEvent;
import org.bukkit.command.CommandSender;

import java.util.function.Consumer;

public interface EventsService {
    boolean invokeEvent(CommandSender commandSender, String[] allArgs, String[] commandArgs, Object[] values);

    void onInvoke(Consumer<CommandEvent> event);

    void onPlayerInvoke(Consumer<PlayerCommandEvent> event);

    void onConsoleInvoke(Consumer<ConsoleCommandEvent> event);
}
