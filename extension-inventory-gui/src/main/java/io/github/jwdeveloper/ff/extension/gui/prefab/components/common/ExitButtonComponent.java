package io.github.jwdeveloper.ff.extension.gui.prefab.components.common;

import io.github.jwdeveloper.ff.extension.gui.api.InventoryComponent;
import io.github.jwdeveloper.ff.extension.gui.api.InventoryDecorator;
import io.github.jwdeveloper.ff.extension.gui.api.InventorySettings;
import io.github.jwdeveloper.ff.extension.gui.api.events.OpenGuiEvent;
import io.github.jwdeveloper.ff.extension.gui.implementation.button_old.events.ButtonClickEvent;
import io.github.jwdeveloper.ff.extension.gui.api.references.ButtonRef;
import io.github.jwdeveloper.ff.extension.gui.api.references.InventoryRef;
import org.bukkit.Material;


public class ExitButtonComponent implements InventoryComponent {
    private final ButtonRef buttonRef = new ButtonRef();
    private final InventoryRef inventoryRef = new InventoryRef();

    @Override
    public void onInitialization(InventoryDecorator decorator) {

        decorator.withInventoryReference(inventoryRef);
        decorator.withButton(btn ->
        {
            btn.withTitle("Exit");
            btn.withReference(buttonRef);
            btn.withPosition(inventoryRef.get().settings().getHeight() - 1, InventorySettings.INVENTORY_WIDTH - 1);
            btn.withMaterial(Material.ARROW);
            btn.withOnLeftClick(this::onClick);
        });
        decorator.withEvents(e -> e.onOpen(this::onOpen));
    }

    private void onOpen(OpenGuiEvent event) {
        var button = buttonRef.getOrThrow();
        var inv = event.getInventory();
        if (inv.hasParent()) {
            button.setTitle("Go back");
        } else {
            button.setTitle("Close");
        }
        inv.buttons().refresh(button);
    }

    private void onClick(ButtonClickEvent event) {
        if (event.getInventory().hasParent()) {
            event.getInventory().parent().open(event.getPlayer());
        } else {
            event.getInventory().close();
        }

    }
}
