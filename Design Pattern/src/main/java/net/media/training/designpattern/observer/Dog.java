package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 10:13:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dog implements Player{
    private boolean outdoors;
    private boolean feelingWarm;
    private boolean feelingTired;

    public boolean isOutdoors() {
        return outdoors;
    }
    
    public void notifySunRose() {
        feelingWarm = true;
    }
    
    public void notifySunSet() {
        feelingWarm = false;
        if (outdoors)
            feelingTired = true;
    }
    
    public void goOutdoors() {
        outdoors = true;
    }
    
    public void goIndoors() {
        outdoors = false;
        feelingTired = true;
    }
    
    public boolean isFeelingWarm() {
        return feelingWarm;
    }

    public boolean isFeelingTired() {
        return feelingTired;
    }
}
