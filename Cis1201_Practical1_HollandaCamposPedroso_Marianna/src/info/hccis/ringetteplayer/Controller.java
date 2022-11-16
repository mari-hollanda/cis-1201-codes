package info.hccis.ringetteplayer;

import info.hccis.ringetteplayer.bo.RingettePlayer;
import java.util.Scanner;

/**
 * Practical 1 CIS 1201 - Introduction to Object Oriente
 *
 * @author marianna hollanda
 * @since 20201026
 */
public class Controller {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //First Object
        RingettePlayer player1 = new RingettePlayer("Brielle", "Jones");

        // Second Object       
        RingettePlayer player2 = new RingettePlayer();
        player2.setFirstName("Marley");
        player2.setLastName("Stephens");
        player2.setAllergies("Cats");
        player2.setJerseyNumber(12);

        // Third Object    
        RingettePlayer player3 = new RingettePlayer();
        player3.getInformation();

        System.out.println("Ringette Players");
        player1.display();
        player2.display();
        player3.display();

        // Output to show the allergies only
        System.out.println("");
        System.out.println("Allergies for all players:");
        System.out.println(player2.getAllergies() + " " + player3.getAllergies());

    }

}
