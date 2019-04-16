package Ajoutepat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *manages all the database connections and operations with the table gestion.consultation
 * @author akentawi
 */
public class ConsultationService{
static void createConsultation(Consultation c){
    PreparedStatement teste = null;
    Connection con=null;
    int numpat =c.getNumeroPat();
    int matr = c.getMatriculeMed();
    int num = c.getNum();
    PreparedStatement teste2 = null;
    
      try {  /*chargement du driver*/
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance() ;
	           // System.out.println("driver charger");
	         }
	  catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex)
          {System.out.println("Erreur driver:  "+ex.getMessage ( ) ) ;ex.printStackTrace();System.exit(0);}
      
      try {con =DriverManager.getConnection ("jdbc:mysql://localhost:3306/gestion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","sidahmed10") ;
	       }
	  catch (SQLException ez ){System.out.println("Erreur de connexion: "+ ez.getMessage ( ));}
       try{teste = con.prepareStatement("insert into consulte values(?,?)");
     
      teste.setInt(1, matr );
      teste.setInt(2, numpat);
     
       teste.executeUpdate();
      }
      catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;ew.printStackTrace();}
     
      try{teste2 = con.prepareStatement("insert into consultation values(now(),?,?,?)");
     
      teste2.setInt(1, matr );
      teste2.setInt(2, numpat);
     teste2.setInt(3, num);
       teste2.executeUpdate();
      }
      catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;ew.printStackTrace();}
      finally{
    try {
        con.close();
    } catch (SQLException ex) {
    }
    try {
        teste.close();
    } catch (SQLException ex) {
    }
        try {
        teste2.close();
    } catch (SQLException ex) {
    }

}


}

static String getConsultations() throws SQLException{
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
      rs=teste.executeQuery("select pr.num,date,c.matricule,m.nom,c.num_ss,p.nom,libelle,indication,posologie,jours from consultation c join patient p on p.num_ss= c.num_ss join medecin m on c.matricule=m.matricule join prescrit pr on c.num = pr.num join medicament md on pr.code=md.code\n" +
"order by pr.num");

} catch(SQLException ew){System.out.println("Erreur driver:  "+ew.getMessage ( ) ) ;}
      ResultSetMetaData rsmd =null;
     
     String s = "";
            try {
               
                rsmd = rs.getMetaData();
            } catch (SQLException ex) {
              System.out.println( ex.getMessage());
            }
           
            try {
                while(rs.next()){ 
                  
                    
                    s+="consultation numéro ";
                    s+=rs.getInt(1);
                    s+="\n ";
                    s+= rsmd.getColumnLabel(2);
                    s+=" : ";
                    s+=rs.getDate(2);
                    s+=", ";
                    s+= rsmd.getColumnLabel(3);
                    s+=": ";
                    s+=rs.getInt(3);
                    s+=", ";
                    s+= rsmd.getColumnLabel(4);
                    s+=": ";
                    s+=rs.getString(4);
                    s+=", ";
                    s+= rsmd.getColumnLabel(5);
                    s+=": ";
                    s+=rs.getInt(5);
                    s+=", ";
                    s+= rsmd.getColumnLabel(6);
                    s+=": ";
                    s+=rs.getString(6);
                    s+=", ";
                    s+= rsmd.getColumnLabel(7);
                    s+=": ";
                    s+=rs.getString(7);
                    s+=", ";
                    s+= rsmd.getColumnLabel(8);
                    s+=": ";
                    s+=rs.getString(8);
                    s+=", "; 
                    s+= rsmd.getColumnLabel(9);
                    s+=": ";
                    s+=rs.getString(9);
                    s+=", ";
                    s+= rsmd.getColumnLabel(10);
                    s+=": ";
                    s+=rs.getInt(10);
                    s+=". ";
                    s+= "\n";
                }
            } catch (SQLException ex) {
            }
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