package com.snmi.reflection.bigTask.inputHelper;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.IntermediateDeveloper;
import com.snmi.reflection.bigTask.developers.JuniorDeveloper;
import com.snmi.reflection.bigTask.global.TechArea;

import java.util.Scanner;

/**
 * Source creator provide the source object creation functionality
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class SourceCreator {

    /**
     * Class constants
     */
    private static final String JUNIOR = "j";
    private static final String DEVELOPER = "d";
    private static final String INTERMEDIATE = "i";
    private static final String INPUT_CLIENT = "Please input main client: ";
    private static final String CREATE_SOURCE = "Choose what kind of source object you want to create (A for Administrator / D for Developer): ";
    private static final String ADMINISTRATOR = "a";
    private static final String INCORRECT_INPUT = "Incorrect input";
    private static final String DEVELOPER_LEVEL = "What level of developer you want to create? (J for Junior / I for Intermediate): ";
    private static final String INPUT_LAST_NAME = "Please input his last name: ";
    private static final String INPUT_FIRST_NAME = "Please input his first name: ";
    private static final String INPUT_EXPERIENCE = "Please input his year experience: ";
    private static final String DEVELOPER_TECH_AREA = "What tech area will he be? (JAVA / C / C++ / C# / PHP / Python): ";

    /**
     * Main Source Creator method which can be used to create a custom source object
     * @param console the console input
     * @return newly created object
     */
    public static Object createSourceObject(Scanner console) {
        String inputSourceObject = InputHelper.validateStringInput(console, CREATE_SOURCE, ADMINISTRATOR, DEVELOPER);

        System.out.print(INPUT_FIRST_NAME);
        String firstName = console.nextLine();

        System.out.print(INPUT_LAST_NAME);
        String lastName = console.nextLine();

        System.out.print(INPUT_EXPERIENCE);
        int yearExperience = console.nextInt();

        switch (inputSourceObject) {
            case ADMINISTRATOR:
                return new Administrator(firstName, lastName, yearExperience);
            case DEVELOPER:
                String levelOfDeveloper = InputHelper.validateStringInput(console, DEVELOPER_LEVEL, JUNIOR, INTERMEDIATE);
                String techAreaDeveloper = InputHelper.inputValidTechArea(console, DEVELOPER_TECH_AREA);
                if (levelOfDeveloper.equalsIgnoreCase(JUNIOR)) {
                    return new JuniorDeveloper(firstName, lastName, yearExperience, validateTechArea(techAreaDeveloper));
                } else if (levelOfDeveloper.equalsIgnoreCase(INTERMEDIATE)) {
                    System.out.print(INPUT_CLIENT);
                    String mainClient = console.nextLine();
                    return new IntermediateDeveloper(firstName, lastName, yearExperience, validateTechArea(techAreaDeveloper), mainClient);
                }
        }

        throw new IllegalArgumentException(INCORRECT_INPUT);
    }

    /**
     * Validate the tech area enum
     * @param techAreaDeveloper take the tech area string
     * @return the tech area enum
     */
    private static TechArea validateTechArea(String techAreaDeveloper) {
        switch (techAreaDeveloper) {
            case InputHelper.JAVA: return TechArea.JAVA;
            case InputHelper.C: return TechArea.C;
            case InputHelper.C_PLUS_PLUS: return TechArea.CPlusPlus;
            case InputHelper.C_SHARP: return TechArea.CSharp;
            case InputHelper.PHP: return TechArea.PHP;
            case InputHelper.PYTHON: return TechArea.Python;
        }

        return TechArea.DEFAULT;
    }
}
