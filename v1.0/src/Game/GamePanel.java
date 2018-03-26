package Game;/*
From code fragments of Java programming techniques for games.
Structured and modified by: Eduardo Cuesta Córdova.
This class maintains a constant frame rate on animation and uses threading and some good practices (the main should be in another class).
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable{
    private boolean isRunning, isPaused, isGameOver;
    private int kFPS = 60;
    private long period = 1000/kFPS;
    private int kPanelWidth = 500, kPanelHeight=500;
    private Graphics ig;
    private Image bImage = null;
    private Thread animator;
    private GameContext context = new GameContext();


    public void addNotify(){
        //adds the JPanel to the JFrame
        super.addNotify();
        startGame();
    }

    public void gameUpdate(){
        if(!isPaused && !isGameOver){
            context.gameUpdate();
        }
    }

    public void gameRender(){
        if(bImage == null){
            bImage = createImage(kPanelWidth, kPanelHeight);
            if(bImage == null){
                return;
            }else{
                ig = bImage.getGraphics();
            }
        }
        ig.setColor(Color.white);
        ig.fillRect(0, 0, kPanelWidth, kPanelHeight);
        context.gameRender(ig);
    }

    public void paintScreen(){
        Graphics g;
        try{
            g = this.getGraphics();
            //draw on frame
            if(g!=null && bImage!=null)
                g.drawImage(bImage, 0, 0, null);
            g.dispose();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void startGame(){
        if(animator == null && !isRunning){
            animator = new Thread(this);
            animator.start();
        }
    }

    public void stopGame(){
        isRunning = false;
    }

    public void pauseGame(){
        isPaused=true;
    }

    public void resumeGame(){
        isPaused=false;
    }

    public void run(){
        long startTime, endTime, elapsedTime, sleepTime, oversleptTime=0L, excessTime = 0L;
        int kDelaysPerYield = 16, kMaxFrameSkips = 5;
        int delays = 0, skips;

        isRunning=true;
        //high resolution timer
        startTime = System.nanoTime();

        while(isRunning){
            gameUpdate();
            gameRender();
            paintScreen();
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            sleepTime = (period - elapsedTime) - oversleptTime;
            if(sleepTime > 0){
                try{
                    //convert from nanoseconds to milliseconds
                    Thread.sleep(sleepTime/1000000L);
                }catch (InterruptedException e){
                    //do nothing
                }
                //check if thread slept more than expected
                oversleptTime = System.nanoTime()-endTime-sleepTime;
            }else{
                //no time for sleeping this loop, loop took more than expected to execute
                //sleepTime is negative
                excessTime -= sleepTime;
                oversleptTime = 0L;
                if(++delays >= kDelaysPerYield){
                    //give other threads chance to run if there have been 16 or more delays
                    Thread.yield();
                    delays = 0;
                }
            }
            startTime = System.nanoTime();
            skips=0;
            //update game state without rendering to not slow the game processing
            while(excessTime>period && skips <= kMaxFrameSkips){
                //this saved one period
                excessTime -= period;
                gameUpdate();
                skips++;
            }
        }
    }

    public GamePanel(){
        //context = GameContext.getInstance();
        setPreferredSize(new Dimension(kPanelWidth, kPanelHeight));
        setFocusable(true);
        requestFocus();
        addKeyListener(EventDispatcher.getInstance());
        addMouseListener(EventDispatcher.getInstance());
    }
}
