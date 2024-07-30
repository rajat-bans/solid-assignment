package net.media.training.designpattern.abstractfactory;

public class AndroidPhoneFactory implements PhoneFactory {
    @Override
    public AndroidCase createCase(){
        return new AndroidCase();
    }
    @Override
    public AndroidMotherBoard createMotherBoard(){
        return new AndroidMotherBoard();
    }
    @Override
    public AndroidProcessor createProcessor(){
        return new AndroidProcessor();
    }
    @Override
    public AndroidScreen createScreen(){
        return new AndroidScreen();
    }
}
