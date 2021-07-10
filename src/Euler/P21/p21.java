package Euler.P21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class p21 {

    private int[] divisors;

    public static void main(String[] args) {

        p21 project = new p21();

        System.out.println (project.findDivisors(220));

        System.out.println(project.newAmicable(project.findDivisors(220)));

    }

    //this should be an int, it is a void for now to avoid the program crashing
    public int newAmicable(ArrayList<Integer> x){

        Integer[] a = (Integer[]) x.toArray();
        int counter = 0;

        for (int i = 0; i < x.size(); i++) {
            counter += a[i];
        }

        return counter;
    }

    //change this back to int[] if it takes forever to compute!!!!!!!!!!!!!!!!!!!!!!!
    public ArrayList<Integer> findDivisors(int x){

        int a = x;
        ArrayList<Integer> b = new ArrayList<Integer>();
        int[] c = null;
        int counter = 0;

        b.add(1);

        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0){
                b.add(i);
                counter++;
                b.add(a / i);
                counter++;
            }
        }

        return b;
    }

    public boolean isAmicable(int x){

        //return true

        return false;
    }

    //this should be an int, it is a void for now to avoid the program crashing
    public void AmicableNumber(int x){

        //return
    }

}
