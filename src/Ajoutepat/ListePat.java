
package Ajoutepat;

import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *manages the process of getting and showing the patients list
 * @author akentawi
 */
public class ListePat extends JFrame{
 static Container c;
 TextArea area = new TextArea();
 String s;
 
    public ListePat(){
        this.setTitle ("liste des patients");     
this.setSize (400,150);
        c= this.getContentPane();
        c.add(area);
        try {
        this.s = PatientService.getPatients();
     } catch (SQLException ex) {
         Logger.getLogger(ListePat.class.getName()).log(Level.SEVERE, null, ex);
     }
  area.setText(s);
  area.setFont(new Font("Verdana", 1, 20));
  area.setEditable(false);
        
    
}
    
}
