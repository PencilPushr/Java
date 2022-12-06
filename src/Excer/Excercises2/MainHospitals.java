package Excer.Excercises2;

public class MainHospitals {

    public static void main(String[] args) {
        Hospitals hs = new Hospitals(10, 10);

        System.out.println("printBeds():");
        hs.printBeds();
        System.out.println("printPercentages():");
        hs.printPercentages();
        System.out.println("printMinPercentages():");
        hs.printMinPercentage();
        System.out.println("printMaxPercentages():");
        hs.printMaxPercentage();
    }
}
