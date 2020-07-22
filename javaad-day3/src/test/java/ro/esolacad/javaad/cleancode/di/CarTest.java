package ro.esolacad.javaad.cleancode.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testNull() {
        Car car = new Car(new NormalMotor());

        car.setAC(new NormalAC());
        car.getAirConditioner().ifPresent(ac -> ac.coolAir());

        String stringToUse = null;

        if(stringToUse != null) {
            car.useString(stringToUse);
        }
    }
}
