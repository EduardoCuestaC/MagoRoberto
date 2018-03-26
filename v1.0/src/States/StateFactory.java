package States;

import Game.GameContext;

import java.util.Hashtable;

public class StateFactory {
    private GameContext context;
    private static StateFactory instance;
    private Hashtable<String, GameState> options  = new Hashtable<>();

    private StateFactory(){
        options.put("running", new RunningState());
        options.put("stopped", new StoppedState());
    }

    public static StateFactory getInstance(){
        if(instance == null)
            instance = new StateFactory();
        return instance;
    }

    public GameState createState(String type){
        return options.getOrDefault(type, null);
    }
}
