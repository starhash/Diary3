/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mahe
 */
public class Home {

    public static String USERPROFILE = System.getenv("USERPROFILE");
    public static String ROOT = System.getenv("USERPROFILE")+"/Documents/Diary 8/";
    public static String USERROOT = "";
    
    public static File getKeyFileFor(String username) {
        File f = new File(ROOT + username + "/ .keyx");
        return (f.exists()) ? f : null;
    }

    public static File getHomeFor(String username) {
        File f = new File(ROOT + username);
        return (f.exists()) ? f : null;
    }
    
    public static File getLogHomeFor(String username) {
        File f = new File(ROOT + username + "/Logs");
        return (f.exists()) ? f : null;
    }
    
    public static File getFinanceFileFor(String username) {
        File f = new File(ROOT + username + "/ .finx");
        return (f.exists()) ? f : null;
    }
    
    public static File getPictureLibraryFileFor(String username) {
        File f = new File(ROOT + username + "/ .picx");
        return (f.exists()) ? f : null;
    }

    public static BioData getBioDataFor(String username) {
        BufferedReader br = null;
        BioData read = new BioData();
        try {
            File bd = new File(getHomeFor(username).getAbsolutePath() + "/ .inx");
            System.out.println(bd.getAbsolutePath());
            br = new BufferedReader(new FileReader(bd));
            String in = br.readLine();
            if (in.equals("[biodata]")) {
                while (!(in = br.readLine()).equals("[.biodata]")) {
                    setFieldInBioData(in, read);
                }
            } else {
                throw new UserDataCorruptException("BioData file corrupt!");
            }
            br.close();
            System.out.println(read.format());
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserDataCorruptException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return read;
    }

    private static void setFieldInBioData(String fieldWithData, BioData dat) {
        String field = fieldWithData.substring(0, fieldWithData.indexOf(":"));
        String data = fieldWithData.substring(fieldWithData.indexOf(":") + 1);
        Class c = BioData.class;
        Field fields[] = c.getFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equalsIgnoreCase(field)) {
                try {
                    Object j = new Object();
                    fields[i].set(dat, data);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
