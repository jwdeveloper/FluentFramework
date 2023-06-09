package io.github.jwdeveloper.ff.core.files.yaml.implementation;

import io.github.jwdeveloper.ff.core.common.TextBuilder;
import io.github.jwdeveloper.ff.core.files.yaml.api.YamlModelMapper;
import io.github.jwdeveloper.ff.core.files.yaml.api.models.YamlContent;
import org.bukkit.configuration.file.YamlConfiguration;

import java.lang.reflect.InvocationTargetException;

public class SimpleYamlModelMapper implements YamlModelMapper {
    private final SimpleYamlValueResolver resolver;

    public SimpleYamlModelMapper() {
        resolver = new SimpleYamlValueResolver();
    }

    @Override
    public <T> YamlConfiguration mapToConfiguration(T data,
                                                    YamlContent model,
                                                    YamlConfiguration configuration,
                                                    boolean overrite) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        for (var content : model.getChildren()) {
            if (content.isList()) {
                resolver.setListContent(data, configuration, content);
                continue;
            }
            if (content.isObject()) {
                resolver.setObject(data, configuration, content, overrite);
                continue;
            }
            resolver.setValue(data, configuration, content, overrite);
        }
        if (model.hasDescription()) {
            var header = configuration.options().header();
            var openTag = "<" + data.getClass().getSimpleName() + ">";
            var closeTag = "</" + data.getClass().getSimpleName() + ">";
            var startIndex = header.indexOf(openTag);
            var endIndex = header.indexOf(closeTag);
            if (startIndex != -1 && endIndex != -1) {
                var temp = "";
                startIndex = startIndex > 1 ? startIndex - 1 : startIndex;
                temp = header.substring(0, startIndex);

                endIndex = header.indexOf(">", endIndex);
                temp += header.substring(endIndex + 1);
                header = temp;
            }
            var description = new TextBuilder()
                    .text(header)
                    .text("#" + openTag).newLine()
                    .text(model.getDescription())
                    .text(closeTag)
                            .toString();
            configuration.options().header(description);
        }
        return configuration;
    }

    @Override
    public Object mapFromConfiguration(Object object, YamlContent model, YamlConfiguration configuration) throws Exception {
        for (var content : model.getChildren()) {
            var field = content.getField();
            if (field == null) {
                continue;
            }

            field.setAccessible(true);
            if (content.isList()) {
                var list = resolver.getListContent(configuration, content);
                field.set(object, list);
                continue;
            }
            if (content.isObject()) {
                var value = resolver.getObject(configuration, content);
                field.set(object, value);
                continue;
            }
            var value = resolver.getValue(configuration, content);
            field.set(object, value);
        }
        return object;
    }
}
