package ro.esolacad.javaad.annotationandreflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionProxyTest {

    @Test
    public void testProxy() {
        List<String> listToProxy = new ArrayList<>();
        listToProxy.add("1");
        listToProxy.add("2");
        listToProxy.add("3");


        List proxyList = (List)Proxy.newProxyInstance(
                List.class.getClassLoader(),
                new Class[]{List.class},
                (proxy, method, args) -> {
                    System.out.println("Calling method " + method.getName() +
                            " with params " + Arrays.toString(args));

                    return method.invoke(listToProxy,args);
                }
        );

        proxyList.add("hello");

        System.out.println(listToProxy);
    }
}
