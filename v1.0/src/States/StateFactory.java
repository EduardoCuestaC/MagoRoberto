package States;

import java.util.Arrays;
import java.util.HashMap;

public class StateFactory {
    private static StateFactory instance;
    private HashMap<String, GameState> states = new HashMap<>();

    public static StateFactory getInstance(){
        if(instance == null)
            instance = new StateFactory();
        return instance;
    }

    private StateFactory(){
        states.put("setup", new SetupState());
        states.put("stopped", new StoppedState());
        states.put("turn1", new Turn1());
        states.put("turn2", new Turn2());
    }

    public GameState createState(String type){
       return states.getOrDefault(type, null);
    }
}
