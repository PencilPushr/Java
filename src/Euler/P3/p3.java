package Euler.P3;

public class p3 {
    private final long y = 600851475143L;
    public static void main(String[] args) {
        int currentPrime = 0;
        p3 project = new p3();
        for (int i = 3; i < Math.sqrt(project.y); i+=2) {
           if (project.isPrime(i) && project.y % i == 0){
               currentPrime = i;
           }
        }
        System.out.println(currentPrime);
    }

    public boolean isPrime(int x) {
        for (int i = 3; i < Math.sqrt(x); i += 2){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }

}
