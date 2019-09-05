package com.snmi.reflection.bigTask.inputHelper;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.Developer;
import java.util.Scanner;

/**
 * ExperienceChanger can be used to change the year experience of deep copied object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ExperienceChanger {

    /**
     * Class constants
     */
    private static final String NO = "no";
    private static final String YES = "yes";
    private static final String INPUT_EXPERIENCE = "Please input new year experience: ";
    private static final String CHANGE_EXPERIENCE = "Do you want to change the year experience of deep cloned object? (Yes / No): ";

    /**
     * Main method of ExperienceChanger which can be used to change the year experience of deep copied object
     * @param console take the user input
     * @param deepCopiedAdministrator take the deep copied Administrator object
     * @param deepCopiedDeveloper take the deep copied Developer object
     */
    public static void changeExperience(Scanner console, Administrator deepCopiedAdministrator, Developer deepCopiedDeveloper) {
        String yesOrNo = InputHelper.validateStringInput(console, CHANGE_EXPERIENCE, YES, NO);

        if (yesOrNo.equalsIgnoreCase(YES)) {
            System.out.print(INPUT_EXPERIENCE);
            int yearExperienceNew = console.nextInt();
            if (deepCopiedAdministrator != null) {
                deepCopiedAdministrator.setYearExperience(yearExperienceNew);
            } else if (deepCopiedDeveloper != null) {
                deepCopiedDeveloper.setYearExperience(yearExperienceNew);
            }
        } else {
            System.exit(0);
        }
    }

}
