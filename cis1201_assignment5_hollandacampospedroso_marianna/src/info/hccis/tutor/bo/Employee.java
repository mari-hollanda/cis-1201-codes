package info.hccis.tutor.bo;

import java.util.Scanner;

/**
 * Class represents an employee for tutorial services
 *
 * @author bjm
 * @since 2020-06-19
 * modified by marianna hollanda
 * @since 2020-11-20
 */
public class Employee {

    public static final double COST_INDIVIDUAL = 15;
    public static final double COST_SMALL_GROUP = 17;
    public static final double COST_LARGE_GROUP = 20;
    public static final double COST_LARGE_ORDER = 200;

    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_FIRST_YEAR = 1;
    public static final int TYPE_SECOND_YEAR = 2;
    public static final int TYPE_PAST_GRADUATE = 3;

    public static double FINAL_COST = 0;

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private int id; //Unique sequential id for this employee
    private String name;
    private double hoursIndividual, hoursSmallGroup, hoursLargeGroup;
    private int employeeType = 0;

    private static int nextId;  //Used to hold the next available id

    /**
     * Default constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee() {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
    }

    /**
     * Custom constructor
     *
     * @since 2020-06-19
     * @author BJM
     */
    public Employee(String name, double hoursIndividual, double hoursSmallGroup, double hoursLargeGroup, int employeeType) {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
        this.name = name;
        this.hoursIndividual = hoursIndividual;
        this.hoursSmallGroup = hoursSmallGroup;
        this.hoursLargeGroup = hoursLargeGroup;
        this.employeeType = employeeType;
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM
     * modified by marianna hollanda
     * @since 2020-11-20
     */
    public void getInformtion() {
        Scanner input = new Scanner(System.in);
        System.out.println("Tutor’s name?");
        name = input.nextLine();

        System.out.println("How many 'Individual' hours?");
        hoursIndividual = input.nextDouble();
        input.nextLine();  //burn

        while (hoursIndividual < 0 || hoursIndividual > 40) {
            System.out.println("Invalid, How many 'Individual' hours?");
            hoursIndividual = input.nextDouble();
            input.nextLine();
        }

        System.out.println("How many 'Small Group' hours?");
        hoursSmallGroup = input.nextDouble();
        input.nextLine();  //burn

        while (hoursSmallGroup < 0 || hoursSmallGroup > 40) {
            System.out.println("Invalid, How many 'Individual' hours?");
            hoursSmallGroup = input.nextDouble();
            input.nextLine();
        }

        System.out.println("How many 'Large Group' hours?");
        hoursLargeGroup = input.nextDouble();
        input.nextLine();  //burn

        while (hoursLargeGroup < 0 || hoursLargeGroup > 40) {
            System.out.println("Invalid, How many 'Individual' hours?");
            hoursLargeGroup = input.nextDouble();
            input.nextLine();
        }

        System.out.println("Employee Type (1=First Year 2=Second Year 3=Past Graduate 0=Unknown)");
        employeeType = input.nextInt();
        input.nextLine();  //burn

        while (employeeType < 0 || employeeType > 4) {
            System.out.println("Invalid entry, Employee Type (1=First-Year 2=Second-Year 3=Past-Graduate 0=Unknown):");
            employeeType = input.nextInt();
            input.nextLine();
        }

        System.out.println(""); //Empty line for formatting  
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @since 2020-06-19
     * @author BJM
     * modified by marianna hollanda
     * @since 2020-11-20
     */
    public double getEarnings() {
        double earnings = hoursIndividual * COST_INDIVIDUAL
                + hoursSmallGroup * COST_SMALL_GROUP
                + hoursLargeGroup * COST_LARGE_GROUP;

        //Apply bonus using a switch statement.  Multiply the earnings by 1+ the 
        //appropriate bonus amount and assign to the earnings.
        switch (employeeType) {
            case TYPE_SECOND_YEAR:
                earnings *= (1 + BONUS_SECOND_YEAR);
                break;
            case TYPE_PAST_GRADUATE:
                earnings *= (1 + BONUS_PAST_GRADUATE);
                break;

        }
        FINAL_COST += earnings;
        return earnings;
    }
    /**
     * Returns the final cost for all the employees
     *
     * @author marianna hollanda
     * @since 2020-11-20
     */
    public double getFinalCost() {
        return FINAL_COST;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursIndividual() {
        return hoursIndividual;
    }

    public void setHoursIndividual(double hoursIndividual) {
        this.hoursIndividual = hoursIndividual;
    }

    public double getHoursSmallGroup() {
        return hoursSmallGroup;
    }

    public void setHoursSmallGroup(double hoursSmallGroup) {
        this.hoursSmallGroup = hoursSmallGroup;
    }

    public double getHoursLargeGroup() {
        return hoursLargeGroup;
    }

    public void setHoursLargeGroup(double hoursLargeGroup) {
        this.hoursLargeGroup = hoursLargeGroup;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {

        String employeeTypeDescription = "Unknown";
        switch (employeeType) {
            case TYPE_FIRST_YEAR:
                employeeTypeDescription = "First Year";
                break;
            case TYPE_SECOND_YEAR:
                employeeTypeDescription = "Second Year";
                break;
            case TYPE_PAST_GRADUATE:
                employeeTypeDescription = "Past Graduate";
                break;
        }

        String largeEarningsDescription = "";
        double earnings = getEarnings();
        if (earnings > COST_LARGE_ORDER) {
            largeEarningsDescription = " (Large Cost!)";
        }
        String output = "Summary for " + name + largeEarningsDescription
                + "\n"
                + "Employee type: " + employeeTypeDescription
                + "\n"
                + "Number of 'Individual' hours: " + hoursIndividual
                + "\n"
                + "Number of 'Small Group' hours: " + hoursSmallGroup
                + "\n"
                + "Number of 'Large Group' hours: " + hoursLargeGroup
                + "\n"
                + "Subtotal:  $" + earnings + " \n"
                + "\n";
        return output;
    }
}
