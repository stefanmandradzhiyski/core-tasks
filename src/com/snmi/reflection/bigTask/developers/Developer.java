package com.snmi.reflection.bigTask.developers;

import com.snmi.reflection.bigTask.global.Followable;
import com.snmi.reflection.bigTask.global.TechArea;

/**
 * Abstract class that all kind of developer need to extend
 * The class hold the important methods which every developer need to implement
 */
public abstract class Developer implements Cloneable, Followable {

    /**
     * Specific variables
     */
    protected String firstName;
    protected String lastName;
    protected int yearExperience;
    protected TechArea techArea;

    /**
     * Default constructor
     */
    public Developer() {}

    /**
     * Custom constructor
     * @param firstName take the first name
     * @param lastName take the last name
     * @param yearExperience take the year experience
     * @param techArea take the tech area
     */
    public Developer(String firstName, String lastName, int yearExperience, TechArea techArea) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearExperience = yearExperience;
        this.techArea = techArea;
    }

    /**
     * Setters and getters
     */
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getYearExperience() { return yearExperience; }

    public void setYearExperience(int yearExperience) { this.yearExperience = yearExperience; }

    public TechArea getTechArea() { return techArea; }

    public void setTechArea(TechArea techArea) { this.techArea = techArea; }

    /**
     * Deep clone for all objects which extends Developer
     * @return new instance of Developer
     * @throws CloneNotSupportedException
     */
    @Override
    public Developer clone() throws CloneNotSupportedException {
        return (Developer) super.clone();
    }

    /**
     * Abstract method which all child need to implement
     */
    public abstract void createModule();

}
