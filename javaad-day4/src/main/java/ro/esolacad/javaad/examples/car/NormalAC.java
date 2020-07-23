package ro.esolacad.javaad.examples.car;

import org.springframework.stereotype.Component;

@Component
public class NormalAC implements AC{
    @Override
    public void coolAir() {
        System.out.println("Blowing cool air");
    }
}
