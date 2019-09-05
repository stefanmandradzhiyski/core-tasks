package com.snmi.randomWords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Sequencer search for the longest match sequence between both words
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */

public class Sequencer {

    /**
     * Class constants
     */
    private static final String INDEX_SENTENCE = "First index %d; Last index %d;";
    private static final String SEQUENCER_PRINT = "Sequencer is printing the word for you: %s";
    private static final String NO_MATCH_SEQUENCE = "No matching sequence!";
    private static final String HAVE_EQUAL_SEQUENCES = "There are substrings with equal length";
    private static final String MISSING_EQUAL_SEQUENCES = "There aren't substrings with equal length";
    private static final String LONGEST_SEQUENCE_SENTENCE = "Longest sequence: %s";


    /**
     * Class variables
     */
    private Set<String> allCharSequence = new HashSet<>();
    private ArrayList<String> equalCharSequence = new ArrayList<>();
    private String firstWord;
    private String secondWord;
    private String longestSequence = "";

    /**
     * Default constructor
     */
    public Sequencer() {}

    /**
     * Custom constructor
     * @param wordsLength take the words legnth from the user input
     */
    public Sequencer(int wordsLength) {
        Generator generator = new Generator();
        this.firstWord = generator.generateRandomWord(wordsLength);
        this.secondWord = generator.generateRandomWord(wordsLength);
    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Print generated word
     * @param generatedWord take already generated word
     */
    public void printWord(String generatedWord) {
        System.out.printf(SEQUENCER_PRINT, generatedWord);
        System.out.println();
    }

    /**
     * Find all sequence which exist in both words
     * @param firstWord take the first generated word
     * @param secondWord take the second generated word
     */
    private void findCharactersSequence(String firstWord, String secondWord) {
        for (int position = 0; position < firstWord.length(); position++) {

            int endIndex;
            if (position <= firstWord.length() - 2) {
                endIndex = position + 1;
            } else {
                endIndex = position;
            }

            boolean containSubstring = false;
            while (endIndex <= firstWord.length() && !containSubstring) {
                String subString = firstWord.substring(position, endIndex);
                endIndex++;
                if (secondWord.contains(subString)) {
                    allCharSequence.add(subString);
                } else {
                    containSubstring = true;
                }
            }

        }
    }

    /**
     * Get the longest sequence
     * @param firstWord take the first generated word
     * @param secondWord take the second generated word
     */
    public void getUniqueSequence(String firstWord, String secondWord) {
        findCharactersSequence(firstWord, secondWord);

        allCharSequence.forEach(
                    currentSequence -> {
                        if (currentSequence.length() > longestSequence.length()) {
                            longestSequence = currentSequence;
                        }
                    }
                );

        allCharSequence.forEach(
                    currentSequence -> {
                        if (currentSequence.length() == longestSequence.length() && longestSequence.length() > 1) {
                            equalCharSequence.add(currentSequence);
                        }
                    }
                );
    }

    /**
     * Get the last equal sequence from list which contain all sequence with equal length
     * @return the last sequence received after list sort
     */
    private String getLastEqualSequence() {
        Collections.sort(equalCharSequence);
        int lastIndex = equalCharSequence.size() - 1;
        return equalCharSequence.get(lastIndex);
    }

    /**
     * Print indexes of the sequence in the first word
     * @param firstWord take the first generated word
     * @param charSequence take the longest sequence
     */
    private void printSequenceIndex(String firstWord, String charSequence) {
        int firstIndex = firstWord.indexOf(charSequence);
        int lastIndex = firstIndex + (charSequence.length() - 1);
        System.out.printf(INDEX_SENTENCE, firstIndex, lastIndex);
        System.out.println();
    }

    /**
     * Print the sequence
     * @param charSequence take the sequence
     */
    private void printSequence(String charSequence) {
        System.out.printf(LONGEST_SEQUENCE_SENTENCE, charSequence);
        System.out.println();
    }

    /**
     * Print full information about the sequence
     * @param someOfTwoWords take either of two words
     */
    public void printFullData(String someOfTwoWords) {
        if (equalCharSequence.size() > 1) {
            System.out.println(HAVE_EQUAL_SEQUENCES);
            longestSequence = getLastEqualSequence();
        } else if (longestSequence.length() > 1){
            System.out.println(MISSING_EQUAL_SEQUENCES);
        } else {
            System.out.println(NO_MATCH_SEQUENCE);
        }

        if (longestSequence.length() > 1) {
            printSequence(longestSequence);
            printSequenceIndex(someOfTwoWords, longestSequence);
        }
    }
}
