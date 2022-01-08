package com.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartTwo {
    public static void main(String[] args) {

        try {
            File file = new File("Day1/input-day1.txt");
            Scanner inputScanner = new Scanner(file);

            List<Integer> measurements = loadMeasurements(inputScanner);

            int countLargerThanPrevious = calculateTotalSlidingWindowSumLargerThanPrevious(measurements) - 1;
            Logger myLogger = Logger.getLogger("mylogger");
            myLogger.log(Level.INFO, "The total measurement windows larger than previous are {0}", countLargerThanPrevious);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static List<Integer> loadMeasurements(Scanner inputScanner) {
        List<Integer> measurements = new ArrayList<>();
        while (inputScanner.hasNextLine()){
            String line = inputScanner.nextLine();
            measurements.add(Integer.parseInt(line));
        }

        inputScanner.close();
        return measurements;
    }

    private static int calculateTotalSlidingWindowSumLargerThanPrevious(List<Integer> measurements){
        int sumPrevious = 0;
        int sumCurrent;
        int countLargerThanPrevious = 0;
        List<Integer> slidingWindow = new ArrayList<>();

        for (Integer measurement: measurements) {
            if (slidingWindow.size() < 3) {
                slidingWindow.add(measurement);
            }
            else {
                sumCurrent = slidingWindow.stream().mapToInt(Integer::intValue).sum();
                countLargerThanPrevious = sumCurrent > sumPrevious ? countLargerThanPrevious + 1: countLargerThanPrevious;
                slidingWindow.remove(0);
                slidingWindow.add(measurement);
                sumPrevious = sumCurrent;
            }
        }
        sumCurrent = slidingWindow.stream().mapToInt(Integer::intValue).sum();
        countLargerThanPrevious = sumCurrent > sumPrevious ? countLargerThanPrevious + 1: countLargerThanPrevious;

        return countLargerThanPrevious;
    }
}
