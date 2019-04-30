package Ajoutepat;

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

static ArrayList<ArrayList<String>> getConsultations() throws SQLException{
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
     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
     ArrayList<ArrayList<String>> s = new ArrayList<>(); 
             ArrayList<String> temp = new ArrayList<>();
            try {
               
                rsmd = rs.getMetaData();
            } catch (SQLException ex) {
              System.out.println( ex.getMessage());
            }
           
            try {
                while(rs.next()){ 
                  
                    
                    temp.add(Integer.toString(rs.getInt(1)));
                    temp.add(dateFormat.format(rs.getDate(2)));
                    temp.add(Integer.toString(rs.getInt(3)));
                    temp.add(rs.getString(4));
                    temp.add(Integer.toString(rs.getInt(5)));
                    temp.add(rs.getString(6));
                    temp.add(rs.getString(7));
                    temp.add(rs.getString(8));
                    temp.add(rs.getString(9));
                    temp.add(Integer.toString(rs.getInt(10)));
                    s.add(temp);
                    temp.clear();
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