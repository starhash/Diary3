/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahe
 */
public class User {

    public String USERNAME;
    private BioData BIODATA;
    public boolean LOGGED_IN = false;

    public User(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public BioData getBioData() {
        return BIODATA;
    }

    public boolean validate(String keyString) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(Home.getKeyFileFor(USERNAME)));
            String inString = br.readLine();
            //Checks
            if (inString.equals(keyString)) {
                BIODATA = Home.getBioDataFor(USERNAME);
                LOGGED_IN = true;
            }
            return LOGGED_IN;
        } catch (IOException ex) {
        }
        return false;
    }

    public boolean hasLog(String year, String month, String day) {
        File home = Home.getLogHomeFor(USERNAME);
        File logdir = new File(home.getAbsolutePath() + "/" + year + "/" + month + "/" + day);
        System.out.println(logdir.getAbsolutePath());
        if (logdir.exists() && logdir.isDirectory()) {
            return logdir.listFiles().length != 0;
        }
        return false;
    }

    public int getNumberOfLogs(String year, String month, String day) {
        System.out.println(year + "." + month + "." + day);
        if (hasLog(year, month, day)) {
            File home = Home.getLogHomeFor(USERNAME);
            File logdir = new File(home.getAbsolutePath() + "/" + year + "/" + month + "/" + day);
            return logdir.listFiles().length;
        }
        return -1;
    }

    public void addLogForCurrentTime(String log) {
        Date d = new Date();
        String year = (d.getYear() + 1900) + "";
        String month = (d.getMonth() + 1) + "";
        String day = d.getDate() + "";
        File home = Home.getHomeFor(USERNAME);
        File logdir = new File(home.getAbsolutePath() + "/Logs/" + year + "/" + month + "/" + day);
        if (!logdir.exists()) {
            logdir.mkdirs();
        }
        File tw = new File(logdir.getAbsolutePath() + "/" + d.toString().replaceAll(":", "-"));
        write(tw, log);
        
    }
    
    public void addLogForCurrentTime(String log, String title) {
        Date d = new Date();
        String year = (d.getYear() + 1900) + "";
        String month = (d.getMonth() + 1) + "";
        String day = d.getDate() + "";
        File home = Home.getHomeFor(USERNAME);
        File logdir = new File(home.getAbsolutePath() + "/Logs/" + year + "/" + month + "/" + day);
        if (!logdir.exists()) {
            logdir.mkdirs();
        }
        String time = d.getHours()+"-"+d.getMinutes()+"-"+d.getSeconds();
        File tw = new File(logdir.getAbsolutePath() + "/" + time + "."
            + JuliusCrypter.perfectSquareCrypt(title)+".logx");
        write(tw, log);
        
    }

    public void write(File f, String s) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(f));
            pw.write(s);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
    
    public void append(File f, String s) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(f, true));
            pw.write(s);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public String read(File f) {
        String ss = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s = "";
            while ((s = br.readLine()) != null) {
                ss += s + "\n";
            }
            br.close();
        } catch (IOException ex) {
        }
        return ss;
    }

    public String readSelectedLog() {
        String s = Diary3.DIARY.logCalendar.getDateString() + "/" + (String) Diary3.DIARY.currentLogList.getSelectedValue();
        System.out.println(Home.getLogHomeFor(Diary3.CURRENT_USER.USERNAME) + "/" + s);
        return read(new File(Home.getLogHomeFor(Diary3.CURRENT_USER.USERNAME) + "/" + s));
    }
}
