package Excercises2;

public class MainHospitals {

    public static void main(String[] args) {
        Hospitals hs = new Hospitals(9, 9);

        hs.printBeds();
        hs.printPercentages();
        hs.printMinPercentage();
        hs.printMaxPercentage();
    }
}
