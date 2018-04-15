package States;

import java.awt.*;

public class SetupState extends GameState {

    private long startTime = System.nanoTime();
    private int waitTime = 10;

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
        if(waitTime - (System.nanoTime()-startTime)/1000000000L == 0)
            changeToTurn1();
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("¡Prepárense! El turno del jugador 1 empieza en...", 50, 100);
        g.drawString(String.valueOf(waitTime - (System.nanoTime()-startTime)/1000000000L),350, 100);
    }
}
