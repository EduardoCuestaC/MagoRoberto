package Game;

import Entities.CorrectCard;
import Events.Counter;
import Events.Observer;
import Events.Subject;
import States.Turn;

public class ContextObserver implements Observer {

    private GameContext context;

    public ContextObserver(GameContext context){
        this.context = context;
        Counter.getInstance().subscribe(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == Counter.getInstance()){
            context.getManager().setSubscriber(this);
            context.changeToTurn1();
        }
        if(subject instanceof CorrectCard){
            System.out.println("eventevent");
            if(context.getCurrent() == context.getTurn1())
                context.changeToTurn2();
            else
                context.changeToTurn1();
        }
    }
}
