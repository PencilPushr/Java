package Exercises3.ex3;

import Exercises3.ex3.PopulationDisplay;

import javax.swing.*;

public class MainPopulation {

    public static void main(String[] args) {
        //PopulationDisplay pd = new PopulationDisplay("C:\\Users\\ajval\\Desktop\\pop2000.asc");
        String[] filenames = {"pop2000.asc", "pop2005.asc", "pop2010.asc", "pop2015.asc", "pop2020.asc"};
        PopulationDisplay pd = new PopulationDisplay(filenames);

        JFrame j = new JFrame("Heatmap");
        j.getContentPane().setSize(750,750);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.repaint(); //PopDisplay will handle the timer and painting

    }

}