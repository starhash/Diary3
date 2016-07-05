/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.util.Vector;

/**
 *
 * @author Mahe
 */
public class JFormattedString implements CharSequence {

    Vector<JPlainString> TOKENS;

    public JFormattedString() {
        TOKENS = new Vector<JPlainString>();
    }

    public JFormattedString(Vector<JPlainString> TOKENS) {
        this.TOKENS = TOKENS;
    }

    public void addToken(JPlainString string) {
        TOKENS.add(string);
    }

    public JPlainString getToken(int idx) {
        return TOKENS.get(idx);
    }

    public int countTokens() {
        return TOKENS.size();
    }

    public JPlainString removeToken(int idx) {
        return TOKENS.remove(idx);
    }
    
    public void removeAll() {
        TOKENS.removeAllElements();
    }

    @Override
    public String toString() {
        String s = "<html>";
        for (int i = 0; i < TOKENS.size(); i++) {
            JPlainString a = TOKENS.get(i);
            s += "<font face=\"" + a.FACE + "\" size=" + a.SIZE + " type="
                    + a.TYPE + " color=" + a.COLOR + ">" + a.getString() + "</font>";
        }
        return s;
    }

    @Override
    public int length() {
        int i = 0;
        for (int j = 0; j < TOKENS.size(); j++) {
            i += TOKENS.get(j).length();
        }
        return i;
    }

    @Override
    public char charAt(int index) {
        return ' ';
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this;
    }
}
