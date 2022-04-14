package Exercises3.ex2;

public class CityData {

    public CityData(){

    }

    public void printLargest10(){
        //Print largest 10 cities (Name + lat + long + country + population)
        System.out.println();
    }

    public void printSmallest10(){
        //Print smallest 10 cities
        System.out.println();
    }

    public void printCountry(String str){
        //Recieves a String country name, and prints all cities from given country
    }

    public void printClosest10(double lon, double lat){
        //print the 10 closest cities to the coordinates, use haversine forumla
        //either iterate through the file and check it against HaversineDistance functions
        //alternatively add them to a hashmap/array and check them against it
    }

    public double HaversineDistance(){
        return 0.0;
    }

}
