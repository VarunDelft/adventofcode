package com.dayone.parttwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.Math.max;

public class PartTwo {

    public static void main(String[] args) {

        try {

            File file = new File("input-day1.txt");
            Scanner inputScanner = new Scanner(file);

            int totalFuelRequirement = calculateTotalFuelRequirement(inputScanner);

            System.out.println("The total fuel requirement is " + totalFuelRequirement);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int calculateTotalFuelRequirement(Scanner inputScanner){
        int mass;
        int sumFuelRequirements = 0;

        while (inputScanner.hasNextLine()){

            String line = inputScanner.nextLine();
            mass = Integer.parseInt(line);
            sumFuelRequirements += requiredFuelPerModule(mass);

        }

        inputScanner.close();

        return sumFuelRequirements;
    }

    private static int requiredFuelPerModule(int mass){

        int fuel = (int) (floor(mass/3) - 2);
        int newMass = fuel;

        while (newMass > 0){
            newMass = (int) (floor(newMass/3) - 2);
            newMass = max(newMass, 0);
            fuel += newMass;
        }

        return fuel;

    }

}
