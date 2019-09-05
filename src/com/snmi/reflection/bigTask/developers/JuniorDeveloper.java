package com.snmi.reflection.bigTask.developers;

import com.snmi.reflection.bigTask.global.Followable;
import com.snmi.reflection.bigTask.global.TechArea;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Junior Developer
 */
public class JuniorDeveloper extends Developer implements Followable {

    /**
     * Class constants
     */
    private static final transient Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String CREATION_ACTIVITY = "I will create an login form";
    private static final String TO_DO = "I need to clean my desk after work and maintain my own computer";
    private static final String PRESENT_MYSELF = "Hello all, I Am %s %s. My tech area is %s and I have %d years experience in it. I'am working as Junior %s Developer";
    private static final String PRESENT_MYSELF_PROMOTION = "Hello all, I Am %s %s. My tech area is %s and I have %d years experience in it. I'am working as Junior %s Developer, BUT I'm waiting promotion!";
    private static final String PRESENT_MYSELF_COPY = "Hello all, I Am %s %s. I have %d years experience in it. I'am working as Junior Developer";
    private static final String PRESENTING = "Junior Developer is presenting himself: ";

    /**
     * Default constructor
     */
    public JuniorDeveloper() {}

    /**
     * Custom constructor
     * @param firstName take the first name
     * @param lastName take the second name
     * @param yearExperience take the year experience
     * @param techArea take the tech area
     */
    public JuniorDeveloper(String firstName, String lastName, int yearExperience, TechArea techArea) {
        super(firstName, lastName, yearExperience, techArea);
    }

    /**
     * Print on console module kind that the developer is creating
     */
    @Override
    public void createModule() {
        System.out.println(CREATION_ACTIVITY);
    }

    /**
     * Present developer's main info
     */
    @Override
    public void presentMyself() {
        LOGGER.log(Level.INFO, PRESENTING);
        if (techArea != null) {
            if (yearExperience < 2) {
                System.out.printf(PRESENT_MYSELF, firstName, lastName, techArea, yearExperience, techArea);
            } else {
                System.out.printf(PRESENT_MYSELF_PROMOTION, firstName, lastName, techArea, yearExperience, techArea);
            }
            System.out.println();
        } else {
            System.out.printf(PRESENT_MYSELF_COPY, firstName, lastName, yearExperience);
            System.out.println();
        }
    }

    /**
     * Print on console specific implementation of company orders that developer need to follow
     */
    @Override
    public void toDo() {
        System.out.println(TO_DO);
    }
}
