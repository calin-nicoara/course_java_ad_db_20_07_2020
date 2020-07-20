package ro.esolacad.javaad.designpatterns.di;

public class NormalAC implements AC{
    @Override
    public void coolAir() {
        System.out.println("Blowing cool air");
    }
}
