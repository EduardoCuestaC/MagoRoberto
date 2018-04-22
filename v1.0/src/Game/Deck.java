package Game;

import Entities.Card;
import Entities.CorrectCard;
import Entities.EntityFactory;
import Entities.Sprite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    private Random random =  new Random();
    private ArrayList<String> nameList;
    private int ignore = 0;

    public Deck(){
        nameList  = new ArrayList<>(Arrays.asList("a", "b", "c", "j", "e", "t", "g", "h", "s"));
        shuffle();
    }

    public void shuffle(){
        ignore = 0;
        String m;
        for(int i=0; i<nameList.size()-1;i++){
            int j = random.nextInt(nameList.size()-i);
            m = nameList.get(j);
            nameList.set(j, nameList.get(i));
            nameList.set(i, m);
        }
    }

    private void sendFirstToBack(){
        String m = nameList.get(nameList.size()-1);
        nameList.set(nameList.size()-1, nameList.get(0));
        nameList.set(0, m);
    }

    public Card draw(){
        Card card = (Card) EntityFactory.getInstance().createEntity("card");
        Sprite face = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        face.setImage(nameList.get(ignore));
        Sprite back = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        back.setImage("equis");
        card.setFace(face);
        card.setBack(back);
        card.setName(nameList.get(ignore));
        ignore++;
        System.out.println("adios");
        return card;
    }

    public Card drawCorrect(){
        Card card = (Card) EntityFactory.getInstance().createEntity("correctCard");
        Sprite face = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        face.setImage(nameList.get(ignore));
        Sprite back = (Sprite) EntityFactory.getInstance().createEntity("sprite");
        back.setImage("palomita");
        card.setFace(face);
        card.setBack(back);
        card.setName(nameList.get(ignore));
        nameList.remove(ignore);
        System.out.println("hola");
        return card;
    }
}
