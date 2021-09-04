package com.company.BST;

import java.util.ArrayList;
import java.util.Stack;
import java.lang.Math;

class Main { //this should be renamed to BalancedST, but I'm too lazy to replace all the mains

    private static void start(){
        System.out.print("hello");
    }

    public static int alphabeticValue(String input){
        int total = 0;
        for (int i = 0; i < input.length(); i++){
            total = total + (int) input.charAt(i);
        }
        return total;
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

        System.out.print("\n\n\n");

        binaryTree dick = new binaryTree();
        dick.add("Christine","A contract killer from Sussex.");
        dick.add("Daisy","An office worker from Galashiels.");
        dick.add("Frederick","A time-travelling shoe salesman from Bristol.");
        dick.add("James","A piano teacher from Essex.");
        dick.add("Terence","A lorry driver, from Jupiter.");

        System.out.print(dick.retrieveValueByKey("Daisy") + "\n");

        balancedBinaryTree harry = new balancedBinaryTree();
        harry.add("Christine","A contract killer from Sussex.");
        harry.add("Daisy","An office worker from Galashiels.");
        harry.add("Frederick","A time-travelling shoe salesman from Bristol.");
        harry.add("James","A piano teacher from Essex.");
        harry.add("Terence","A lorry driver, from Jupiter.");

        System.out.print(harry.retrieveValueByKey("James") + "\n");
    }
}