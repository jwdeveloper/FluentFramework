package io.github.jwdeveloper.ff.plugin.api.assembly_scanner;

import java.lang.annotation.Annotation;
import java.util.Collection;

public interface JarScanner
{
      void attacheAllClassesFromPackage(Class<?> clazz);
     Collection<Class<?>> findByAnnotation(Class<? extends Annotation> annotation);

     Collection<Class<?>> findByInterface(Class<?> _interface);

     Collection<Class<?>> findBySuperClass(Class<?> superClass);

     Collection<Class<?>> findByPackage(Package _package);
}
