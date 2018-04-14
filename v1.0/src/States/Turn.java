package States;

import Entities.Card;
import Entities.CorrectCard;
import Entities.EntityFactory;
import Entities.Sprite;
import Events.Observer;
import Game.Manager;
import Game.Player;

import java.util.ArrayList;
import java.util.Random;

public abstract class Turn extends GameState implements Observer{
    protected Manager manager;
    protected Player player;
    public void createPlayer(String name){
        player = new Player(name);
    }
}
