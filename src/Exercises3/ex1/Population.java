package Exercises3.ex1;

public class Population {

    private double size; //set in millions e.g. "10.2" million

    public Population(double inputSize){
        this.size = inputSize;
    }

    public void update(double inputSize){
        this.size += inputSize;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
