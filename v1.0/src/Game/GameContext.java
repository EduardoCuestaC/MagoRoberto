package Game;

import States.GameState;
import States.StateFactory;

import java.awt.*;

public class GameContext implements KeyEventObserver{
    private GameState running;
    private GameState paused;
    private GameState stopped;
    private GameState current;

    public void updateOnKeyEvent(int key, int type){
        switch (key){
            case 5:
                pauseGame();
                break;
            case 6:
                resumeGame();
                break;
            case 7:
                stopGame();
                break;
            default:
                break;
        }
    }

    public void stopGame(){
        current.stopGame();
    }

    public void pauseGame(){
        current.pauseGame();
    }

    public void resumeGame(){
        current.resumeGame();
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

    public GameState getRunning() {
        return running;
    }

    public GameState getPaused() {
        return paused;
    }

    public GameState getStopped() {
        return stopped;
    }



    public GameContext(){
        running = StateFactory.getInstance().createState("running");
        paused = StateFactory.getInstance().createState("paused");
        stopped = StateFactory.getInstance().createState("stopped");
        running.setGameContext(this);
        paused.setGameContext(this);
        stopped.setGameContext(this);
        current = running;

        EventDispatcher.getInstance().registerKeyObserver(this);
    }
}
