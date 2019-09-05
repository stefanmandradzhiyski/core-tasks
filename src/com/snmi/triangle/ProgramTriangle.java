package com.snmi.triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The program read every word from specific file.
 * Calculate the sum of alphabets.
 * Check if the word is triangle and increase the counter.
 * At the end the program print the number of all triangle words in file.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class ProgramTriangle {

    /**
     * Class constants
     */
    private static final char FIRST_ALPHABET = 'A';
    private static final char LAST_ALPHABET = 'Z';

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int EIGHT = 8;
    private static final int DIVISION_REMAINDER = 0;
    private static final int FIRST_INDEX_OF_WORD = 0;

    private static final String PATH_NAME = "triangle_words.txt";
    private static final String RESULT_SENTENCE = "The number of all triangle words in the file is: %d";

    /**
     * Class variable which will hold the number of triangle words
     */
    private static int countOfTriangleWord = 0;

    /**
     * Class collection
     */
    private static Map<Character,Integer> allEnglishAlphabets;

    public static void main(String[] args) {
        fillAlphabetsMap();
        readWord();
        printCounter();
    }

    /**
     * Fill the HashMap with alphabets characters and numeration
     */
    private static void fillAlphabetsMap() {
        allEnglishAlphabets = new HashMap<>();
        int numeration = ZERO;

        for (char alphabet = FIRST_ALPHABET; alphabet <= LAST_ALPHABET; alphabet++) {
            numeration++;
            allEnglishAlphabets.put(alphabet, numeration);
        }
    }

    /**
     * Read every word from the file
     */
    private static void readWord() {
        File file = new File(PATH_NAME);
        try (FileReader fileReader = new FileReader(file.getAbsolutePath()); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String wordPerLine;
            while ((wordPerLine = bufferedReader.readLine()) != null) {
                checkForTriangleWord(wordPerLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate the sum of word's alphabets numeration
     * @param lineWord take the current word from the file
     * @return the sum of word's alphabets numeration
     */
    private static int calculateTheSum(String lineWord) {
        int sumOfAllAlphabetsNumeration = ZERO;

        for (int specificChar = FIRST_INDEX_OF_WORD; specificChar < lineWord.length(); specificChar++) {

            char currentChar = lineWord.toUpperCase().charAt(specificChar);
            if (allEnglishAlphabets.get(currentChar) != null) {
                int specificAlphabetNumeration = allEnglishAlphabets.get(currentChar);
                sumOfAllAlphabetsNumeration += specificAlphabetNumeration;
            }
        }

        return sumOfAllAlphabetsNumeration;
    }

    /**
     * Check if the word is triangle and increase the counter
     * @param wordPerLine take the current word
     */
    private static void checkForTriangleWord(String wordPerLine) {
        int sumOfWordAlphabets = calculateTheSum(wordPerLine);
        if (isWordTriangle(sumOfWordAlphabets)) {
            countOfTriangleWord++;
        }
    }

    /**
     * Check if the word is triangle
     * @param sumOfAllAlphabetsNumeration take the sum of word's alphabets numeration
     * @return boolean result if the word is triangle or not
     */
    private static boolean isWordTriangle(int sumOfAllAlphabetsNumeration) {
        double reverseTriangleNumber = (Math.sqrt(EIGHT * sumOfAllAlphabetsNumeration + ONE) - ONE) / TWO;
        return reverseTriangleNumber % ONE == DIVISION_REMAINDER;
    }

    /**
     * Print the result on console
     */
    private static void printCounter() {
        System.out.printf(RESULT_SENTENCE, countOfTriangleWord);
    }
}
