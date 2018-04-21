package Game;

import Entities.CorrectCard;
import Events.Observer;
import Events.Subject;
import States.Turn;

public class ContextObserver implements Observer {

    private GameContext context;

    public ContextObserver(GameContext context){
        this.context = context;
        this.context.getManager().setSubscriber(this);
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject instanceof CorrectCard){
            context.getManager().initializeTurn();
            context.changeToTurn1();
            context.changeToTurn2();
            ((Turn)context.getCurrent()).setCards(context.getManager().initializeTurn());
        }
    }
}
