package States;

public class StateFactory {
    private static StateFactory instance;

    public static StateFactory getInstance(){
        if(instance == null)
            instance = new StateFactory();
        return instance;
    }

    public GameState createState(String type){
        switch(type){
            case "setup":
                return new SetupState();
            case "stopped":
                return new StoppedState();
            case "turn1":
                return new Turn1();
            case "turn2":
                return new Turn2();
        }
        return null;
    }
}
