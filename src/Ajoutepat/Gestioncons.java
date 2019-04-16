package Ajoutepat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.swing.JFrame;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;
 
/**
 *manages the authentification process with the database 
 * @author akentawi
 */
public class Gestioncons extends JFrame {
      private javax.swing.JButton btnseconnecter;
    
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textlogin;
    private javax.swing.JTextField textmdp;
    private javax.swing.JButton creecompte;
    
public Gestioncons() {
        initComponents();
    }
    private void initComponents() {
        
       
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textlogin = new javax.swing.JTextField(15);
        textmdp = new javax.swing.JPasswordField(15);
        btnseconnecter = new javax.swing.JButton();
        creecompte = new javax.swing.JButton("creer un compte");
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        
        jLabel2.setText("login");
 
        jLabel3.setText("mot de passe");
 
 
        btnseconnecter.setText("se connecter");
        btnseconnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    
                    btnseconnecterActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         creecompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    creecompteActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
 BufferedImage image = null;
          try {
              image = ImageIO.read(this.getClass().getResource("1457d8b5eb4da12.jpg"));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
          
 this.setIconImage(image);
       
        
        
        JLabel back = null;   
        try {
              
             back = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("1457d8b5eb4da12.jpg"))));
          } catch (IOException ex) {
              Logger.getLogger(Gestioncons.class.getName()).log(Level.SEVERE, null, ex);
          }
        back.setLayout(null);
        back.setBounds(0,0,500,600);
        
                JPanel pane= new JPanel(new GridLayout());
                this.getContentPane().add(pane);
        pane.add(back,BorderLayout.WEST);
        JPanel panex= new JPanel(new GridLayout(3,2));
        pane.add(panex,BorderLayout.EAST);
        JPanel pane1= new JPanel(new GridLayout(2,2));
        JPanel pane2= new JPanel(new FlowLayout());
        

       
        
        
        pane1.add(jLabel2);
        pane1.add(textlogin);
        pane1.add(jLabel3);
        pane1.add(textmdp);
        panex.add(pane1,BorderLayout.NORTH);
        pane.setBorder(new TitledBorder("gestion de consultations"));
        pane2.add(btnseconnecter);
        pane2.add(creecompte);
        panex.add(pane2,BorderLayout.SOUTH);
        
        
        pack();
        this.addWindowListener (new WindowAdapter ( )  {@Override
 public void windowClosing (WindowEvent e)        { System.exit ( 0);         } } ); 
    }
     
    private void creecompteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                               
      PreparedStatement teste = null ;
      String login = textlogin.getText();
      String password = textmdp.getText();
      Connection con=null;
 if(textlogin.getText().equals("")|textmdp.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "completez les champs vides!");
                    }
 else{
     try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception e){System.out.println("Erreur driver:  "+e.getMessage ( ) ) ;}
     try {con =DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
    try { 
        String sql = " insert into `auth` values (?,?) ";
        teste = con.prepareStatement(sql);
        teste.setString(1, login );
        teste.setString(2, password );
        teste.executeUpdate();
        JOptionPane.showMessageDialog(this,"compte crée avec succes!");
        textlogin.setText("");
        textmdp.setText("");
        
	        }
	  catch(SQLException t){System.out.println("Erreur de Statement"+t.getMessage());}
    
  
   try{
     con.close();
     teste.close();}
   catch(NullPointerException e){System.out.print("Erreur close:  "+e.getMessage ( ));}
     
    }
    }
 
    private void btnseconnecterActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                               
      PreparedStatement teste = null ;
      String login = textlogin.getText();
      ResultSet rs=null ;
      String password = textmdp.getText();
      Connection con=null;
 
     try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance ( )  ;
	           // System.out.println("driver charger");
	         }
	  catch (Exception e){System.out.println("Erreur driver:  "+e.getMessage ( ) ) ;}
     try {con =DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (Exception ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
    try { 
        String sql = "SELECT pass FROM `auth` WHERE login = ? ";
        teste = con.prepareStatement(sql);
        teste.setString(1, login );
        rs = teste.executeQuery();
        
	        }
	  catch(SQLException t){System.out.println("Erreur de Statement"+t.getMessage());}
    
   if(rs.next()){
                     
                    String motDePasse = rs.getString(1);
         
                if(motDePasse.equals(password)){
             
                    JOptionPane.showMessageDialog(this,"connexion reussie");
                    Smainint fen = new Smainint(); 
    fen.setVisible (true);
    this.setVisible(false);
                }else {
                     
                    JOptionPane.showMessageDialog(this,"mot de passe incorrecte");
                }
                }else {
                     
                    JOptionPane.showMessageDialog(this,"login incorrecte");
                }
   try{
     con.close();
     rs.close();
     teste.close();}
   catch(NullPointerException e){System.out.print("Erreur close:  "+e.getMessage ( ));}
     
     
    }
    
      
  
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gestioncons().setVisible(true);
            }
        });
    }
 
    }
 
