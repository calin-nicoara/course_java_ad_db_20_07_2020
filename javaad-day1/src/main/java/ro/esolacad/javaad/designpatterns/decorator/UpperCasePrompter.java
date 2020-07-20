package ro.esolacad.javaad.designpatterns.decorator;

public class UpperCasePrompter extends PrompterDecorator {

    public UpperCasePrompter(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public String giveMeALine() {
        return prompter.giveMeALine().toUpperCase();
    }
}
