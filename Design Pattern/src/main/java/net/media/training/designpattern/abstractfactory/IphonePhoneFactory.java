package net.media.training.designpattern.abstractfactory;

public class IphonePhoneFactory implements PhoneFactory {
    @Override
    public IphoneCase createCase(){
        return new IphoneCase();
    }
    @Override
    public IphoneMotherBoard createMotherBoard(){
        return new IphoneMotherBoard();
    }
    @Override
    public IphoneProcessor createProcessor(){
        return new IphoneProcessor();
    }
    @Override
    public IphoneScreen createScreen(){
        return new IphoneScreen();
    }
}
