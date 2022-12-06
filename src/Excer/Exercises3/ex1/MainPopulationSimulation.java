package Excer.Exercises3.ex1;

import java.util.Random;

public class MainPopulationSimulation {

    public static void main(String[] args) {
        Country country = new Country(12, 100.0);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double randomIncrease = random.nextDouble() * (10 - 0) + 0;
            country.update(randomIncrease);
            System.out.println("Year " + i + ", increase:" + randomIncrease + " million");

        }
        System.out.println("Largest city: " + country.getMaximum().toString());
        System.out.println("Smallest city: " + country.getMinimum().toString());
        System.out.println("Total: " + country.toString());
    }

}
