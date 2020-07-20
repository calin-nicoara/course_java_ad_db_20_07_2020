package ro.esolacad.javaad.designpatterns.factorymethod;

public class ManagerMonthlyActionPlan extends MonthlyActionPlan{
    @Override
    protected Employee getEmployee() {
        return new Manager();
    }
}
