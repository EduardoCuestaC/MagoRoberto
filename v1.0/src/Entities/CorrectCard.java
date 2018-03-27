package Entities;

import Events.Observer;
import Events.Subject;
import java.util.ArrayList;

public class CorrectCard extends Card implements Subject{
    private int[] state;
    private ArrayList<Observer> observers = new ArrayList<>();

    public int[] getState() {
        return state;
    }

    public void setState(int[] state) {
        this.state = state;
    }

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers)
            observer.updateOnEvent(this);
    }

    @Override
    public void onFlip(){
        notifyObservers();
    }
}
