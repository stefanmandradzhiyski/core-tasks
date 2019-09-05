package com.snmi.division;

import java.util.ArrayList;
import java.util.List;

/**
 * The program need to print on console the smallest and largest
 * number which can be divided by all numbers from one to twenty.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProgramDivision {

    /**
     * Class constants
     */
    private static final int DIVISION_REMAINDER = 0;
    private static final int LAST_DIVIDER_NUMBER = 20;
    private static final int LAST_CURRENT_NUMBER = 500000000;
    private static final int FIRST_CURRENT_AND_DIVIDER_NUMBER = 1;

    private static final String SMALLEST_NUMBER_SENTENCE = "The smallest number which can be divided by all numbers from 1 to 20 is: %d \n";
    private static final String LARGEST_NUMBER_SENTENCE = "The largest number which can be divided by all numbers from 1 to 20 is: %d \n";

    /**
     * Class collection
     */
    private static List<Integer> allNumbers = new ArrayList<>();

    public static void main(String[] args) {
        findAllNumbers();
        printNumbers();
    }

    /**
     * Iterate through every number from one to five millions.
     * If the number can be divided by all numbers from one to twenty it have been added to the list.
     */
    private static void findAllNumbers() {
        for (int currentNumber = FIRST_CURRENT_AND_DIVIDER_NUMBER; currentNumber <= LAST_CURRENT_NUMBER; currentNumber++) {
            if (isNumberDivisible(currentNumber)) {
                allNumbers.add(currentNumber);
            }
        }
    }

    /**
     * Check if the number can be divided by all numbers from one to twenty.
     * @param currentNumber take the current number from the iteration
     * @return boolean result if the number can be divided by all numbers from one to twenty
     */
    private static boolean isNumberDivisible(int currentNumber) {
        for (int currentDivider = FIRST_CURRENT_AND_DIVIDER_NUMBER; currentDivider <= LAST_DIVIDER_NUMBER; currentDivider++) {
            if (currentNumber % currentDivider != DIVISION_REMAINDER) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print the smallest and largest number
     */
    private static void printNumbers() {
        int smallestNumber = allNumbers.get(0);
        int largestNumber = allNumbers.get(allNumbers.size() - 1);
        System.out.printf(SMALLEST_NUMBER_SENTENCE, smallestNumber);
        System.out.printf(LARGEST_NUMBER_SENTENCE, largestNumber);
    }
}
