package Euler.P20;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p20 {

    public static void main(String[] args) {

        p20 project = new p20();

/*        BigInteger bigint, runningTotal, spare;
        bigint = new BigInteger("1");
        runningTotal = new BigInteger("0");
        spare = new BigInteger("0");

        for (int i = 1; i < 101; i++) {
            bigint = bigint.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigint);

        while(!bigint.equals(spare)){
            runningTotal = runningTotal.add(bigint.mod(BigInteger.valueOf(10)));
            bigint = bigint.divide(BigInteger.valueOf(10));
        }
        System.out.println(runningTotal);*/

        int FactorialInput = 5;
        project.LongMultiplicationFactorial(FactorialInput);

    }

    public int[] LongMultiplicationFactorial(int x){


        int tempInput = x;

        //if we reach the fourth loop and the if statement is not initialised, we've fucked up
        for (int i = tempInput; i > 0; i--) {
            int[] array = new int[i];
            for (int j = 0; j < i; j++) {

                array[i] = array[i] * tempInput;
                if (array[i] > 10){
                    array[i] = array[i] % 10;
                    array[i+1] = array[i] /10;
                }

                //array[i] = array[i] * array[i+1];

                //in the if statement we may have to reassign array[i] to temp[i]
                //as we may not want to fully reassign the array until the last moment before return from this funciton.


            }
        }

        int[] c = new int[];

        for


        return;
    }

    public int[] arrayMultiply(int x, int[] y){

        int temp = x;
        int[] tempArray = y;
        int[] b;

        Collections.reverse(Arrays.asList(y));

        for (int i:tempArray) {
            tempArray[i] = tempArray[i] * temp;
        }

        for (int i = 0; i < tempArray.length-1; i++) {

            if (tempArray[i] > 10){
                tempArray[i+1] = tempArray[i+1] + tempArray[i];
                //tempArray[i+1] = tempArray[i] / 10;
                tempArray[i] = tempArray[i] % 10;
            }

            if (tempArray[tempArray.length-1] > 10){
                b = new int[tempArray.length+1];
            }
        }


    }

}
