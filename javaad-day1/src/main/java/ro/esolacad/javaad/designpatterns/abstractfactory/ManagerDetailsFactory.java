package ro.esolacad.javaad.designpatterns.abstractfactory;

public class ManagerDetailsFactory implements EmployeeDetailsFactory{
    @Override
    public EmployeeHistory getHistory() {
        return new ManagerHistory();
    }

    @Override
    public EmployeeReview getReview() {
        return new ManagerReview();
    }
}
