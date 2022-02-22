package Labs.Lab1p2;

public class MainExercise2 {

    public static void main(String[] args){
        Checking checking = new Checking("Winston", 1234,0);
        System.out.println(checking.getNumber());
        System.out.println(checking.getName());
        System.out.println(checking.getBalance());
        checking.deposit(152.15);
        System.out.println(checking.getBalance());
        checking.withdraw(52.15);
        System.out.println(checking.getBalance());

        Savings savings = new Savings("Winston", 5678,1000, 3);

    }
}
