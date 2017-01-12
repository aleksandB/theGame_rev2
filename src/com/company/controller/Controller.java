package com.company.controller;

import com.company.model.DBOperator;
import com.company.model.Model;
import com.company.model.SortingModel;
import com.company.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user on 28.09.2016.
 */
public class Controller {
    private Model model;
    private View view;

    ActionListener actionListenerItems, actionListenerButtons;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

    }

    public void controll(){

///Begin controller MainForm

        actionListenerItems = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                    if (actionEvent.getActionCommand().equals("CommandsStatus")) {
                        view.getmFrame().updateViewStart(model.getTeamsList(),(new SortingModel(model.getTeamsList()).getSort()));
               //         view.getmFrame().updateViewGlobal(model.getTeamsList(),"Info");
                    }
                    if (actionEvent.getActionCommand().equals("CommandsForSorting")) {

                    }
                      if (actionEvent.getActionCommand().equals("CommandsStatusStart")) {

                          view.getmFrame().updateViewCompetition(model.getTeamsList(),(new SortingModel(view.getmFrame().getCurrentTable()).getSortStart()));
                          model.setTeamsListCompetition(view.getmFrame().setListByTable(model.getTeamsList(), view.getmFrame().getCurrentTable()));
                     }
                    if (actionEvent.getActionCommand().equals("Generation")) {
                        view.getmFrame().updateViewStart(model.getTeamsList(),(new SortingModel(model.getTeamsList()).getSort()));
                        view.getmFrame().updateViewCompetition(model.getTeamsList(),(new SortingModel(view.getmFrame().getCurrentTable()).getSortStart()));
                        model.setTeamsListCompetition(view.getmFrame().setListByTable(model.getTeamsList(), view.getmFrame().getCurrentTable()));
                        view.getmFrame().updateUI("Generate64");

       //                 model.start();

                    }
                    if (actionEvent.getActionCommand().equals("FinalTableInfo")) {

                    }
                    if (actionEvent.getActionCommand().equals("RestartDB")) {
                        view.getmFrame().updateUI("Restart");

                   }
                    if (actionEvent.getActionCommand().equals("GenerateFR")) {
                        model.startGen(model.getTeamsList());
                        view.getmFrame().updateViewGlobal(model.getTeamsListStart(),"Save");
                    }
                }
        };

        actionListenerButtons = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                if (actionEvent.getActionCommand().equals("Exit")) {
                    view.getmFrame().dispose();
                    model.getDbOperator().closeDB();
                }
                if (actionEvent.getActionCommand().equals("Generate")) {
                    view.getmFrame().updateViewCompetition(model.getTeamsList(),(new SortingModel(view.getmFrame().getCurrentTable()).getSortStart()));
                    model.setTeamsListCompetition(view.getmFrame().setListByTable(model.getTeamsList(), view.getmFrame().getCurrentTable()));
                    view.getmFrame().updateUI("Generate64");
                }
                if (actionEvent.getActionCommand().equals("Generate64")) {
                    model.start();
                    model.getChm().play64();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),64);
                }
                if (actionEvent.getActionCommand().equals("Generate32")) {
                    model.getChm().play32();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),32);
                }
                if (actionEvent.getActionCommand().equals("Generate16")) {
                    model.getChm().play16();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),16);
                }
                if (actionEvent.getActionCommand().equals("Generate8")) {
                    model.getChm().play8();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),8);
                }
                if (actionEvent.getActionCommand().equals("Generate4")) {
                    model.getChm().play4();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),4);
                }
                if (actionEvent.getActionCommand().equals("Generate34")) {
                    model.getChm().playExFinal();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),2);
                }
                if (actionEvent.getActionCommand().equals("Generate12")) {
                    model.getChm().playFinal();
                    view.getmFrame().updateLogCompetition(model.getChm().getStatList(),1);
                }
                if (actionEvent.getActionCommand().equals("SaveDB")) {
                    model.getDbOperator().sendInfoToDB(model.getTeamsListStart());
                    model.setTeamsList(model.getDbOperator().getInfoFromDB());
                }
                if (actionEvent.getActionCommand().equals("SaveDBComp")) {
                    model.getDbOperator().sendInfoToDB(model.getChm().getFinishList());
                    model.setTeamsList(model.getDbOperator().getInfoFromDB());
                    view.getmFrame().updateViewStart(model.getTeamsList(),(new SortingModel(model.getTeamsList()).getSort()));
                    view.getmFrame().updateUI("Generate");
                }
                if (actionEvent.getActionCommand().equals("RestartDB")) {
                    model.getDbOperator().restartInfoInDB(model.getTeamsList());
                    model.setTeamsList(model.getDbOperator().getInfoFromDB());
                    view.getmFrame().updateViewStart(model.getTeamsList(),(new SortingModel(model.getTeamsList()).getSort()));
                }
            }

        };


        view.getmFrame().getMenuItems()[0].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[1].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[2].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[3].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[4].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[5].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[6].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[7].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[8].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[9].addActionListener(actionListenerItems);
        view.getmFrame().getMenuItems()[10].addActionListener(actionListenerItems);
        view.getmFrame().getButtons()[0].addActionListener(actionListenerButtons);
        view.getmFrame().getButtons()[1].addActionListener(actionListenerButtons);



///End controller MainForm



    }


}