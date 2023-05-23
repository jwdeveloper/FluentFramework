package io.github.jwdeveloper.ff.plugin.implementation;

import io.github.jwdeveloper.ff.plugin.api.FluentApiContainerBuilder;
import io.github.jwdeveloper.ff.plugin.api.FluentApiSpigotBuilder;
import io.github.jwdeveloper.ff.plugin.api.assembly_scanner.FluentAssemblyScanner;
import io.github.jwdeveloper.ff.plugin.api.config.FluentConfig;
import io.github.jwdeveloper.ff.plugin.api.extention.FluentApiExtension;
import io.github.jwdeveloper.ff.plugin.implementation.extensions.command.FluentApiCommandBuilder;
import io.github.jwdeveloper.ff.plugin.implementation.extensions.permissions.api.FluentPermissionBuilder;
import io.github.jwdeveloper.ff.core.common.logger.BukkitLogger;
import io.github.jwdeveloper.ff.core.spigot.tasks.api.FluentTaskManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.nio.file.Path;


public class FluentApiBuilder implements FluentApiSpigotBuilder {

    public static FluentApiBuilder create(Plugin plugin, FluentApiExtension extension) {
        var builder = new FluentApiBuilder(new FluentApiSpigotBuilderImpl(plugin));
        builder.useExtension(extension);
        return builder;
    }


    public static FluentApiBuilder create(Plugin plugin) {
        return create((JavaPlugin) plugin);
    }

    public static FluentApiBuilder create(JavaPlugin plugin) {
        return new FluentApiBuilder(new FluentApiSpigotBuilderImpl(plugin));
    }

    private final FluentApiSpigotBuilderImpl builder;

    FluentApiBuilder(FluentApiSpigotBuilderImpl builder) {
        this.builder = builder;
    }

    @Override
    public FluentApiCommandBuilder defaultCommand() {
        return builder.defaultCommand();
    }

    @Override
    public FluentApiContainerBuilder container() {
        return builder.container();
    }

    @Override
    public FluentApiSpigotBuilder useExtension(FluentApiExtension extension) {
        return builder.useExtension(extension);
    }
    @Override
    public FluentConfig config() {
        return builder.config();
    }

    @Override
    public FluentPermissionBuilder permissions() {
        return builder.permissions();
    }

    @Override
    public Plugin plugin() {
        return builder.plugin();
    }

    @Override
    public Path pluginPath() {
        return builder.pluginPath();
    }

    @Override
    public FluentAssemblyScanner classFinder() {
        return builder.classFinder();
    }

    @Override
    public BukkitLogger logger() {
        return builder.logger();
    }

    @Override
    public FluentTaskManager tasks() {
        return builder.tasks();
    }

    public FluentApiSpigot build() throws Exception {
        var api = builder.build();
        FluentApi.setFluentApiSpigot(api);
        return api;
    }
}
