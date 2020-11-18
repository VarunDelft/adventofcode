package com.dayone.partone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Math.floor;

public class PartOne {

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
        return (int) (floor(mass/3) - 2);
    }

}
