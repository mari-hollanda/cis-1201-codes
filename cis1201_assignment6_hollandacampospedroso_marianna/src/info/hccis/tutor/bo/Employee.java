package info.hccis.tutor.bo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class represents an employee for tutorial services
 *
 * @author bjm
 * @since 2020-06-19 
 * modified by marianna hollanda 
 * Added requirements for assignment 6
 * @since 2020-11-30
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

    public static final double BONUS_SECOND_YEAR = 0.1;
    public static final double BONUS_PAST_GRADUATE = 0.2;

    private int id; //Unique sequential id for this employee
    private String name;
    private int employeeType = 0;
    private double hoursIndividual, hoursSmallGroup, hoursLargeGroup;
    private String phoneNumber;
    private String email;
    private int type;

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
     * @param name
     * @param type
     * @since 2020-06-19
     * @author BJM 
     * modified by marianna hollanda 
     * Added requirements for assignment 6
     * @since 2020-11-30
     */
    public Employee(String name, int type) {
        //Increment the next id and assign it to this employees id.
        this.id = ++nextId;
        this.name = name;
        this.type = type;
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
        System.out.println("Tutor’s name?");
        name = input.nextLine();

        boolean isValid = false;
        while (!isValid) {

            System.out.println("Email address?");
            email = input.nextLine();

            if (email != null && email.length() > 0) {
                String validEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
                Pattern emailPattern = Pattern.compile(validEmail, Pattern.CASE_INSENSITIVE);
                Matcher matcher = emailPattern.matcher(email);

                if (matcher.matches()) {
                    isValid = true;
                } else {
                    System.out.println(email + " is not a valid email address.");
                }
            }
        }

        boolean isValidPhone = false;
        while (!isValidPhone) {
            
            System.out.println("Phone number?");
            phoneNumber = input.nextLine();
            
            Pattern numberPattern = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
            Matcher numberMatcher = numberPattern.matcher(phoneNumber);
            
            if (numberMatcher.matches()) {
                isValidPhone = true;
            }else{
            System.out.println(phoneNumber + " is not a valid phone number (999-999-9999 format).");
                
            }
        }

        System.out.println("Employee Type (1=First Year 2=Second Year 3=Past Graduate)?");
        employeeType = input.nextInt();

        input.nextLine();  //burn

        if (employeeType > TYPE_PAST_GRADUATE) {
            System.out.println("Invalid employee type, setting to unknown");
            employeeType = TYPE_UNKNOWN;
        }
    }

//    /**
//     * Returns the calculated earnings for this employee
//     *
//     * @since 2020-06-19
//     * @author BJM
//     */
//    public double getEarnings() {
//        double earnings = hoursIndividual * COST_INDIVIDUAL
//                + hoursSmallGroup * COST_SMALL_GROUP
//                + hoursLargeGroup * COST_LARGE_GROUP;
//        
//        //Apply bonus using a switch statement.  Multiply the earnings by 1+ the 
//        //appropriate bonus amount and assign to the earnings.
//        switch(employeeType){
//            case TYPE_SECOND_YEAR:
//                earnings *= (1+BONUS_SECOND_YEAR);
//                break;
//            case TYPE_PAST_GRADUATE:
//                earnings *= (1+BONUS_PAST_GRADUATE);
//                break;
//                
//        }
//        return earnings;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
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

//        String largeEarningsDescription = "";
//        double earnings = getEarnings();
//        if(earnings > COST_LARGE_ORDER){
//            largeEarningsDescription = " (Large Earnings!)";
//        }
        String[] resultName = name.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String name1 : resultName) {
            sb.append(name1.substring(0, 1).toUpperCase()).append(name1.substring(1).toLowerCase());
            sb.append(" ");
        }

        String output = "Invoice Summary"
                + "\n"
                + "Name: " + sb
                + "\n"
                + "Phone number: " + phoneNumber
                + "\n"
                + "Email address: " + email
                + "\n"
                + "Employee type: " + employeeTypeDescription;
//                + "Number of 'Individual' hours: " + hoursIndividual
//                + "\n"
//                + "Number of 'Small Group' hours: " + hoursSmallGroup
//                + "\n"
//                + "Number of 'Large Group' hours: " + hoursLargeGroup
//                + "\n"
//                + "Earnings:  $" + getEarnings() + " \n"
//                + "\n";
        return output;
    }
}
