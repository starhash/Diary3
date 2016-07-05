/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import static diary3.MenuChangerAction.DIARY;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

/**
 *
 * @author Mahe
 */
public class MenuChangerMouse implements MouseListener {

    public static DiaryView DIARY;

    @Override
    public void mouseClicked(MouseEvent e) {
        Class c = e.getSource().getClass();
        System.out.println("Class Source : " + c.getName());
        if (c.getName().contains("JTextField")) {
            JTextField j = (JTextField) e.getSource();
            System.out.println(j.getName());
            if (j.getName().equals("username")) {
                DIARY.setEditMenu("User");
            }
        } else if (c.getName().contains("Text")) {
            DIARY.setEditMenu("Edit");
        } else if (((Component) e.getSource()).getName().contains("deskPane")) {
            DIARY.setEditMenu("Desk");
        } else if (c.getName().equals("diary3.DocumentEditor")) {
            DIARY.setEditMenu("Log");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
