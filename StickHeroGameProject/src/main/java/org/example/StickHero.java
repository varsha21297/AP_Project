package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StickHero extends Rectangle {
    private double positionX;
    private double positionY;
    private Stick stick;
    private double score;
    private Timeline stretchTimeline;
    private boolean isMovingLeft, isMovingRight;
    private boolean isAlive; // New flag for the alive state

    public StickHero() {
        super(40, 40, Color.PEACHPUFF);
        this.stick = new Stick();
        initializeTimeline();
        initializeMovement();
        isAlive = true; // Initialize as alive
    }

    private void initializeTimeline() {
        stretchTimeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    stretchStick(); // Call the method to stretch the stick
                })
        );
        stretchTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void initializeMovement() {
        setOnKeyPressed(this::handleKeyPress);
        setOnKeyReleased(this::handleKeyRelease);
    }

    private void handleKeyPress(KeyEvent event) {
        if (isAlive) {
            switch (event.getCode()) {
                case LEFT:
                    moveLeft();
                    break;
                case RIGHT:
                    moveRight();
                    break;
            }
        }
    }

    private void handleKeyRelease(KeyEvent event) {
        if (isAlive) {
            switch (event.getCode()) {
                case LEFT:
                case RIGHT:
                    stopMoving();
                    break;
            }
        }
    }

    public double getScore() {
        return this.score;
    }

    public void move(double deltaX, double deltaY) {
        this.positionX += deltaX;
        this.positionY += deltaY;
    }

    public void stretchStick() {
        // Stretch the stick
        this.stick.increaseLength();

        // Update the coordinates of the stick based on the length
        this.stick.updateCoordinates(this.stick.getXStart(), this.stick.getYStart());

        // Rotate the stick horizontally
        this.stick.rotateStickHorizontal();
    }

    public void startStretching() {
        // Start stretching when the mouse is pressed
        stretchTimeline.play();
    }    

    public void stopStretching() {
        // Stop stretching when the mouse is released
        stretchTimeline.stop();
    }
    

    public double getPositionX() {
        return this.positionX;
    }

    public double getPositionY() {
        return this.positionY;
    }

    public void increaseScore() {
        this.score++;
    }

    public void moveLeft() {
        double moveDelta = 10; // Adjust the movement speed as needed
        this.setX(this.getX() - moveDelta);
        isMovingLeft = true;
        isMovingRight = false;
    }
    
    public void moveRight() {
        double moveDelta = 10; // Adjust the movement speed as needed
        this.setX(this.getX() + moveDelta);
        isMovingLeft = false;
        isMovingRight = true;
    }
    

    public void stopMoving() {
        // Stop movement
        isMovingLeft = false;
        isMovingRight = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
