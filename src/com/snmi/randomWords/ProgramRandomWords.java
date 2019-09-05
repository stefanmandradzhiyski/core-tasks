package com.snmi.randomWords;

import java.util.*;

/**
 * The program need to find:
 * Existing letter in both words;
 * List of all existing characters in both words;
 * The longest match sequence between two words.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class ProgramRandomWords {

    /**
     * Class constants
     */
    private static final String OUT = "out";
    private static final String FOUNDER = "founder";
    private static final String COMPARATOR = "comparator";
    private static final String SEQUENCER = "sequencer";
    private static final String INTRO_SENTENCE = "Input correctly action as founder,comparator,sequencer or out: ";
    private static final String INPUT_SENTENCE = "Input number for words length: ";
    private static final String INPUT_ALPHABET = "Input correct alphabet from A - Z: ";
    private static final String ERROR_SENTENCE = "Error! Invalid number. Please input valid positive number and try again.";

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.print(INTRO_SENTENCE);
            userAnswer = console.nextLine().trim();
            if (isValidAction(userAnswer)) {
                int wordsLength = validateWordsLength(console);
                switch (userAnswer.toLowerCase()) {
                    case FOUNDER: letterFounder(wordsLength, console); break;
                    case COMPARATOR: comparator(wordsLength); break;
                    case SEQUENCER: sequencer(wordsLength); break;
                    default: break;
                }
            }
        } while(!userAnswer.equalsIgnoreCase(OUT));
    }

    /**
     * Founder help to find specific letter in both words
     * @param wordsLength take the desired words length from the user
     */
    private static void letterFounder(int wordsLength, Scanner console) {
        String lookForCharacter = validateCharacter(console);
        LetterFounder letterFounder = new LetterFounder(wordsLength, lookForCharacter);
        String firstWord = letterFounder.getFirstWord();
        String secondWord = letterFounder.getSecondWord();
        letterFounder.printWord(firstWord);
        letterFounder.printWord(secondWord);
        letterFounder.printAnswer(firstWord);
        letterFounder.printAnswer(secondWord);
    }

    /**
     * Comparator list all characters that exist in both words
     * @param wordsLength take the desired words length from the user
     */
    private static void comparator(int wordsLength) {
        Comparator comparator = new Comparator(wordsLength);
        String firstWord = comparator.getFirstWord();
        String secondWord = comparator.getSecondWord();
        comparator.printWord(firstWord);
        comparator.printWord(secondWord);
        comparator.findCharacters(firstWord, secondWord, wordsLength);
        comparator.printAllCharacters();
    }

    /**
     * Sequencer search for the longest match sequence between both words
     * @param wordsLength take the desired words length from the user
     */
    private static void sequencer(int wordsLength) {
        Sequencer sequencer = new Sequencer(wordsLength);
        String firstWord = sequencer.getFirstWord();
        String secondWord = sequencer.getSecondWord();
        sequencer.printWord(firstWord);
        sequencer.printWord(secondWord);
        sequencer.getUniqueSequence(firstWord, secondWord);
        sequencer.printFullData(firstWord);
    }

    /**
     * Validate user action input
     * @param userAnswer user desired action
     * @return true if the input is correct
     */
    private static boolean isValidAction(String userAnswer) {
        return  !OUT.equalsIgnoreCase(userAnswer) && FOUNDER.equalsIgnoreCase(userAnswer) ||
                COMPARATOR.equalsIgnoreCase(userAnswer) || SEQUENCER.equalsIgnoreCase(userAnswer);
    }

    /**
     * Validate the user input for desired words length
     * @param console provides user console
     * @return words length
     */
    private static int validateWordsLength(Scanner console) {
        int wordsLength = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print(INPUT_SENTENCE);
            if (console.hasNextInt()) {
                wordsLength = console.nextInt();
                isValidInput = true;
            } else {
                System.out.println(ERROR_SENTENCE);
            }
            console.nextLine();
        }

        return wordsLength;
    }

    /**
     * Validate user character input for founder
     * @param console take the user console
     * @return input character
     */
    private static String validateCharacter(Scanner console) {
        String lookForCharacter;
        do {
            System.out.print(INPUT_ALPHABET);
            lookForCharacter = console.nextLine().toLowerCase().trim();
        } while (lookForCharacter.length() != 1 || !lookForCharacter.matches("[a-z]+"));

        return lookForCharacter;
    }
}
