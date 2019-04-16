
package Ajoutepat;

import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *responsible for the process of getting and showing the history of consultations
 * @author akentawi
 */
public class Histocons extends JFrame{
 static Container c;
 JScrollPane listsc=new JScrollPane();
 TextArea area = new TextArea();
 String s;
 
    public Histocons(){
        this.setTitle ("liste des consultations");     
this.setSize (800,700);
        c= this.getContentPane();
        c.add(area);
        try {
        this.s = ConsultationService.getConsultations();
     } catch (SQLException ex) {
         Logger.getLogger(ListePat.class.getName()).log(Level.SEVERE, null, ex);
     }
  area.setText(s);
  area.setFont(new Font("Verdana", 1, 15));
  area.setEditable(false);
        
    
}
    
}
