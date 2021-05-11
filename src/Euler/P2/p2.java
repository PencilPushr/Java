package Euler.P2;

public class p2 {

    public int Fibonacci(int n) {
        if (n < 2){
            return n;
        }
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        p2 project = new p2();
        int i = 1;
        int sum = 0;
        while (project.Fibonacci(i) <= 4_000_000){
            i++;
            System.out.println(project.Fibonacci(i));
            int counter = project.Fibonacci(i);
            if (counter % 2 == 0){
                sum += project.Fibonacci(i);
            }
        }
        System.out.println(sum);
    }

    /* cool way I found someone worked on this project after I did it my way on this piece of euler code
    int main() {
        long* fib = new long[3];
        fib[0] = 1;
        fib[1] = 2;
        long total = 0;
        while(true) {
            fib[2] = fib[0]+fib[1];
            fib[0] = fib[1];
            fib[1] = fib[2];
            if(fib[2]>=1000000)
                break;
            if(fib[2]%2==0)
                    total+=fib[2];
            }
            System.out.println(total);
        }
     */
}
