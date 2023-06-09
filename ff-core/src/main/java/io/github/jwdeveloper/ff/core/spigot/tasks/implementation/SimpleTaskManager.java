package io.github.jwdeveloper.ff.core.spigot.tasks.implementation;

import io.github.jwdeveloper.ff.core.common.logger.PluginLogger;
import io.github.jwdeveloper.ff.core.common.logger.SimpleLogger;
import io.github.jwdeveloper.ff.core.spigot.tasks.api.FluentTaskManager;
import io.github.jwdeveloper.ff.core.spigot.tasks.api.TaskAction;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class SimpleTaskManager implements FluentTaskManager
{
    private final Plugin plugin;
    private final PluginLogger logger;

    public SimpleTaskManager(Plugin plugin, PluginLogger logger) {
        this.plugin = plugin;
        this.logger = logger;
    }

    public SimpleTaskTimer taskTimer(int ticks, TaskAction task) {
        return new SimpleTaskTimer(ticks, task, plugin, logger);
    }
    public BukkitTask task(Runnable action) {
        return Bukkit.getScheduler().runTask(plugin, action);
    }

    public void taskLater(Runnable action, int ticks) {
        Bukkit.getScheduler().runTaskLater(plugin, action, ticks);
    }
    public BukkitTask taskAsync(Runnable action) {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, action);
    }
}
