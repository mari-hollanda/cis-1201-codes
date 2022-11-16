package cis;

import cis.entity.Kid;
import cis.util.CisUtility;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Controls the overall flow of the program.
 *
 * @author cis1201
 * @since Nov 18, 2020
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = System.lineSeparator() + "--- Main Menu ---" + System.lineSeparator() + "1) Add a kid to Santa's lists" + System.lineSeparator()
            + "2) Lookup a kid" + System.lineSeparator()
            + "3) Move a kid to the naughty list" + System.lineSeparator()
            + "4) Show the list" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    //**********************************************************
    //Santa specifica attributes.  Note these strings will contain
    //the list of kids who are naughty or nice.
    //**********************************************************
    private static String listNice, listNaughty;

    public static void main(String[] args) {

        int menuOption;
        initializeLists(); //Load the initial names into the lists (not reflective of who's actually naughty/nice :-)

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    addKid();  //Method to add a kid
                    break;
                case 2:
                    lookup();  //Method to lookup a kid
                    break;
                case 3:
                    moveToNaughtyList(); //Method to move from nice to naughty list string.
                    break;
                case 4:
                    showLists();  //This method is completed and can show the kids on the lists.
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * When the user picks 1 add a kid.
     *
     * @since 20201202
     * @author BJM
     * @modified by marianna hollanda
     * @since 20201207 
     * Added a logic to add the kid to the correct list. 
     */
    public static void addKid() {
        System.out.println(System.lineSeparator() + "--- Add a kid ---");
        Kid kid = new Kid();
        kid.getInformation(listNaughty, listNice);
        kid.display();

        String name = kid.getName();
        int age = kid.getAge();
        int behaviourRating = kid.getBehaviourRating();

        if (age >= 10 && behaviourRating < 6) {
            listNaughty = listNaughty + "," + name;
        } else if (age < 10 && behaviourRating < 5) {
            listNaughty = listNaughty + "," + name;
        } else {
            listNice = listNice + "," + name;
        }
    }

    /**
     * Option 2 - lookup a kid to see if naughty or nice.
     *
     * @since 20201118
     * @author BJM
     * @modified by marianna hollanda
     * @since 20201207 
     * Added a code to see if a kid is in the naughty list or nice list
     */
    public static void lookup() {
        System.out.println(System.lineSeparator() + "--- Lookup a kid's status ---");

        String name = CisUtility.getInputString("");

        if (listNice.contains(name)) {
            System.out.println(name + " Is Nice");
        } else if (listNaughty.contains(name)) {
            System.out.println(name + " Is Naughty");
        }
    }

    /**
     * Option 3 - move to naughty list
     *
     * @since 20201202
     * @author BJM
     * @modified by marianna hollanda
     * @since 20201207 
     * Added a code to move a kid from the nice list to the naughty list
     */
    public static void moveToNaughtyList() {
        System.out.println(System.lineSeparator() + "--- Move a kid to the naughty list ---");

        String name = CisUtility.getInputString("");

        if (listNice.contains(name)) {
            listNice = listNice.replace("," + name, "");
            listNaughty = listNaughty + "," + name;
        }

    }

    /**
     * Show the lists
     *
     * @since 20201202
     * @author BJM
     */
    public static void showLists() {
        StringTokenizer st = new StringTokenizer(listNice, ",");
        System.out.println(System.lineSeparator() + "--- Nice List ---");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        st = new StringTokenizer(listNaughty, ",");
        System.out.println(System.lineSeparator() + "--- Naughty List ---");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }

    /**
     * Load the nice and naughty lists. Note these are randomly assigned!
     *
     * @since 20201202
     * @author BJM
     */
    public static void initializeLists() {

        listNice = ",Aaron,Adline,Alberto,Amy,Andres,Azam,Bailee,Ben,Blaise,Brandon,Chad,Christian,Colin,Courtney,Dakota,"
                + "David,Dmitrii";

        //Just random :-)
        listNaughty = ",Nick,Michael,Steve";
    }

}
