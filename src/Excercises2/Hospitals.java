package Excercises2;

import java.util.Random;

public class Hospitals {

    private boolean[][] beds;
    private double[] percentages;

    public Hospitals(int noOfHosp, int noOfBeds) {

        //this.beds = beds;
        //this.percentages = percentages;
        //Java didn't like me doing this

        this.beds = new boolean[noOfHosp][noOfBeds];
        this.percentages = new double[noOfHosp];

        assignBeds();
        calcPercentages();

    }

    //Realised there was a better way of doing this using Random
    private boolean RandomBoolean(){
        //0 + (int) (Math.random() * (100 - 0 + 1)); -- This generates random ints between given ranges.

        boolean randomBool = false;
        int randomInt = 0 + (int) (Math.random() * (1 - 0 + 1));

        if (randomInt == 1)
            randomBool = true;

        return randomBool;
    }

    private void assignBeds(){

        Random random = new Random();
        random.nextBoolean();

        for (int i = 0; i < this.beds.length; i++) {
            for (int j = 0; j < this.beds[i].length; j++) { // unsure if I should just assign -> (j < i) or (j < this.beds[i].length)?
                this.beds[i][j] = random.nextBoolean();
            }
        }

    }

    private void calcPercentages(){

        int counter = 0;
        int[] bedPercArray = new int[9];

        for (int i = 0; i < this.beds.length; i++) {
            for (int j = 0; j < this.beds[i].length; j++) {

            }
        }
    }

    public void printPercentages(){

    }

    public void printBeds(){

    }

    public void printMinPercentage(){

    }

    public void printMaxPercentage(){

    }


}
