package ro.esolacad.javaad.annotationandreflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ShouldRead {

    boolean value() default true;
}
