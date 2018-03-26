package States;

import Game.GameContext;

import java.awt.*;

public class StoppedState extends GameState {

    @Override
    public void resumeGame() {

    }

    @Override
    public void stopGame() {

    }

    @Override
    public void gameUpdate() {

    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("stopped", 100, 100);
    }
}
