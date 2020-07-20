package ro.esolacad.javaad.designpatterns.factorymethod;

public abstract class MonthlyActionPlan {

//    public void doMonthlyAction(Integer income) {
//        System.out.println("Starting monthly action plan");
//
//        Assistant assistant = new Assistant();
//
//        Integer taxes = assistant.doMonthlyTaxes(income);
//
//        System.out.println("Taxes are " + taxes);
//        assistant.paySalary(100);
//
//        System.out.println("Ending monthly action plan");
//    }

    public void doMonthlyAction(Integer income) {
        System.out.println("Starting monthly action plan");

        Employee employee = getEmployee();

        Integer taxes = employee.doMonthlyTaxes(income);

        System.out.println("Taxes are " + taxes);
        employee.paySalary(100);

        System.out.println("Ending monthly action plan");
    }

    protected abstract Employee getEmployee();
}
