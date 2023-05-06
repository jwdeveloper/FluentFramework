package io.github.jwdeveloper.ff.extension.mysql.api.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Key
{
    boolean isPrimary() default true;

    boolean autoIncrement() default true;
}
