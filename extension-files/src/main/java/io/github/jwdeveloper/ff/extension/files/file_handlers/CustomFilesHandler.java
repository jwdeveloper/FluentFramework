package io.github.jwdeveloper.ff.extension.files.file_handlers;



import io.github.jwdeveloper.ff.extension.files.api.CustomFile;

import java.util.ArrayList;
import java.util.List;

public class CustomFilesHandler implements FileHandler {

    private final List<CustomFile> files = new ArrayList<>();

    @Override
    public void load() {
        for (var file : files) {
            file.load();
        }
    }

    @Override
    public void save() {
        for (var file : files) {
            file.save();
        }
    }

    @Override
    public void addObject(Object object) {
        files.add((CustomFile)object);
    }

    @Override
    public void removeObject(Object object) {
        files.remove(object);
    }
}
