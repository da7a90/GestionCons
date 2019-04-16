
package Ajoutepat;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *creates the Graphical user's interface that lets him insert a list of Meciament objects
 * @author akentawi
 */
public class PrescritGUI extends JFrame implements ActionListener{
    static JTextField prescription = new JTextField();
    static JLabel pres =new JLabel("prescription");
    static JButton ap= new JButton("ajouter prescription");
    static JLabel jr=new JLabel("jours");
    static JTextField jours= new JTextField();
    static JLabel num = new JLabel("numero");
    static JTextField numero = new JTextField();
    static Container contenu;
    static JPanel p4=new JPanel();
    static JPanel p411=new JPanel(new GridLayout(3,2));
    static JPanel p421=new JPanel(new FlowLayout());

    /**
     *
     */
    public PrescritGUI(){
        this.setTitle ("prescription");     
this.setSize (1200,700);
 contenu = this.getContentPane( );
init();
ap.addActionListener(this);

  this.addWindowListener (new WindowAdapter ( )  {@Override
 public void windowClosing (WindowEvent e)        { System.exit ( 0);         } } ); 

        }
    public void init()
    {
        contenu.add(p4);
        p4.add(p411);
        p4.add(p421);
         p411.add(num);
 p411.add(numero);
    p411.add(pres);
 p411.add(prescription);
 p411.add(jr);
 p411.add(jours);
 p421.add(ap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource()==ap){
     
     Prescrit p = new Prescrit(Integer.parseInt(numero.getText()),prescription.getText(),Integer.parseInt(jours.getText()));
     prescription.setText("");
     int id =p.getId();
     String code = p.getCode();
     int jour = p.getJours();
     int option =JOptionPane.showConfirmDialog(this, "avez vous termine votre liste?","confirmez",JOptionPane.YES_NO_OPTION);
        if(option==JOptionPane.YES_OPTION){
     try {
         PrescritService.createPrescrit(id,code,jour);
         JOptionPane.showMessageDialog(this, "consultation cree avec succes");
         this.setVisible(false);
         
 
     } catch (SQLException ex) {
         Logger.getLogger(PrescritService.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
        else{
            assert true;
        } 

            }
 
    }
}
