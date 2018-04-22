package Game;

import Entities.Card;
import Entities.EntityFactory;
import Entities.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private Random random =  new Random();

    public Deck(){
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "j", "e", "t", "g", "h", "s"));
        for(int i = 0; i<nameList.size(); i++){
            Sprite sprite, spriteBack;
            sprite = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            spriteBack = (Sprite) EntityFactory.getInstance().createEntity("sprite");
            sprite.setImage(nameList.get(i));
            spriteBack.setImage("equis");
            cards.add((Card) EntityFactory.getInstance().createEntity("card"));
            cards.get(i).setFace(sprite);
            cards.get(i).setBack(spriteBack);
            cards.get(i).setName(nameList.get(i));
            //cards.get(i).setX(220*i + 50);
            //cards.get(i).setY(100);
        }
        shuffle();
    }

    public void shuffle(){
        Card m;
        for(int i=0; i<cards.size()-1;i++){
            int j = random.nextInt(cards.size()-i);
            m = cards.get(j);
            cards.set(j, cards.get(i));
            cards.set(i, m);
        }
    }
    public Card draw(){
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }
}
