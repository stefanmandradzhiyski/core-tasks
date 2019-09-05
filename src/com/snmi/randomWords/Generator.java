package com.snmi.randomWords;

import java.util.Random;

/**
 * Generator generate random words
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Generator {

    /**
     * Class constants
     */
    private static final String ALPHABETS = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
    private static final int RANDOM_MAX_VALUE = 51;

    /**
     * Generate random word
     * @param wordLength take the desired word's length
     * @return the generated word
     */
    public String generateRandomWord(int wordLength) {
        StringBuilder generatedWord = new StringBuilder();

        for (int iteration = 0; iteration <= wordLength; iteration++) {
            Random random = new Random();
            int characterIndex = random.nextInt(RANDOM_MAX_VALUE);
            String specificCharacter = String.valueOf(ALPHABETS.charAt(characterIndex));
            generatedWord.append(specificCharacter);
        }

        return generatedWord.toString();
    }
}
