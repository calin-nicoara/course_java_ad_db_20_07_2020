package ro.esolacad.javaad.examples.car;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Motorcycle {

    private final Motor motor;

    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Motorcycle is up");
        System.out.println("----------------------------------");
        System.out.println();
    }

    public Motorcycle(final Motor motor) {
        this.motor = motor;
    }
}
