package Entities;

import Events.Observer;
import Events.Subject;
import Game.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.util.function.Consumer;

public class HUD extends Entity implements Subject {

    private static HUD instance;
    private Player player1;
    private Player player2;
    private ArrayList<ArrayList<Double>> scores = new ArrayList<>(Arrays.asList(new ArrayList<Double>(), new ArrayList<Double>()));
    private DecimalFormat df = new DecimalFormat(".##");
    private ArrayList<Observer> observers = new ArrayList<>();

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void addResultToPlayer1(double result){
        scores.get(0).add(result);
    }

    public void addResultToPlayer2(double result){
        scores.get(1).add(result);
    }

    public static HUD getInstance(){
        if(instance == null)
            instance = new HUD();
        return instance;
    }

    private HUD(){
        x = 220;
        y = 350;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        double p1 = 0, p2 = 0;
        for(double score : scores.get(0))
            p1 += score;
        for(double score : scores.get(1))
            p2 += score;

        g.setColor(Color.black);
        g.drawRect(x-10, y-20, 300, 75);
        g.drawRect(x-5, y-16, 70, 20);
        g.drawString("PUNTAJES", x, y);
        g.drawString("Turno 1", x+70, y);
        g.drawString("Turno 2", x+120, y);
        g.drawString("Turno 3", x+170, y);
        g.drawString(player1.getName(), x, y+20);
        g.drawString(player2.getName(), x, y+40);
        for(int i = 0; i<scores.size(); i++){
            for(int j = 0; j<scores.get(i).size(); j++)
                g.drawString(String.valueOf(df.format(scores.get(i).get(j))), x+70+j*50, y+20+i*20);
            for(int j = scores.get(i).size(); j<3; j++)
                g.drawString("0.0", x+70+j*50, y+20+i*20);
        }
        g.drawString("TOTAL", x+220, y);
        g.drawString(String.valueOf(df.format(p1)), x+220, y+20);
        g.drawString(String.valueOf(df.format(p2)), x+220, y+40);
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers)
            observer.updateOnEvent(this);
    }

    public Player getWinner(){
        if(scores.get(0).size() == 3 && scores.get(1).size() == 3 ){
            double p1 = 0, p2 = 0;
            for(double score : scores.get(0))
                p1 += score;
            for(double score : scores.get(1))
                p2 += score;
            if(p1>p2)
                return player2;
            return player1;
        }
        return null;
    }
}
