package projectmanager;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
    
 /*
employee_ID
first_Name
last_Name
email
password
position
activated
tel_number
activation_code
company_ID
   */
    private final IntegerProperty employee_id;
    private final StringProperty first_name;
    private final StringProperty last_name;
    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty position;
    private final StringProperty cell;
    private final IntegerProperty company_id;

    public Employee(int employee_id, String first_name, String last_name, String email, String password, String position, String cell, int company_id) {
       
        this.employee_id = new SimpleIntegerProperty(employee_id);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.position = new SimpleStringProperty(position);
        this.cell = new SimpleStringProperty(cell);
        this.company_id = new SimpleIntegerProperty(company_id);
    }

    public int get_employee_id(){
        return employee_id.get();
    }    
    
    public String get_last_name(){
        return last_name.get();
    }
    
    public String get_first_name(){
        return first_name.get();
    }
    public String get_email(){
        return email.get();
    }
    public String get_password(){
        return password.get();
    }
    public String get_position(){
        return position.get();
    }
    public String get_cell(){
        return cell.get();
    }
    public int get_company_id(){
        return company_id.get();
    }
    
  
    public void set_last_name(String value){
        last_name.set(value);
    }
    public void set_first_name(String value){
        first_name.set(value);
    }
    public void set_email(String value){
        email.set(value);
    }
    public void set_password(String value){
        password.set(value);
    }
    public void set_position(String value){
        position.set(value);
    }
    public void set_cell(String value){
        cell.set(value);
    }
    public void set_company_id(int value){
        company_id.set(value);
    }
    
    
    public IntegerProperty employee_idProperty(){
        return employee_id;
    }
        public StringProperty last_nameProperty(){
        return last_name;
    }
            public StringProperty first_nameProperty(){
        return first_name;
    }
                public StringProperty emailProperty(){
        return email;
    }
                    public StringProperty passwordProperty(){
        return password;
    }
                        public StringProperty positionProperty(){
        return position;
    }
                            public StringProperty cellProperty(){
        return cell;
    }
    
       public IntegerProperty company_idProperty(){
        return company_id;
    }
    
       
       
       
       
       
       
}
