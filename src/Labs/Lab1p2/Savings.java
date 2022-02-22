package Labs.Lab1p2;

import java.text.DecimalFormat;

public class Savings extends Accounts {

    private double interestRate;

    public Savings(String name, int number, double balance, double interestRate){
        super(name, number, balance);
        this.interestRate = interestRate;
    }

    double accumulateInterest(int yearsAccum){

        double fakeBalance = balance;
        double fakeIR = interestRate;


        double interest = fakeBalance * (Math.pow((1 + fakeIR/100), yearsAccum)) - fakeBalance;
        //Math.pow raises something to the power of
        //we take away the balance at the end in order to just get the interest alone

        String pattern ="###.##";
        DecimalFormat df = new DecimalFormat(pattern);
        df.format(interest);
        return interest;
    }

}
