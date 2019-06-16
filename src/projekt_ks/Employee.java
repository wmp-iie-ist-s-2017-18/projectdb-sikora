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
public class Employee {
    
    
    private int employee_ID;
    private String login;
    private String email;
    private String first_Name;
    private String last_Name;
    private String password;
    private String position;
   // private String tel_number;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



   

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
/*
    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }
*/
    public Employee(String login, String email, String first_Name, String last_Name, String password, String position) {
        this.login = login;
        this.email = email;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.password = password;
        this.position = position;
    }

    public Employee(int employee_ID, String login, String email, String first_Name, String last_Name, String password, String position) {
        this.employee_ID = employee_ID;
        this.login = login;
        this.email = email;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.password = password;
        this.position = position;
    }


    
    
}
