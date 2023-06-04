package io.github.jwdeveloper.ff.extension.gui.inventory;


import io.github.jwdeveloper.ff.extension.gui.core.implementation.ButtonType;
import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.ButtonUIEvent;
import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.observer_button.ButtonObserverUI;
import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.observer_button.observers.ButtonNotifier;
import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.observer_button.observers.ButtonObserverBuilder;
import io.github.jwdeveloper.ff.extension.gui.inventory.styles.renderer.ButtonStyleRenderer;
import io.github.jwdeveloper.ff.extension.gui.inventory.styles.ButtonDescriptionInfoBuilder;

import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.observer_button.ButtonObserverUIBuilder;
import io.github.jwdeveloper.ff.extension.gui.core.implementation.button.observer_button.observers.ButtonObserver;
import io.github.jwdeveloper.ff.core.observer.implementation.Observer;
import org.bukkit.Color;
import org.bukkit.Material;
import io.github.jwdeveloper.ff.extension.gui.core.api.managers.events.ClickGuiEvent;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class FluentButtonUIBuilder {
    private final ButtonDescriptionInfoBuilder descriptionBuilder;
    private final ButtonObserverUIBuilder buttonBuilder;
    private ButtonRef buttonUIRef;

    public FluentButtonUIBuilder() {
        descriptionBuilder = new ButtonDescriptionInfoBuilder();
        buttonBuilder = new ButtonObserverUIBuilder();
        buttonUIRef = new ButtonRef();
    }

    public <T> FluentButtonUIBuilder setObserver(Observer<T> observer, ButtonNotifier<T> buttonNotifier) {
        buttonBuilder.addObserver(observer, buttonNotifier);
        return this;
    }

    public <T> FluentButtonUIBuilder setObserver(Supplier<Observer<T>> observer, ButtonNotifier<T> buttonNotifier) {
        buttonBuilder.addObserver(observer, buttonNotifier);
        return this;
    }

    public <T> FluentButtonUIBuilder setObserver(Consumer<ButtonObserverBuilder<T>> consumer) {
        var observer = new ButtonObserverBuilder<T>();
        consumer.accept(observer);
        buttonBuilder.addObserver(observer);
        return this;
    }

    public <T> FluentButtonUIBuilder setObserver(ButtonObserver<T> buttonObserver) {
        buttonBuilder.addObserver(buttonObserver);
        return this;
    }


    public FluentButtonUIBuilder setDescription(Consumer<ButtonDescriptionInfoBuilder> consumer) {
        consumer.accept(descriptionBuilder);
        return this;
    }

    public FluentButtonUIBuilder setLocation(int height, int width) {
        buttonBuilder.setLocation(height, width);
        return this;
    }

    public FluentButtonUIBuilder setMaterial(Material material) {
        buttonBuilder.setMaterial(material);
        return this;
    }

    public FluentButtonUIBuilder setMaterial(Material material, int customMaterialId) {
        buttonBuilder.setCustomMaterial(material, customMaterialId);
        return this;
    }

    public FluentButtonUIBuilder setMaterial(Material material, int customMaterialId, Color color)
    {
        buttonBuilder.setCustomMaterial(material, customMaterialId, color);
        return this;
    }

    public FluentButtonUIBuilder setButtonType(ButtonType type) {
        buttonBuilder.setButtonType(type);
        return this;
    }

    public FluentButtonUIBuilder setPermissions(String... permissions) {
        buttonBuilder.setPermissions(permissions);
        return this;
    }
    public FluentButtonUIBuilder setOnRefresh(Consumer<ClickGuiEvent> event) {

        return this;
    }
    public FluentButtonUIBuilder setOnLeftClick(Consumer<ClickGuiEvent> event) {

        return this;
    }

    public FluentButtonUIBuilder setOnLeftClick(ButtonUIEvent event) {
        buttonBuilder.setOnClick(event);
        return this;
    }

    public FluentButtonUIBuilder setOnRightClick(ButtonUIEvent event) {
        buttonBuilder.setOnRightClick(event);
        return this;
    }

    public FluentButtonUIBuilder setOnShiftClick(ButtonUIEvent event) {
        buttonBuilder.setOnShiftClick(event);
        return this;
    }

    public FluentButtonUIBuilder setHighlighted() {
        buttonBuilder.setHighlighted();
        return this;
    }

    public FluentButtonUIBuilder setReference(ButtonRef refrence)
    {
        this.buttonUIRef = refrence;
        return this;
    }

    public ButtonObserverUI build(ButtonStyleRenderer renderer) {
        var description = renderer.render(descriptionBuilder.build());
        buttonBuilder.setDescription(description);
        buttonBuilder.setTitle(" ");
        var button = buttonBuilder.build();
        buttonUIRef.set(null);
        return button;
    }
}
