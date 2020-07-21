package ro.esolacad.javaad.annotationandreflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
public @interface CustomAnnotation {
    String name();
    String createdBy() default "me";
    int numberOfDays() default 1;
    String[] updaters() default {"Ionut"};
}
