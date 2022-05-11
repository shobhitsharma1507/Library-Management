/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Shobhit
 */
public class CommonOperation {

    public static void openInternalFrame(JDesktopPane deskpane, JInternalFrame frame) {
        frame.setVisible(true);
        deskpane.add(frame);
    }
    
    public static String generateMemberID(){
        String id = "ST" + System.currentTimeMillis();
        return id;
    }
}
