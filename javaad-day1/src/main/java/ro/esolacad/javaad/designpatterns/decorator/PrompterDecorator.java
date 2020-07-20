package ro.esolacad.javaad.designpatterns.decorator;

public abstract class PrompterDecorator implements Prompter{

    protected Prompter prompter;

    public PrompterDecorator(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public String giveMeALine() {
        return prompter.giveMeALine();
    }

    @Override
    public String methodOne() {
        return prompter.methodOne();
    }

    @Override
    public String methodTwo() {
        return prompter.methodTwo();
    }

    @Override
    public String methodThree() {
        return prompter.methodThree();
    }
}
