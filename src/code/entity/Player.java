package code.entity;

import code.core.InputHandler;

import java.awt.*;

public class Player extends Human {
    InputHandler inputHandler;

    public Player(InputHandler inputHandler) {
        this.positionX = 500;
        this.positionY = 500;

        this.speed = 10;

        this.inputHandler = inputHandler;
    }

    public void update() {
        if (inputHandler.leftPressed) {
            this.positionX -= this.speed;
            action = "go_left";
        } else if (inputHandler.rightPressed) {
            this.positionX += this.speed;
            action = "go_right";
        }
        super.update();
    }

    // TODO: add functionality to choose character before - or on time of - creation
    public void chooseCharacter(int characterNumber) {
        super.characterNumber = characterNumber;
    }
}
