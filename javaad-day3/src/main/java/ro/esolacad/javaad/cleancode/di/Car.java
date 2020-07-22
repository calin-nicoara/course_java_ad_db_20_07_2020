package ro.esolacad.javaad.cleancode.di;

import java.util.Optional;

public class Car {

    private final Motor motor;
    private AC airConditioner;

    public Car(final Motor motor) {
        this.motor = motor;
    }

    public void setAC(AC airConditioner) {
        this.airConditioner = airConditioner;
    }

    public void accelerate() {
        System.out.println("Car accelerating");
        motor.goFast();
    }

    public Optional<AC> getAirConditioner() {
        return Optional.ofNullable(airConditioner);
    }

    public void stopCar() {
        System.out.println("Stopping car");
        motor.stopMotor();
    }

    public void startCar() {
        motor.start();

        if(airConditioner != null) {
            airConditioner.coolAir();
        }
    }

    public void useString(String string) {
        System.out.println(string.toUpperCase());
    }
}
