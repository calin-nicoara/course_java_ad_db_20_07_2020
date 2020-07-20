package ro.esolacad.javaad.designpatterns.factorymethod;

public interface Employee {

    Integer doMonthlyTaxes(Integer income);
    void paySalary(final int salary);
}
