package States;

import Entities.HUD;
import Game.GameContext;

import java.awt.*;
import java.util.ArrayList;

public class StoppedState extends GameState {

    @Override
    public void changeToRunning() {

    }

    @Override
    public void stopGame() {

    }

    @Override
    public void changeToTurn1() {

    }

    @Override
    public void changeToTurn2() {

    }

    @Override
    public void gameUpdate() {

    }

    private String getWinner(){
        ArrayList<ArrayList<Double>> scores = HUD.getInstance().getScores();
        double p1 = 0, p2 = 0;
        for(double score : scores.get(0))
            p1 += score;
        for(double score : scores.get(1))
            p2 += score;
        if(p1>p2)
            return HUD.getInstance().getPlayer2().getName();
        return HUD.getInstance().getPlayer1().getName();
    }

    @Override
    public void gameRender(Graphics g) {
        g.setColor(Color.black);
        g.drawString("¡Ha ganado "+getWinner()+"!", 100, 100);
        HUD.getInstance().render(g);
    }
}
