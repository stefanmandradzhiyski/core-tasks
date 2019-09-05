package com.snmi.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * The program need to sum all odd numbers from fibonacci series sequence
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProgramFibonacciSequence {

    /**
     * Class constants
     */
    private static final int DIVIDER = 2;
    private static final int DIVISION_REMAINDER = 1;
    private static final int FIBONACCI_MAX_VALUE = 2000000;
    private static final int FIBONACCI_MINIMUM_VALUE = 0;

    /**
     * Class variables which are used for fibonacci sequence
     */
    private static long fibonacciNumber = 1, firstNumberHolder = 1, secondNumberHolder = 2;

    /**
     * Class collection that will hold all odd numbers from fibonacci series sequence
     */
    private static List<Long> allOddNumbers = new ArrayList<>();

    public static void main(String[] args) {
        fibonacciSequence(FIBONACCI_MAX_VALUE);
        printTheSum(calculateTheSum());
    }

    /**
     * Find every fibonacci number and check it if it is odd.
     * If the number is odd it have been added to the collection.
     * @param fibonacciMaxValue take the max value of fibonacci sequence
     */
    private static void fibonacciSequence(int fibonacciMaxValue) {
        for (int loopIteration = FIBONACCI_MINIMUM_VALUE; loopIteration < fibonacciMaxValue; loopIteration++) {
            fibonacciNumber = firstNumberHolder;
            firstNumberHolder = secondNumberHolder;
            secondNumberHolder = fibonacciNumber + firstNumberHolder;

            if (fibonacciNumber % DIVIDER == DIVISION_REMAINDER) {
                allOddNumbers.add(fibonacciNumber);
            }
        }
    }

    /**
     * Calculate the sum of all odd numbers from fibonacci sequence and print it
     * @return the sum
     */
    private static long calculateTheSum() {
        return allOddNumbers.stream().mapToLong(oddNumber -> oddNumber).sum();
    }

    /**
     * Print the sum on console
     * @param sumOfAllOddNumbers take the sum of all odd numbers
     */
    private static void printTheSum(long sumOfAllOddNumbers) {
        System.out.println(sumOfAllOddNumbers);
    }
}
