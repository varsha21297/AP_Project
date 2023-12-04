package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class StickHeroGame extends Application {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    private Pane root;
    private StickHero hero;
    private List<Pillar> pillars;
    private List<Cherry> cherries;
    private boolean isAlive;

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        initializeGame();

        primaryStage.setTitle("Stick Hero Game");
        primaryStage.setScene(scene);

        // Handle user input
        scene.setOnMousePressed(event -> hero.startStretching());
        scene.setOnMouseReleased(event -> {
            hero.stopStretching();
            if (isAlive) {
                // Check for collisions and update game logic
                updateGame();
            }
        });

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    hero.moveLeft();
                    break;
                case RIGHT:
                    hero.moveRight();
                    break;
            }
        });


        // Game loop
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isAlive) {
                    // Update game logic
                    updateGame();
                }
            }
        };
        timer.start();

        primaryStage.show();
    }

    private void initializeGame() {
        hero = new StickHero();
        pillars = new ArrayList<>();
        cherries = new ArrayList<>();
        isAlive = true;

        // Create initial pillars and cherries
        generateInitialPillars();
        generateInitialCherries();

        // Find the top of the initial pillar and set the hero on top of it
        Pillar initialPillar = pillars.get(0);
        double heroX = initialPillar.getX() + (initialPillar.getWidth() - hero.getWidth()) / 2;
        double heroY = initialPillar.getY() - hero.getHeight();

        // Set the initial position of the hero
        hero.setX(heroX);
        hero.setY(heroY);
        root.getChildren().addAll(hero);
    }

    private void generateInitialPillars() {
        // Generate initial pillars
        for (int i = 0; i < 5; i++) {
            Pillar pillar = Pillar.generatePillar(i * 200);
            pillars.add(pillar);
            root.getChildren().add(pillar);
        }
    }

    private void generateInitialCherries() {
        // Generate initial cherries
        for (Pillar pillar : pillars) {
            Cherry cherry = new Cherry();
            cherry.putCherry(pillar, Pillar.getPillarHeight());
            cherries.add(cherry);
            root.getChildren().add(cherry);
        }
    }

    public void updateGame() {
        if (isAlive) {
            // Check if the hero has moved beyond the center of the window
            if (hero.getX() > WINDOW_WIDTH / 2) {
                // Calculate the amount of movement
                double moveDelta = hero.getX() - WINDOW_WIDTH / 2;

                // Move all game elements (hero, pillars, cherries) to the left
                moveGameElementsLeft(moveDelta);

                // Adjust the viewport to follow the hero
                root.setTranslateX(root.getTranslateX() - moveDelta);
            }

            // Check for collisions and update the game state
            checkCollisions();
            updateGameState();
        }
    }

    private void updateGameState() {
        // Add any additional game state update logic here
        // For example, check if the game should end based on certain conditions

        // You can also update the UI, display scores, etc.
        System.out.println("Score: " + hero.getScore());
    }


    private void moveGameElementsLeft(double moveDelta) {
        // Move the hero and stick
        hero.setX(hero.getX() - moveDelta);

        // Move each pillar
        for (Pillar pillar : pillars) {
            pillar.setX(pillar.getX() - moveDelta);
        }

        // Move each cherry
        for (Cherry cherry : cherries) {
            cherry.setCenterX(cherry.getCenterX() - moveDelta);
        }
    }

    private void checkCollisions() {
        checkCherryCollisions();
        checkPillarCollisions();
    }

    private void checkCherryCollisions() {
        // Check for collisions with cherries
        List<Cherry> cherriesToRemove = new ArrayList<>();
        for (Cherry cherry : cherries) {
            int collisionResult = cherry.checkCollision(hero);
            if (collisionResult > 0) {
                // Cherry collected, update score
                hero.increaseScore();
                cherriesToRemove.add(cherry);
            }
        }

        // Remove collected cherries
        cherries.removeAll(cherriesToRemove);
        root.getChildren().removeAll(cherriesToRemove);
    }

    private void checkPillarCollisions() {
        // Check for collisions with pillars or falling off
        for (Pillar pillar : pillars) {
            if (pillar.getBoundsInParent().intersects(hero.getBoundsInParent())) {
                // Collided with a pillar, handle as needed
                isAlive = false;
                break;
            } else if (pillar.getX() + pillar.getWidth() < 0) {
                // Pillar is off-screen, generate a new one
                generateNewPillar();
            }
        }

        if (hero.getPositionX() < 0) {
            // Hero fell off the screen, handle as needed
            isAlive = false;
        }
    }

    private void generateNewPillar() {
        // Generate a new pillar based on the position of the rightmost pillar
        Pillar lastPillar = pillars.get(pillars.size() - 1);
        Pillar newPillar = Pillar.generatePillar((int) (lastPillar.getX() + lastPillar.getWidth()));
        pillars.add(newPillar);
        root.getChildren().add(newPillar);

        // Generate a new cherry for the new pillar
        Cherry cherry = new Cherry();
        cherry.putCherry(newPillar, Pillar.getPillarHeight());
        cherries.add(cherry);
        root.getChildren().add(cherry);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

