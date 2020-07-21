package ro.esolacad.javaad.annotationandreflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class ReflectionExampleTest {

    @Test
    public void testClass() {
//        Class<ReflectionUser> reflectionUserClass = ReflectionUser.class;

        ReflectionUser reflectionUser = new ReflectionUser();

        Class<?> aClass = reflectionUser.getClass();

        assert aClass == ReflectionUser.class;

        System.out.println(aClass.getName());
        System.out.println(aClass.getSimpleName());
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] constructors = ReflectionUser.class.getConstructors();

        assert constructors.length == 3;

        Optional<Constructor<?>> any = Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterCount() == 2)
                .findAny();

        Class<?>[] parameterTypes = any.get().getParameterTypes();

        assert parameterTypes[0] == Long.class;
        assert parameterTypes[1] == String.class;
    }

    @Test
    public void getConstructor() {
        try {
            Constructor<ReflectionUser> constructor = ReflectionUser.class.getConstructor(Long.class, String.class);
            assert constructor != null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getMethods() {
        Arrays.stream(ReflectionUser.class.getMethods())
        .forEach(x -> System.out.println(x.getName()));

        System.out.println();
        System.out.println("-------------------------");
        Arrays.stream(ReflectionUser.class.getDeclaredMethods())
                .forEach(x -> System.out.println(x.getName()));
    }

    @Test
    public void getFields() {
        Arrays.stream(ChildReflectionUser.class.getFields())
                .forEach(x -> System.out.println(x.getName()));

        System.out.println();
        System.out.println("-------------------------");
        Arrays.stream(ChildReflectionUser.class.getDeclaredFields())
                .forEach(x -> System.out.println(x.getName()));
    }
}
