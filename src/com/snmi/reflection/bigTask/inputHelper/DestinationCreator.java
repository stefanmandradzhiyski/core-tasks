package com.snmi.reflection.bigTask.inputHelper;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.Developer;
import com.snmi.reflection.bigTask.developers.IntermediateDeveloper;
import com.snmi.reflection.bigTask.developers.JuniorDeveloper;
import com.snmi.reflection.bigTask.reflectionManager.ReflectionManager;
import java.util.Scanner;

/**
 * DestinationCreator make a new object with all similar fields of source object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class DestinationCreator {

    /**
     * Class constants
     */
    private static final String LEVEL_J = "j";
    private static final String LEVEL_I = "i";
    private static final String DESTINATION_A = "a";
    private static final String DESTINATION_D = "d";
    private static final String ASK_FOR_LEVEL = "Copy to which level of developer? (J for Junior / I for Intermediate): ";
    private static final String CREATION_FAILED = "Fail to create a destination object";
    private static final String INCORRECT_INPUT = "Incorrect destination object";
    private static final String ASK_FOR_DESTINATION = "To what object you want to copy the similar fields? (A for Administrator /D for Developer): ";

    private static final char ASK_FOR_LEVEL_J = 'j';
    private static final char ASK_FOR_LEVEL_I = 'i';
    private static final char ASK_FOR_DESTINATION_A = 'a';
    private static final char ASK_FOR_DESTINATION_D = 'd';

    /**
     * Main method of DestinationCreator which can be used to make a new object with similar fields values of source object
     * @param console take the user input
     * @param sourceAdministrator take the source Administrator object
     * @param sourceDeveloper take the source Developer object
     * @return newly created object with values of all similar source's object fields
     */
    public static Object createDestinationObject(Scanner console, Administrator sourceAdministrator, Developer sourceDeveloper) {
        String toDestination = InputHelper.validateStringInput(console, ASK_FOR_DESTINATION, ASK_FOR_DESTINATION_A, ASK_FOR_DESTINATION_D);

        switch (toDestination) {
            case DESTINATION_A:
                Administrator destinationAdministrator = new Administrator();
                return getAdministratorObject(sourceAdministrator, sourceDeveloper, destinationAdministrator);
            case DESTINATION_D:
                String developerLevel = InputHelper.validateStringInput(console, ASK_FOR_LEVEL,ASK_FOR_LEVEL_J,ASK_FOR_LEVEL_I);
                switch (developerLevel) {
                    case LEVEL_J:
                        Developer destinationJuniorDeveloper = new JuniorDeveloper();
                        return getDeveloperObject(sourceAdministrator, sourceDeveloper, destinationJuniorDeveloper);
                    case LEVEL_I:
                        Developer destinationIntermediateDeveloper = new IntermediateDeveloper();
                        return getDeveloperObject(sourceAdministrator, sourceDeveloper, destinationIntermediateDeveloper);
                }
        }

        throw new IllegalArgumentException(CREATION_FAILED);
    }

    /**
     * Create a new Administrator object
     * @param sourceAdministrator take the source Administrator object
     * @param sourceDeveloper take the source Developer object
     * @param destinationAdministrator take the destination Administrator object
     * @return newly created Administrator with values of all similar source's object fields
     */
    private static Object getAdministratorObject(Administrator sourceAdministrator, Developer sourceDeveloper, Administrator destinationAdministrator) {
        if (sourceDeveloper != null) {
            ReflectionManager.clone(sourceDeveloper, destinationAdministrator);
            return destinationAdministrator;
        } else if (sourceAdministrator != null) {
            ReflectionManager.clone(sourceAdministrator, destinationAdministrator);
            return destinationAdministrator;
        }

        throw new IllegalArgumentException(INCORRECT_INPUT);
    }

    /**
     * Create a new Developer object
     * @param sourceAdministrator take the source Administrator object
     * @param sourceDeveloper take the source Developer object
     * @param destinationDeveloper take the destination Developer object
     * @return newly created Developer with values of all similar source's object fields
     */
    private static Object getDeveloperObject(Administrator sourceAdministrator, Developer sourceDeveloper, Developer destinationDeveloper) {
        if (sourceDeveloper != null) {
            ReflectionManager.clone(sourceDeveloper, destinationDeveloper);
            return destinationDeveloper;
        } else if (sourceAdministrator != null) {
            ReflectionManager.clone(sourceAdministrator, destinationDeveloper);
            return destinationDeveloper;
        }

        throw new IllegalArgumentException(INCORRECT_INPUT);
    }
}
