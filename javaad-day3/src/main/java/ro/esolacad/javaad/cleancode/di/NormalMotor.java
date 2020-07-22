package ro.esolacad.javaad.cleancode.di;

public class NormalMotor implements Motor{

    @Override
    public void goFast() {
        System.out.println("Motor is going fast!");
    }

    @Override
    public void stopMotor() {
        if(true) {
            throw new MotorStoppedException("Motor stopped!");
        }

        System.out.println("Motor stopped");
    }

    @Override
    public void start() {
        System.out.println("Start motor");
    }
}
