package io.github.jwdeveloper.ff.core.spigot.commands.api.models;

import io.github.jwdeveloper.ff.core.spigot.commands.api.enums.ArgumentDisplay;
import io.github.jwdeveloper.ff.core.spigot.commands.api.enums.ArgumentType;
import io.github.jwdeveloper.ff.core.spigot.commands.implementation.validators.CommandArgumentValidator;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Getter
@Setter
public class CommandArgument {
    private String name;

    private ArgumentType type = ArgumentType.TEXT;

    private ArgumentDisplay argumentDisplayMode = ArgumentDisplay.TYPE;
    private List<CommandArgumentValidator> validators = new ArrayList<>();

    private String description;

    private ChatColor color = ChatColor.WHITE;

    private Supplier<List<String>> tabCompleter = () -> {
        return List.of();
    };

    private Supplier<List<String>> onTabCompleter = () -> {
        return List.of();
    };

    public void addValidator(CommandArgumentValidator validator) {
        validators.add(validator);
    }
}
