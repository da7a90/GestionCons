package Ajoutepat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *manages the connection and operations to the table gestion.medecin
 * @author akentawi
 */
public class MedecinService{
static void createMedecin(Medecin m){
    PreparedStatement teste = null;
    Connection con=null;
    String n =m.getNom();
    int mat = m.getMatricule();
    
      try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      try{teste = con.prepareStatement("insert into medecin values(?,?)");
      teste.setInt(1, mat );
      teste.setString(2, n);
       teste.executeUpdate();
      }
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
static ResultSet getMedecin() throws SQLException{
    Connection con = null;
    Statement teste = null;

ResultSet rs = null;
     try {  
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      try{
          teste = con.createStatement();
      rs=teste.executeQuery("select * from medecin");

} catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;}
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
return rs;
}
static int getMedecinByID(int id) throws SQLException{
    Connection con = null;
    PreparedStatement teste = null;
int s =0;
ResultSet rs = null;
     try {  
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      try{
          teste = con.prepareStatement("select * from medecin where matricule=?");
          teste.setInt(1, id);
      rs=teste.executeQuery();
      if(rs.next())
s=rs.getInt(1);
} catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;ew.printStackTrace();}
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
return s;
}
}