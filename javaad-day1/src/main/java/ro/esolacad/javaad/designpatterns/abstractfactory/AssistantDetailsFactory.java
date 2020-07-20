package ro.esolacad.javaad.designpatterns.abstractfactory;

public class AssistantDetailsFactory implements EmployeeDetailsFactory {

    @Override
    public EmployeeHistory getHistory() {
        return new AssistantEmployeeHistory();
    }

    @Override
    public EmployeeReview getReview() {
        return new AssistantEmployeeReview();
    }
}
