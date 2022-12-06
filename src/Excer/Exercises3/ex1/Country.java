package Excer.Exercises3.ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Country extends Population{

    private City[] cities;
    //private static final Range Lat = new Range(-90, 90);
    //private static final Range Lon = new Range(-180, 180);
    private final int LatMax = 90;
    private final int LatMin = -90;
    private final int LngMax = 180;
    private final int LngMin = -180;

    public Country(int numCities, double countrySize) {
        super(countrySize);
        this.cities = new City[numCities];
        //setSize(countrySize); //call the current class method

        Random r = new Random();
        City city;

        for (int i = 0; i < numCities; i++) {
            double lat = r.nextDouble() * (LatMax- LatMin) + LatMin;
            double lng = r.nextDouble() * (LngMax - LngMin) + LngMin;
            cities[i] = new City(countrySize, lat, lng);
        }

        randomDistribution(numCities, countrySize);
    }

    //can make this return double[]
    public void randomDistribution(int n, double m){ //maybe remove this, have it dynamically call the number of cities, or just input the array?
        Random rand = new Random();
        double[] randNums = new double[n];
        double sum = 0;

        //Generate n random numbers
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] = Math.random();
            sum += randNums[i];
        }

        //Normalize sum to m
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] *= m;
            randNums[i] /= sum;
        }

        //setting the cities distribution.
        for (int i = 0; i < this.cities.length; i++) {
            this.cities[i].setSize(randNums[i]);
        }
    }

    @Override
    public void update(double inputSize) {
        this.randomDistribution(this.cities.length, inputSize);
        super.update(inputSize);
    }

    public City getMinimum(){
        City min = this.cities[0];
        for (int i = 0; i < this.cities.length; i++) {
            if(this.cities[i].getSize() < min.getSize()){
                min = this.cities[i];
            }
        }
        return min;
    }

    public City getMaximum(){
        City max = this.cities[0];
        for (int i = 0; i < this.cities.length; i++) {
            if (this.cities[i].getSize() > max.getSize()){
                max = this.cities[i];
            }
        }
         return max;

    }

    @Override
    public String toString() {
        //could not call City::roundToTwoDP
        //return "Total: " + roundToTwoDP(this.getSize()) + " million in " + this.cities.length + " cities";
        return String.format("%.2f million in %d cities", getSize(), cities.length);
    }

    //check city.java for description
    public double roundToTwoDP(double value){
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, //rounding to 2 decimal places
                RoundingMode.HALF_UP); //apparently java default is to round down if the last number is even
        return bd.doubleValue();
    }
}

