package info.hccis.vehicle.bo;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Class represents a vehicle
 *
 * @author marianna hollanda
 * @since 2020-12-04
 */
public class Vehicle {

    public static final double MILEAGE_ONE = 0.3;
    public static final double MILEAGE_TWO = 0.35;
    public static final double MILEAGE_THREE = 0.4;
    public static final double MILEAGE_FOUR = 0.5;
    public static final double AUTOMATIC_TRANSMISSION = 0.05;
    public static final double MANUAL_TRANSMISSION = 0.05;
    public static final double HAS_SUNROOF = 0.1;

    private Vehicle vehicle;

    private double vehiclePrice;
    private double vehicleMileage;
    private String vehicleTransmission;
    private String vehicleSunroof;

    /**
     * Default constructor
     *
     * @author marianna hollanda
     * @since 2020-12-04
     */
    public Vehicle() {

    }

    /**
     * Custom constructor
     *
     *
     * @author marianna hollanda
     * @param vehiclePrice
     * @param vehicleMileage
     * @param vehicleTransmission
     * @param vehicleSunroof
     * @since 2020-12-04
     */
    public void Vehicle(double vehiclePrice, double vehicleMileage, String vehicleTransmission, String vehicleSunroof) {
        this.vehiclePrice = vehiclePrice;
        this.vehicleMileage = vehicleMileage;
        this.vehicleTransmission = vehicleTransmission;
        this.vehicleSunroof = vehicleSunroof;
    }

    /**
     * Get information from the user
     *
     * @author marianna hollanda
     * @since 2020-12-04
     */
    public void getInformation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Vehicle Price: ");
        vehiclePrice = input.nextDouble();
        input.nextLine();

        System.out.println("Mileage on Vehicle: ");
        vehicleMileage = input.nextDouble();
        input.nextLine();

        System.out.println("Transmission (A-automatic / M-manual): ");
        vehicleTransmission = input.nextLine();

        System.out.println("Sunroof (Y/N): ");
        vehicleSunroof = input.nextLine();
    }

    public double getTotal() {
        double finalTotal = vehiclePrice;

        if (vehicleMileage >= 0 && vehicleMileage <= 59.999) {
            finalTotal -= vehiclePrice * MILEAGE_ONE;
        } else if (vehicleMileage >= 60.000 && vehicleMileage <= 99.999) {
            finalTotal -= vehiclePrice * MILEAGE_TWO;
        } else if (vehicleMileage >= 100.000 && vehicleMileage <= 199.999) {
            finalTotal -= vehiclePrice * MILEAGE_THREE;
        } else if (vehicleMileage >= 200.000) {
            finalTotal -= vehiclePrice * MILEAGE_FOUR;
        }
        switch (vehicleTransmission) {
            case "A": {
                finalTotal += vehiclePrice * AUTOMATIC_TRANSMISSION;
                break;
            }
            case "M": {
                finalTotal -= vehiclePrice * MANUAL_TRANSMISSION;
                break;
            }
        }
        if (vehicleSunroof.indexOf("Y") != -1) {
            finalTotal += vehiclePrice * HAS_SUNROOF;
        }
        return finalTotal;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public double getVehicleMileage() {
        return vehicleMileage;
    }

    public void setVehicleMileage(double vehicleMileage) {
        this.vehicleMileage = vehicleMileage;
    }

    public String getVehicleTransmission() {
        return vehicleTransmission;
    }

    public void setVehicleTransmission(String vehicleTransmission) {
        this.vehicleTransmission = vehicleTransmission;
    }

    public String getVehicleSunroof() {
        return vehicleSunroof;
    }

    public void setVehicleSunroof(String vehicleSunroof) {
        this.vehicleSunroof = vehicleSunroof;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        double finalPrice = getTotal();

        Locale en = new Locale("en", "Canada");
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String value = money.format(finalPrice);

        String output = "Your vehicle is now valued at: " + value;

        return output;

    }
}
