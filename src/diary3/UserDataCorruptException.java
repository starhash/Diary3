/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

/**
 *
 * @author Mahe
 */
public class UserDataCorruptException extends Exception{

    public UserDataCorruptException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "The User Data for : "+Diary3.CURRENT_USER.USERNAME
                + " is corrupt. Sorry for the inconvenience."+super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
