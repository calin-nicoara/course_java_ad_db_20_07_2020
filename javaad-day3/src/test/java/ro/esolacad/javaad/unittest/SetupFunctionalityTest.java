package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SetupFunctionalityTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
    }

    @Test
    @Order(3)
    public void testSomething1() {
        System.out.println("Test 1");
    }

    @Test
    @Order(1)
    public void testSomething2() {
        System.out.println("Test 2");
    }

    @Test
    @Order(2)
    public void testSomething3() {
        System.out.println("Test 3");
    }

}
