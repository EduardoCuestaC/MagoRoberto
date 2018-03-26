package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EventDispatcher implements KeyListener, MouseListener {

    private ArrayList<KeyEventObserver> keyObservers = new ArrayList<>();
    private ArrayList<MouseEventObserver> mouseObservers =  new ArrayList<>();
    private static EventDispatcher instance;
    public static int PRESSED;
    public static int RELEASED;
    public static int TYPED;


    public static EventDispatcher getInstance(){
        if(instance == null)
            instance = new EventDispatcher();
        return instance;
    }

    public void registerKeyObserver(KeyEventObserver observer){
        keyObservers.add(observer);
    }
    public void registerMouseObserver(MouseEventObserver observer){
        mouseObservers.add(observer);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyvalue;
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                keyvalue = 1;
                break;
            case KeyEvent.VK_UP:
                keyvalue = 2;
                break;
            case KeyEvent.VK_DOWN:
                keyvalue = 3;
                break;
            case KeyEvent.VK_RIGHT:
                keyvalue = 4;
                break;
            case KeyEvent.VK_P:
                keyvalue = 5;
                break;
            case KeyEvent.VK_R:
                keyvalue = 6;
                break;
            case KeyEvent.VK_ESCAPE:
                keyvalue = 7;
                break;
            default:
                keyvalue = 0;
                break;
        }
        for(KeyEventObserver o : keyObservers){
            o.updateOnKeyEvent(keyvalue, PRESSED);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mousePressed");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MouseEventObserver o : mouseObservers){
            o.updateOnMouseEvent(e.getX(), e.getY(), PRESSED);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
