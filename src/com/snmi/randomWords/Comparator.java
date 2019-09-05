package com.snmi.randomWords;

import java.util.ArrayList;
import java.util.List;

/**
 * Comparator find all existing characters in both words
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Comparator {

    /**
     * Class constants
     */
    private static final String COMPARATOR_PRINT = "Comparator is printing the word for you: %s";
    private static final String EXISTING_CHARACTERS = "Characters which exists in both words: ";
    private static final String CHARACTER_PRINT_PATTERN = "%s, ";

    /**
     * Class variables
     */
    private String firstWord;
    private String secondWord;
    private List<Character> foundedCharacter;

    /**
     * Default constructor
     */
    public Comparator() {}

    /**
     * Custom constructor
     * @param wordsLength the word's length
     */
    public Comparator(int wordsLength) {
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
     * Print the already generated word on console
     * @param generatedWord take the generated word
     */
    public void printWord(String generatedWord) {
        System.out.printf(COMPARATOR_PRINT, generatedWord);
        System.out.println();
    }

    /**
     * Find all equal characters for both words
     * @param firstWord take the first word
     * @param secondWord take the second word
     * @param wordsLength take the words length
     */
    public void findCharacters(String firstWord, String secondWord, int wordsLength) {
        foundedCharacter = new ArrayList<>(wordsLength);
        for (int position = 0; position < firstWord.length(); position++) {
            if (secondWord.contains(String.valueOf(firstWord.charAt(position)))) {
                foundedCharacter.add(firstWord.charAt(position));
            }
        }
    }

    /**
     * Print all characters on console
     */
    public void printAllCharacters() {
        System.out.print(EXISTING_CHARACTERS);
        foundedCharacter.forEach(character -> System.out.printf(CHARACTER_PRINT_PATTERN, character));
        System.out.println();
    }
}
