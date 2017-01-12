package com.company.model;

import com.company.data.Team;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sr01001 on 15/12/2016.
 */
public class Generator {

    private Team team1, team2;
    private int statusTeam1 = 0, statusTeam2 = 0;
    int schT1, schT2;
    int scoreT1 = 0, scoreT2 = 0;


    int time = 0;

    public Generator(Team team1, Team team2) {
    this.team1 = team1;
    this.team2 = team2;
        setSchT1(ThreadLocalRandom.current().nextInt(1, 7));
        setSchT2(ThreadLocalRandom.current().nextInt(1, 7));

//        System.out.println(getSchT1());
 //       System.out.println(getSchT2());

        runGen();

    }


    private void runGen(){

        while(time < 91) {
            timeGen();
        }
 //       System.out.println("Score of the match " + getScoreT1() + " ## " + getScoreT2());

        if(getScoreT1() == getScoreT2()){
            while(time < 121) {
                setStatusTeam1(0);
                setStatusTeam2(0);
                timeGen();
            }
//            System.out.println("Score of the match " + getScoreT1() + " ## " + getScoreT2());
        }

            boolean status = false;
            while (getScoreT1() == getScoreT2()) {
                if (!status) {
                    for (int i = 0; i < 5; i++) {
                        penaltuGen();
                    }
                    status = true;
                } else {
                    penaltuGen();
                }

            }

   //     System.out.println("Score of the match " + getScoreT1() + " ## " + getScoreT2());

    }

    private void penaltuGen(){
        setStatusTeam1(4);
        setStatusTeam2(-4);
        timeGen();
        setStatusTeam1(-4);
        setStatusTeam2(4);
        timeGen();
    }

    private void timeGen(){

            double scoreT1coe = coeffCalc(getSchT1(),getStatusTeam1(),getTeam1());
            double scoreT2coe = coeffCalc(getSchT2(),getStatusTeam2(),getTeam2());
  //          System.out.println("Score at time " + time + " ## " + scoreT1coe + " ## " + scoreT2coe);
            time++;


            if(scoreT1coe > scoreT2coe){
                if(getStatusTeam1() == 4 && getStatusTeam2()  == -4) {
                    setStatusTeam1(0);
                    setStatusTeam2(0);
                    setScoreT1(getScoreT1() + 1);
                }else{
                    setStatusTeam1(getStatusTeam1() + 1);
                    setStatusTeam2(getStatusTeam2() - 1);
                }
            }else if(scoreT1coe < scoreT2coe){
                if(getStatusTeam1() == -4 && getStatusTeam2()  == 4) {
                    setStatusTeam1(0);
                    setStatusTeam2(0);
                    setScoreT2(getScoreT2() + 1);
                }else{
                    setStatusTeam1(getStatusTeam1() - 1);
                    setStatusTeam2(getStatusTeam2() + 1);
                }
            }else System.out.println("##");
   //         System.out.println("Status " + getStatusTeam1() + " ## " + getStatusTeam2());

   }



    private double coeffCalc(int sch,int status, Team team){
       int schemeTa = 2 , schemeTdm = 4, schemeTdf = 4;
        double coefMult = team.getRank()/(ThreadLocalRandom.current().nextInt(-20, 20)+0.1);




            switch (sch) {
                case 1:
                    schemeTa = 3;
                    schemeTdm = 3;
                    schemeTdf = 4;
                    break;
                case 2:
                    schemeTa = 2;
                    schemeTdm = 5;
                    schemeTdf = 3;
                    break;
                case 3:
                    schemeTa = 1;
                    schemeTdm = 5;
                    schemeTdf = 4;
                    break;
                case 4:
                    schemeTa = 2;
                    schemeTdm = 4;
                    schemeTdf = 4;
                    break;
                case 5:
                    schemeTa = 4;
                    schemeTdm = 2;
                    schemeTdf = 4;
                    break;
                case 6:
                    schemeTa = 3;
                    schemeTdm = 4;
                    schemeTdf = 3;
                    break;
            }



        switch(status){
            case 4:
                return (1.0 *schemeTa * team.getForce_att() +
                        0.7 * schemeTdm * team.getForce_demi() +
                        0.3 * schemeTdf * team.getForce_def() +
                        0.0 * team.getForce_goal() +
                        coefMult);
            case 3:
                return (1.0 *schemeTa * team.getForce_att() +
                        0.7 * schemeTdm * team.getForce_demi() +
                        0.3 * schemeTdf * team.getForce_def() +
                        0.0 * team.getForce_goal() +
                        coefMult);
            case 2:
             return (1.0 *schemeTa * team.getForce_att() +
                        0.8 * schemeTdm * team.getForce_demi() +
                        0.2 * schemeTdf * team.getForce_def() +
                        0.0 * team.getForce_goal() +
                         coefMult);
            case 1:
                return (0.5 *schemeTa * team.getForce_att() +
                        1.0 * schemeTdm * team.getForce_demi() +
                        0.3 * schemeTdf * team.getForce_def() +
                        0.0 * team.getForce_goal() +
                        coefMult);
            case 0:
                 return (0.4 *schemeTa * team.getForce_att() +
                        1.0 * schemeTdm * team.getForce_demi() +
                        0.4 * schemeTdf * team.getForce_def() +
                        0.0 * team.getForce_goal() +
                         coefMult);
            case -1:
               return (0.3 *schemeTa * team.getForce_att() +
                        1.0 * schemeTdm * team.getForce_demi() +
                        0.6 * schemeTdf * team.getForce_def() +
                        0.1 * team.getForce_goal() +
                       coefMult);
            case -2:
                return (0.2 *schemeTa * team.getForce_att() +
                        0.8 * schemeTdm * team.getForce_demi() +
                        1.0 * schemeTdf * team.getForce_def() +
                        0.3 * team.getForce_goal() +
                        coefMult);
            case -3:
                return (0.3 *schemeTa * team.getForce_att() +
                        0.8 * schemeTdm * team.getForce_demi() +
                        1.0 * schemeTdf * team.getForce_def() +
                        0.2 * team.getForce_goal() +
                        coefMult);
            case -4:
                return (0.1 *schemeTa * team.getForce_att() +
                        0.6 * schemeTdm * team.getForce_demi() +
                        0.9 * schemeTdf * team.getForce_def() +
                        1.0 * team.getForce_goal() +
                        coefMult);
        }

      return 0.0;
    }





    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getStatusTeam1() {
        return statusTeam1;
    }

    public void setStatusTeam1(int statusTeam1) {
        this.statusTeam1 = statusTeam1;
    }

    public int getStatusTeam2() {
        return statusTeam2;
    }

    public void setStatusTeam2(int statusTeam2) {
        this.statusTeam2 = statusTeam2;
    }
    public int getSchT1() {
        return schT1;
    }

    public void setSchT1(int schT1) {
        this.schT1 = schT1;
    }

    public int getSchT2() {
        return schT2;
    }

    public void setSchT2(int schT2) {
        this.schT2 = schT2;
    }

    public int getScoreT1() {
        return scoreT1;
    }

    public void setScoreT1(int scoreT1) {
        this.scoreT1 = scoreT1;
    }

    public int getScoreT2() {
        return scoreT2;
    }

    public void setScoreT2(int scoreT2) {
        this.scoreT2 = scoreT2;
    }

    public int getTime() {
        return time;
    }
}
