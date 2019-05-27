package com.redentor.redgames.model;

public class Equipe {

    private String logo;
    private String name;
    private String description;
    private String leaderName;
    private String memberNames;
    private int numberParticipations;
    private int placing;

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

    public String getLeaderName() { return leaderName; }

    public void setLeaderName(String leaderName) { this.leaderName = leaderName; }

    public String getMemberNames() { return memberNames; }

    public void setMemberNames(String memberNames) { this.memberNames = memberNames; }

    public int getNumberParticipations() { return numberParticipations; }

    public void setNumberParticipations(int numberParticipations) { this.numberParticipations = numberParticipations; }

    public int getPlacing() { return placing; }

    public void setPlacing(int placing) { this.placing = placing; }
}
