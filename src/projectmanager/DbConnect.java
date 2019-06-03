package projectmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnect {
     private static final String Sterownik = "com.mysql.jdbc.Driver";    
     
     public Connection DbConnection() 
        {
        try
        {
            String url = "jdbc:mysql://localhost/project";
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