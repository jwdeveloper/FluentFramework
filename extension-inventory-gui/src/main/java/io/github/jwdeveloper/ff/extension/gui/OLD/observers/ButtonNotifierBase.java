package io.github.jwdeveloper.ff.extension.gui.OLD.observers;

import io.github.jwdeveloper.ff.extension.gui.OLD.observer_button.observers.ButtonNotifier;
import io.github.jwdeveloper.ff.extension.gui.OLD.observer_button.observers.ButtonObserverEvent;
import lombok.Getter;

import java.util.List;

public abstract class ButtonNotifierBase<T> implements ButtonNotifier<T> {

    @Getter
    private final String id;

    @Getter
    private boolean isInitialized = false;
    @Getter
    private int descriptionIndex = -1;

    public ButtonNotifierBase(NotifierOptions notifierOptions) {
        id = notifierOptions.getId();
    }

    protected abstract void onInitialize(ButtonObserverEvent<T> event);

    protected abstract void onUpdate(ButtonObserverEvent<T> event);

    @Override
    public final void onValueChanged(ButtonObserverEvent<T> event) {
        if (!isInitialized) {
            if (!initialize(event.getButton().getDescription())) {
                return;
            }

            onInitialize(event);
            isInitialized = true;
        }
        onUpdate(event);
    }

    private boolean initialize(List<String> description) {
        for (var i = 0; i < description.size(); i++) {
            var line = description.get(i);
            if (line.contains("<observer>")) {
                descriptionIndex = i;
                var index = line.indexOf('>');
                var id = line.substring(index + 1);
                if (getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }
}
