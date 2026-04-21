package code.core;

import code.entity.Player;
import code.util.Utilities;

import javax.swing.*;

import java.awt.*;

//Draws and runs game loop
public class GamePanel extends JPanel implements Runnable {
    Thread gameThread;
    Player player;

    //Class constructor
    public GamePanel(Rectangle maximumWindowBounds, Player player) {
        this.setPreferredSize(new Dimension(maximumWindowBounds.width, maximumWindowBounds.height));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.player = player;
    }

    public void startGameThread() {
        //avoids starting two game threads
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    //this logic written by AI
    @Override
    public void run() {
        double drawInterval = 1_000_000_000.0 / Utilities.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;

        player.draw(graphics2D);

    }
}
