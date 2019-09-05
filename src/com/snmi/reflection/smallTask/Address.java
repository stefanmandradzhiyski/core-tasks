package com.snmi.reflection.smallTask;

/**
 * Address object which is used by Student object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Address {

    /**
     * Variables
     */
    private String streetName;
    private int streetNumber;

    /**
     * Default constructor
     */
    public Address() {}

    /**
     * Custom constructor
     * @param streetName take the street name
     * @param streetNumber take the street number
     */
    public Address(String streetName, int streetNumber) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    /**
     * Setters and getters of all fields
     */
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * To string method
     * @return string of address fields
     */
    @Override
    public String toString() {
        return streetName + " №:" + streetNumber;
    }
}
