package Ajoutepat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *manages all connections and operations with the table gestion.medicament
 * @author akentawi
 */
public class MedicamentService{
static void createMedicament(Medicament m){
    PreparedStatement teste = null;
    Connection con=null;
    String code =m.getCode();
    String libelle = m.getLibelle();
    String posologie = m.getPosologie();
    String indication = m.getIndication();
    
    
      try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      try{teste = con.prepareStatement("insert into medicament values(?,?,?,?)");
      teste.setString(1, code );
      teste.setString(2, libelle);
      teste.setString(3, indication );
      teste.setString(4, posologie );
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


static String getMedicamentByID(String code) throws SQLException{
    Connection con = null;
    PreparedStatement teste = null;
String s="";
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
          teste = con.prepareStatement("select * from medicament where code=?");
          teste.setString(1, code);
      rs=teste.executeQuery();
      if(rs.next())
rs.getString(1);
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