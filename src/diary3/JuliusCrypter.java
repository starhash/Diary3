/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

/**
 *
 * @author HP
 */
public class JuliusCrypter {

    public static String perfectSquareCrypt(String s) {
        if (s.length() <= 3) {
            return s;
        } else {
            int ps = (int) (Math.sqrt(s.length()));
            String h = s.substring(0, ps * ps);
            int idx = 0;
            char[][] arr = new char[ps][];
            for (int u = 0; u < ps; u++) {
                arr[u] = new char[ps];
            }
            for (int i = 0; i < ps; i++) {
                for (int j = 0; j < ps; j++) {
                    arr[i][j] = h.charAt(idx++);
                }
            }
            String crypt = "";
            for (int i = 0; i < ps; i++) {
                for (int j = 0; j < ps; j++) {
                    crypt += arr[j][i];
                }
            }
            String rem = s.substring(ps * ps);
            return crypt + perfectSquareCrypt(rem);
        }
    }
}
