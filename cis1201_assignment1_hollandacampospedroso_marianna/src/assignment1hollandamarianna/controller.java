package assignment1hollandamarianna;

import java.util.Scanner;

/**
 * Assignment 1 CIS 1201 - Introduction to Object Oriente
 *
 * @author marianna hollanda
 * @since 20200916
 */
public class controller {

    public static final String BUSINESS_NAME = "College Tutorial Services"
                + "\n"
                + "140 Weymouth Street\n"
                + "Charlottetown, PE\n"
                + "C1A 1H6";

    public static final int INDIVIDUAL_TUTORIAL_PER_HOUR = 15;
    public static final int SMALL_GROUP_PER_HOUR = 17;
    public static final int LARGE_GROUP_PER_HOUR = 20;

    public static void main(String[] args) {
        System.out.println(BUSINESS_NAME);

        Scanner input = new Scanner(System.in);

        System.out.println("Employee's Name:");
        String employeeName = input.nextLine();
        System.out.println("How many 'Individual' hours?");
        int individualHours = input.nextInt();
        input.nextLine();
        System.out.println("How many 'Small Group' hours?");
        int smallGroupHours = input.nextInt();
        input.nextLine();
        System.out.println("How many 'Large Group' hours?");
        int largeGroupHours = input.nextInt();
        input.nextLine();
        int finalEarnings = individualHours * INDIVIDUAL_TUTORIAL_PER_HOUR + smallGroupHours * SMALL_GROUP_PER_HOUR + largeGroupHours * LARGE_GROUP_PER_HOUR;

        System.out.println("Summary for "+ employeeName);
        System.out.println("Number of 'Individual' hours: " + individualHours);
        System.out.println("Number of 'Small Group' hours: " + smallGroupHours);
        System.out.println("Number of 'Large Group' hours: " + largeGroupHours);

        System.out.println("Earnings: $ " + finalEarnings);
    }

}
