package Game;

import Entities.CorrectCard;
import Events.Counter;
import Events.Observer;
import Events.Subject;
import States.Turn;

public class ContextObserver implements Observer {

    private GameContext context;
    private int transitions;

    public ContextObserver(GameContext context){
        this.context = context;
        Counter.getInstance().subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == Counter.getInstance()){
            if(context.getCurrent() == context.getSetup()) {
                context.getManager().setSubscriber(this);
                context.changeToTurn1();
            }
        }
        if(subject instanceof CorrectCard){
            if(transitions == 5){
                context.stopGame();
            }else if(transitions % 2 == 0){
                context.changeToTurn2();
            }else{
                context.changeToTurn1();
            }
            transitions++;
        }
    }
}
