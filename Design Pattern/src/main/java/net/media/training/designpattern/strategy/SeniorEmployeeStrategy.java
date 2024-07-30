package net.media.training.designpattern.strategy;

public class SeniorEmployeeStrategy implements Strategy{
    public void checkSalary(int salary){
        atMost(salary, 1000);
        atLeast(salary, 200);
    }

    public void checkMonthsSpent(int months){
        atLeast(months, 60);
    }
}
