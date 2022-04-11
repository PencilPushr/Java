package Exercises3;

import java.awt.font.NumericShaper;

public class Country extends Population{

    private City[] cities;
    private static final Range Lat = new Range(-90, 90);
    private static final Range Lon = new Range(-180, 180);

    //TODO: make a class to simplify this
    /*
    private static final int minLat = -90;
    private static final int maxLat = 90;
    private static final int minLon = -180;
    private static final int maxLon = 180;
     */



    public Country(double popSize, int numCities) {
        super(popSize);
        this.cities = new City[numCities];
        setSize(popSize); //call the current class method
    }

    private void randomDistribution(int popSize, int citySize){ //maybe remove this, have it dynamicall call the number of cities, or just input the array?
        
    }

    private void assignCoords(){

    }

    @Override
    public double update(double inputSize) {
        return super.update(randomDistribution(inputSize));
    }

    public double getMinimum(){

    }

    public double getMaximum(){

    }
}

