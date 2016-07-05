/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.io.File;
import javax.swing.UIManager;

/**
 *
 * @author Mahe
 */
public class Diary3 {

    public static File HOME = new File("C:/Users/Diary 3.0/");
    public static File PROGRAM_HOME = new File("C:/Program Files/Diary 3.0/");
    public static User CURRENT_USER;
    public static DiaryView DIARY;

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.installLookAndFeel(
                "Synthetica", "de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel");
        UIManager.installLookAndFeel(
                "EASynth", "com.easynth.lookandfeel.EaSynthLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Acryl", "com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Aero", "com.jtattoo.plaf.aero.AeroLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Aluminium", "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Bernstein", "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Fast", "com.jtattoo.plaf.fast.FastLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Graphite", "com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Hi-Fi", "com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Luna", "com.jtattoo.plaf.luna.LunaLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Mc-Win", "com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Mint", "com.jtattoo.plaf.mint.MintLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Noire", "com.jtattoo.plaf.noire.NoireLookAndFeel");
        UIManager.installLookAndFeel(
                "Tattoo Smart", "com.jtattoo.plaf.smart.SmartLookAndFeel");
        UIManager.installLookAndFeel(
                "Sea Glass", "com.seaglasslookandfeel.SeaGlassLookAndFeel");
        UIManager.installLookAndFeel(
                "Web", "com.alee.laf.WebLookAndFeel");
        UIManager.installLookAndFeel(
                "Kunst Stoff", "com.incors.plaf.kunststoff.KunststoffLookAndFeel");
        UIManager.installLookAndFeel(
                "Liquid", "com.birosoft.liquid.LiquidLookAndFeel");
        


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Sea Glass".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        DIARY = new DiaryView();
        DIARY.setVisible(true);
    }

    public static void logIn(String text, char[] password) {
        User u = new User(text);
        boolean validate = u.validate(new String(password));
        if(validate) {
            CURRENT_USER = u;
            DIARY.setBioData(CURRENT_USER.getBioData());
        } else {
            System.out.println("Wrong user name or password!");
        }
    }
}
