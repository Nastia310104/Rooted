package code.asset;

import code.core.InputHandler;
import code.entity.Player;
import code.util.Utilities;

import java.awt.*;
import java.awt.event.MouseListener;

public class Tile {
    public int positionX;
    public int positionY;
    public int width = Utilities.TILE_SIZE;
    public int height = Utilities.TILE_SIZE;

    protected InputHandler inputHandler;
    Player player;

    public boolean clickable;
    public boolean walkable;


    public Tile(int x, int y, boolean clickable, boolean walkable, InputHandler inputHandler, Player player) {
        this.positionX = x;
        this.positionY = y;
        this.clickable = clickable;
        this.walkable = walkable;
        this.inputHandler = inputHandler;
        this.player = player;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.PINK);
        graphics2D.fillRect(positionX, positionY, width, height);
    }

    public void update() {
        if (inputHandler.rightPressed){
            if (positionX <= inputHandler.mouseX && inputHandler.mouseX  <= positionX + width) {
                if (walkable) {
                    player.targetPositionX = positionX;
                    player.targetPositionY = positionY;
//                    player.move();
                    System.out.println("Bop");
                }
            }
        }
    }
}
