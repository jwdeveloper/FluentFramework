package io.github.jwdeveloper.ff.core.injector.decorator.implementation;

import io.github.jwdeveloper.ff.core.injector.api.events.events.OnInjectionEvent;
import io.github.jwdeveloper.ff.core.injector.api.events.events.OnRegistrationEvent;
import io.github.jwdeveloper.ff.core.injector.decorator.api.Decorator;
import io.github.jwdeveloper.ff.core.injector.decorator.api.DecoratorInstanceProvider;
import io.github.jwdeveloper.ff.core.injector.decorator.api.models.DecorationDto;

import java.util.Map;

public class DefaultDecorator implements Decorator
{
    private final Map<Class<?>, DecorationDto> decorators;
    private final DecoratorInstanceProvider decoratorInstanceProvider;

    public DefaultDecorator(DecoratorInstanceProvider decoratorInstanceProvider,
                            Map<Class<?>, DecorationDto> decorators) {
        this.decorators = decorators;
        this.decoratorInstanceProvider = decoratorInstanceProvider;
    }

    @Override
    public boolean OnRegistration(OnRegistrationEvent event) {
        return true;
    }

    public Object OnInjection(OnInjectionEvent event) throws Exception {
        var decoratorDto =  decorators.get(event.input());
        if(decoratorDto == null)
        {
            return event.output();
        }
        var result = event.output();
        for(var injectionInfo : decoratorDto.implementations())
        {

            var nextDecorator = decoratorInstanceProvider.getInstance(
                    injectionInfo,
                    event.injectionInfoMap(),
                    result,
                    event.container());
            result = nextDecorator;
        }
        return result;
    }
}
