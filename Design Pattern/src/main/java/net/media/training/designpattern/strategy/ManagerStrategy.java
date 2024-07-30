package net.media.training.designpattern.strategy;

public class ManagerStrategy  implements Strategy{
    public void checkSalary(int salary){
        atLeast(salary, 1);
    }
}
