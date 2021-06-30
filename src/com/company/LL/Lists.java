package com.company.LL;

public class Lists {

    private void start(){
        System.out.print("hello");
    }

    //this simply satisfies the OOP requirements
    public static void main(String[] args) {
        linkedList tom = new linkedList();
        tom.add("Hello");
        tom.add("My");
        tom.add("Baby");
        tom.add("Hello");
        tom.add("My");
        tom.add("Honey");
        tom.add("Hello");
        tom.add("My");
        tom.add("Ragtime");
        tom.add("Gal");
        System.out.print(tom.getValue(4));

    }
}

