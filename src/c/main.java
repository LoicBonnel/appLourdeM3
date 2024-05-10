package c;

import java.sql.*;

public class main {

public static void main(String[] args) {

    try
    {
      //étape 1: charger la classe de driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      //étape 2: créer l'objet de connexion
      Connection conn = DriverManager.getConnection(
      "jdbc:mysql://192.168.1.86:8889/Fripouille", "bob", "bob");
      
      
      //étape 3: créer l'objet statement 
      Statement stmt = conn.createStatement();
      ResultSet res = stmt.executeQuery("SELECT * FROM creche");
      
      
      //étape 4: exécuter la requête
      while(res.next())
        System.out.println(res.getInt(1)+"  "+res.getString(2)
        +"  "+res.getString(3));
      
      
      //étape 5: fermer l'objet de connexion
      
      conn.close();
    }
    catch(Exception e){ 
      System.out.println(e);
    }
    
	}
 
}