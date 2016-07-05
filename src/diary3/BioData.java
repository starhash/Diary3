/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.util.Date;

/**
 *
 * @author Mahe
 */
public class BioData {

    public String USERNAME;
    public String FIRST_NAME;
    public String MIDDLE_NAME;
    public String LAST_NAME;
    public String GENDER;
    public String DOB;
    public String ADDRESS;
    public String CITY;
    public String REGION_PROVINCE;
    public String COUNTRY;
    public String PIN_CODE;
    public String PHONE_NUMBER;
    public String MOBILE_NUMBER;
    public String RELATIONSHIP_STATUS;
    public String BRIEF;

    public String format() {
        return "username:" + USERNAME
                + "\nfirst_name:"+FIRST_NAME
                + "\nmiddle_name:"+MIDDLE_NAME
                + "\nlast_name:"+LAST_NAME
                + "\ngender:"+GENDER
                + "\ndob:"+DOB
                + "\naddress:"+ADDRESS
                + "\ncity:"+CITY
                + "\nregion_province:"+REGION_PROVINCE
                + "\ncountry:"+COUNTRY
                + "\npin_code:"+PIN_CODE
                + "\nphone_number:"+PHONE_NUMBER
                + "\nmobile_number:"+MOBILE_NUMBER
                + "\nrelationship_status:"+RELATIONSHIP_STATUS
                + "\nbrief:"+BRIEF;
    }
}
