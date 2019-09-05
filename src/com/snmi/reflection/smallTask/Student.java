package com.snmi.reflection.smallTask;

/**
 * Student object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Student {

    /**
     * Variables
     */
    private String facNo;
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

    /**
     * Default constructor
     */
    public Student() {}

    /**
     * Custom constructor
     * @param facNo take fac no of student
     * @param firstName take first name
     * @param lastName take last name
     * @param age take age
     */
    public Student(String facNo, String firstName, String lastName, int age) {
        this.facNo = facNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Second custom constructor
     * @param facNo take the fac no of student
     * @param firstName take the first name
     * @param lastName take the last name
     * @param age take the age
     * @param address take the Address object
     */
    public Student(String facNo, String firstName, String lastName, int age, Address address) {
        this.facNo = facNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    /**
     * Setters and getters of all fields
     */
    public String getFacNo() {
        return facNo;
    }

    public void setFacNo(String facNo) {
        this.facNo = facNo;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) { this.age = age; }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    /**
     * To string method
     * @return string of student fields
     */
    @Override
    public String toString() {
        return "Student{" +
                "facNo='" + facNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
