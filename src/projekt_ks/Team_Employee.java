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
public class Team_Employee {
    
    private int employee_ID;
   
    private String first_Name;
    private String last_Name;
    private int team_id;
    private String name;
    private int leader_id;

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
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

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    public Team_Employee(int employee_ID, String first_Name, String last_Name, int team_id, String name, int leader_id) {
        this.employee_ID = employee_ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.team_id = team_id;
        this.name = name;
        this.leader_id = leader_id;
    }

    
    
}
