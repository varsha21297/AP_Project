package org.example;

import java.util.ArrayList;

public class StickHeroGame {
    public static void main(String[] args) {
        ArrayList<StickHero> heroArrayList=new ArrayList<>();
        //ArrayList<Stick> stickArrayList=new ArrayList<>();
        ArrayList<Platform> platformArrayList=new ArrayList<>();
        ArrayList<Cherry> cherriesArrayList=new ArrayList<>();
        GameController gameController = new GameController(heroArrayList,platformArrayList,cherriesArrayList);
        Settings settings= new Settings();
        Cherry cherry = new Cherry(10);
        LevelManager levelManager=new LevelManager(0);
    }
}