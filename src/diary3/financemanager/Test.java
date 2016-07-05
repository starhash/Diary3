/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3.financemanager;

import diary3.User;
import java.util.Date;

/**
 *
 * @author Mahe
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User u = new User("Harsh Srivastava");
        u.LOGGED_IN = true;
        FinanceManagerAgent f = new FinanceManagerAgent(u);
        f.addEntry("18 April 2014 00:00:01", "test 1", 100, 'c', "credit test 1");
        f.addEntry("18 April 2014 00:00:02", "test 2", 1000, 'd', "debit test 1");
        f.addEntry("18 April 2014 00:00:03", "test 3", 2000, 'c', "credit test 2");
        f.addEntry("18 April 2014 00:00:04", "test 4", 100, 'd', "debit test 2");
        
        //FinanceManager f = new FinanceManager();
        //f.setUSER(u);
    }
}
