package info.hccis.tutor;

import info.hccis.tutor.bo.Business;
import info.hccis.tutor.bo.Invoice;

/**
 * A project to track tutor transactions.
 *
 * @author bjmaclean
 * @since 20200617
 */
public class Controller {
    
   public static void main(String[] args) {

       Business.showBusinessInformation();
       
       Invoice invoice = new Invoice();
       invoice.getInformation();
       invoice.display();
       
    }
}
