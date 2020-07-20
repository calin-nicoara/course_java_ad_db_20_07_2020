package ro.esolacad.javaad.designpatterns;

import org.junit.jupiter.api.Test;

import ro.esolacad.javaad.designpatterns.factorymethod.ManagerMonthlyActionPlan;
import ro.esolacad.javaad.designpatterns.factorymethod.MonthlyActionPlan;

class MonthlyActionPlanTest {

    @Test
    public void testMonthlyActionPlan() {
//        MonthlyActionPlan monthlyActionPlan = new AssistantMonthlyActionPlan();
        MonthlyActionPlan monthlyActionPlan = new ManagerMonthlyActionPlan();

        monthlyActionPlan.doMonthlyAction(10000);
    }

}
