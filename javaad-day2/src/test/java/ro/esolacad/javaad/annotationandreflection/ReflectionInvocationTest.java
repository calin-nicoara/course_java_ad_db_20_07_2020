package ro.esolacad.javaad.annotationandreflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInvocationTest {

    @Test
    public void testGetMethodInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<? extends ReflectionUser> aClass = reflectionUser.getClass();

        Method getIdMethod = aClass.getDeclaredMethod("getId");

        Object id = getIdMethod.invoke(reflectionUser);

        assert id.equals(1L);
        System.out.println(id);
    }

    @Test
    public void testSetMethodInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<? extends ReflectionUser> aClass = reflectionUser.getClass();

        Method getIdMethod = aClass.getDeclaredMethod("setId", Long.class);
//        getIdMethod.setAccessible(true);

        Object result = getIdMethod.invoke(reflectionUser, 10L);

        assert result == null;
        assert reflectionUser.getId().equals(10L);

        System.out.println(reflectionUser.getId());
    }

    @Test
    public void testNoArgsContructor() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<?> constructor = ReflectionUser.class.getConstructor();

        Object o = constructor.newInstance();

        System.out.println(o);
    }

    @Test
    public void testWithArgsContructor() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<?> constructor = ReflectionUser.class.getConstructor(Long.class, String.class);

        Object o = constructor.newInstance(5L, "Dynamic Instance");

        System.out.println(o);
    }
}
