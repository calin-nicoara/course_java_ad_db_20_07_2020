package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {

    @Test
    public void firstLambda() {
        TransformString transformString = new TransformString() {
            @Override
            public String getModifiedString(final String inputString) {
                return inputString.toUpperCase();
            }
        };

        System.out.println(transformString.getModifiedString("hello!"));

        TransformString lambdaTransform = String::toString;

        System.out.println(lambdaTransform.getModifiedString("HELLO!"));
    }

    @Test
    public void testShowSomething() {
        ShowSomething showSomething = (label, value) -> System.out.println(label + ": " + value);

        showSomething.showSomething("The number is", 10);

        ShowANumber showANumber = (label, value) -> {
            System.out.println("Do something!");
            System.out.println(label + ": " + value);
        };
        showANumber.showANumber("The number is", 100);
    }

    @Test
    public void testGetNothing() {
        GetNothing getNothing = () -> System.out.println("Do something");

        getNothing.doSomething();
    }

    @Test
    public void testLambdasinFunctions() {
        testLambdaMethods((label, value) -> System.out.println(label + ": " + value));
    }

    private void testLambdaMethods(ShowSomething showSomething) {
        showSomething.showSomething("Hello. Lucky number", 7);
    }

    @Test
    public void testMethodReference() {
        ShowSomething showSomething = (label, value) -> {
            String upperCase = label.toUpperCase();
            System.out.println("NEW STRING:" + upperCase + " " + value);
        };
    }

    private String fromTestClass = "Fromtestclass";

    @Test
    public void testLambdaContext() {
        GetNothing getNothingAnon = new GetNothing() {
            private String test;

            @Override
            public void doSomething() {
                System.out.println(this.test);
            }
        };

        final String testString = "TEST_STRING";

        GetNothing getNothing = () -> {
            System.out.println(this.fromTestClass);
            System.out.println(testString);
            System.out.println("Do something");
        };

//        testString = "TEST_AGAIN";

        getNothing.doSomething();
    }

}
