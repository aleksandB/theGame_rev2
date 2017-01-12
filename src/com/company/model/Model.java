package com.company.model;

import com.company.data.Team;

import javax.swing.*;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 * Created by user on 28.09.2016.
 */
public class Model {

    private DBOperator dbOperator;
    private List<Team> teamsList;
    private List<Team> teamsListStart;
    private List<Team> teamsListCompetition;
    private ChampGen chm;


    public Model(){
       setDbOperator(new DBOperator());
       setTeamsList(dbOperator.getInfoFromDB());

        System.out.println("Lise size: " + getTeamsList().size());

    }

    public void start(){

        List<Team> random = new ArrayList<>();
        List<Integer> indexT = new StartGenerator(64).getIdSelection();

            for (int i = 0; i < 64; i++) {
                random.add(getTeamsListCompetition().get(indexT.get(i)-1));
            }
        ChampGen chamGen = new ChampGen(random);
        setChm(chamGen);
/*
        chamGen.play64();
        chamGen.play32();
        chamGen.play16();
        chamGen.play8();
        chamGen.play4();
        chamGen.playExFinal();
        chamGen.playFinal();
        System.out.println("First Test");
        */
    }


    public void startGen(List<Team> teams){
        List<Team> teamsSt = new ArrayList<>();

        for (int i = 0; i < teams.size(); i++) {
            Team team = new Team();
            team.setId(teams.get(i).getId());
            team.setName(teams.get(i).getName());
            team.setZone(teams.get(i).getZone());
            team.setRank(new BigDecimal(teams.get(i).getRank()).add(new BigDecimal(myRandom(0, 200))).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
            team.setChamp(teams.get(i).getChamp());
            team.setGold(teams.get(i).getGold());
            team.setSilver(teams.get(i).getSilver());
            team.setBronze(teams.get(i).getBronze());
            team.setForce_goal(new BigDecimal(teams.get(i).getForce_goal()).add(new BigDecimal(myRandom(0, 1))).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
            team.setForce_def(new BigDecimal(teams.get(i).getForce_def()).add(new BigDecimal(myRandom(0, 1))).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
            team.setForce_demi(new BigDecimal(teams.get(i).getForce_demi()).add(new BigDecimal(myRandom(0, 1))).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
            team.setForce_att(new BigDecimal(teams.get(i).getForce_att()).add(new BigDecimal(myRandom(0, 1))).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue());
            teamsSt.add(team);
        }

        setTeamsListStart(teamsSt);
    }

    double myRandom(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int)((max-min)*1000+1))+min*1000) / 1000.000;
    }

    public ChampGen getChm() {
        return chm;
    }

    public void setChm(ChampGen chm) {
        this.chm = chm;
    }

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }
    public DBOperator getDbOperator() {
        return dbOperator;
    }

    public void setDbOperator(DBOperator dbOperator) {
        this.dbOperator = dbOperator;
    }

    public List<Team> getTeamsListStart() {
        return teamsListStart;
    }

    public void setTeamsListStart(List<Team> teamsListStart) {
        this.teamsListStart = teamsListStart;
    }

    public List<Team> getTeamsListCompetition() {
        return teamsListCompetition;
    }

    public void setTeamsListCompetition(List<Team> teamsListCompetition) {
        this.teamsListCompetition = teamsListCompetition;
    }
}