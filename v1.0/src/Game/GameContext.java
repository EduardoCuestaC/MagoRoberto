package Game;

import Entities.CorrectCard;
import States.GameState;
import States.StateFactory;

import java.awt.*;
import java.util.ArrayList;

public class GameContext{
    private GameState stopped;
    private GameState setup;
    private GameState turn1;
    private GameState turn2;

    private GameState current;

    private Manager manager;

    public void stopGame(){
        current.stopGame();
    }

    public void changeToTurn1(){
        current.changeToTurn1();
    }

    public void changeToTurn2(){
        current.changeToTurn2();
    }

    public void gameUpdate(){
        current.gameUpdate();
    }
    public void gameRender(Graphics g){
        current.gameRender(g);
    }

    public void setCurrent(GameState state){
        current = state;
    }
    public GameState getCurrent(){
        return current;
    }

    public GameState getSetup(){
        return setup;
    }
    public GameState getStopped() {
        return stopped;
    }
    public GameState getTurn1(){
        return turn1;
    }
    public GameState getTurn2(){
        return turn2;
    }

    public GameContext(){
        stopped = StateFactory.getInstance().createState("stopped");
        setup = StateFactory.getInstance().createState("setup");
        turn1 = StateFactory.getInstance().createState("turn1");
        turn2 = StateFactory.getInstance().createState("turn2");
        stopped.setGameContext(this);
        setup.setGameContext(this);
        turn1.setGameContext(this);
        turn2.setGameContext(this);

        current = setup;
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public Manager getManager(){
        return manager;
    }
}
