package Euler.P5;

public class p5 {

    public p5() {
        System.out.println(this.counter());
    }

    public static void main(String[] args) {
        new p5();
    }

    public boolean divisor(int x){
        int y = x;

        //should look at GCD algorithm as referenced from a StackExchange post
        for (int i = 11; i < 20; i++) { //i can also start at 2
            int temp = y;
            if ((temp = temp % i) != 0){
                return false;
            }
        }

        return true;
    }

    public int counter(){
        int currentNumber = 2520;

        while(!divisor(currentNumber)){
            currentNumber++;
        }

        return currentNumber;
    }
}
