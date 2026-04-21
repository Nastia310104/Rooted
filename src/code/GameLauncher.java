package code;

import javax.swing.JFrame;

import code.asset.Tile;
import code.core.GamePanel;
import code.core.InputHandler;
import code.entity.Player;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class GameLauncher {

    public static void startGame() {
        // Set up full-screen mode
        GraphicsEnvironment graphicsEnvironment =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice =
                graphicsEnvironment.getDefaultScreenDevice();

        InputHandler inputHandler = new InputHandler();
        JFrame window = new JFrame();
        Player player = new Player(inputHandler);
        Tile tile = new Tile(700, 700, true, true, inputHandler, player);
        GamePanel panel = new GamePanel(graphicsEnvironment.getMaximumWindowBounds(), player, tile);

        // TODO: add functionality to choose character before - or on time of - creation
        player.chooseCharacter(2);

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
