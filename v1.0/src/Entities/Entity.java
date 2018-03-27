package Entities;

import java.awt.*;

public abstract class Entity {
    protected int x = 0;
    protected int y = 0;
    protected int w = 0;
    protected int h = 0;
    protected Color color;
    public abstract void update();
    public abstract void render(Graphics g);
    protected Rectangle boundingBox = new Rectangle(x, y, w, h);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
