package ro.esolacad.javaad.annotationandreflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionFieldTest {

    @Test
    public void getFieldValue() {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<?> reflectionClass = reflectionUser.getClass();

        try {
            Field publicVariable = reflectionClass.getField("publicVariable");
            Object o = publicVariable.get(reflectionUser);
            assert o.equals("public");
            System.out.println(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setFieldValue() {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<?> reflectionClass = reflectionUser.getClass();

        try {
            Field publicVariable = reflectionClass.getField("publicVariable");
            publicVariable.set(reflectionUser, "newPublic");
            assert reflectionUser.publicVariable.equals("newPublic");
            System.out.println(reflectionUser.publicVariable);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDeclaredFieldValue() {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<?> reflectionClass = reflectionUser.getClass();

        try {
            Field privateVariable = reflectionClass.getDeclaredField("secret");
            privateVariable.setAccessible(true);
            Object o = privateVariable.get(reflectionUser);
            assert o.equals("secret");
            System.out.println(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStaticFieldValue() {
        ReflectionUser reflectionUser = new ReflectionUser(1L, "secret", "public");

        Class<?> reflectionClass = reflectionUser.getClass();

        try {
            Field privateVariable = reflectionClass.getDeclaredField("publicStaticVariable");
            Object o = privateVariable.get(null);
            assert o.equals("STATIC");
            System.out.println(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
