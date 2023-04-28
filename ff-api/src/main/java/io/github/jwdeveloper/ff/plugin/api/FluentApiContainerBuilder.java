package io.github.jwdeveloper.ff.api.api;


import io.github.jwdeveloper.spigot.fluent.core.injector.api.containers.builders.ContainerBuilder;


public interface FluentApiContainerBuilder extends ContainerBuilder<FluentApiContainerBuilder> {
    <T> FluentApiContainerBuilder registerDecorator(Class<T> _interface, Class<? extends T> _implementaition);
}
