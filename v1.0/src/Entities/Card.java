package Entities;

import Events.MouseSubject;
import Events.Observer;
import Events.Subject;

import java.awt.*;

public class Card extends Entity implements Observer {
    private Sprite face;
    private Sprite back;
    private boolean flipped = false;

    public Card(){
        MouseSubject.getInstance().subscribe(this);
    }

    public void setX(int x){
        this.x = x;
        face.setX(x);
        back.setX(x);
        updateBoundingBox();
    }

    public void setY(int y){
        this.y = y;
        face.setY(y);
        back.setY(y);
        updateBoundingBox();
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        if(flipped)
            onFlip();

        this.flipped = flipped;
    }

    public void setFace(Sprite face) {
        this.face = face;

        if(w<face.getW())
            w = face.getW();
        if(h<face.getH())
            h = face.getH();

        updateBoundingBox();
    }

    public void setBack(Sprite back) {
        this.back = back;

        if(w<back.getW())
            w = back.getW();
        if(h<back.getH())
            h = back.getH();

        updateBoundingBox();
    }

    private void updateBoundingBox(){
        boundingBox.setBounds(x, y, w, h);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        if(face == null || back == null)
            return;
        if(flipped){
            back.render(g);
        }
        else{
            face.render(g);
        }
    }

    @Override
    public void updateOnEvent(Subject subject) {
        if(subject == MouseSubject.getInstance()){
            if(boundingBox.contains(MouseSubject.getInstance().getState()[0], MouseSubject.getInstance().getState()[1])){
                setFlipped(true);
            }
        }
    }

    public void onFlip(){

    }
}
