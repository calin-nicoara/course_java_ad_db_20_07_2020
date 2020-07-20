package ro.esolacad.javaad.designpatterns.abstractfactory;

public class ManagerReview implements EmployeeReview{
    @Override
    public int getGeneralScore() {
        return 1000;
    }
}
