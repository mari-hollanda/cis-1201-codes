package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Class represents an employee for tutorial services
 *
 * @author marianna hollanda
 * @since 20201014
 */
public class Employee {

    public static final double INDIVIDUAL_TUTORIAL_PER_HOUR = 15;
    public static final double SMALL_GROUP_PER_HOUR = 17;
    public static final double LARGE_GROUP_PER_HOUR = 20;

    private int id;
    private String name;
    private double individualHours;
    private double smallGroupHours;
    private double largeGroupHours;
    private static int currentMaxId;
    private int employeeType;

    /**
     * Default Constructor
     *
     * @author marianna hollanda
     * @since 20201014
     */
    public Employee() {
        this.id = ++currentMaxId;
        individualHours = 0;
        smallGroupHours = 0;
        largeGroupHours = 0;
    }

    /**
     * Custom Constructor
     *
     * @author marianna hollanda
     * @param name
     * @param individualHours
     * @param smallGroupHours
     * @param largeGroupHours
     * @param employeeType
     * @since 20201014
     */
    public Employee(String name, int individualHours,
            int smallGroupHours, int largeGroupHours, int employeeType) {
        this.id = ++currentMaxId;
        this.name = name;
        this.individualHours = individualHours;
        this.smallGroupHours = smallGroupHours;
        this.largeGroupHours = largeGroupHours;

        if (employeeType <= 0 || employeeType > 3) {
            this.employeeType = 0;
        } else {
            this.employeeType = employeeType;
        }
    }

    /**
     * Get information from the user
     *
     * @author marianna hollanda
     * @since 20201014
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Employee's Name: ");
        name = input.nextLine();

        System.out.println("How many 'Individual' hours?");
        individualHours = input.nextInt();
        input.nextLine();

        if (individualHours < 0) {
            individualHours = 0;
            System.out.println("Invalid entry, individual hours being set to 0");
        }

        System.out.println("How many 'Small Group' hours?");
        smallGroupHours = input.nextInt();
        input.nextLine();

        if (smallGroupHours < 0) {
            smallGroupHours = 0;
            System.out.println("Invalid entry, individual hours being set to 0");
        }

        System.out.println("How many 'Large Group' hours?");
        largeGroupHours = input.nextInt();
        input.nextLine();

        if (largeGroupHours < 0) {
            largeGroupHours = 0;
            System.out.println("Invalid entry, individual hours being set to 0");
        }

        System.out.println("Employee Type (1=First Year 2=Second Year 3=Past Graduate)?");
        employeeType = input.nextInt();
        input.nextLine();

        if (employeeType <= 0 || employeeType > 3) {
            System.out.println("Invalid employee type, setting to unknown");
            employeeType = 0;
        }

        System.out.println("");
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @author marianna hollanda
     * @return 
     * @since 20201014
     */
    public double getEarnings() {
        double finalEarnings = individualHours * INDIVIDUAL_TUTORIAL_PER_HOUR + smallGroupHours * SMALL_GROUP_PER_HOUR + largeGroupHours * LARGE_GROUP_PER_HOUR;

        switch (employeeType) {
            case 2:
                finalEarnings += (finalEarnings * 0.1);
                break;

            case 3:
                finalEarnings += (finalEarnings * 0.2);
                break;

        }

        return finalEarnings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIndividualHours() {
        return individualHours;
    }

    public void setIndividualHours(double individualHours) {
        this.individualHours = individualHours;
    }

    public double getSmallGroupHours() {
        return smallGroupHours;
    }

    public void setSmallGroupHours(double smallGroupHours) {
        this.smallGroupHours = smallGroupHours;
    }

    public double getLargeGroupHours() {
        return largeGroupHours;
    }

    public void setLargeGroupHours(double largeGroupHours) {
        this.largeGroupHours = largeGroupHours;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String output = "Summary for " + name;

        if (getEarnings() >= 200) {
            output += "(Large Earnings!)";
        }

        output += "\nEmployee Type: ";

        switch (employeeType) {
            case 1:
                output += "First Year";
                break;

            case 2:
                output += "Second Year";
                break;

            case 3:
                output += "Past Graduate";
                break;

            default:
                output += "Unknown";

        }

        output += "\nNumber of 'Individual' hours: " + individualHours
                + "\nNumber of 'Small Group' hours: " + smallGroupHours
                + "\nNumber of 'Large Group' hours: " + largeGroupHours
                + "\nEarnings: $ " + getEarnings();

        return output;
    }
}
