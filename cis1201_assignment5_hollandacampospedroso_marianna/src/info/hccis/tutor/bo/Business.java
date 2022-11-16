package info.hccis.tutor.bo;

/**
 * Contains information about the business.
 *
 * @author marianna hollanda
 * @since 20201014
 */
public class Business {

    public static final String BUSINESS_NAME = "College Tutorial Services";
    public static final String BUSINESS_ADRESS = "140 Weymouth Street\n"
            + "Charlottetown, PE\n"
            + "C1A 1H6";

    /**
     * Static method to output the constants
     *
     * @author marianna hollanda
     * @since 20201014
     */
    public static void showBusinessInformation() {
        System.out.println(BUSINESS_NAME);
        System.out.println(BUSINESS_ADRESS);
    }
}
