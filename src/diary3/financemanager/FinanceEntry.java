/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3.financemanager;

import java.util.Date;

/**
 *
 * @author Mahe
 */
public class FinanceEntry {
    String date;
    String tag;
    double amount;
    char dORc;
    String description;

    public FinanceEntry(String date, String tag, double amount, char dORc, String description) {
        this.date = date;
        this.tag = tag;
        this.amount = amount;
        this.dORc = dORc;
        this.description = description;
    }

    @Override
    public String toString() {
        return tag+"|"+date+"|"+amount+"|"+dORc+"|"+description;
    }
    
    public int compareTo(FinanceEntry obj) {
        return new Date(date).compareTo(new Date(obj.date));
    }
}
