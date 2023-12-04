package org.example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Pillar extends Rectangle {
    // Non-static variables to ensure each instance of Pillar has its own width and starting position
    private int pillarWidth;
    private int pillarStartX;
    private static final int PILLAR_HEIGHT = 300;
    private static final int PILLAR_START_Y = 300;

    public static int getPillarHeight(){
        return PILLAR_HEIGHT;
    }
    // Constructor to initialize the pillar width and starting position
    public Pillar(int startX) {
        // Ensure the width is set within the desired range
        this.pillarWidth = new Random().nextInt(80, 300);
        // Set the dimensions and color of the pillar
        this.setWidth(pillarWidth);
        this.setHeight(PILLAR_HEIGHT);
        this.setFill(Color.BROWN);
        // Set the initial position of the pillar
        this.pillarStartX = startX;
        this.setX(pillarStartX);
        this.setY(PILLAR_START_Y);
    }

    // Method to generate a new instance of Pillar with a starting position based on the previous pillar
    public static Pillar generatePillar(int previousPillarX) {
        // Generate a random gap between pillars
        int gap = new Random().nextInt(100, 200);
        // Calculate the starting position of the new pillar based on the previous pillar and the gap
        int startX = previousPillarX + gap;
        return new Pillar(startX);
    }
}
