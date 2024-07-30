package net.media.training.designpattern.abstractfactory;

public interface PhoneFactory {
    MotherBoard createMotherBoard();
    Case createCase();
    Processor createProcessor();
    Screen createScreen();
    default Battery createBattery(){
        return new Battery();
    }
}
