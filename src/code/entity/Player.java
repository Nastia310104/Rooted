package code.entity;

import code.core.InputHandler;

import java.awt.*;

public class Player extends Human {
    InputHandler inputHandler;

    public Player(InputHandler inputHandler) {
        this.positionX = 500;
        this.positionY = 500;

        this.speed = 4;

        this.inputHandler = inputHandler;
    }

    public void update() {
        if (inputHandler.leftPressed) {
            this.targetPositionX = inputHandler.mouseX;
            this.targetPositionY = inputHandler.mouseY;
            this.moving = true;
        }

        super.update();
    }

    // TODO: add functionality to choose character before - or on time of - creation
    public void chooseCharacter(int characterNumber) {
        super.characterNumber = characterNumber;
    }
}
