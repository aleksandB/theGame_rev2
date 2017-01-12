package com.company.view;

import javax.swing.*;

/**
 * Created by user on 28.09.2016.
 */
public class View {

    MainFrame mFrame;


    public View(){
        mFrame =new MainFrame();
        mFrame.setVisible(true);
        setmFrame(mFrame);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public MainFrame getmFrame() {
        return mFrame;
    }

    public void setmFrame(MainFrame mFrame) {
        this.mFrame = mFrame;
    }



}