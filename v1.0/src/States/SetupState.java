package States;

import java.awt.*;

public class SetupState extends GameState {

    @Override
    public void changeToRunning() {

    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {
        context.setCurrent(context.getTurn1());
    }

    @Override
    public void changeToTurn2() {
    }

    @Override
    public void gameUpdate() {
        changeToTurn1();
    }

    @Override
    public void gameRender(Graphics g) {

    }
}
