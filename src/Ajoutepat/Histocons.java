
package Ajoutepat;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *responsible for the process of getting and showing the history of consultations
 * @author akentawi
 */
public class Histocons extends JFrame{
 static Container c;
 JTable area = null;
 JScrollPane listsc=new JScrollPane();
 ArrayList<ArrayList<String>> s;
 String [] s0 = {"id","Date","matricule med","nom med","num ss","nom pat","code medoc","libelle","indication","nbre de jours"};
    public Histocons(){
        this.setTitle ("liste des consultations");     
this.setSize (800,700);
        c= this.getContentPane();
        try {
        this.s = ConsultationService.getConsultations();
     } catch (SQLException ex) {
         Logger.getLogger(ListePat.class.getName()).log(Level.SEVERE, null, ex);
     }
        try{
        Object [][] temp0 = new Object[s.size()][];
        for(int i = 0;i<temp0.length;i++){
        temp0[i]=new Object[s.get(i).size()];
        }
        for(int i=0;i<s.size();i++){
        for(int j=0;j<s.get(i).size();j++){
        temp0[i][j]=s.get(i).get(j);
        }
        }
  area = new JTable(temp0, s0);
  c.add(area);
        }
        catch(Exception e){System.out.println(e.getMessage());}
        
        
    
}
    
}
