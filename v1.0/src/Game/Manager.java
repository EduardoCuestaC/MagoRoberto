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
    private long lastStartTime;
    private int cc;
    private Turn turn;
    private String letter = "";

    public Manager(Turn turn, ArrayList<String> list){
        nameList = list;
        this.turn = turn;
    }

    private void initializeTurn(){
        lastStartTime = System.nanoTime();
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
                letter = nameList.get(i);
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
            if(card != null)
                card.render(g);
        }
        g.setColor(Color.black);
        g.drawString("Elige al animal cuyo nombre empieza con la letra "+letter, 30, 40);
    }

    public void listenTo(Subject subject){
        subject.subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(((GameContext) subject).getCurrent() == turn)// && HUD.getInstance().getWinner() != null)
            initializeTurn();
    }

    public double getTurnTime(){
        return (double)(System.nanoTime() - lastStartTime)/1000000000 - 1;
    }
}
