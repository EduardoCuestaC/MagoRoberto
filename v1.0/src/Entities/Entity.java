package Entities;

import java.awt.*;

public abstract class Entity {
    protected int x, y, w, h;
    protected Color color;
    public abstract void update();
    public abstract void render(Graphics g);
}
