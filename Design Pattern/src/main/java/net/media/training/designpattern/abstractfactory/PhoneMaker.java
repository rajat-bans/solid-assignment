package net.media.training.designpattern.abstractfactory;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 18, 2011
 * Time: 6:34:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhoneMaker {

    public Case buildPhone(PhoneFactory factory) {
        MotherBoard motherBoard = factory.createMotherBoard();
        motherBoard.attachBattery(factory.createBattery());
        motherBoard.attachProcessor(factory.createProcessor());

        Screen screen = factory.createScreen();
        Case phoneCase = factory.createCase();
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);
        return phoneCase;
    }
}
