package Exercises3.ex1;

import java.util.Random;

public class Country extends Population{

    private City[] cities;
    private static final Range Lat = new Range(-90, 90);
    private static final Range Lon = new Range(-180, 180);

    public Country(int numCities, double countrySize) {
        super(countrySize);
        this.cities = new City[numCities];
        setSize(countrySize); //call the current class method
    }

    //can make this return double[]
    private void randomDistribution(int n, double m){ //maybe remove this, have it dynamicall call the number of cities, or just input the array?
        Random rand = new Random();
        double[] randNums = new double[n];
        double sum = 0;

        //Generate n random numbers
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] = rand.nextDouble();
            sum += randNums[i];
        }

        //Normalize sum to m
        for (int i = 0; i < randNums.length; i++) {
            randNums[i] /= sum * m;
        }

        //setting the cities distribution.
        for (int i = 0; i < this.cities.length; i++) {
            this.cities[i].setSize(randNums[i]);
        }
    }

    private void randAssignCoords(){

    }

    @Override
    public double update(double inputSize) {
        super.update(inputSize);
        return this.randomDistribution(this.cities.length, inputSize);
    }

    public double getMinimum(){
        double min = this.cities[0].getSize();
        for (int i = 0; i < this.cities.length; i++) {
            if(this.cities[i].getSize()<min){
                min=this.cities[i].getSize();
            }
        }
    }

    public double getMaximum(){
        for (int i = 0; i < ; i++) {

        }
    }
}

