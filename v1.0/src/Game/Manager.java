package Game;

import Entities.*;
import Events.Observer;
import Events.Subject;
import States.Turn;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;

public class Manager{
    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "j", "e", "t", "g", "h", "s"));;
    private Random random = new Random();
    private long lastStartTime;
    private String letter = "";
    private Sprite mr;
    private DecimalFormat df = new DecimalFormat(".#");
    private Deck deck = new Deck();
    private Observer subscriber;

    public void setSubscriber(Observer observer){
        subscriber = observer;
    }

    public String getLetter(){
        return letter;
    }

    public ArrayList<Card> getTurnCards(){
        //System.out.println("gotturncards");
        deck.shuffle();
        Random random =  new Random();
        int cc = random.nextInt(3);
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i<3; i++){
            Card card;
            if(i==cc){
                card = deck.drawCorrect();
                letter = card.getName().charAt(0)+"";
                ((CorrectCard) card).subscribe(HUD.getInstance());
                ((CorrectCard) card).subscribe(subscriber);
            }else{
                card =deck.draw();
            }
            cards.add(card);
            cards.get(i).setX(220*i + 50);
            cards.get(i).setY(100);
        }
        return cards;
    }

    public void update(){

    }

    public void render(Graphics g){

    }
}

