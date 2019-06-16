/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_ks;

/**
 *
 * @author Karol
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_connect {
     private static final String Sterownik = "com.mariadb.jdbc.Driver";    
     
     public Connection DB_connection() 
//Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
//jdbc:mysql://localhost:3306/db?user=someUser&disableMariaDbDriver

        {
        try
        {
            String url = "jdbc:mariadb://localhost:3306/database?user=root&password=";
            String user = "root";
            String password = "";

            Class.forName(Sterownik);
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
              System.out.println("Error: unable to load driver class!");
              System.exit(1);
        }
        return null;
    
}
     
     
}