package States;

import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn2 extends Turn {

    public Turn2(){
        manager = new Manager(this, nameList);
    }

    @Override
    public void changeToRunning() {

    }

    @Override
    public void stopGame() {
        context.setCurrent(context.getStopped());
    }

    @Override
    public void changeToTurn1() {
        context.setCurrent(context.getTurn2());
    }

    @Override
    public void changeToTurn2() {

    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        manager.render(g);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        changeToTurn1();
    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
        manager.listenTo(this.context);
    }
}
