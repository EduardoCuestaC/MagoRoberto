package Game;

import Entities.*;
import Events.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Manager implements Observer {
    private HUD hud = new HUD();
    private Player player1, player2;
    private Turn current, turn1, turn2;
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c"));
    private Random random = new Random();
    private Card[] cards = new Card[3];
    private int lastStartTime = 0;

    public Manager(){
        player1 = new Player("Jugador 1");
        turn1 = new Turn(player1);
        player2 = new Player("Jugador 2");
        turn2 = new Turn(player2);
        hud.addPlayer(player1);
        hud.addPlayer(player2);
        initializeTurn();
    }

    public void setCurrent(Turn turn) {
        current = turn;
    }

    public void initializeTurn(){
        lastStartTime = (int) (System.nanoTime()/1000000L);
        shuffle();
        Sprite sprite, spriteBack;
        int cc = random.nextInt(3);
        for(int i = 0; i < 3; i++){
            sprite = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            spriteBack = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            sprite.setImage(nameList.get(i));
            if(i == cc){
                cards[i] = (Card) EntityFactory.getInstance().createEntity("correctCard");
                spriteBack.setImage("palomita");
                cards[i].setFace(sprite);
                cards[i].setBack(spriteBack);
                ((CorrectCard) cards[i]).subscribe(this);
            }else {
                cards[i] = (Card) EntityFactory.getInstance().createEntity("card");
                spriteBack.setImage("equis");
                cards[i].setFace(sprite);
                cards[i].setBack(spriteBack);
            }
            cards[i].setX(220*i + 50);
            cards[i].setY(100);
        }
        nameList.remove(cc);
    }

    private void shuffle(){
        String m;
        for(int i=0; i<nameList.size()-1;i++){
            int j = random.nextInt(nameList.size()-i);
            m = nameList.get(j);
            nameList.set(j, nameList.get(i));
            nameList.set(i, m);
        }
    }

    public void update(){

    }

    public void render(Graphics g){
        for(Card card : cards){
            card.render(g);
        }
        hud.render(g);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject instanceof CorrectCard){
            if(current == turn1)
                setCurrent(turn2);
            else
                setCurrent(turn1);
            current.getPlayer().addResult((double) (lastStartTime/1000));
        }
    }
}
