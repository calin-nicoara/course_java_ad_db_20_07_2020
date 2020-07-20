package ro.esolacad.javaad.designpatterns.abstractfactory;

import java.util.Arrays;
import java.util.List;

public class ManagerHistory implements EmployeeHistory{
    @Override
    public List<String> getFormerEmployees() {
        return Arrays.asList("Google", "FAcebook", "Apple");
    }
}
