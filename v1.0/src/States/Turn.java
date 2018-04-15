package States;

import Entities.Card;
import Entities.CorrectCard;
import Entities.EntityFactory;
import Entities.Sprite;
import Events.Observer;
import Game.Manager;
import Game.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Turn extends GameState implements Observer{
    protected Manager manager;
    protected Player player;
    protected static ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
    public void createPlayer(String name){
        player = new Player(name);
    }
}
