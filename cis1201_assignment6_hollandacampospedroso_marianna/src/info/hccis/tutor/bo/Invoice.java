package info.hccis.tutor.bo;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Tutoring service invoice
 *
 * @author bjm
 * @since 20200619 
 * modified by marianna hollanda 
 * Added requirements for assignment 6
 * @since 2020-11-30
 */
public class Invoice {

    public static final double COST_INDIVIDUAL = 15;
    public static final double COST_SMALL_GROUP = 17;
    public static final double COST_LARGE_GROUP = 20;
    public static final double COST_LARGE_ORDER = 200;

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private Employee employee;

    private int id;
    private int employeeId;
    private double hoursIndividual, hoursSmallGroup, hoursLargeGroup;
    private double total;
    private String startDate, endDate;

    private static int nextId;  //Used to hold the next available id

    public Invoice() {

        this.employee = new Employee();

    }

    /**
     * Custom Constructor
     *
     * @author marianna hollanda
     * @param employeeId
     * @param hoursIndividual
     * @param hoursSmallGroup
     * @param hoursLargeGroup
     * @param startDate
     * @param endDate
     * @since 2020-12-01
     */
    public Invoice(int employeeId, double hoursIndividual, double hoursSmallGroup, double hoursLargeGroup, String startDate, String endDate) {
        this.employeeId = employeeId;
        this.hoursIndividual = hoursIndividual;
        this.hoursSmallGroup = hoursSmallGroup;
        this.hoursLargeGroup = hoursLargeGroup;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Get information from the user
     *
     * @since 2020-06-19
     * @author BJM 
     * modified by marianna hollanda 
     * Added requirements for assignment 6
     * @since 2020-11-30
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);

        //Use the getInformation method from the employee object to get 
        //the attributes of the employee associated with this invoice.
        employee.getInformation();

        System.out.println("How many 'Individual' hours?");
        hoursIndividual = input.nextDouble();
        input.nextLine();  //burn

        if (hoursIndividual < 0) {
            System.out.println("Invalid entry, individual hours being set to 0");
            hoursIndividual = 0;
        }

        System.out.println("How many 'Small Group' hours?");
        hoursSmallGroup = input.nextDouble();
        input.nextLine();  //burn

        if (hoursSmallGroup < 0) {
            System.out.println("Invalid entry, small group hours being set to 0");
            hoursSmallGroup = 0;
        }

        System.out.println("How many 'Large Group' hours?");
        hoursLargeGroup = input.nextDouble();
        input.nextLine();  //burn

        if (hoursLargeGroup < 0) {
            System.out.println("Invalid entry, large group hours being set to 0");
            hoursLargeGroup = 0;
        }

        System.out.println(""); //Empty line for formatting
    }

    /**
     * Returns the calculated earnings for this employee
     *
     * @return
     * @since 2020-06-19
     * @author BJM 
     * modified by marianna hollanda 
     * Added requirements for assignment 6
     * @since 2020-11-30
     */
    public double getTotal() {
        double finalTotal = hoursIndividual * COST_INDIVIDUAL
                + hoursSmallGroup * COST_SMALL_GROUP
                + hoursLargeGroup * COST_LARGE_GROUP;

        //Apply bonus using a switch statement.  Multiply the earnings by 1+ the 
        //appropriate bonus amount and assign to the earnings.
        switch (employee.getEmployeeType()) {
            case Employee.TYPE_SECOND_YEAR:
                finalTotal *= (1 + BONUS_SECOND_YEAR);
                break;
            case Employee.TYPE_PAST_GRADUATE:
                finalTotal *= (1 + BONUS_PAST_GRADUATE);
                break;

        }

        return finalTotal;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Invoice.nextId = nextId;
    }
    
    public void display() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {

        String largeEarningsDescription = "";
        double earnings = getTotal();
        if (earnings > COST_LARGE_ORDER) {
            largeEarningsDescription = " (Large Earnings!)";
        }
        
        Locale en = new Locale("en", "Canada");
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String value = money.format(getTotal());
        
        String output = employee.toString()
                + "\n"
                + "Number of 'Individual' hours: " + hoursIndividual
                + "\n"
                + "Number of 'Small Group' hours: " + hoursSmallGroup
                + "\n"
                + "Number of 'Large Group' hours: " + hoursLargeGroup
                + "\n"
                + "Earnings: " + value + " \n"
                + "\n";
        return output;
    }

}
