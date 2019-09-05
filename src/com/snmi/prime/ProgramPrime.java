package com.snmi.prime;

/**
 * The program need to find the last primitive number on specific position
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class ProgramPrime {

    /**
     * Class constants
     */
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int SEVEN = 7;
    private static final int TEN = 10;
    private static final int DESIRED_POSITION = 10001;
    private static final int DIVISION_REMAINDER = 0;

    private static final String INFORMATIVE_SENTENCE = "The number of the %d'th position is %d";

    /**
     * Class variables which will hold the number and his position
     */
    private static int primitiveNumberPosition = 0;
    private static int primitiveNumber = 1;

    public static void main(String[] args) {
        checkPrimitiveNumber(DESIRED_POSITION);
        printNumberAndPosition();
    }

    /**
     * The method is looping through all numbers until find the number of desired position.
     * @param desiredPosition take the desired position
     */
    private static void checkPrimitiveNumber(int desiredPosition) {
        while (primitiveNumberPosition != desiredPosition) {
            primitiveNumberPosition = getNextPosition(primitiveNumber, primitiveNumberPosition);
            primitiveNumber++;
        }
    }

    /**
     * Check if the number is two or three
     * @param primitiveNumber take the current number
     * @return the result of conditional check if the number is two or three
     */
    private static boolean isTwoOrThree(int primitiveNumber) {
        return primitiveNumber == TWO || primitiveNumber == THREE;
    }

    /**
     * Check if the number is primitive
     * @param primitiveNumber take the current number
     * @return the result of conditional check if the number is not divisible by two and three
     */
    private static boolean isNotDivisibleByTwoAndThree(int primitiveNumber) {
        return primitiveNumber % TWO != DIVISION_REMAINDER && primitiveNumber % THREE != DIVISION_REMAINDER;
    }

    /**
     * Check if the number is primitive
     * @param primitiveNumber take the current number
     * @return the result of conditional check if the number is not divisible by two,three,five and seven
     */
    private static boolean isNotDivisibleBySeveralNumbers(int primitiveNumber) {
        return  primitiveNumber % TWO != DIVISION_REMAINDER && primitiveNumber % THREE != DIVISION_REMAINDER &&
                primitiveNumber % FIVE != DIVISION_REMAINDER && primitiveNumber % SEVEN != DIVISION_REMAINDER;
    }

    /**
     * Increase the position every time the program found a primitive number
     * @param primitiveNumber take the current number
     * @param primitiveNumberPosition take the current primitive position
     * @return the last position of founded number
     */
    private static int getNextPosition(int primitiveNumber, int primitiveNumberPosition) {

        if (isTwoOrThree(primitiveNumber)) {
            primitiveNumberPosition++;
            return primitiveNumberPosition;
        }

        if (primitiveNumber < TEN) {
            if (isNotDivisibleByTwoAndThree(primitiveNumber)) {
                primitiveNumberPosition++;
            }
        } else {
            if (isNotDivisibleBySeveralNumbers(primitiveNumber)) {
                primitiveNumberPosition++;
            }
        }

        return primitiveNumberPosition;
    }

    /**
     * Print the number and his position on console
     */
    private static void printNumberAndPosition() {
        System.out.printf(INFORMATIVE_SENTENCE, primitiveNumberPosition, primitiveNumber);
    }
}
