package Game;

import Entities.*;
import Events.Observer;
import Events.Subject;
import States.Turn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Manager implements Observer {
    private ArrayList<String> nameList;
    private Random random = new Random();
    private Card[] cards = new Card[3];
    private int lastStartTime = 0, cc;
    private Turn turn;

    public Manager(Turn turn){
        nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        this.turn = turn;
    }

    public void initializeTurn(){
        lastStartTime = (int) (System.nanoTime()/1000000L);
        shuffle();
        Sprite sprite, spriteBack;
        cc = random.nextInt(3);
        for(int i = 0; i < 3; i++){
            sprite = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            spriteBack = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            sprite.setImage(nameList.get(i));
            if(i == cc){
                cards[i] = (Card) EntityFactory.getInstance().createEntity("correctCard");
                spriteBack.setImage("palomita");
                cards[i].setFace(sprite);
                cards[i].setBack(spriteBack);
                ((CorrectCard) cards[i]).subscribe(turn);
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
    }

    public void listenTo(GameContext context){
        context.subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(((GameContext) subject).getCurrent() instanceof Turn)
            initializeTurn();
    }
}
