package io.github.jwdeveloper.ff.extension.commands.implementation;

import io.github.jwdeveloper.ff.extension.commands.api.FluentCommandOptions;
import io.github.jwdeveloper.ff.core.spigot.commands.FluentCommand;
import io.github.jwdeveloper.ff.core.spigot.commands.api.builder.SimpleCommandBuilder;
import io.github.jwdeveloper.ff.plugin.api.FluentApiSpigotBuilder;
import io.github.jwdeveloper.ff.plugin.api.extention.FluentApiExtension;
import io.github.jwdeveloper.ff.plugin.implementation.FluentApiSpigot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FluentCommandExtension implements FluentApiExtension {
    private final Consumer<FluentCommandOptions> consumer;
    private final FluentCommandOptions options;
    private final FluentCommandFactory factory;
    private final List<FluentCommandInvoker> invokers;
    private final List<SimpleCommandBuilder> builders;

    public FluentCommandExtension(Consumer<FluentCommandOptions> consumer) {
        this.consumer = consumer;
        options = new FluentCommandOptions();
        factory = new FluentCommandFactory();
        invokers = new ArrayList<>();
        builders = new ArrayList<>();
    }


    @Override
    public void onConfiguration(FluentApiSpigotBuilder builder) {
        consumer.accept(options);

        if(options.getDefaultCommand() != null)
        {
            var model = factory.create(options.getDefaultCommand(), builder.defaultCommand());
            invokers.addAll(model);
        }

        for (var command : options.getCommandClasses()) {
            var cmdBuilder = FluentCommand.create(command.getSimpleName());
            var cmdModels = factory.create(command, cmdBuilder);
            invokers.addAll(cmdModels);
            builders.add(cmdBuilder);
        }

        for(var invoker : invokers)
        {
            builder.container().registerSigleton(invoker.getCommandClass());
        }
    }


    @Override
    public void onFluentApiEnable(FluentApiSpigot fluentAPI) {
        for (var invoker : invokers)
        {
            var invokerInstance = fluentAPI.container().findInjection(invoker.getCommandClass());
            invoker.setCommandObject(invokerInstance);
        }

        for(var builder : builders)
        {
            builder.buildAndRegister();
        }
    }
}
