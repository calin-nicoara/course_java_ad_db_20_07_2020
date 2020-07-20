package ro.esolacad.javaad.designpatterns.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    public void testFactory() {
//        EmployeeDetailsFactory employeeDetailsFactory = new AssistantDetailsFactory();
        EmployeeDetailsFactory employeeDetailsFactory = new ManagerDetailsFactory();

        EmployeeHistory history = employeeDetailsFactory.getHistory();
        System.out.println(history.getFormerEmployees());

        EmployeeReview employeeReview = employeeDetailsFactory.getReview();
        System.out.println(employeeReview.getGeneralScore());
    }
}
