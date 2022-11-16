package cis.entity;

import cis.util.CisUtility;

/**
 * Represents a sponsor
 *
 * @author bjm
 * @since 13-Nov-2020
 *
 * @modified by Marianna Hollanda
 * @since 16-Nov-2020
 */
public class Sponsor {

    private String name;
    private double pledgeAmount;
    private int numberOfChristmasCards;
    private boolean participatingInEliminationDraw;
    private int majorSponsorType;
    private double totalDonationAmount;

    public static final double DONATION_GOLD = 1000.0;
    public static final double DONATION_SILVER = 500.0;
    public static final double DONATION_BRONZE = 250.0;
    public static final double DONATION_ELIMINATION_DRAW = 20.0;
    public static final double COST_CHRISTMAS_CARD = 5.0;

    public Sponsor() {
    }

    /**
     * Custom constructor which accepts values for the name and the various
     * types of donations possible for a sponsor.
     *
     * @since 20201113
     * @author BJM
     */
    public Sponsor(String name, double pledgeAmount, int numberOfChristmasCards, boolean participatingInEliminationDraw, int majorSponsorType) {
        this.name = name;
        this.pledgeAmount = pledgeAmount;
        this.numberOfChristmasCards = numberOfChristmasCards;
        this.participatingInEliminationDraw = participatingInEliminationDraw;
        this.majorSponsorType = majorSponsorType;
    }

    /**
     * Method to prompt the user for values of the object.
     *
     * @since 20201113
     * @author BJM
     */
    public void getInformation() {

        CisUtility.display(System.lineSeparator() + "--- Please provide sponsor details ---");
        name = CisUtility.getInputString("Name");
        pledgeAmount = CisUtility.getInputDouble("Pledge amount");
        numberOfChristmasCards = CisUtility.getInputInt("Number of Christmas cards");
        participatingInEliminationDraw = CisUtility.getInputString("Participating in elimination draw? (y/n)").equalsIgnoreCase("Y");
        majorSponsorType = CisUtility.getInputInt("Major sponsor type (0-No, 1=Gold, 2=Silver, 3=Bronze");

        //BJM after 
        totalDonationAmount = calculateTotalDonationAmount();

    }

    /**
     * Method to calculate the amount of donations based on the attributes of
     * this class.
     *
     * @return The amount of the total donation
     * @since 20201113
     * @author BJM
     * @modified by Marianna Hollanda
     * @since 20201116
     */
    public double calculateTotalDonationAmount() {

        double totalDonation = 0.0;
        totalDonation += pledgeAmount + (numberOfChristmasCards * COST_CHRISTMAS_CARD);
        
        if (participatingInEliminationDraw) {
            totalDonation += DONATION_ELIMINATION_DRAW;
        }
        switch (majorSponsorType) {
            case 1:
                totalDonation += (DONATION_GOLD);
                break;
            case 2:
                totalDonation += (DONATION_SILVER);
                break;
            case 3:
                totalDonation += (DONATION_BRONZE);
                break;
            default: {
                
                break; 
            }
        }
        return totalDonation;
    }

    /**
     * If the sponsor made a pledge, bought Christmas cards, participated in the
     * elimination draw, and is a major sponsor --> have this method return
     * true. Otherwise the method should return false.
     *
     * @return whether or not the sponsor sponsoring for all sponsorship
     * options.
     * @since 20201113
     * @author BJM
     * @modified by Marianna Hollanda
     * @since 20201116
     */
    public boolean determineIfFullParticipant() {
  
        if (pledgeAmount == 0 || numberOfChristmasCards > 0 || participatingInEliminationDraw || majorSponsorType > 0){
        return true;
        }
        return false;
     }
        


    public void display() {
        CisUtility.display(this.toString());
    }

    @Override
    public String toString() {
        String output = System.lineSeparator() + "--- Sponsor Details ---";
        output += System.lineSeparator()+"Name: " + name + System.lineSeparator();
        if (pledgeAmount > 0){
        output += "Sponsorship from pledge amount: $" + pledgeAmount + System.lineSeparator();}
        
        if (numberOfChristmasCards > 0){
        output += "Number of Christmas cards: " + numberOfChristmasCards + System.lineSeparator();}
        
        if (participatingInEliminationDraw){
        output += "Elimination draw details here: Elimination draw Participant" + System.lineSeparator();}
        
        switch (majorSponsorType){
            case 1:
           output += "Major sponsor type: gold" + System.lineSeparator();     
        break;
        case 2:
            output += "Major sponsor type: silver" + System.lineSeparator();
            break;
        case 3: 
            output += "Major sponsor type: bronze" + System.lineSeparator();
            break;
        }
 
        output += "Total Donation Amount: $"+calculateTotalDonationAmount();
        
        return output;
    }

}
