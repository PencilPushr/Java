package com.company;

public class Main {

    public static void main(String[] args) {
        boolean game0ver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if (game0ver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }

        score = 10_000;
        levelCompleted = 8;
        bonus = 200;

        if (game0ver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

    }

}
