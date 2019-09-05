package com.snmi.palindrome;

/**
 * The program purpose is to find the biggest palindrome number obtained from multiplication of two three digits numbers
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class ProgramPalindrome {

    /**
     * Class constants
     */
    private static final int MAX_THREE_DIGITS_VALUE = 999;
    private static final int MINIMUM_THREE_DIGITS_VALUE = 100;

    /**
     * Class variable that will hold the max palindrome number
     */
    private static int maxPalindromeNumber = 0;

    public static void main(String[] args) {
        calculateMaxPalindrome();
        printThePalindrome();
    }

    /**
     * Calculate the biggest palindrome number obtained from multiplication of two three digits numbers
     * Then print the result on console.
     */
    private static void calculateMaxPalindrome() {
        for (int firstThreeDigitsNumber = MAX_THREE_DIGITS_VALUE; firstThreeDigitsNumber > MINIMUM_THREE_DIGITS_VALUE; firstThreeDigitsNumber--) {
            for (int secondThreeDigitsNumber = firstThreeDigitsNumber; secondThreeDigitsNumber > MINIMUM_THREE_DIGITS_VALUE; secondThreeDigitsNumber--) {
                int currentMaxPalindromeNumber = secondThreeDigitsNumber * firstThreeDigitsNumber;
                if (isPalindrome(currentMaxPalindromeNumber) && currentMaxPalindromeNumber > maxPalindromeNumber) {
                    maxPalindromeNumber = currentMaxPalindromeNumber;
                }
            }
        }
    }

    /**
     * Convert the number to string, reverse it and compare them
     * @param currentMaxPalindromeNumber take the current max palindrome number
     * @return boolean result obtained after two strings comparison
     */
    private static boolean isPalindrome(int currentMaxPalindromeNumber) {
        String leftToRightNumber = String.valueOf(currentMaxPalindromeNumber);
        StringBuilder stringBuilderForLeftToRightNumber = new StringBuilder(leftToRightNumber);
        String rightToLeftNumber = String.valueOf(stringBuilderForLeftToRightNumber.reverse());
        return leftToRightNumber.equals(rightToLeftNumber);
    }

    private static void printThePalindrome() {
        System.out.println(maxPalindromeNumber);
    }
}
