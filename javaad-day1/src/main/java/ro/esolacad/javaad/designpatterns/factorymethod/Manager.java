package ro.esolacad.javaad.designpatterns.factorymethod;

public class Manager implements Employee{
    @Override
    public Integer doMonthlyTaxes(final Integer income) {
        return income / 4;
    }

    @Override
    public void paySalary(final int salary) {
        System.out.println("Manager got " + salary*1.5 + " euro!");
    }
}
