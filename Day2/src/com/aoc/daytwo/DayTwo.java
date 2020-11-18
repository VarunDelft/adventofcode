package com.aoc.daytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DayTwo {

    public static void main(String[] args) {

        try {

            File file = new File("input-day2.txt");
            Scanner inputScanner = new Scanner(file);
            inputScanner.useDelimiter(",");

            List<Integer> opCodes = processOpCodesAsList(inputScanner);

            final List<Integer> intCodeResult = runIntCodeProgram(opCodes);

            System.out.println(intCodeResult);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static List<Integer> runIntCodeProgram(List<Integer> opCodes) {

        int value;
        Boolean stopProgram = false;

        for (int i = 0; i <= opCodes.size(); i+=4 ){

            if(stopProgram) {
                break;
            }

            switch (opCodes.get(i)){
                case 1:
                    value = opCodes.get(opCodes.get(i + 1)) + opCodes.get(opCodes.get(i + 2));
                    opCodes.set(opCodes.get(i + 3), value);
                    break;

                case 2:
                    value = opCodes.get(opCodes.get(i + 1)) * opCodes.get(opCodes.get(i + 2));
                    opCodes.set(opCodes.get(i + 3), value);
                    break;

                case 99:
                    stopProgram = true;
                    break;

                default:
            }
        }

        return opCodes;

    }

    private static List<Integer> processOpCodesAsList(Scanner inputScanner){

        List<Integer> opCodes = new ArrayList<>();

        while (inputScanner.hasNextLine()){

            String line = inputScanner.nextLine();
            opCodes = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        }

        return opCodes;

    }

}
