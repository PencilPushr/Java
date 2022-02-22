package Labs.Lab1p2;

public class Checking extends Accounts {

    public Checking(String name, int number, double balance) {
        super(name, number, balance);
    }

    void deposit(double input){
        this.balance = this.balance + input;
    }

    void withdraw(double input){
        this.balance = this.balance - input;
    }
}
