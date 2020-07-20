package ro.esolacad.javaad.designpatterns.factorymethod;

public class Assistant implements Employee{

    public Integer doMonthlyTaxes(Integer income) {
        return income / 2;
    }

    public void paySalary(final int salary) {
        System.out.println("Assistant got " + salary + " euro!");
    }
}
