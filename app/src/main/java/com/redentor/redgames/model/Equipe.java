package com.redentor.redgames.model;

import java.io.Serializable;

public class Equipe implements Serializable {

    private String logo;
   // private int id = 0;
    private String name;
    private String description;
    private String leader;
    private String[] members;
    private int participations = 0;
    private String placing;

    public Equipe() {}

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLeader() { return leader; }

    public void setLeader(String leader) { this.leader = leader; }

    public String[] getMembers() { return members; }

    public void setMembers(String[] members) { this.members = members; }

    public int getParticipations() { return participations; }

    public void setParticipations(int participations) { this.participations = participations; }

    public String getPlacing() { return placing; }

    public void setPlacing(String placing) { this.placing = placing; }
}
