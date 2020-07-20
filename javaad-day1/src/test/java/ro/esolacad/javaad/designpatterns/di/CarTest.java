package ro.esolacad.javaad.designpatterns.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testDi() {
        Motor motor = new NormalMotor();
        Car car = new Car(motor);

        car.accelerate();
        car.stopCar();
    }

    @Test
    public void testDiSetter() {
        Motor motor = new NormalMotor();
        Car car = new Car(motor);

        car.startCar();

        car.setAC(new NormalAC());

        car.startCar();
    }
}
