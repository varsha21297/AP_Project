package org.example;

import java.util.ArrayList;
import javafx.application.Application;

public class StickHeroGame extends Application {
    public static void main(String[] args) {
        ArrayList<StickHero> heroArrayList = new ArrayList<>();
        //ArrayList<Stick> stickArrayList=new ArrayList<>();
        ArrayList<Platform> platformArrayList = new ArrayList<>();
        ArrayList<Cherry> cherriesArrayList = new ArrayList<>();
        GameController gameController = new GameController(heroArrayList, platformArrayList, cherriesArrayList);
        Settings settings = new Settings();
        Cherry cherry = new Cherry(10);
        LevelManager levelManager = new LevelManager(0);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}