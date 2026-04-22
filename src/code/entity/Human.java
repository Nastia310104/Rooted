package code.entity;

import code.asset.SpriteSheet;
import code.util.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Human extends Entity{
    // TODO: add functionality to choose character before - or on time of - creation
    public int characterNumber = 0;

    BufferedImage[][] frames = new BufferedImage[3][24];

    String action = "idle_front";
    int actionIndex = 0;
    int frameIndex = 0;
    int frameCounter = 0;

    int numColumns = 4;
    int numRows = 3;


    public Human() {
        this.width = Utilities.TILE_SIZE;
        this.height = Utilities.TILE_SIZE;

        SpriteSheet spriteSheet = new SpriteSheet("src/resources/images/character/Josh/Idle.png");

        assignImages(spriteSheet);
    }

    public void assignImages(SpriteSheet spriteSheet){
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                frames[i][j] = spriteSheet.getSprite(j, i, Utilities.ORIGINAL_TILE_SIZE, Utilities.ORIGINAL_TILE_SIZE);
            }
        }
    }

    public void update() {
        frameCounter++;

        if (frameCounter > 10) {
            frameIndex = (frameIndex + 1) % 4;
            frameCounter = 0;
        }

        if (moving) {
            move();
        }
    }

    public void draw(Graphics2D graphics2D) {
        actionUpdate();
        if (action.equals("idle_left") || action.equals("go_left")){
            graphics2D.drawImage(frames[actionIndex][frameIndex], positionX + width, positionY, -width, height, null);
        } else {
            graphics2D.drawImage(frames[actionIndex][frameIndex], positionX, positionY, width, height, null);
        }
    }

    // Choose frames. It was really hard to figure out :)
    public void actionUpdate() {
        switch (action) {
            case "idle_left":
            case "idle_right":
                actionIndex = 2;
                break;
//            case "go_left":
//            case "go_right":
//                actionIndex = 2;
//                break;
            case "idle_front":
                actionIndex = 0;
                break;
//            case "go_front":
//                actionIndex = 6;
//                break;
            case "idle_back":
                actionIndex = 1;
                break;
//            case "go_back":
//                actionIndex = 10;
//                break;
        }
    }

    // DONT FORGET STUPID ME if and else if check
    public void move() {
        if ((positionX + width / 2) != targetPositionX) {
            if (positionX >= targetPositionX) {
                positionX -= speed;
                action = "idle_left";
            } else if (positionX <= targetPositionX - speed) {
                positionX += speed;
                action = "idle_right";
            }
        } else if (positionY != targetPositionY) {
            if (positionY >= targetPositionY) {
                positionY -= speed;
                action = "idle_back";
            } else if (positionY <= targetPositionY - speed) {
                positionY += speed;
                action = "idle_front";
            }
        } else {
            moving = false;
            action = "idle_front";
        }
    }
}
