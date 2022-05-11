/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author Shobhit
 */
public class Validations {
        public static boolean isNumber(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
    
    public static boolean isDecimalNumber(String value) {
        try {
            if (value != null) {
                Float.parseFloat(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }
}
