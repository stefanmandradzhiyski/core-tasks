package com.snmi.reflection.bigTask.administrator;

import com.snmi.reflection.bigTask.global.Followable;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Administrator object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Administrator implements Cloneable, Followable {

    /**
     * Class constants
     */
    private static final transient Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final String CREATION_ACTIVITY = "I need to maintain all computers in the office";
    private static final String PRESENT_MYSELF = "Hello all, I Am %s %s. I have %d years experience in it. I'am working as Administrator";
    private static final String PRESENTING = "Administrator is presenting himself: ";

    /**
     * Specific variables
     */
    private String firstName;
    private String lastName;
    private int yearExperience;

    /**
     * Default constructor
     */
    public Administrator() {}

    /**
     * Custom constructor
     * @param firstName take the first name
     * @param lastName take the last name
     * @param yearExperience take the year experience
     */
    public Administrator(String firstName, String lastName, int yearExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearExperience = yearExperience;
    }

    /**
     * Setters and getters
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    /**
     * Create a deep clone method
     * @return new instances of Administrator
     * @throws CloneNotSupportedException
     */
    @Override
    public Administrator clone() throws CloneNotSupportedException {
        return (Administrator) super.clone();
    }


    /**
     * Present the administrator
     */
    @Override
    public void presentMyself() {
        LOGGER.log(Level.INFO, PRESENTING);
        System.out.printf(PRESENT_MYSELF, firstName, lastName, yearExperience);
        System.out.println();
    }

    /**
     * Print on console specific implementation of company orders that administrator need to follow
     */
    @Override
    public void toDo() {
        System.out.println(CREATION_ACTIVITY);
    }
}
