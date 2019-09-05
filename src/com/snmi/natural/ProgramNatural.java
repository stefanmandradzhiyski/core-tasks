package com.snmi.natural;

/**
 * The program need to calculate the sum of all numbers that aren't divisible by three or five from zero to one hundred.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class ProgramNatural {

    /**
     * Class constants
     */
    private static final int MAX_NUMBER = 10000;
    private static final int FIRST_NUMBER = 0;
    private static final int DIVIDE_BY_FIVE = 5;
    private static final int DIVIDE_BY_THREE = 3;
    private static final int DIVISION_REMAINDER = 0;

    /**
     * Class variable which will hold the sum of all numbers divisible by three or five
     */
    private static int sumOfAllValidNumbers = 0;

    public static void main(String[] args) {
        calculateTheSum();
        printTheSum();
    }

    /**
     * Iterate throw all numbers from zero to one hundred.
     * Check if the number is not divisible by three or five.
     * If the number meet the requirements it will be added to the total sum.
     */
    private static void calculateTheSum() {
        for (int currentNumber = FIRST_NUMBER; currentNumber <= MAX_NUMBER; currentNumber++) {
            if (isDivisible(currentNumber)) {
                sumOfAllValidNumbers += currentNumber;
            }
        }
    }

    /**
     * @param currentNumber take the current number which need to be checked
     * @return boolean result of conditional check
     */
    private static boolean isDivisible(int currentNumber) {
        return  currentNumber % DIVIDE_BY_THREE == DIVISION_REMAINDER
                || currentNumber % DIVIDE_BY_FIVE == DIVISION_REMAINDER;
    }

    /**
     * Print the sum
     */
    private static void printTheSum() {
        System.out.println(sumOfAllValidNumbers);
    }
}
