package net.media.training.designpattern.observer;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 20, 2011
 * Time: 9:12:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sun {
    private boolean isUp;
    private final Player[] players; 

    public Sun(Robot robot, Person person, Dog dog, Cat cat) {
        this.players = new Player[]{robot, person, dog, cat};
    }

    public boolean isUp() {
        return isUp;
    }

    public void set() {
        isUp = false;

        for(int i = 0;i<players.length;i++){
            if(players[i].isOutdoors()){
                players[i].notifySunSet();
            }
        }
    }

    public void rise() {
        isUp = true;

        for(int i = 0;i<players.length;i++){
            if(players[i].isOutdoors()){
                players[i].notifySunRose();
            }
        }
    }
}