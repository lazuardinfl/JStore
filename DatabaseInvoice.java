import java.util.ArrayList;
/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }
    
    public static int getLastInvoiceID(){
        return LAST_INVOICE_ID;
    }
    
    public static boolean addInvoice(Invoice invoice){
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID++;
        return true;
    }
    
    public static Invoice getInvoice(int id){
        for (int i = 0; i < INVOICE_DATABASE.size(); i++){
            if (INVOICE_DATABASE.get(i).getId() == id){
                return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }
    
    public static Invoice getActiveOrder(Customer customer){
        for (int i = 0; i < INVOICE_DATABASE.size(); i++){
            if (INVOICE_DATABASE.get(i).getCustomer().equals(customer) &&
                (INVOICE_DATABASE.get(i).getInvoiceStatus().equals(InvoiceStatus.Unpaid) ||
                INVOICE_DATABASE.get(i).getInvoiceStatus().equals(InvoiceStatus.Installment)) &&
                INVOICE_DATABASE.get(i).getIsActive() == true){
                    return INVOICE_DATABASE.get(i);
            }
        }
        return null;
    }
    
    public static boolean removeInvoice(int id){
        for (int i = 0; i < INVOICE_DATABASE.size(); i++){
            if (INVOICE_DATABASE.get(i).getId() == id
                && INVOICE_DATABASE.get(i).getIsActive() == true){
                    INVOICE_DATABASE.remove(i);
                    return true;
            }
        }
        return false;
    }
}
