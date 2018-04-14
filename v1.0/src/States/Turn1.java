package States;

import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn1 extends Turn {

    public Turn1(){
        manager = new Manager(this);
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

    }

    @Override
    public void changeToTurn2() {
        context.setCurrent(context.getTurn2());
    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        manager.render(g);
        g.drawString("hola", 100, 100);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        changeToTurn2();
    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
        manager.listenTo(this.context);
    }
}
