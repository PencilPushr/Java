package Euler.p6;

public class p6 {

    public p6(){
        this.squareMachine();
    }

    public static void main(String[] args) {
        new p6();
    }

    public void squareMachine(){
        int temp = 0;
        int temp2 = 0;
        for (int i = 1; i <= 100; i++) {
            temp += i;
            temp2 += (i * i);
        }
        temp *= temp;
        System.out.println(temp - temp2);
    }

}
