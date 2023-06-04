package io.github.jwdeveloper.ff.extension.gui.core.api.managers.events;

import io.github.jwdeveloper.ff.extension.gui.core.api.FluentInventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

@AllArgsConstructor
@Getter
public class CloseGuiEvent implements Cancellable
{

    @Setter
    private boolean Cancelled;

    private FluentInventory inventory;


    private Player player;
}