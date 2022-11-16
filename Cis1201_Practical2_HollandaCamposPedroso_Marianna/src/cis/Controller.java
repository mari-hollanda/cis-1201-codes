package cis;

import cis.entity.Sponsor;

/**
 * A starting project which we can use for applications that need a menu driven
 * program. Note that the name of the project should be modified to reflect the
 * specific requirements.
 *
 * @author bjmaclean
 * @since 20181115
 */
public class Controller {
        
    public static void main(String[] args) {

        //Create a test sponsor
        Sponsor sponsor1 = new Sponsor("Andrew", 20, 5, true, 2);
        sponsor1.display();

    }

}
