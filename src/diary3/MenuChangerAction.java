/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mahe
 */
public class MenuChangerAction implements ActionListener {

    public static DiaryView DIARY;

    @Override
    public void actionPerformed(ActionEvent e) {
        Class c = e.getSource().getClass();
        if (c.getName().contains("Text")) {
            DIARY.setEditMenu("Edit");
        }
    }
}
