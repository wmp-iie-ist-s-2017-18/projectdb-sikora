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
     private static final String Sterownik = "com.mysql.jdbc.Driver";    
     
     public Connection DB_connection() 
        {
        try
        {
            String url = "jdbc:mysql://localhost/database";
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