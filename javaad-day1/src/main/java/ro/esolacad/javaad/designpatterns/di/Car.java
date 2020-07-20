package ro.esolacad.javaad.designpatterns.di;

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
}
