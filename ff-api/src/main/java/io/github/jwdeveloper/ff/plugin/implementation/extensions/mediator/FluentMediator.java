package io.github.jwdeveloper.ff.api.implementation.extensions.mediator;

public interface FluentMediator
{
    public <Output> Output resolve(Object input, Class<Output> outputClass);
}

