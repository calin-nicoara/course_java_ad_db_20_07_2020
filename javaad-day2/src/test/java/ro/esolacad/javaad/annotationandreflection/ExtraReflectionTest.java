package ro.esolacad.javaad.annotationandreflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ExtraReflectionTest {

    @Test
    public void testSupperClass() {
        Class<? super ChildReflectionUser> superclass = ChildReflectionUser.class.getSuperclass();

        assert superclass.equals(ReflectionUser.class);
    }

    @Test
    public void testModifiers() throws NoSuchFieldException {
        Field field = ReflectionUser.class.getField("publicVariable");

        assert Modifier.isPublic(field.getModifiers());
        assert !Modifier.isStatic(field.getModifiers());

//        ReflectionUser.class.getPackage()
    }

    @Test
    public void testUSeCustomAnnotation() {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "different_secret", "public");

        Arrays.stream(reflectionUser.getClass().getDeclaredFields())
                .filter(field -> {
                    ShouldRead annotation = field.getAnnotation(ShouldRead.class);
                    return annotation != null && annotation.value();
                })
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        System.out.println(field.getName() + " " + field.get(reflectionUser));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }


}
