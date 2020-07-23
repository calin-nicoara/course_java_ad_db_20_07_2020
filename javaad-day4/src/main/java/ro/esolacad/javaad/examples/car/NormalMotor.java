package ro.esolacad.javaad.examples.car;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
//@Scope("prototype")
//@Profile("!dev")
public class NormalMotor implements Motor{

//    private List<String> strings  = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("NormalMotor is up");
        System.out.println("------------------------------------");
        System.out.println();
    }

    @Override
    public void goFast() {
        System.out.println("Motor is going fast!");
    }

    @Override
    public void stopMotor() {
        System.out.println("Motor stopped");
    }

    @Override
    public void start() {
        System.out.println("Start motor");
    }
}
