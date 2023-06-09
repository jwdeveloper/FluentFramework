package io.github.jwdeveloper.ff.core.injector.api.factory;

import io.github.jwdeveloper.ff.core.common.java.Pair;
import io.github.jwdeveloper.ff.core.injector.api.models.InjectionInfo;
import io.github.jwdeveloper.ff.core.injector.api.models.RegistrationInfo;


public interface InjectionInfoFactory
{
    public Pair<Class<?>, InjectionInfo> create(RegistrationInfo registrationInfo) throws Exception;
}
