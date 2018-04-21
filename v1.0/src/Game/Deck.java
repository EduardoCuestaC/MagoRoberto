package Game;

import java.util.ArrayList;
import java.util.Arrays;

public class Deck {

    private ArrayList<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "j", "e", "t", "g", "h", "s"));

    public ArrayList<String> getCards(){
        return nameList;
    }



}
