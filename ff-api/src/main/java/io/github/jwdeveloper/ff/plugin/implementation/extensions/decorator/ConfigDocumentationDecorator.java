package io.github.jwdeveloper.ff.plugin.implementation.extensions.decorator;

import io.github.jwdeveloper.ff.core.common.java.StringUtils;
import io.github.jwdeveloper.ff.core.common.logger.FluentLogger;
import io.github.jwdeveloper.ff.core.documentation.api.DocumentationDecorator;
import io.github.jwdeveloper.ff.core.documentation.api.models.Documentation;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigDocumentationDecorator extends DocumentationDecorator {


    @Override
    public void decorate(Documentation documentation) {
        addTitle("Configuration",documentation,"yml-title");
        addImage("https://raw.githubusercontent.com/jwdeveloper/SpigotFluentAPI/master/resources/banners/configuration.png",documentation);
        addYml(loadConfig(),documentation);
    }

    public String loadConfig()
    {
        try
        {
            var path = "";
            //path
            //var path = FluentApi.path()+ FileUtility.separator()+"config.yml";
            String content = new String(Files.readAllBytes(Paths.get(path)));
            return content;
        }
        catch (Exception e)
        {
            FluentLogger.LOGGER.error("ConfigDocumentationDecorator",e);
            return StringUtils.EMPTY;
        }
    }
}
