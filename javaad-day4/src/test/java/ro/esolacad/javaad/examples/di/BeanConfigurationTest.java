package ro.esolacad.javaad.examples.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ro.esolacad.javaad.examples.car.Car;

@SpringBootTest
@ActiveProfiles("dev")
public class BeanConfigurationTest {

    @Autowired
    private Car car;

    @Autowired
    @Qualifier("urlForDatabase")
    private String injectedString;

    @Test
    public void testCarBean() {
        car.startCar();
    }

    @Test
    public void testDatabaseUrl() {
        System.out.println(injectedString);
    }
}
