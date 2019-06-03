package projectmanager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLLoginController implements Initializable {
    
     @FXML
    private Button login_button;
     @FXML
    private Button register;
     @FXML
    private TextField mailField;
     @FXML
    private PasswordField passField;
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    @FXML
    private void login(ActionEvent event) throws IOException {
        
        Parent login_parent = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        Scene scena = new Scene(login_parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        if (credentials()) {
            window.setScene(scena);
            window.show();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Logowanie pomyślne");
            alert.showAndWait();
        } else {
          Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Logowanie");
            alert.setHeaderText(null);
            alert.setContentText("Login/hasło nieprawidłowe!");
            alert.showAndWait();
        }
    }
    
     @FXML
    private void registerButton(ActionEvent event) throws IOException {

      
    }
    
    private boolean credentials() {
        //  private String MYSQL_URL = "jdbc:mysql://localhost:3306/test";
        String DRIVER = "com.mysql.jdbc.Driver";
        boolean correct = false;
        Connection c = null;
        Statement stmt = null; 
        
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost/project";
            String user = "root";
            String pass = "";
            //Connection conn = DriverManager.getConnection(URL, USER, PASS);
            c = DriverManager.getConnection(url, user, pass);            
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE email= " + "'" + mailField.getText() + "'" + " AND password= " + "'" + passField.getText() + "'");

            while (rs.next()) {
                if (rs.getString("email") != null && rs.getString("password") != null) {
                    correct = true;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return correct;

    }
    
    
    
}
