package Excercises2;

import java.util.Random;

public class Hospitals {

    private boolean[][] beds;
    private double[] percentages;

    public Hospitals(int noOfHosp, int noOfBeds) {

        //sanity check, can't have 0 of either.
        if (noOfHosp < 1 || noOfBeds < 1){
            noOfBeds = 1;
            noOfHosp = 1;
            System.out.println("Values shouldn't be less than 1");
        }

        this.beds = new boolean[noOfHosp][noOfBeds];
        this.percentages = new double[noOfHosp];

        assignBeds();
        calcPercentages();

    }

    private void assignBeds(){

        Random random = new Random();
        random.nextBoolean();

        int hospitals = this.beds[0].length; //only need to assign it once

        for (int i = 0; i < this.beds.length; i++) {
            for (int j = 0; j < hospitals; j++) {
                this.beds[i][j] = random.nextBoolean();
            }
        }

    }

    private void calcPercentages(){

        int bedSize = this.beds.length;
        int hospitals = this.beds[0].length;
        int total;
        double temp;

        for (int i = 0; i < hospitals; i++) {
            total = 0;
            for (int j = 0; j < bedSize; j++) {
                if (this.beds[j][i]){
                    total++;
                }
            }
            temp = ((double) total)/ ((double) bedSize);
            temp = temp * 100.0;
            this.percentages[i] = temp;
        }
    }

    public void printPercentages(){

        String temp;

        for (int i = 0; i < this.percentages.length; i++) {
            temp = "Hospital " + i + " (%): " + this.percentages[i];
            System.out.println(temp);
        }
    }

    public void printBeds(){

        String temp;
        int hospitals = this.beds[0].length;
        int bedSize = this.beds.length;

        for (int i = 0; i < hospitals; i++) {
            temp = "Hospital " + i + " : [";
            for (int j = 0; j < bedSize; j++) {
                if (this.beds[j][i]){
                    temp = temp + "true";
                } else{
                    temp = temp + "false";
                }
                if (j != bedSize -1){
                    temp = temp + ", ";
                }
            }
            temp = temp + "] ";
            System.out.println(temp);
        }

    }

    public void printMinPercentage(){

        String temp;
        double percent = 100.0;
        int hospital = 0;

        for (int i = 0; i < this.percentages.length; i++) {
            if (percent > this.percentages[i]){
                percent = this.percentages[i];
                hospital = i;
            }
        }

        temp = "Minimum Percentage of " + percent + " in Hospital " + hospital;

        System.out.println(temp);
    }

    public void printMaxPercentage(){

        String temp;
        double percent = 0.0;
        int hospital = 0;

        for (int i = 0; i < this.percentages.length; i++) {
            if (percent < this.percentages[i]){
                percent = this.percentages[i];
                hospital = i;
            }
        }

        temp = "Maximum Percentage of " + percent + " in Hospital " + hospital;

        System.out.println(temp);
    }


}
