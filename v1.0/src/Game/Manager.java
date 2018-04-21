package Game;

import Entities.*;
import Events.Observer;
import Events.Subject;
import States.Turn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;

public class Manager{
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "j", "e", "t", "g", "h", "s"));;
    private Random random = new Random();
    private long lastStartTime;
    private int cc;
    private String letter = "";
    private Sprite mr;
    private DecimalFormat df = new DecimalFormat(".#");
    private Deck deck = new Deck();
    private Observer subscriber;

    public void setSubscriber(Observer observer){
        subscriber = observer;
    }

    public Card[] initializeTurn(){
        Card[] cards = new Card[3];
        mr = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        mr.setImage("magoRoberto");
        mr.setX(10);
        mr.setY(10);
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
                ((CorrectCard) cards[i]).subscribe(subscriber);
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
        return cards;
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
        mr.render(g);
        g.setColor(Color.black);
        g.drawString("Elige al animal cuyo nombre empieza con la letra "+letter, 120, 60);
        g.drawString("Tiempo: "+String.valueOf(df.format(getTurnTime()+1)), 600, 60);
    }

    public double getTurnTime(){
        return (double)(System.nanoTime() - lastStartTime)/1000000000 - 1;
    }
}
