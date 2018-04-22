package States;

import Events.Counter;

import java.awt.*;

public class SetupState extends GameState {

    private long startTime = System.nanoTime();
    private int waitTime = 10;

    public SetupState(){
        Counter.getInstance().startNew(10000);
    }

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
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("¡Prepárense! El turno del jugador 1 empieza en...", 50, 100);
        g.drawString(String.valueOf((int)Counter.getInstance().getElapsedTime()),350, 100);
    }
}
