package dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PartOne {
    public static void main(String[] args) {

        try {
            File file = new File("advent-2023/src/resources/day1/input-day1.txt");
            Scanner inputScanner = new Scanner(file);

            int countLargerThanPrevious = getSumOfCalibInputs(inputScanner);
            Logger myLogger = Logger.getLogger("mylogger");
            myLogger.log(Level.INFO, "The total sum of all calibration inputs are {0}", countLargerThanPrevious);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static int getSumOfCalibInputs(Scanner inputScanner) {
        int sum = 0;
        while (inputScanner.hasNextLine()){
            String line = inputScanner.nextLine();
            String calib = line.replaceAll("\\D+","");
            sum+= Integer.parseInt("" + calib.charAt(0) + calib.charAt(calib.length()-1));
        }
        inputScanner.close();
        return sum;
    }

}
