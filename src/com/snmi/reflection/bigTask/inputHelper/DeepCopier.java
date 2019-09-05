package com.snmi.reflection.bigTask.inputHelper;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.Developer;
import java.util.Scanner;

/**
 * DeepCopier make deep copy between two specific objects
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class DeepCopier {

    /**
     * Class constants
     */
    private static final String NO = "no";
    private static final String YES = "yes";
    private static final String SOURCE = "s";
    private static final String REFLECTED = "r";
    private static final String INCORRECT_INPUT = "Incorrect deep copied object input";
    private static final String WHICH_OBJECT_TO_COPY = "Which one you want to copy? (S for Source / R for Reflected one): ";
    private static final String CREATE_DEEP_COPIED_OBJECT = "Do you want to create a new object from existing one? ";

    /**
     * Main method of DeepCopier utility class which can be used to make a deep copy of Administrator or Developer object
     * @param console take the user input
     * @param sourceAdministrator take the source administrator object
     * @param sourceDeveloper take the source developer object
     * @param reflectedAdministrator take the reflected administrator object
     * @param reflectedDeveloper take the reflected developer object
     * @return new instance of deep copied object
     * @throws CloneNotSupportedException
     */
    public static Object deepCopy(Scanner console, Administrator sourceAdministrator, Developer sourceDeveloper,
                                  Administrator reflectedAdministrator, Developer reflectedDeveloper) throws CloneNotSupportedException {
        String yesOrNo = InputHelper.validateStringInput(console, CREATE_DEEP_COPIED_OBJECT, YES, NO);

        if (yesOrNo.equalsIgnoreCase(YES)) {
            String deepCopy = InputHelper.validateStringInput(console, WHICH_OBJECT_TO_COPY, SOURCE, REFLECTED);
            switch (deepCopy) {
                case SOURCE:
                    if (sourceAdministrator != null) {
                        return sourceAdministrator.clone();
                    } else {
                        return sourceDeveloper.clone();
                    }
                case REFLECTED:
                    if (reflectedAdministrator != null) {
                        return reflectedAdministrator.clone();
                    } else {
                        return reflectedDeveloper.clone();
                    }
            }
        } else {
            System.exit(0);
        }

        throw new IllegalArgumentException(INCORRECT_INPUT);
    }
}
