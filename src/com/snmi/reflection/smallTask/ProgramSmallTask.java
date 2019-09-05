package com.snmi.reflection.smallTask;

/**
 * The program can be used to make a deep copy of two similar objects with reflection
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProgramSmallTask {

    /**
     * Class constants
     */
    private static final String PRINT_SENTENCE = "Hi, My name is %s %s and I'm %d years old. My university fac No. is %s and my home address is %s";

    public static void main(String[] args) {
        Student studentSource = createStudent();
        Student studentDestination = new Student();
        Address address = new Address();

        DeepReflection.copy(studentSource, studentDestination, address);

        studentSource.setFirstName("Chefo");
        changeStudentAddress(studentSource, "Dimityr Dimitrov", 29);
        studentDestination.setAge(27);
        changeStudentAddress(studentDestination, "bul. Bulgaria", 134);

        printStudent(studentSource);
        printStudent(studentDestination);
    }

    /**
     * Create a new student with custom fields
     * @return the created student
     */
    private static Student createStudent() {
        String facNo = "8110070304";
        String firstName = "Stefan";
        String lastName = "Mandradzhiyski";
        int age = 24;

        String streetName = "Unknown Unknown";
        int streetNumber = 0;

        Address address = new Address(streetName, streetNumber);
        return new Student(facNo, firstName, lastName, age, address);
    }

    /**
     * Change the address of specific student
     * @param student take specific student object
     * @param streetName take street name
     * @param streetNumber take street number
     */
    private static void changeStudentAddress(Student student, String streetName, int streetNumber) {
        student.getAddress().setStreetName(streetName);
        student.getAddress().setStreetNumber(streetNumber);
    }

    /**
     * Print full data of specific student
     * @param student take specific student object
     */
    private static void printStudent(Student student) {
        System.out.printf(PRINT_SENTENCE, student.getFirstName(), student.getLastName(), student.getAge(), student.getFacNo(), student.getAddress());
        System.out.println();
    }

}
