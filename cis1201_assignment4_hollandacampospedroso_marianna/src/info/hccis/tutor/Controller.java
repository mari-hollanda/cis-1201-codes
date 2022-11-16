package info.hccis.tutor;

import info.hccis.tutor.bo.Business;
import info.hccis.tutor.bo.Employee;

/**
 * A project to track tutor transactions.
 *
 * @author marianna hollanda
 * @since 20201014
 */

public class Controller {

    public static void main(String[] args) {

        Business.showBusinessInformation();

        Employee employee = new Employee();
        employee.getInformation();
        employee.display();

    }
}
