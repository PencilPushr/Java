package Excercises;

import java.util.Arrays;

public class MainRocket {

    public static void main(String[] args) {

        int[] randomArr = new int[10];
        for (int i = 0; i < randomArr.length; i++){
            randomArr[i] = 0 + (int) (Math.random() * (100 - 0 + 1));   // int Random = (min.value ) + (int)(Math.random()* ( Max - Min + 1));
                                                                    // *Where min is the smallest value You want to be the smallest number possible to generate and Max is the biggest possible number to generate
        }

        // have to instantiate a new object with parameter we are passing in order for the code below to work
        Rocket rocket = new Rocket(randomArr);

        System.out.println("Payload: " +Arrays.toString(randomArr));
        System.out.println("Sum weight = " +rocket.getLaunchWeight());
        System.out.println("Average weight = " +rocket.getAverageWeight());
        System.out.println("Maximum weight = " +rocket.getMaxWeight());
        System.out.println("Minimum weight = " +rocket.getMinWeight());
        //rocket.printCountDown(rocket.countdownInput());  // countdown - but in excercise 1E it's never said we need to call it

    }
}
