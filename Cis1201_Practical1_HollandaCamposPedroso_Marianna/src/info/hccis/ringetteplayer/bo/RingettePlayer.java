package info.hccis.ringetteplayer.bo;

import java.util.Scanner;

/**
 * Practical 1 - RingettePlayer Class - CIS 1201 - Introduction to Object
 * Oriente
 *
 * @author marianna hollanda
 * @since 20201023
 */
public class RingettePlayer {

    private String firstName;
    private String lastName;
    private String allergies;
    private int jerseyNumber;
    private int birthYear;

    /**
     * Default no-parameter constructor.
     *
     * @author marianna hollanda
     * @since 20201026
     */
    public RingettePlayer() {
        firstName = "Unknown";
        lastName = "Unknown";
        allergies = "";
        jerseyNumber = 0;
        birthYear = 0;
    }

    /**
     * Custom constructor which accepts values for the first and last name.
     *
     * @author marianna hollanda
     * @param firstName
     * @param lastName
     * @since 20201026
     */
    public RingettePlayer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        allergies = "";
        jerseyNumber = 0;
        birthYear = 0;
    }

    /**
     * Custom constructor which accepts value for the Jersey number.
     *
     * @author marianna hollanda
     * @param jerseyNumber
     * @since 20201026
     */
    public RingettePlayer(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
        firstName = "Unknown";
        lastName = "Unknown";
        allergies = "";
        birthYear = 0;
    }

    /**
     * Custom constructor which accepts values for all attributes.
     *
     * @author marianna hollanda
     * @param firstName
     * @param lastName
     * @param allergies
     * @param jerseyNumber
     * @since 20201026
     */
    public RingettePlayer(String firstName, String lastName, String allergies, int jerseyNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.allergies = allergies;
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * Method for get information from the user.
     *
     * @author marianna hollanda
     * @since 20201026
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);
        System.out.println("First Name: ");
        firstName = input.nextLine();
        System.out.println("Last Name: ");
        lastName = input.nextLine();
        System.out.println("Jersey Number: ");
        jerseyNumber = input.nextInt();
        input.nextLine();
        System.out.println("Allergies: ");
        allergies = input.nextLine();
        System.out.println("Birth Year: ");
        birthYear = input.nextInt();
        input.nextLine();
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

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Generates a string with the required output
     *
     * @return output
     * @author marianna hollanda
     * @since 20201026
     */
    @Override
    public String toString() {
        String output = "Name: " + firstName + " " + lastName
                + " Jersey Number: " + jerseyNumber
                + " Allergies: " + allergies
                + " Birth Year: " + birthYear;
        return output;

    }

    /**
     * Method called to display the final output
     *
     * @author marianna hollanda
     * @since 20201026
     */
    public void display() {
        System.out.println(toString());
    }

}
