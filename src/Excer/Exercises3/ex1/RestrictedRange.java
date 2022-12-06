package Excer.Exercises3.ex1;

public class RestrictedRange{
    private int min;
    private int max;
    private double value;

    public RestrictedRange(int min, int max, int Value){
        if (min >= max){
            System.out.println("RANGE CLASS: Your min cannot be greater than your max");
            throw new IllegalArgumentException();
        }
        this.min = min;
        this.max = max;

        if (Value > 90 || Value < 90){

        }
    }

    public RestrictedRange(int longitudeValue){

    }

}
