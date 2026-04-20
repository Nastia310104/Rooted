package code.core;

import code.util.Utilities;

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

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(Color.pink);
        graphics2D.fillRect(Utilities.position, 500, Utilities.TILE_SIZE, Utilities.TILE_SIZE);
        graphics2D.dispose();
    }
}
