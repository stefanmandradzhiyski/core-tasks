package com.snmi.reflection.bigTask.inputHelper;

import java.util.Scanner;

/**
 * Main Input Validation Helper which task is to validate all user inputs
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class InputHelper {

    /**
     * Public constants
     */
    public static final String JAVA = "java";
    public static final String C = "c";
    public static final String C_PLUS_PLUS = "c++";
    public static final String C_SHARP = "c#";
    public static final String PHP = "php";
    public static final String PYTHON = "python";

    private InputHelper() {}

    /**
     * Validate string user input by strings
     * @param console take the user input
     * @param MESSAGE take specific message which will be showed to the user
     * @param firstRequire take the first String check
     * @param secondRequire take the second String check
     * @return validated string
     */
    public static String validateStringInput(Scanner console, String MESSAGE, String firstRequire, String secondRequire) {
        String input;
        do {
            System.out.print(MESSAGE);
            input = console.nextLine().trim().toLowerCase();
        } while (!input.equalsIgnoreCase(firstRequire) && !input.equalsIgnoreCase(secondRequire));
        return input;
    }

    /**
     * Validate string user input by chars
     * @param console take the user input
     * @param MESSAGE take specific message which will be showed to the user
     * @param firstRequire take the first char check
     * @param secondRequire take the second char check
     * @return validated string
     */
    public static String validateStringInput(Scanner console, String MESSAGE, char firstRequire, char secondRequire) {
        String input;
        do {
            System.out.print(MESSAGE);
            input = console.nextLine().trim().toLowerCase();
        } while (!input.equalsIgnoreCase(String.valueOf(firstRequire)) && !input.equalsIgnoreCase(String.valueOf(secondRequire)));
        return input;
    }

    /**
     * Validate selection of enums by user
     * @param console take the user input
     * @param MESSAGE take specific message which will be showed to the user
     * @return validated string
     */
    public static String inputValidTechArea(Scanner console, String MESSAGE) {
        String input;
        do {
            System.out.print(MESSAGE);
            input = console.nextLine().trim().toLowerCase();
        } while (isValidTechArea(input));
        return input;
    }

    /**
     * Check if input string is equal to specific enum type
     * @param techAreaDeveloper take the input string
     * @return boolean result
     */
    public static boolean isValidTechArea(String techAreaDeveloper) {
        return  !JAVA.equalsIgnoreCase(techAreaDeveloper ) && !C.equalsIgnoreCase(techAreaDeveloper) &&
                !C_PLUS_PLUS.equalsIgnoreCase(techAreaDeveloper) && !C_SHARP.equalsIgnoreCase(techAreaDeveloper) &&
                !PHP.equalsIgnoreCase(techAreaDeveloper) && !PYTHON.equalsIgnoreCase(techAreaDeveloper);
    }
}
