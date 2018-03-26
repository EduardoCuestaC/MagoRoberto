package States;
import java.awt.*;
import Entities.*;
import Game.GameManager;

public class RunningState extends GameState {
    private GameManager manager =  new GameManager();

    @Override
    public void resumeGame() {

    }

    @Override
    public void stopGame() {
        context.setCurrent(context.getStopped());
    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
    }
}
