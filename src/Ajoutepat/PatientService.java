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
 *manages all the connections and operations to the table gestion.patient
 * @author akentawi
 */
public class PatientService{
static void createPatient(Patient p){
    PreparedStatement teste = null;
    Connection con=null;
    String nom =p.getNom();
    int num = p.getNumss();
    
      try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
      try{teste = con.prepareStatement("insert into patient values(?,?)");
      teste.setInt(1, num );
      teste.setString(2, nom);
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

static String getPatients() throws SQLException{
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
      rs=teste.executeQuery("select * from patient");

} catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;}
      
      
      
     ResultSetMetaData rsmd =null;
     
     String s = "";
            try {
               
                rsmd = rs.getMetaData();
            } catch (SQLException ex) {
              System.out.println( ex.getMessage());
            }

            try {
                int i = 1;
                while(rs.next()){
                    s+="patient numéro "+i;
                    s+="\n";
                    s+= rsmd.getColumnName(1);
                    s+= " : ";
                    s+=rs.getInt(1);
                    s+=", ";
                    s+= rsmd.getColumnName(2);
                    s+= " : ";
                    s+=rs.getString(2);
                    s+="\n";
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Smainint.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
        try {
           rs.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(Smainint.class.getName()).log(Level.SEVERE, null, ex);
        }
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
static int getPatientByID(int id) throws SQLException{
    Connection con = null;
    PreparedStatement teste = null;
int s=0;
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
          teste = con.prepareStatement("select * from patient where num_ss=?");
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