package io.github.jwdeveloper.ff.extension.gui.implementation.button_old.observer_button.observers;

public interface ButtonNotifier<T>
{
     void onLeftClick(ButtonObserverEvent<T> event);

     default void onRightClick(ButtonObserverEvent<T> event)
     {

     }

     void onValueChanged(ButtonObserverEvent<T> event);
}