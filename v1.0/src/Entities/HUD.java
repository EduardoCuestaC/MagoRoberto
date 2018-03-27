package Entities;

import Game.Player;

import java.awt.*;
import java.util.ArrayList;

public class HUD extends Entity {

    private static HUD instance;
    private ArrayList<Player> players = new ArrayList<>();

    public static HUD getInstance(){
        if(instance == null)
            instance = new HUD();
        return instance;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        System.out.println("p1: "+(float)(players.get(0).getResults()[0])+"p2: "+(float)(players.get(1).getResults()[0]));
    }
}
