package io.github.jwdeveloper.ff.extension.files.file_handlers;

public interface SimpleFilesBuilder {

    void addJsonFile(String path, Class toClass);

    void addXmlFile(String path,  Class toClass);

    void addYmlFile(String path,  Class toClass);

    void addCustomFile(String path,  Class toClass);
}
