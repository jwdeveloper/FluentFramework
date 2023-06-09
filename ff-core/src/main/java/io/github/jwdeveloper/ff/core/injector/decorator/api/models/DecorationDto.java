package io.github.jwdeveloper.ff.core.injector.decorator.api.models;

import io.github.jwdeveloper.ff.core.injector.api.models.InjectionInfo;

import java.util.List;

public record DecorationDto(Class<?> _interface, List<InjectionInfo> implementations)
{

}
