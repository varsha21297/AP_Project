package org.example;

public class Stick {
    private double length = 0;
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;

    public double getLength() {
        return this.length;
    }

    // Additional method to reset the length, if needed
    public void reset() {
        this.length = 0;
    }

    // Setter method for the extension rate
    public void increaseLength() {
        this.length += 10;
    }
    

    public void rotateStickHorizontal() {
        // Rotate the stick horizontally
        this.xEnd = this.xStart + this.length;
        this.yEnd = this.yStart;
    }


    // Method to update the coordinates of the stick based on the length
    public void updateCoordinates(double startX, double startY) {
        this.xStart = startX;
        this.yStart = startY;
        this.xEnd = startX; // The stick grows vertically, so xEnd remains the same
        this.yEnd = startY - length; // Update yEnd based on the length
    }

    // Getter methods for the coordinates
    public double getXStart() {
        return xStart;
    }

    public double getYStart() {
        return yStart;
    }

    public double getXEnd() {
        return xEnd;
    }

    public double getYEnd() {
        return yEnd;
    }
}

