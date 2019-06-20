/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_ks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Karol
 */
public class Projekt_KS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameLogin().setVisible(true);
               
            }
        });
        // TODO code application logic here
        /*
        String Sterownik = "com.mysql.jdbc.Driver";
         Connection conn = null;
   Statement stmt = null;
  
        try {
            Class.forName(Sterownik);
            String url = "jdbc:mysql://localhost/database";
            String user = "root";
            String pass = "";
            //Connection conn = DriverManager.getConnection(URL, USER, PASS);
            conn = DriverManager.getConnection(url, user, pass);            
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select employee.first_Name, employee.last_Name, team.name from employee, team, team_employee WHERE employee.employee_ID = team_employee.employee_ID and team.team_ID = team_employee.team_ID ;");

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
         String first = rs.getString("first_Name");
         String last = rs.getString("last_Name");
         String name = rs.getString("name");
         //Display values
         
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
         System.out.println(", Last: " + name);
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
        */
        /*
         String Sterownik = "com.mysql.jdbc.Driver";
         Connection conn = null;
   Statement stmt = null;
  
        try {
            Class.forName(Sterownik);
            String url = "jdbc:mysql://localhost/projectmanager";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(url, "root", "");
            conn = DriverManager.getConnection(url, user, pass);            
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
 String sql = "INSERT INTO employee (first_Name, last_Name, email, password, position, company_id) " +
                   "VALUES ( 'Zara', 'asd', 'sada@wp.pl', 'asdad1234', 'mis', 1)";
      stmt.executeUpdate(sql);
        System.out.println("Inserted records into the table...");
}catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        
        */
        //  InsertApp app = new InsertApp();
     
    }
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost/database";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //team id name lider id
       public void insert(String name, int leader_ID) {
        String sql = "INSERT INTO team(name, leader_ID) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, leader_ID);
           
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*
    void insert(String imie, String nazwisko, String login, String email, String haslo, String pozycja) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
