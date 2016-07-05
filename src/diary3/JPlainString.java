/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Mahe
 */
public class JPlainString implements CharSequence {

    String STRING;
    Font FONT;
    String FACE;
    String TYPE;
    String SIZE;
    String COLOR = "Black";

    public Font getFont() {
        return FONT;
    }

    public void setFont(Font FONT) {
        this.FONT = FONT;
        FACE = FONT.getName();
        TYPE = FONT.getStyle()+"";
        SIZE = FONT.getSize()+"";
    }

    public String getString() {
        return STRING;
    }

    public void setString(String STRING) {
        this.STRING = STRING;
    }

    public JPlainString() {
    }

    public JPlainString(String STRING) {
        this.STRING = STRING;
    }

    public JPlainString(String STRING, Font FONT) {
        this.STRING = STRING;
        this.FONT = FONT;
        FACE = FONT.getName();
        TYPE = FONT.getStyle()+"";
        SIZE = FONT.getSize()+"";
    }
    
    public JPlainString(String STRING, String face, String type, String size) {
        this.STRING = STRING;
        FACE = face;
        TYPE = type;
        SIZE = size;
        COLOR = "black";
    }
    
    public JPlainString(String STRING, String face, String type, String size, String color) {
        this.STRING = STRING;
        FACE = face;
        TYPE = type;
        SIZE = size;
        COLOR = color;
    }

    @Override
    public int length() {
        return STRING.length();
    }

    @Override
    public char charAt(int index) {
        return STRING.charAt(index);
    }

    @Override
    public JPlainString subSequence(int start, int end) {
        return new JPlainString(STRING.substring(start, end));
    }
}
