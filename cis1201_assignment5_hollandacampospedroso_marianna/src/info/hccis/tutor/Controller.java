package info.hccis.tutor;

import info.hccis.tutor.bo.Business;
import info.hccis.tutor.bo.Employee;
import java.util.Scanner;

/**
 * A project to track tutor transactions.
 *
 * @author marianna hollanda
 * @since 20201014
 */
public class Controller {

    static boolean finished = false;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Business.showBusinessInformation();

        Employee employee = new Employee();

        while (!finished) {
            System.out.println("Main Menu");
            System.out.println("1 - Add an employee");
            System.out.println("2 - Show total of all employee earnings since program start");
            System.out.println("0 - Exit");
            int option = input.nextInt();

            switch (option) {
                case 1:
                    employee.getInformtion();
                    employee.display();
                    break;
                case 2:
                    System.out.println("Total earnings so far: $" + employee.getFinalCost());
                    break;
                case 0:
                    System.out.println("Goodbye");
                    finished = true;
                    break;
                default: {
                    System.out.println("Invalid option");
                    break;
                }
            }
        }
    }
}
