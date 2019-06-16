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
public class Team {
    
    private int team_id;
    private String name;
    private int leader_id;

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

    public Team(int team_id, String name, int leader_id) {
        this.team_id = team_id;
        this.name = name;
        this.leader_id = leader_id;
    }
    
    
    
}
