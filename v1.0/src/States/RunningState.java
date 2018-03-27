package States;
import java.awt.*;
import Entities.*;
import Game.Manager;

public class RunningState extends GameState {
    private Manager manager = new Manager();
    private Sprite sprite, sprite2;
    private Card card;

    public RunningState(){
        /*
        sprite = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        sprite.setImage("a");
        sprite2 = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        sprite2.setImage("palomita");
        card = (Card) EntityFactory.getInstance().createEntity("correctCard");
        card.setFace(sprite);
        card.setBack(sprite2);
        card.setX(500);
        card.setY(100);*/
    }

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
        manager.render(g);
    }
}
