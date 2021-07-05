package Euler.P20;

import java.util.Arrays;

public class p20a {

    public static void main(String[] args) {

        p20 p = new p20();

        int[] array = new int[1];
        array[0] = 1;

        //for (int i = 2; i < 101; i++) {
            //array = p.arrayMultiplication(i, array);
        //}

        int total = 0;

        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        System.out.println(total);

    }

    public int[] arrayMultiplication(int x, int[] y){

        int temp = x;
        int[] tempArray = y;
        int[] b = y;

        tempArray = multiplyArray(temp, tempArray);


        for (int i = 0; i < tempArray.length-1; i++) {
            if (tempArray[i] > 10){
                tempArray[i+1] = tempArray[i+1] + (tempArray[i] /10);
                tempArray[i] = tempArray[i] % 10;
            }
        }

        while (tempArray[tempArray.length-1] > 10){
            b = new int[resizeArray(tempArray).length];
            b = copyOverArray(b, tempArray);
            int i = b.length - 2;
            b[i+1] = b[i+1] + b[i];
            b[i+1] = b[i] / 10;
            b[i] = b[i] % 10;
            tempArray = new int[b.length];
            Arrays.fill(tempArray, 0);
            tempArray = b;
        }

        return b;
    }

    public int[] resizeArray(int[] x){

        int[] copy = new int[x.length+1];
        Arrays.fill(copy, 0);

        return copy;
    }

    public int[] copyOverArray(int[] x, int[] y){

        int[] a = x; // the larger array, should be filled with zeros from resizeArray, Do not reassign if it is smaller
        int[] b = y; // the smaller array that we are copying over SHOULD BE SMALLER THAN A!

        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }

        return a;
    }

    public int[] multiplyArray(int x, int[] y){

        int temp = x;
        int[] tempArray = y;

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i] * temp;
        }

        return tempArray;
    }
}
