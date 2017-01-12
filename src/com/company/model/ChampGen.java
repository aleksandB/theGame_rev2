package com.company.model;

import com.company.data.Stat;
import com.company.data.Team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ChampGen {

    private List<Team> startList64, startList32, startList16, startList8, startList4, startExFinal, startFinal, finishList;
    private List<Stat> statList;

    private double sum64=0.0, sum32=0.0,sum16=0.0,sum8=0.0,sum4=0.0;

    public ChampGen(List<Team> teamList) {

        setStartList64(teamList);
        setSum64(getSummTotal(getStartList64()));
        System.out.println(getSum64());

    }

    public void play64(){

        List<Team> teams32 = new ArrayList<>(),teamsFin = new ArrayList<>();
        List<Stat> statListT = new ArrayList<>();

        for (int i = 0; i < getStartList64().size(); i=i+2) {
            Team team1 = getStartList64().get(i);
            Team team2 = getStartList64().get(i+1);
            Stat stat1 = new Stat();
            Generator gen = new Generator(team1, team2);
            stat1.setNameT1(team1.getName().trim());
            stat1.setRankT1(String.valueOf(team1.getRank()));
            stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
            stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
            stat1.setRankT2(String.valueOf(team2.getRank()));
            stat1.setNameT2(team2.getName().trim());
            stat1.setTime(gen.getTime());
            statListT.add(stat1);
            System.out.println(team1.getName().trim() + "(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
            if(gen.getScoreT1()>gen.getScoreT2()){
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),64,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 64, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setChamp(team2.getChamp()+1);
                teamsFin.add(team2);
                teams32.add(team1);
            }else{
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),64,false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setChamp(team1.getChamp()+1);
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(),team1.getRank(),64,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsFin.add(team1);
                teams32.add(team2);
            }
        }
        int count = 1;
        System.out.println("Teams32 ");
        setFinishList(teamsFin);
        setStartList32(teams32);
        setStatList(statListT);
        System.out.println("Stat list size: " + statListT.size());
        for (Team tm:getStartList32()) {
            System.out.println("N " + count + " Name " + tm.getName());
            count++;
        }
        System.out.println("Teams out " + getFinishList().size());
        setSum32(getSummTotal(teams32));
        System.out.println(getSum32());
    }

    public void play32(){
        List<Team> teams16 = new ArrayList<>(),teamsFin = getFinishList() ;
        List<Stat> statListT = new ArrayList<>();
        for (int i = 0; i < getStartList32().size(); i=i+2) {
            Team team1 = getStartList32().get(i);
            Team team2 = getStartList32().get(i+1);
            Stat stat1 = new Stat();
            Generator gen = new Generator(team1, team2);
            stat1.setNameT1(team1.getName().trim());
            stat1.setRankT1(String.valueOf(team1.getRank()));
            stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
            stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
            stat1.setRankT2(String.valueOf(team2.getRank()));
            stat1.setNameT2(team2.getName().trim());
            stat1.setTime(gen.getTime());
            statListT.add(stat1);
            System.out.println(team1.getName().trim() +"(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
            if(gen.getScoreT1()>gen.getScoreT2()){
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),32,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 32, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setChamp(team2.getChamp() + 1);
                teamsFin.add(team2);
                teams16.add(team1);
            }else{
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),32,false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setChamp(team1.getChamp()+1);
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(),team1.getRank(),32,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsFin.add(team1);
                teams16.add(team2);
            }
        }
        int count = 1;
        System.out.println("Teams16 ");
        setFinishList(teamsFin);
        setStartList16(teams16);
        setStatList(statListT);
        for (Team tm:getStartList16()) {
            System.out.println("N " + count + " Name " + tm.getName());
            count++;
        }
        System.out.println("Teams out " + getFinishList().size());
        setSum16(getSummTotal(teams16));
        System.out.println(getSum16());
    }

    public void play16(){
        List<Team> teams8 = new ArrayList<>(),teamsFin = getFinishList() ;
        List<Stat> statListT = new ArrayList<>();
        for (int i = 0; i < getStartList16().size(); i=i+2) {
            Team team1 = getStartList16().get(i);
            Team team2 = getStartList16().get(i+1);
            Stat stat1 = new Stat();
            Generator gen = new Generator(team1, team2);
            stat1.setNameT1(team1.getName().trim());
            stat1.setRankT1(String.valueOf(team1.getRank()));
            stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
            stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
            stat1.setRankT2(String.valueOf(team2.getRank()));
            stat1.setNameT2(team2.getName().trim());
            stat1.setTime(gen.getTime());
            statListT.add(stat1);
            System.out.println(team1.getName().trim()+"(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
            if(gen.getScoreT1()>gen.getScoreT2()){
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),16,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 16, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setChamp(team2.getChamp() + 1);
                teamsFin.add(team2);
                teams8.add(team1);
            }else{
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),16,false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setChamp(team1.getChamp()+1);
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(),team1.getRank(),16,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsFin.add(team1);
                teams8.add(team2);
            }
        }
        int count = 1;
        System.out.println("Teams8 ");
        setFinishList(teamsFin);
        setStartList8(teams8);
        setStatList(statListT);
        for (Team tm:getStartList8()) {
            System.out.println("N " + count + " Name " + tm.getName());
            count++;
        }
        System.out.println("Teams out " + getFinishList().size());
        setSum8(getSummTotal(teams8));
        System.out.println(getSum8());
    }
    public void play8(){
        List<Team> teams4 = new ArrayList<>(),teamsFin = getFinishList() ;
        List<Stat> statListT = new ArrayList<>();
        for (int i = 0; i < getStartList8().size(); i=i+2) {
            Team team1 = getStartList8().get(i);
            Team team2 = getStartList8().get(i+1);
            Stat stat1 = new Stat();
            Generator gen = new Generator(team1, team2);
            stat1.setNameT1(team1.getName().trim());
            stat1.setRankT1(String.valueOf(team1.getRank()));
            stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
            stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
            stat1.setRankT2(String.valueOf(team2.getRank()));
            stat1.setNameT2(team2.getName().trim());
            stat1.setTime(gen.getTime());
            statListT.add(stat1);
            System.out.println(team1.getName().trim()+"(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
            if(gen.getScoreT1()>gen.getScoreT2()){
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),8,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 8, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setChamp(team2.getChamp() + 1);
                teamsFin.add(team2);
                teams4.add(team1);
            }else{
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(),team2.getRank(),8,false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setChamp(team1.getChamp()+1);
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(),team1.getRank(),8,true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsFin.add(team1);
                teams4.add(team2);
            }
        }
        int count = 1;
        System.out.println("Teams4 ");
        setFinishList(teamsFin);
        setStartList4(teams4);
        setStatList(statListT);
        for (Team tm:getStartList4()) {
            System.out.println("N " + count + " Name " + tm.getName());
            count++;
        }
        System.out.println("Teams out " + getFinishList().size());
        setSum4(getSummTotal(teams4));
        System.out.println(getSum4());
    }

    public void play4(){
        List<Team> teamsEx = new ArrayList<>(),teamsFinal = new ArrayList<>() ;
        List<Stat> statListT = new ArrayList<>();
        for (int i = 0; i < getStartList4().size(); i=i+2) {
            Team team1 = getStartList4().get(i);
            Team team2 = getStartList4().get(i+1);
            Stat stat1 = new Stat();
            Generator gen = new Generator(team1, team2);
            stat1.setNameT1(team1.getName().trim());
            stat1.setRankT1(String.valueOf(team1.getRank()));
            stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
            stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
            stat1.setRankT2(String.valueOf(team2.getRank()));
            stat1.setNameT2(team2.getName().trim());
            stat1.setTime(gen.getTime());
            statListT.add(stat1);
            System.out.println(team1.getName().trim()+"(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
            if(gen.getScoreT1()>gen.getScoreT2()){
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 4, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 4, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsEx.add(team2);
                teamsFinal.add(team1);
            }else{
                team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 4, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.001*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 4, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
                teamsEx.add(team1);
                teamsFinal.add(team2);
            }
        }
        int count = 1;
        System.out.println("Teams4 ");
        setStartExFinal(teamsEx);
        setStartFinal(teamsFinal);
        setStatList(statListT);
        for (Team tm:getStartExFinal()) {
            System.out.println("N " + count + " Name " + tm.getName());
            count++;
        }
        int countF = 1;
        for (Team tm : getStartFinal()) {
            System.out.println("N " + countF + " Name " + tm.getName());
            countF++;
        }
    }
    public void playExFinal(){
        List<Team> teamsFin = getFinishList() ;
        List<Stat> statListT = new ArrayList<>();
        Team team1 = getStartExFinal().get(0);
        Team team2 = getStartExFinal().get(1);
        Stat stat1 = new Stat();
        Generator gen = new Generator(team1, team2);
        stat1.setNameT1(team1.getName().trim());
        stat1.setRankT1(String.valueOf(team1.getRank()));
        stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
        stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
        stat1.setRankT2(String.valueOf(team2.getRank()));
        stat1.setNameT2(team2.getName().trim());
        stat1.setTime(gen.getTime());
        statListT.add(stat1);
        System.out.println(team1.getName().trim() + "(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
        if(gen.getScoreT1()>gen.getScoreT2()){
            System.out.println("4 place " + team2.getName());
            System.out.println("3 place " + team1.getName());
            team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 2, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setChamp(team1.getChamp() + 1);
            team1.setBronze(team1.getBronze() + 1);
            team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 2, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setChamp(team2.getChamp() + 1);
            teamsFin.add(team1);
            teamsFin.add(team2);
        }else{
            System.out.println("4 place " + team1.getName());
            System.out.println("3 place " + team2.getName());
            team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 2, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.01*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setChamp(team1.getChamp() + 1);
            team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 2, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setChamp(team2.getChamp() + 1);
            team2.setBronze(team2.getBronze() + 1);
            teamsFin.add(team1);
            teamsFin.add(team2);
        }
        setFinishList(teamsFin);
        setStatList(statListT);
    }
    public void playFinal(){
        List<Team> teamsFin = getFinishList() ;
        List<Stat> statListT = new ArrayList<>();
        Team team1 = getStartFinal().get(0);
        Team team2 = getStartFinal().get(1);
        Stat stat1 = new Stat();
        Generator gen = new Generator(team1, team2);
        stat1.setNameT1(team1.getName().trim());
        stat1.setRankT1(String.valueOf(team1.getRank()));
        stat1.setScoreT1(String.valueOf(gen.getScoreT1()));
        stat1.setScoreT2(String.valueOf(gen.getScoreT2()));
        stat1.setRankT2(String.valueOf(team2.getRank()));
        stat1.setNameT2(team2.getName().trim());
        stat1.setTime(gen.getTime());
        statListT.add(stat1);
        System.out.println(team1.getName().trim() + "(" + team1.getRank() + ")" + " ## " + gen.getScoreT1() + " : " + gen.getScoreT2() + " ## " + team2.getName().trim() + "(" + team2.getRank() + ")");
        if(gen.getScoreT1()>gen.getScoreT2()){
            System.out.println("2 place " + team2.getName());
            System.out.println("1 place " + team1.getName());
            team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 1, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.15*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.15*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.15*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.15*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setChamp(team1.getChamp() + 1);
            team1.setGold(team1.getGold() + 1);
            team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 1, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.05*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setChamp(team2.getChamp() + 1);
            team2.setSilver(team2.getSilver()+1);
            teamsFin.add(team1);
            teamsFin.add(team2);
        }else{
            System.out.println("2 place " + team1.getName());
            System.out.println("1 place " + team2.getName());
            team1.setRank(new BigDecimal(team1.getRank()).add(new BigDecimal(setRanking(team1.getRank(), team2.getRank(), 1, false))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_goal(new BigDecimal(team1.getForce_goal()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_def(new BigDecimal(team1.getForce_def()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_demi(new BigDecimal(team1.getForce_demi()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setForce_att(new BigDecimal(team1.getForce_att()).add(new BigDecimal(myRandom(0, 0.05*team1.getRank()/team2.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team1.setChamp(team1.getChamp() + 1);
            team1.setSilver(team1.getSilver()+1);
            team2.setRank(new BigDecimal(team2.getRank()).add(new BigDecimal(setRanking(team2.getRank(), team1.getRank(), 1, true))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_goal(new BigDecimal(team2.getForce_goal()).add(new BigDecimal(myRandom(0, 0.15*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_def(new BigDecimal(team2.getForce_def()).add(new BigDecimal(myRandom(0, 0.15*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_demi(new BigDecimal(team2.getForce_demi()).add(new BigDecimal(myRandom(0, 0.15*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setForce_att(new BigDecimal(team2.getForce_att()).add(new BigDecimal(myRandom(0, 0.15*team2.getRank()/team1.getRank()))).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue());
            team2.setChamp(team2.getChamp() + 1);
            team2.setGold(team2.getGold() + 1);
            teamsFin.add(team1);
            teamsFin.add(team2);
        }
        setFinishList(teamsFin);
        setStatList(statListT);
        System.out.println("Teams out " + getFinishList().size());
    }
    public List<Team> getStartList64() {
        return startList64;
    }

    public List<Team> getStartList32() {
        return startList32;
    }
    public List<Team> getStartList16() {
        return startList16;
    }
    public List<Team> getStartList8() {
        return startList8;
    }
    public List<Team> getStartList4() {
        return startList4;
    }
    public List<Team> getFinishList() {
        return finishList;
    }
    public void setFinishList(List<Team> finishList) {
        this.finishList = finishList;
    }
    public void setStartList64(List<Team> startList64) {
        this.startList64 = startList64;
    }
    public void setStartList32(List<Team> startList32) {
        this.startList32 = startList32;
    }
    public void setStartList16(List<Team> startList16) {
        this.startList16 = startList16;
    }
    public void setStartList8(List<Team> startList8) {
        this.startList8 = startList8;
    }
    public void setStartList4(List<Team> startList4) {
        this.startList4 = startList4;
    }
    public List<Team> getStartExFinal() {
        return startExFinal;
    }
    public void setStartExFinal(List<Team> startExFinal) {
        this.startExFinal = startExFinal;
    }
    public List<Team> getStartFinal() {
        return startFinal;
    }
    public void setStartFinal(List<Team> startFinal) {
        this.startFinal = startFinal;
    }
    private double getSummTotal(List<Team> teams){
        double summ = 0;
        for (Team tm:teams) {
            summ = new BigDecimal(summ).add(new BigDecimal(tm.getRank())).doubleValue();
        }
        return summ;
    }

    public double getSum64() {
        return sum64;
    }
    public void setSum64(double sum64) {
        this.sum64 = sum64;
    }
    public double getSum32() {
        return sum32;
    }
    public void setSum32(double sum32) {
        this.sum32 = sum32;
    }

    public double getSum16() {
        return sum16;
    }

    public void setSum16(double sum16) {
        this.sum16 = sum16;
    }
    public double getSum8() {
        return sum8;
    }
    public void setSum8(double sum8) {
        this.sum8 = sum8;
    }
    public double getSum4() {
        return sum4;
    }
    public void setSum4(double sum4) {
        this.sum4 = sum4;
    }
    public double myRandom(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int)((max-min)*1000+1))+min*1000) / 1000.000;
    }
    public double setRanking(double rank1, double rank2, int stage, boolean status) {
        switch (stage) {
            case 64:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+getSum64()/(stage*4*(rank1+rank2));
                }else{
                    double a= -Math.abs((rank1+rank2)/getSum64()*getSum64()/rank2)+getSum64()/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 32:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32())/(stage*4*(rank1+rank2));
                }else{
                    double a = -Math.abs((rank1+rank2)/getSum32()*getSum32()/rank2)+(getSum64()+getSum32())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 16:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32()+getSum16())/(stage*4*(rank1+rank2));
                }else{
                    double a =  -Math.abs((rank1+rank2)/getSum16()*getSum16()/rank2)+(getSum64()+getSum32()+getSum16())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 8:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32()+getSum16()+getSum8())/(stage*4*(rank1+rank2));
                }else{
                    double a = -Math.abs((rank1+rank2)/getSum8()*getSum8()/rank2)+(getSum64()+getSum32()+getSum16()+getSum8())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 4:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*4*(rank1+rank2));
                }else{
                    double a = -Math.abs((rank1+rank2)/getSum4()*getSum4()/rank2)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 2:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*4*(rank1+rank2));
                }else{
                    double a = -Math.abs((rank1+rank2)/getSum4()*getSum4()/rank2)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
            case 1:
                if(status){
                    return Math.abs((rank1+rank2)/rank1)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*4*(rank1+rank2));
                }else{
                    double a = -Math.abs((rank1+rank2)/getSum4()*getSum4()/rank2)+(getSum64()+getSum32()+getSum16()+getSum8()+getSum4())/(stage*(rank1+rank2));
                    if ((rank1 + a) < 0 ) return 1.0;
                    else return a;
                }
        }
        return 0.0;

    }

    public List<Stat> getStatList() {
        return statList;
    }

    public void setStatList(List<Stat> statList) {
        this.statList = statList;
    }
}