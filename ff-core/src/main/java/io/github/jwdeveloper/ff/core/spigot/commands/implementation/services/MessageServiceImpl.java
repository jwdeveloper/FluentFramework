package io.github.jwdeveloper.ff.core.spigot.commands.implementation.services;


import io.github.jwdeveloper.ff.core.spigot.commands.api.services.MessagesService;
import io.github.jwdeveloper.ff.core.spigot.messages.message.MessageBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageServiceImpl implements MessagesService
{

    @Override
    public String noPermission(CommandSender sender, String permission)
    {
        return new MessageBuilder()
                .inBrackets(sender.getName())
                .space()
                .color(ChatColor.RED)
                .color(ChatColor.BOLD)
                .text("has no permission ->")
                .space()
                .color(ChatColor.RESET)
                .text(permission)
                .toString();
    }
}
