package Euler.P7;

public class p7 {

    public p7(){
        primeLoop();
    }

    public static void main(String[] args) {
        new p7();
    }

    public void primeLoop(){
        int primeCounter = 2;
        int number = 3;

        //less than 10,001
        while(primeCounter < 10001){
            number += 2;
            if (isPrime(number)){
                primeCounter++;
            }
        }
        System.out.println(number);
    }

    public boolean isPrime(int x){
        for (int i = 3; i <= Math.sqrt(x); i+=2) {
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
}
