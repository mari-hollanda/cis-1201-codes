package info.hccis.vehicle;

import info.hccis.vehicle.bo.Vehicle;

/**
 * A project to calculate the current value of a vehicle
 *
 * @author marianna hollanda
 * @since 2020-12-04
 */
public class Controller {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.getInformation();
        vehicle.display();
    }

}
