package States;

import Entities.Card;
import Entities.CorrectCard;
import Entities.EntityFactory;
import Entities.Sprite;
import Events.Observer;
import Game.Manager;
import Game.Player;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Turn extends GameState{
    protected Player player;
    protected ArrayList<Card> cards =  new ArrayList<>();
    protected DecimalFormat df = new DecimalFormat(".##");
    protected Sprite mr = (Sprite) EntityFactory.getInstance().createEntity("sprite");
    public void setCards(ArrayList<Card> cards){
        this.cards.clear();
        this.cards.addAll(cards);
    }
}
