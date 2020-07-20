package ro.esolacad.javaad.designpatterns.decorator;

public class HappyPrompter implements Prompter {

    public String giveMeALine() {
        return "It's beautiful day!";
    }

    @Override
    public String methodOne() {
        return null;
    }

    @Override
    public String methodTwo() {
        return null;
    }

    @Override
    public String methodThree() {
        return null;
    }
}
