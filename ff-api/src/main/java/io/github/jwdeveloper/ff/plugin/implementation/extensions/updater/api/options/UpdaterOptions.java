package io.github.jwdeveloper.ff.api.implementation.extensions.updater.api.options;

import lombok.Data;

@Data
public class UpdaterOptions
{
    private boolean forceUpdate;
    private boolean checkUpdateOnStart = true;
    private String commandName = "update";
}
