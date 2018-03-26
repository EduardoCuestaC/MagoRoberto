package Game;

import java.awt.*;

public class GameManager implements MouseEventObserver{
    public static GameManager instance;

    public static GameManager getInstance(){
        if(instance == null)
            instance = new GameManager();
        return instance;
    }

    public void update(){

    }

    public void render(Graphics g){

    }

    @Override
    public void updateOnMouseEvent(int x, int y, int type) {

    }
}
