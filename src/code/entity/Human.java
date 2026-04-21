package code.entity;

import code.asset.SpriteSheet;
import code.util.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Human extends Entity{
    // TODO: add functionality to choose character before - or on time of - creation
    public int characterNumber = 0;

    BufferedImage[] frames = new BufferedImage[12];

    int frameIndex = 0;
    int frameCounter = 0;

    int numColumns = 3;
    int numRows = 4;

    String action = "idle_front";
    int actionIndex = 0;

    public Human() {
        this.width = Utilities.TILE_SIZE;
        this.height = Utilities.TILE_SIZE;

        SpriteSheet spriteSheet = new SpriteSheet("src/resources/images/TinyFarm_Characters.png");

        assignImages(spriteSheet);
    }

    public void assignImages(SpriteSheet spriteSheet){
        int spriteNum = 0;
        for (int i = 0; i < numColumns; i++) {
            for (int j = 4 * characterNumber; j < numRows + (4 * characterNumber); j++) {
                frames[spriteNum] = spriteSheet.getSprite(i, j, Utilities.ORIGINAL_TILE_SIZE, Utilities.ORIGINAL_TILE_SIZE);
                spriteNum++;
            }
        }
    }

    public void update() {
        frameCounter++;

        if (frameCounter > 10) {
            frameIndex = (frameIndex + 1) % 2 + actionIndex;
            frameCounter = 0;
        }
    }

    public void draw(Graphics2D graphics2D) {
        actionUpdate();
        if (action.equals("idle_right") || action.equals("go_right")){
            graphics2D.drawImage(frames[frameIndex], positionX + width, positionY, -width, height, null);
        } else {
            graphics2D.drawImage(frames[frameIndex], positionX, positionY, width, height, null);
        }
    }

    // Choose frames. It was really hard to figure out :)
    public void actionUpdate() {
        switch (action) {
            case "idle_left":
            case "idle_right":
                actionIndex = 0;
                break;
            case "go_left":
            case "go_right":
                actionIndex = 2;
                break;
            case "idle_front":
                actionIndex = 4;
                break;
            case "go_front":
                actionIndex = 6;
                break;
            case "idle_back":
                actionIndex = 8;
                break;
            case "go_back":
                actionIndex = 10;
                break;
        }
    }
}
