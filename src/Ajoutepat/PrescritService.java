package Ajoutepat;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *manages all connections and operations with the table gestion.prescrit
 * @author akentawi
 */
public class PrescritService{

static void createPrescrit(int id,String code,int jours) throws SQLException{
    PreparedStatement teste = null;
    Connection con=null;
       
      try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      
     
      try{teste = con.prepareStatement("insert into prescrit values(?,?,?)");
      
        teste.setString(1, code);    
        teste.setInt(2, id );
        teste.setInt(3, jours);
        teste.executeUpdate();}
      
      
      catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;}
     finally{
    try {
        con.close();
    } catch (SQLException ex) {
    }
    try {
        teste.close();
    } catch (SQLException ex) {
    }

}


}



}