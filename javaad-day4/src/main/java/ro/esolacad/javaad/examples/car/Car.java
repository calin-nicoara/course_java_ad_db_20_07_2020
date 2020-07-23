package ro.esolacad.javaad.examples.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

//    @Autowired
    private final Motor motor;
    private final String customLabel;
//    @Autowired(required = false)
    private AC airConditioner;

    public Car(final Motor motor, final @Value("${custom-label}") String customLabel) {
        this.motor = motor;
        this.customLabel = customLabel;
    }

    @Autowired(required = false)
    public void setAC(AC airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void accelerate() {
        System.out.println("Car accelerating");
        motor.goFast();
    }

    public void stopCar() {
        System.out.println("Stopping car");
        motor.stopMotor();
    }

    public void startCar() {
        System.out.println("This is custom label: " + customLabel);

        motor.start();

        if(airConditioner != null) {
            airConditioner.coolAir();
        }
    }
}
