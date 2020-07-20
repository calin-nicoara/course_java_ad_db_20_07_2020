package ro.esolacad.javaad.designpatterns.abstractfactory;

import java.util.Arrays;
import java.util.List;

public class AssistantEmployeeHistory implements EmployeeHistory{
    @Override
    public List<String> getFormerEmployees() {
        return Arrays.asList("MEtro", "google", "assistant r us");
    }
}
