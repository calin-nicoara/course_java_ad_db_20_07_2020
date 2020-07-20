package ro.esolacad.javaad.designpatterns.di;

public class NormalMotor implements Motor{

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
