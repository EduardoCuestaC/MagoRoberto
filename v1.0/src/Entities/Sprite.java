package Entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite extends Entity{
    private BufferedImage image;

    public Sprite(){
        x = 100;
        y = 100;
    }

    public void setImage(String imgName){
        image = ImageLoader.getInstance().getImage(imgName);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
