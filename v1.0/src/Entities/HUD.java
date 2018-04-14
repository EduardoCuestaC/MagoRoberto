package Entities;

import Game.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HUD extends Entity {

    private static HUD instance;
    private Player player1;
    private Player player2;
    private ArrayList<ArrayList<Double>> scores = new ArrayList<>(2);

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

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        //System.out.println("p1: "+(float)(players.get(0).getResults()[0])+"p2: "+(float)(players.get(1).getResults()[0]));
    }
}
