package Exercises3.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.*;

public class CityData {

    //Utility class
    //Holds: AsciiName, Lat, Long, Country, and Population.
    public class metropolis{
        public String namium;
        public double latitude;
        public double longitude;
        public String country;
        public int population;

        public metropolis(String n, double l1,double l2, String c, int p){
            this.namium = n;
            this.latitude = l1;
            this.longitude = l2;
            this.country = c;
            this.population = p;
        }
    }

    //associates ID with the Country, for fast retrieval
    private HashMap<Integer,metropolis> atlas;

    private static final double pi = 3.141592;

    public CityData(String fileName) throws FileNotFoundException {
        this.atlas = new HashMap<Integer,metropolis>();

        //Now, we start reading from the file.
        Scanner s = new Scanner(new File(fileName + ".csv"));
        boolean first = true;
        while(s.hasNext()){
            if (!first){
                String[] line = s.nextLine().split(",");
                metropolis temp = new metropolis(line[1],Double.parseDouble(line[2]),
                        Double.parseDouble(line[3]),line[4],Integer.parseInt(line[9]));
                this.atlas.put(Integer.valueOf(line[10]),temp);
            }
            first = false;
        }
        s.close();

    }

    public void printLargest10(){
        //Print largest 10 cities (ASCII name, latitude, longitude, country and population)
        System.out.println();
    }

    public void printSmallest10(){
        metropolis[] m = new metropolis[10];
        for (var entry: atlas.entrySet()) {
            Collections.min(atlas.)
        }
        System.out.println();
    }

    //Recieves a String country name, and prints all cities from given country
    public void printCountry(String str){
        //Recieves a String country name, and prints all cities from given country
        Set<String> keys = new HashSet<>();
        for (var entry : atlas.entrySet()){
            if (Objects.equals(str, entry.getValue())){
                System.out.println(entry.getKey().toString() + "=" + entry.getValue());
            }
        }

    }

    public void printClosest10(double lon, double lat){
        //print the 10 closest cities to the coordinates, use haversine forumla
        //either iterate through the file and check it against HaversineDistance functions
        //alternatively add them to a hashmap/array and check them against it

        //create array 10 of type metropolis
        //set every value to null
        //go through every single city (iterate through the hashmap)
        //if it is closer (smaller than) to the coordinates replace the value on the metropolis
    }

    //Takes in geocoordinates, returns a distance in kilometres as the crow flies.
    public double HaversineDistance(double lat1, double lon1, double lat2, double lon2){

        // distance between latitudes and longitudes
        double dLat = (lat2 - lat1) *
                CityData.pi / 180.0;
        double dLon = (lon2 - lon1) *
                CityData.pi / 180.0;

        // convert to radians
        lat1 = (lat1) * CityData.pi / 180.0;
        lat2 = (lat2) * CityData.pi / 180.0;

        // apply formulae
        double a =  Math.pow(Math.sin(dLat / 2), 2) +
                    Math.pow(Math.sin(dLon / 2), 2) *
                            Math.cos(lat1) * Math.cos(lat2);
        double rad = 6371; //radius of the earth
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }



}