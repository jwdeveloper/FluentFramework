package io.github.jwdeveloper.ff.extension.gui.OLD.observers.string;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
@AllArgsConstructor
public class TextInputEvent {
    private Player player;
    private String message;
}
