package Euler.P20;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class p20 {

    public static void main(String[] args) {

        BigInteger bigint, runningTotal, spare;
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
        System.out.println(runningTotal);

        //see if it's possible to solve using arrays
        ArrayList<Integer> al = new ArrayList<Integer>();
        int[] a = new int[1];
        Arrays.fill(a, 1);
        int localV = 1;


        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < a.length; j++) {
                a[j] = a[j] * i;
            }
        }
        System.out.println(localV);
    }

}
