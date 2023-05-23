package io.github.jwdeveloper.ff.plugin.implementation;

import io.github.jwdeveloper.ff.core.common.logger.BukkitLogger;
import io.github.jwdeveloper.ff.core.files.FileUtility;
import io.github.jwdeveloper.ff.core.spigot.commands.api.FluentCommandManger;
import io.github.jwdeveloper.ff.core.spigot.commands.api.builder.CommandBuilder;
import io.github.jwdeveloper.ff.core.spigot.commands.implementation.builder.CommandBuilderImpl;
import io.github.jwdeveloper.ff.core.spigot.events.api.FluentEventManager;
import io.github.jwdeveloper.ff.core.spigot.messages.SimpleMessage;
import io.github.jwdeveloper.ff.core.spigot.tasks.api.FluentTaskManager;
import io.github.jwdeveloper.ff.plugin.api.config.FluentConfig;
import io.github.jwdeveloper.ff.plugin.api.extention.FluentApiExtensionsManager;
import io.github.jwdeveloper.ff.plugin.implementation.extensions.container.FluentInjection;
import io.github.jwdeveloper.ff.plugin.implementation.extensions.mediator.FluentMediator;
import io.github.jwdeveloper.ff.plugin.implementation.extensions.permissions.api.FluentPermission;
import org.bukkit.plugin.Plugin;

public final class FluentApiSpigot {

    private final FluentInjection fluentInjection;
    private final FluentMediator fluentMediator;
    private final FluentConfig fluentConfig;
    private final FluentPermission fluentPermission;
    private final Plugin plugin;
    private final SimpleMessage simpleMessages;
    private final FluentEventManager fluentEvents;
    private final FluentTaskManager simpleTasks;
    private final FluentCommandManger commandManger;
    private final FluentApiExtensionsManager extensionsManager;
    private final BukkitLogger logger;

    public FluentApiSpigot(
            Plugin plugin,
            FluentInjection injection,
            FluentMediator mediator,
            FluentConfig fluentConfig,
            FluentPermission permission,
            FluentApiExtensionsManager extensionsManager,
            BukkitLogger logger,
            FluentCommandManger commandManger,
            FluentEventManager eventManager,
            FluentTaskManager taskManager) {
        this.plugin = plugin;
        this.fluentConfig = fluentConfig;
        this.extensionsManager = extensionsManager;
        this.commandManger = commandManger;
        this.logger = logger;
        fluentInjection = injection;
        fluentMediator = mediator;
        fluentPermission = permission;
        fluentEvents = eventManager;
        simpleTasks = taskManager;
        simpleMessages = new SimpleMessage();
    }

    public void enable() {
        extensionsManager.onEnable(this);
    }

    public void disable() {
        extensionsManager.onDisable(this);
    }

    public FluentPermission permission() {
        return fluentPermission;
    }

    public FluentInjection container() {
        return fluentInjection;
    }

    public FluentMediator mediator() {
        return fluentMediator;
    }

    public FluentConfig config() {
        return fluentConfig;
    }

    public FluentEventManager events() {
        return fluentEvents;
    }

    public FluentTaskManager tasks() {
        return simpleTasks;
    }

    public FluentCommandManger commands() {
        return commandManger;
    }

    public CommandBuilder createCommand(String commandName) {
        return new CommandBuilderImpl(commandName, commandManger);
    }

    public SimpleMessage messages() {
        return simpleMessages;
    }

   /* public static FluentParticlebuilder particles() {
        return new FluentParticlebuilder(new ParticleSettings());
    }*/

    public Plugin plugin() {
        return plugin;
    }

    public BukkitLogger logger() {
        return logger;
    }

    public String path() {
        return FileUtility.pluginPath(plugin);
    }

    public String dataPath() {
        return path() + FileUtility.separator() + "data";
    }

}

