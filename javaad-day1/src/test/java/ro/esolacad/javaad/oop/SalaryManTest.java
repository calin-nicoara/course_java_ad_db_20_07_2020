package ro.esolacad.javaad.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryManTest {

    @Test
    public void testPoly() {
        SalaryMan salaryMan = new User();

        System.out.println(salaryMan.getSalary());
    }

    @Test
    public void testPoly2() {
        SalaryMan salaryMan = new SuperUser();

        System.out.println(salaryMan.getSalary());

        Manager manager = new SuperUser();

        Manager manager1 = (SuperUser) salaryMan;
        System.out.println(manager1.getManagerStatus());

//        System.out.println(manager.getManagerStatus());
    }

}
