package net.media.training.designpattern.strategy;

public class EmployeeStrategy implements Strategy{
    public void checkSalary(int salary){
        atMost(salary, 1000);
        atLeast(salary, 1);
    }


    public void checkMonthsSpent(int months){
        atLeast(months, 0);
    }

    public void checkMaxAllowedLeaves(int leaves){
        atLeast(leaves, 1);
    }
}
