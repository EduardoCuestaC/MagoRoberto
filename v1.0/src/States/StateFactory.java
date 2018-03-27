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
            case "running":
                return new RunningState();
            case "stopped":
                return new StoppedState();
        }
        return null;
    }
}
