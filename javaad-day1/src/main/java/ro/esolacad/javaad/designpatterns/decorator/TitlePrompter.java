package ro.esolacad.javaad.designpatterns.decorator;

public class TitlePrompter extends PrompterDecorator{

    public TitlePrompter(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public String giveMeALine() {
        return "-------------------------------------\n" +
                "-----" + prompter.giveMeALine() + "----\n" +
                "-------------------------------------";
    }
}
