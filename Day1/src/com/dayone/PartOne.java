package com.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartOne {

    public static void main(String[] args) {

        try {
            File file = new File("Day1/input-day1.txt");
            Scanner inputScanner = new Scanner(file);

            int countLargerThanPrevious = calculateTotalMeasurementsLargerThanPrevious(inputScanner) - 1;
            Logger myLogger = Logger.getLogger("mylogger");
            myLogger.log(Level.INFO, "The total measurements larger than previous are {0}", countLargerThanPrevious);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int calculateTotalMeasurementsLargerThanPrevious(Scanner inputScanner){
        int countLargerThanPrevious = 0;
        int prevValue = 0;
        int currValue;

        while (inputScanner.hasNextLine()){

            String line = inputScanner.nextLine();
            currValue = Integer.parseInt(line);
            countLargerThanPrevious = currValue > prevValue ? countLargerThanPrevious + 1: countLargerThanPrevious;
            prevValue = currValue;

        }

        inputScanner.close();

        return countLargerThanPrevious;
    }


}
