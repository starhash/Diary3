/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3.financemanager;

import diary3.DCalendar;
import diary3.Home;
import diary3.User;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Mahe
 */
public class FinanceManagerAgent {

    Vector<FinanceEntry> financeEntries;
    User USER;

    public FinanceManagerAgent(User user) {
        financeEntries = new Vector<>();
        USER = user;
        readEntries();
    }

    public void addEntry(String date, String tag, double amt, char dorc, String desc) {
        FinanceEntry f = new FinanceEntry(date, tag, amt, dorc, desc);
        financeEntries.add(f);
        USER.append(Home.getFinanceFileFor(USER.USERNAME), f.toString() + " ");
    }

    public void readEntries() {
        financeEntries.clear();
        String fullRead = USER.read(Home.getFinanceFileFor(USER.USERNAME));
        StringTokenizer st = new StringTokenizer(fullRead, " ");
        int count = st.countTokens();
        System.out.println("FinEnts : " + count);
        for (int i = 0; i < count; i++) {
            try {
                StringTokenizer stt = new StringTokenizer(st.nextToken(), "|");
                String tag = stt.nextToken();
                String ds = stt.nextToken();
                System.out.println("read : " + i + " : " + ds);
                double amt = Double.parseDouble(stt.nextToken());
                char c = stt.nextToken().charAt(0);
                String desc = stt.nextToken();
                FinanceEntry f = new FinanceEntry(ds, tag, amt, c, desc);
                financeEntries.add(f);
            } catch (NoSuchElementException e) {
                System.err.println("Null End");
            }
        }
    }
}
