package Euler.P20;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p20 {

    public static void main(String[] args) {

        p20 project = new p20();

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

    }

}
