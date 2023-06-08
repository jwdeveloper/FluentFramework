package io.github.jwdeveloper.ff.extension.gui.implementation.button_old.events;


import lombok.AllArgsConstructor;
import lombok.Getter;
import io.github.jwdeveloper.ff.extension.gui.implementation.FluentInventoryImpl;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@AllArgsConstructor
public class SpigotListenerActionEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    private FluentInventoryImpl inventory;

    private State state;

    public enum State
    {
        Register,Unregister
    }
}