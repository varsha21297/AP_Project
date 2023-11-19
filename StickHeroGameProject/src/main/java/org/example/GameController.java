package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // Properties
    private StickHero stickHero;
    private List<Platform> platforms;
    private List<Cherry> cherries;

    //constructor
    public GameController(ArrayList<StickHero> stickHero, List<Platform> platforms, List<Cherry> cherries) {
        this.stickHero = stickHero;
        this.platforms = platforms;
        this.cherries = cherries;
    }

    public StickHero getStickHero() {
        return stickHero;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Cherry> getCherries() {
        return cherries;
    }

    // Methods
    public void startGame() {
        Platform platform=new Platform();
        // Initialize and start the game
    }

    public void endGame() {
        // End the game and handle game-over conditions
    }

    public void collectCherry() {
        // Handle cherry collection and scoring
    }
    public void saveGame() {
        // Save the game state
    }


}
