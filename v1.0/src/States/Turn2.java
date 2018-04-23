package States;

import Entities.Card;
import Entities.CorrectCard;
import Entities.HUD;
import Entities.ImageLoader;
import Events.Counter;
import Events.Subject;
import Game.GameContext;
import Game.Manager;
import Game.Player;

import java.awt.*;

public class Turn2 extends Turn {

    public Turn2(){
        mr.setX(10);
        mr.setY(10);
        mr.setImage("magoRoberto");
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
        Counter.getInstance().restart();
        ((Turn) context.getTurn1()).setCards(context.getManager().getTurnCards());
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
        mr.render(g);
        g.drawString("Haz click sobre el animal que empieza con "+context.getManager().getLetter(), 131, 50);
        g.drawString("Es turno de "+player.getName(),200, 30);
        g.drawString(String.valueOf(df.format(Counter.getInstance().getElapsedTime())), 500, 50);
    }

    @Override
    public void setGameContext(GameContext context){
        this.context = context;
    }
}
