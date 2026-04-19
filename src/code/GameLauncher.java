package code;

import javax.swing.JFrame;

import code.core.GamePanel;
import code.core.InputHandler;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class GameLauncher {

    public static void startGame() {
        // Set up full-screen mode
        GraphicsEnvironment graphicsEnvironment =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice =
                graphicsEnvironment.getDefaultScreenDevice();

        JFrame window = new JFrame();
        GamePanel panel = new GamePanel(graphicsEnvironment.getMaximumWindowBounds());
        InputHandler inputHandler = new InputHandler();

        graphicsDevice.setFullScreenWindow(window);

        window.setTitle("Rooted");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(panel);
        window.pack();
        window.setVisible(true);

        panel.addKeyListener(inputHandler);
        panel.addMouseListener(inputHandler);
        panel.requestFocusInWindow();
        panel.startGameThread();
    }

    public static void closeGame(){

    }
}
