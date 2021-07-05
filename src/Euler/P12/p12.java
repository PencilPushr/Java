package Euler.P12;

public class p12 {

    public static void main(String[] args) {
        p12 p = new p12();

        p.TriangularLoop();

    }

    public void TriangularLoop(){
        int total = 1;
        int i = 1;

        while(hasNFactors(total) < 500){
            total = 0;
            for (int j = 1; j <= i; j++) {
                total += j;
            }
         i++;
        }
        System.out.println(total);
    }

    public int hasNFactors(int x){

        int a = x;
        int counter = 0;

        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0){
                counter++;
            }
        }

        counter *= 2;

        return counter;
    }


}
