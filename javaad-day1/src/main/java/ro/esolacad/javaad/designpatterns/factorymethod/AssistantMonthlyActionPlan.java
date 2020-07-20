package ro.esolacad.javaad.designpatterns.factorymethod;

public class AssistantMonthlyActionPlan extends MonthlyActionPlan{
    @Override
    protected Employee getEmployee() {
        return new Assistant();
    }
}
