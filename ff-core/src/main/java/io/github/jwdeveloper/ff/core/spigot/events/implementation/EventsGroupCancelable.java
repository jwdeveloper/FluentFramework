package io.github.jwdeveloper.ff.core.spigot.events.implementation;

import org.bukkit.event.Cancellable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventsGroupCancelable<T extends Cancellable>
{
    private final List<Consumer<T>> events;

    public EventsGroupCancelable()
    {
        events = new ArrayList<>();
    }

    public boolean invoke(T payload)
    {
        for(var event : events)
        {
            if(payload.isCancelled())
            {
               return false;
            }
            event.accept(payload);
        }
        return true;
    }

    public void subscribe(Consumer<T> event)
    {
        events.add(event);
    }

    public void unsubscribe(Consumer<T> event)
    {
        events.remove(event);
    }
}
