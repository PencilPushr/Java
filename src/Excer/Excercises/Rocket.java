package Excer.Excercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rocket {

    private int[] payload;

    public Rocket(int[] randomArr) {
        payload = randomArr;

    }


    // Collects the integer for input to be used in printCountdown provided the input is bigger than 1
    public int countdownInput(){
        int cdNumber = -1;
        while(!(cdNumber>1)){
            try {
                System.out.println("Please input a time bigger than one: ");
                Scanner s = new Scanner(System.in);
                cdNumber = s.nextInt();
                if (!(cdNumber > 1)) {
                    System.out.println("Invalid Time!");
                }
            }
            catch (InputMismatchException e){
                System.err.println("Not a valid input | error: " + e.getMessage());
            }
        }

        return cdNumber;
    }

    //should take in an int (but I thought having the countdownInput made things simpler) and counts down from the given number to 1 and prints lift off
    public void printCountDown(int countDown){

        for (int i = countDown; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Lift Off!");    // we are only counting down to 1, as next value would be zero in which case we would have lift off.
    }

    // returns sum of the payload array index and assigns it to payload sum which we return
    public int getLaunchWeight(){

        int payloadSum = 0;
        for (int i : payload) {
            payloadSum += i;
        }

        return payloadSum;
    }

    //Calling getLaunchWeight and dividing it by payload index (number of elements in the array) and return the variable assigned
    public double getAverageWeight(){

        /*  -- This is backup in case code below fails.
        double payloadMean = 0.0d;
        for (int i=0; i < payload.length; i++){ // this can be made into a for-each loop, but it's not being used so no point.
            payloadMean += payload[i];
        }
        payloadMean /= payload.length;
        */

        return (double) getLaunchWeight() / (double) payload.length; // coupled + unsure if its safe to cast this
    }

    //Initiates a for loop which iterates through every element and assigns it to payloadMax if the payload element is larger
    public int getMaxWeight(){

        int payloadMax = 0;
        //for-each loop; we are iterating through each element to run the if statement + makes the code neater
        for (int i : payload) {
            if (payloadMax < i) {
                payloadMax = i;
            }
        }

        return payloadMax;
    }

    //initiates a for loop to iterate through every element and assign it to payloadMin if payload element is smaller
    public int getMinWeight(){

        int payloadMin = payload[0];
        for (int i : payload) {
            if (payloadMin > i) {
                payloadMin = i;
            }
        }

        return payloadMin;
    }
}
