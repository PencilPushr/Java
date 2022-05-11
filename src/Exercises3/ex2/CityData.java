package Exercises3.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.*;

public class CityData {

    //Utility class
    //Holds: AsciiName, Lat, Long, Country, and Population.
    public class metropolis{
        public int id;
        public String namium;
        public double latitude;
        public double longitude;
        public String country;
        public int population;

        public metropolis(int i, String n, double l1, double l2, String c, int p){
            this.id = i;
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
            String thing = s.nextLine();
            if (first == false){
                //Some country names, like "Korea, South" contain commas.
                //So, we must split by "," and after removing the quotes
                //from the start and end of each line.
                String[] line = thing.replaceAll("^\"|\"$", "").split("\",\"");
                metropolis temp = new metropolis(Integer.parseInt(line[10]), line[1],Double.parseDouble(line[2]),
                                                    Double.parseDouble(line[3]),line[4],Integer.parseInt(line[9]));
                this.atlas.put(Integer.valueOf(line[10]),temp);
            }
            first = false;
        }
        s.close();

    }

    public void printLargest10(){
        //Print largest 10 cities
        metropolis[] tenSmallestSoFar = new metropolis[10];

        for (var entry: atlas.values()){
            tenSmallestSoFar = this.enterCity(false,(metropolis) entry,tenSmallestSoFar);
        }

        //ASCII name, latitude, longitude, country and population
        System.out.println("TAH-DAH!!!!");
        for (var city: tenSmallestSoFar){
            String temp = city.namium+", Country: "+city.country+", Co-ordinates: "+city.latitude+","+city.longitude +", Population: "+city.population;
            System.out.println("----Name: "+temp);
        }
    }

    public void printSmallest10(){
        //Print smallest 10 cities

        metropolis[] tenSmallestSoFar = new metropolis[10];

        for (var entry: atlas.values()){
            tenSmallestSoFar = this.enterCity(true,(metropolis) entry,tenSmallestSoFar);
        }

        //ASCII name, latitude, longitude, country and population
        System.out.println("TAH-DAH!!!!");
        for (var city: tenSmallestSoFar){
            String temp = city.namium+", Country: "+city.country+", Co-ordinates: "+city.latitude+","+city.longitude +", Population: "+city.population;
            System.out.println("----Name: "+temp);
        }
    }

    //Iterates through city array to check population for smallest and largest based on boolean
    private metropolis[] enterCity(boolean small,metropolis newCity,metropolis[] pool){
        metropolis temp = null;
        for (int i=0;i<pool.length;i++){
            if (pool[i] != null){
                if (small){
                    if (newCity.population <= pool[i].population){
                        temp = pool[i];
                        pool[i] = newCity;
                        newCity = temp;
                        temp = null;
                    }
                }else{
                    if (newCity.population >= pool[i].population){
                        temp = pool[i];
                        pool[i] = newCity;
                        newCity = temp;
                        temp = null;
                    }
                }
            } else {
                pool[i] = newCity;
                return pool;
            }
        }
        return pool;
    }

    //Recieves a String country name, and prints all cities from given country
    public void printCountry(String str){
        //Recieves a String country name, and prints all cities from given country

        //set to hold all the values
        Set<String> keys = new HashSet<>();
        //Iterates through atlas, checking if the name is equal to the str
        for (var entry : atlas.entrySet()){
            if (Objects.equals(str, entry.getValue())){ //if name = string
                System.out.println(entry.getKey().toString() + "=" +             entry.getValue());
            }
        }

        //ArrayList<String> printCities = new ArrayList<String>();

        for (var entry : atlas.values()){
            if (entry.country.equals(str)){
                System.out.println(entry.namium);
            }
        }

    }

    // This function is like enterCity, but for distance
    private metropolis[] navigateCity(double startLat, double startLong, metropolis newCity,metropolis[] pool){
        metropolis temp = null;
        for (int i=0;i<pool.length;i++){
            if (pool[i] != null){
                double distanceOne = HaversineDistance(newCity.latitude, newCity.longitude, startLat, startLong);
                double distanceTwo = HaversineDistance(pool[i].latitude, pool[i].longitude, startLat, startLong);
                if (distanceOne <= distanceTwo){
                    temp = pool[i];
                    pool[i] = newCity;
                    newCity = temp;
                    temp = null;
                }
            } else {
                pool[i] = newCity;
                return pool;
            }
        }
        return pool;
    }

    public void printClosest10(double lat, double lon){
        //print the 10 closest cities to the coordinates, use haversine forumla
        //either iterate through the file and check it against HaversineDistance functions
        //alternatively add them to a hashmap/array and check them against it


        metropolis[] tenClosestSoFar = new metropolis[10];

        for (var entry: atlas.values()){
            tenClosestSoFar = this.navigateCity(lat, lon, (metropolis) entry,tenClosestSoFar);
        }

        //ASCII name, latitude, longitude, country and population
        System.out.println("TAH-DAH!!!!");
        for (var city: tenClosestSoFar){
            String temp = city.namium+", Country: "+city.country+", Co-ordinates: "+city.latitude+","+city.longitude +", Population: "+city.population;
            System.out.println("----Name: "+temp);
        }

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