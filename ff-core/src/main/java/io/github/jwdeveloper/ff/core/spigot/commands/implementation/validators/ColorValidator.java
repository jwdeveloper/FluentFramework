package io.github.jwdeveloper.ff.core.spigot.commands.implementation.validators;
import org.bukkit.ChatColor;

public class ColorValidator extends EnumValidator<ChatColor>
{
    public ColorValidator() {
        super(ChatColor.class);
    }
}
