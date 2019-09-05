package com.snmi.randomWords;

/**
 * Search for specific letter in both words
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class LetterFounder {

    /**
     * Class constants
     */
    private static final String FOUNDER_PRINT = "Letter founder is printing word: %s";
    private static final String CONTAINS_LETTER = "The word %s CONTAINS the character (%s)";
    private static final String NOT_CONTAINS_LETTER = "The word %s DOESN'T contain the character (%s)";

    /**
     * Class variables
     */
    private String lookForCharacter;
    private String firstWord;
    private String secondWord;

    /**
     * Default constructor
     */
    public LetterFounder() {}

    /**
     * Custom constructor
     * @param wordsLength take the desired words length
     * @param lookForCharacter take the desired letter which will be search for
     */
    public LetterFounder(int wordsLength, String lookForCharacter) {
        Generator generator = new Generator();
        this.firstWord = generator.generateRandomWord(wordsLength);
        this.secondWord = generator.generateRandomWord(wordsLength);
        this.lookForCharacter = lookForCharacter;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    /**
     * Print word on console
     * @param generatedWord take the generated word
     */
    public void printWord(String generatedWord) {
        System.out.printf(FOUNDER_PRINT, generatedWord);
        System.out.println();
    }

    /**
     * Check if the word contains specific letter
     * @param generatedWord take word
     * @return boolean result if the word contains the letter
     */
    private boolean isContainsLetter(String generatedWord) {
        return generatedWord.toLowerCase().contains(lookForCharacter);
    }

    /**
     * Print the result on console
     * @param generatedWord take word
     */
    public void printAnswer(String generatedWord) {
        if (isContainsLetter(generatedWord)) {
            System.out.printf(CONTAINS_LETTER, generatedWord, lookForCharacter);
            System.out.println();
        } else {
            System.out.printf(NOT_CONTAINS_LETTER, generatedWord, lookForCharacter);
            System.out.println();
        }
    }
}
