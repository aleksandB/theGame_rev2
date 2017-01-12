package com.company.data;

/**
 * Created by user on 28.09.2016.
 */
public class Team {
    private int id;
    private String name;
    private String zone;
    private double rank;
    private int champ;
    private int gold;
    private int silver;
    private int bronze;
    private double force_goal;
    private double force_def;
    private double force_demi;
    private double force_att;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getChamp() {
        return champ;
    }

    public void setChamp(int champ) {
        this.champ = champ;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public double getForce_goal() {
        return force_goal;
    }

    public void setForce_goal(double force_goal) {
        this.force_goal = force_goal;
    }

    public double getForce_def() {
        return force_def;
    }

    public void setForce_def(double force_def) {
        this.force_def = force_def;
    }

    public double getForce_demi() {
        return force_demi;
    }

    public void setForce_demi(double force_demi) {
        this.force_demi = force_demi;
    }

    public double getForce_att() {
        return force_att;
    }

    public void setForce_att(double force_att) {
        this.force_att = force_att;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (Double.compare(team.rank, rank) != 0) return false;
        if (champ != team.champ) return false;
        if (gold != team.gold) return false;
        if (silver != team.silver) return false;
        if (bronze != team.bronze) return false;
        if (Double.compare(team.force_goal, force_goal) != 0) return false;
        if (Double.compare(team.force_def, force_def) != 0) return false;
        if (Double.compare(team.force_demi, force_demi) != 0) return false;
        if (Double.compare(team.force_att, force_att) != 0) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        return zone != null ? zone.equals(team.zone) : team.zone == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        temp = Double.doubleToLongBits(rank);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + champ;
        result = 31 * result + gold;
        result = 31 * result + silver;
        result = 31 * result + bronze;
        temp = Double.doubleToLongBits(force_goal);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(force_def);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(force_demi);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(force_att);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
