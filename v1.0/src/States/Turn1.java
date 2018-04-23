package States;

import Entities.Card;
import Entities.HUD;
import Entities.ImageLoader;
import Events.Counter;
import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn1 extends Turn {

    public Turn1(){
        mr.setX(10);
        mr.setY(10);
        mr.setImage("magoRoberto");
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
        Counter.getInstance().restart();
        ((Turn) context.getTurn2()).setCards(context.getManager().getTurnCards());
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
        mr.render(g);
        g.drawString("Haz click sobre el animal que empieza con "+context.getManager().getLetter(), 130, 50);
        g.drawString("Es turno de "+player.getName(),200, 30);
        g.drawString(String.valueOf(df.format(Counter.getInstance().getElapsedTime())), 500, 50);
    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
    }
}
