package Labs.Lab1p2;

public class Accounts {

    private String name;
    private int number;
    protected double balance;

    public Accounts(String name, int number, double balance){
        this.name = name;
        this.number = number;
        this.balance = 0.0;

    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public double getBalance() {
        return this.balance;
    }
}
