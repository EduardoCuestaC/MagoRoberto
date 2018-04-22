package States;

import Entities.Card;
import Entities.CorrectCard;
import Entities.HUD;
import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn2 extends Turn {

    public Turn2(){
        player = new Player("Jugador 2");
        HUD.getInstance().setPlayer2(player);
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
        for(Card card : cards){
            card.render(g);
        }
        HUD.getInstance().render(g);
        g.drawString("Es turno de "+player.getName(),180, 40);
    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
    }
}
