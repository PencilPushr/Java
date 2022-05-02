package Exercises3.ex3;

public class PopulationData {

    private double[][] popData;

    public PopulationData(String filename) {

        //blue maximum, red 0, green 0 for -9999
        //green mis variable, red is maximum blue is 0 for every other value;
        //takes us from red to yellow

        //as you iterate, keep track of maximum pop
        //max pop is yellow, no people is red
        //take pop of dot, divide by highest population (running total) that number between 0 and 1
        //multiply number by 255.0 (double) that will be green value




    }

    public double[][] getPopData() {
        return popData;
    }
}
