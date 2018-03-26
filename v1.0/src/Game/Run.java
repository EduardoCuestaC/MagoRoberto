package Game;

import javax.swing.*;

public class Run {
    public static void main(String[] args){
        JFrame window = new JFrame("Engine");
        GamePanel panel = new GamePanel();
        window.getContentPane().add(panel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(panel.getPreferredSize());
        window.setVisible(true);

    }
}
