package com.snmi.reflection.bigTask.developers;

import com.snmi.reflection.bigTask.global.Followable;
import com.snmi.reflection.bigTask.global.TechArea;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Intermediate Developer
 */
public class IntermediateDeveloper extends Developer implements Followable {

    /**
     * Class constants
     */
    private static final transient Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String CREATION_ACTIVITY = "I will integrate the payment method";
    private static final String TO_DO = "I need to clean my desk after work, maintain my own computer, " +
            "talk with clients and make shorter code than juniors";
    private static final String PRESENT_MYSELF = "Hello all, I Am %s %s. My tech area is %s and I have %d years experience in it. I'am working as Intermediate %s Developer";
    private static final String PRESENT_MYSELF_PROMOTION = "Hello all, I Am %s %s. My tech area is %s and I have %d years experience in it. I'am working as Intermediate %s Developer, BUT I'm waiting promotion";
    private static final String PRESENT_MYSELF_COPY = "Hello all, I Am %s %s. I have %d years experience in it. I'am working as Intermediate Developer";
    private static final String PRESENT_MYSELF_WITH_CLIENT = "Hello all, I Am %s %s. My tech area is %s and I have %d years experience in it. I'am working as Intermediate %s Developer. My client is %s";
    private static final String PRESENTING = "Intermediate Developer is presenting himself: ";

    /**
     * Specific variables
     */
    private String mainClient;

    /**
     * Default constructor
     */
    public IntermediateDeveloper() {}

    /**
     * Custom constructor without client
     * @param firstName take the first name
     * @param lastName take the second name
     * @param yearExperience take the year experience
     * @param techArea take the tech area
     */
    public IntermediateDeveloper(String firstName, String lastName, int yearExperience, TechArea techArea) {
        super(firstName, lastName, yearExperience, techArea);
    }

    /**
     * Custom constructor with client
     * @param firstName take the first name
     * @param lastName take the second name
     * @param yearExperience take the year experience
     * @param techArea take the main tech area
     * @param mainClient take the name of main client
     */
    public IntermediateDeveloper(String firstName, String lastName, int yearExperience, TechArea techArea, String mainClient) {
        super(firstName, lastName, yearExperience, techArea);
        this.mainClient = mainClient;
    }

    /**
     * Setters and getters
     */
    public String getMainClient() { return mainClient; }

    public void setMainClient(String mainClient) { this.mainClient = mainClient; }

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
            if (mainClient != null) {
                System.out.printf(PRESENT_MYSELF_WITH_CLIENT, firstName, lastName, techArea, yearExperience, techArea, mainClient);
            }
            if (yearExperience < 4) {
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
