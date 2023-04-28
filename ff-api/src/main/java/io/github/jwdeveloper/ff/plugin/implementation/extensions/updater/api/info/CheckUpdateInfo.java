package io.github.jwdeveloper.ff.api.implementation.extensions.updater.api.info;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckUpdateInfo {

    private boolean isUpdate;
    private UpdateInfo updateInfo;
}
