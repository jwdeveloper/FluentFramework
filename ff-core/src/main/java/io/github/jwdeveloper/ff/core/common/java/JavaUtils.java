package io.github.jwdeveloper.ff.core.common.java;

import java.util.function.Consumer;

public class JavaUtils {
    public static <T> void ifNotNull(T input, Consumer<T> action) {
        if(input == null)
            return;
        action.accept(input);
    }
}
