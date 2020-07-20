package ro.esolacad.javaad.designpatterns.abstractfactory;

public interface EmployeeDetailsFactory {
    EmployeeHistory getHistory();
    EmployeeReview getReview();
}
