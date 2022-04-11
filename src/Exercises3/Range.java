package Exercises3;

public class Range
{
    private int min;
    private int max;

    public Range(int low, int high){
        if (low >= high){
            System.out.println("RANGE CLASS: Your min cannot be greater than your max");
            throw new IllegalArgumentException();
        }
        this.min = low;
        this.max = high;
    }

    public boolean contains(int number){
        return (number >= min && number <= max);
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}