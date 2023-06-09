package io.github.jwdeveloper.ff.core.injector.api.events.events;

import io.github.jwdeveloper.ff.core.injector.api.models.InjectionInfo;
import io.github.jwdeveloper.ff.core.injector.api.models.RegistrationInfo;
public record OnRegistrationEvent(Class<?> input, InjectionInfo injectionInfo, RegistrationInfo registrationInfo) {
}
