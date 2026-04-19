package code.core;

import javax.swing.*;

import java.awt.*;

//Draws and runs game loop
public class GamePanel extends JPanel implements Runnable {
    Thread gameThread;

    //Class constructor
    public GamePanel(Rectangle maximumWindowBounds) {
        this.setPreferredSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void startGameThread() {
        //avoids starting two game threads
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    @Override
    public void run() {
//        while (gameThread != null) {
//            System.out.println("Hello!");
//        }
    }
}
