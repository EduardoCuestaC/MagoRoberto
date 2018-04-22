package States;

import Entities.Card;
import Entities.HUD;
import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn1 extends Turn {

    public Turn1(){
        player = new Player("Jugador 1");
        HUD.getInstance().setPlayer1(player);
    }

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
        context.setCurrent(context.getTurn2());
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
