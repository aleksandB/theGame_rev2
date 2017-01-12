package com.company.view;

import com.company.data.Stat;
import com.company.data.Team;
import com.company.model.ExcelAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * Created by user on 30.11.2016.
 */
public class MainFrame extends JFrame {

    private JPanel mainPanel;
    final private JMenuBar menuBar = new JMenuBar();
    private JMenu infoMenu, sortMenu, gameMenu,finalMenu, adminMenu;
    private JMenuItem infoMenuItem, infoMenuFinalItem, infoMenuStartItem, sortMenuItem, gameMenuItem, finalMenuItem,
                      exportDBtoExcelItem, saveDBItem, reserveCopyDBItem, generateForceRankItem, restartDBItem;

    private JLabel labelInfo;
    private JTable table;

    private JButton buttonExit,buttonInfo;

    public MainFrame(){
        //Default Description of View for Main Frame
        super("mainView");

        mainPanel = new JPanel(new GridBagLayout());
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //create menus
        infoMenu = new JMenu("DB Info");
        sortMenu = new JMenu("Commands for sorting");
        gameMenu = new JMenu("Game generator");
        finalMenu = new JMenu("Status game");
        adminMenu = new JMenu("Admin panel");

        //create items;
        infoMenuItem = new JMenuItem("Commands Status");
        infoMenuItem.setActionCommand("CommandsStatus");
        infoMenuStartItem = new JMenuItem("Commands Start Status");
        infoMenuStartItem.setActionCommand("CommandsStatusStart");
        infoMenuFinalItem = new JMenuItem("Commands Status Final");
        infoMenuFinalItem.setActionCommand("CommandsStatusFinal");
        sortMenuItem = new JMenuItem("Commands for sorting");
        sortMenuItem.setActionCommand("CommandsForSorting");
        gameMenuItem = new JMenuItem("Generation");
        gameMenuItem.setActionCommand("Generation");
        finalMenuItem = new JMenuItem("Final Table Info");
        finalMenuItem.setActionCommand("FinalTableInfo");
        generateForceRankItem = new JMenuItem("Generate start teams forces and ranks");
        generateForceRankItem.setActionCommand("GenerateFR");
        saveDBItem = new JMenuItem("Save DB after generation");
        saveDBItem.setActionCommand("SaveDB");
        exportDBtoExcelItem = new JMenuItem("Export DB to Excel");
        exportDBtoExcelItem.setActionCommand("ExportDB");
        reserveCopyDBItem = new JMenuItem("Reserve copy DB");
        reserveCopyDBItem.setActionCommand("ReserveCopyDB");
        restartDBItem = new JMenuItem("Restart DB status");
        restartDBItem.setActionCommand("RestartDB");


        //add menu items
        infoMenu.add(infoMenuItem);
        infoMenu.add(infoMenuStartItem);
        infoMenu.add(infoMenuFinalItem);

        sortMenu.add(sortMenuItem);
        gameMenu.add(gameMenuItem);
        finalMenu.add(finalMenuItem);


        adminMenu.add(generateForceRankItem);
        adminMenu.add(saveDBItem);
        adminMenu.add(exportDBtoExcelItem);
        adminMenu.add(reserveCopyDBItem);
        adminMenu.add(restartDBItem);

        //add menus
        menuBar.add(infoMenu);
        menuBar.add(sortMenu);
        menuBar.add(gameMenu);
        menuBar.add(finalMenu);
        menuBar.add(adminMenu);


        //add menu to frame
        setJMenuBar(menuBar);


        String[] columns = {" "," "," "," "};
        String[][] data = new String[0][10];
        DefaultTableModel model = new DefaultTableModel(data, columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        table = new JTable(model);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1200,640));
        table.setCellSelectionEnabled(false);
        mainPanel.add(scrollPane, new GridBagConstraints(0, 0, 10, 1, 1, 0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
        buttonInfo = new JButton("OK");
        buttonInfo.setActionCommand("OK");
        buttonExit = new JButton("Exit");
        buttonExit.setActionCommand("Exit");
        buttonExit.setPreferredSize(new Dimension(150,30));
        buttonInfo.setPreferredSize(new Dimension(150,30));

        mainPanel.add(buttonInfo, new GridBagConstraints(8, 1, 1, 1, 1, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));
        mainPanel.add(buttonExit, new GridBagConstraints(9, 1, 1, 1, 0, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 0, 5, 5), 0, 0));


        getContentPane().add(mainPanel, BorderLayout.NORTH);
        labelInfo = new JLabel("Information");
        getContentPane().add(labelInfo, BorderLayout.SOUTH);

        setSize(1268, 768);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public JMenuItem[] getMenuItems() {
        JMenuItem[] items = {  infoMenuItem,     //0
                sortMenuItem,     //1
                gameMenuItem,     //2
                finalMenuItem,     //3
                infoMenuFinalItem,     //4
                generateForceRankItem,  //5
                saveDBItem,          //6
                exportDBtoExcelItem,  //7
                reserveCopyDBItem,    //8
                infoMenuStartItem,    //9
                restartDBItem,    //10

        };
        return items;
    }
    public JButton[] getButtons() {
        JButton[] buttons = { buttonInfo ,     //0
                buttonExit,     //1

        };
        return buttons;
    }

    public JLabel getLable(){
        return labelInfo;
    }

    public JTable getCurrentTable(){
        return table;
    }


//## Update Table View

    public void updateViewGlobal(List list, String str){
        System.out.println("GlobalTable");
        List<Team> listTeam = list;
        String[] columnNamesTeams = {
                "ID",
                "Name",
                "Zone",
                "Rank",
                "Championat",
                "Gold",
                "Silver",
                "Bronze",
                "Force goal",
                "Force def",
                "Force demi",
                "Force att",
        };

        System.out.println("List size " + listTeam.size());
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 12){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tbl.setColumnIdentifiers(columnNamesTeams);
        table.setModel(tbl);

        int rows = 0;
        for (Team tm : listTeam) {
            table.setValueAt(tm.getId(),rows,0);
            table.setValueAt(tm.getName(),rows,1);
            table.setValueAt(tm.getZone(),rows,2);
            table.setValueAt(tm.getRank(),rows,3);
            table.setValueAt(tm.getChamp(),rows,4);
            table.setValueAt(tm.getGold(),rows,5);
            table.setValueAt(tm.getSilver(),rows,6);
            table.setValueAt(tm.getBronze(),rows,7);
            table.setValueAt(tm.getForce_goal(),rows,8);
            table.setValueAt(tm.getForce_def(),rows,9);
            table.setValueAt(tm.getForce_demi(),rows,10);
            table.setValueAt(tm.getForce_att(),rows,11);
            rows++;
        }
        if(str.contains("Info")) {
            updateUI("Info");
        }else{
            updateUI("Save");
        }
    }

    public void updateViewStart(List list, TreeMap<Integer,Double> treeMap){
        System.out.println("StartTable");
        List<Team> listTeam = list;
        TreeMap<Integer,Double> tree = treeMap;
        System.out.println("Tree Size: " + tree.size());

        String[] columnNamesTeams = {
                "Position",
                "ID",
                "Name",
                "Zone",
                "Rank",
                "Championship",
                "Gold",
                "Silver",
                "Bronze",
                "Force goal",
                "Force def",
                "Force demi",
                "Force att",
        };

        System.out.println("List size " + listTeam.size());
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 13){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tbl.setColumnIdentifiers(columnNamesTeams);
        table.setModel(tbl);
        int rows = 0;
        int count = 1;
        for(Map.Entry<Integer, Double> pair : sortByValues(tree).entrySet()) {
            System.out.println("Key :" + pair.getKey());
            for (Team tm : listTeam) {
                if(tm.getId() == pair.getKey()) {
                    table.setValueAt(count, rows, 0);
                    table.setValueAt(tm.getId(), rows, 1);
                    table.setValueAt(tm.getName(), rows, 2);
                    table.setValueAt(tm.getZone(), rows, 3);
                    table.setValueAt(tm.getRank(), rows, 4);
                    table.setValueAt(tm.getChamp(), rows, 5);
                    table.setValueAt(tm.getGold(), rows, 6);
                    table.setValueAt(tm.getSilver(), rows, 7);
                    table.setValueAt(tm.getBronze(), rows, 8);
                    table.setValueAt(tm.getForce_goal(), rows, 9);
                    table.setValueAt(tm.getForce_def(), rows, 10);
                    table.setValueAt(tm.getForce_demi(), rows, 11);
                    table.setValueAt(tm.getForce_att(), rows, 12);
                    rows++;
                    count++;
                }
            }
        }

        updateUI("Info");

    }


    public void updateViewCompetition(List list, TreeMap<Integer,Integer> treeMap){
        System.out.println("StartTable");
        List<Team> listTeam = list;
        TreeMap<Integer,Integer> tree = treeMap;
        System.out.println("Tree Size: " + tree.size());

        String[] columnNamesTeams = {
                "Position",
                "PositionByRank",
                "ID",
                "Name",
                "Zone",
                "Rank",
                "Championship",
                "Gold",
                "Silver",
                "Bronze",
                "Force goal",
                "Force def",
                "Force demi",
                "Force att",
        };

        System.out.println("List size " + listTeam.size());
        DefaultTableModel tbl = new DefaultTableModel(list.size(), 14){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tbl.setColumnIdentifiers(columnNamesTeams);
        table.setModel(tbl);
        int rows = 0;
        int count = 1;
        for(Map.Entry<Integer, Integer> pair : tree.entrySet()) {
            System.out.println("Key :" + pair.getKey());
            for (Team tm : listTeam) {
                if(tm.getId() == pair.getValue()) {
                    table.setValueAt(count, rows, 0);
                    table.setValueAt(pair.getKey(), rows, 1);
                    table.setValueAt(tm.getId(), rows, 2);
                    table.setValueAt(tm.getName(), rows, 3);
                    table.setValueAt(tm.getZone(), rows, 4);
                    table.setValueAt(tm.getRank(), rows, 5);
                    table.setValueAt(tm.getChamp(), rows, 6);
                    table.setValueAt(tm.getGold(), rows, 7);
                    table.setValueAt(tm.getSilver(), rows, 8);
                    table.setValueAt(tm.getBronze(), rows, 9);
                    table.setValueAt(tm.getForce_goal(), rows, 10);
                    table.setValueAt(tm.getForce_def(), rows, 11);
                    table.setValueAt(tm.getForce_demi(), rows, 12);
                    table.setValueAt(tm.getForce_att(), rows, 13);
                    rows++;
                    count++;
                }
            }
        }
        updateUI("Info");

    }

    public void updateLogCompetition(List list, int stage){

        System.out.println("StartTable");
        List<Stat> listStat = list;
        if(stage == 64){
        String[] columnNamesTeams = {
                "Name Team1",
                "Rank Team1",
                "Score Team1",
                "Score Team2",
                "Name Team2",
                "Rank Team2",
                "Time",
        };

        System.out.println("List size " + listStat.size());
        DefaultTableModel tbl = new DefaultTableModel(70, 7){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tbl.setColumnIdentifiers(columnNamesTeams);
        table.setModel(tbl);
        int rows = 0;

            for (Stat st : listStat) {
                    table.setValueAt(st.getNameT1(), rows, 0);
                    table.setValueAt(st.getRankT1(), rows, 1);
                    table.setValueAt(st.getScoreT1(), rows, 2);
                    table.setValueAt(st.getScoreT2(), rows, 3);
                    table.setValueAt(st.getNameT2(), rows, 4);
                    table.setValueAt(st.getRankT2(), rows, 5);
                    table.setValueAt((st.getTime()-1), rows, 6);
                    rows++;


        }
            updateUI("Generate32");
        }

        if(stage == 32){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 32, 0);
            getCurrentTable().setValueAt("########", rows + 32, 1);
            getCurrentTable().setValueAt("########", rows + 32, 2);
            getCurrentTable().setValueAt("########", rows + 32, 3);
            getCurrentTable().setValueAt("########", rows + 32, 4);
            getCurrentTable().setValueAt("########", rows + 32, 5);
            getCurrentTable().setValueAt("########", rows + 32, 6);
            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 33, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 33, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 33, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 33, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 33, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 33, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 33, 6);
                rows++;
            }
            updateUI("Generate16");
        }

        if(stage == 16){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 49, 0);
            getCurrentTable().setValueAt("########", rows + 49, 1);
            getCurrentTable().setValueAt("########", rows + 49, 2);
            getCurrentTable().setValueAt("########", rows + 49, 3);
            getCurrentTable().setValueAt("########", rows + 49, 4);
            getCurrentTable().setValueAt("########", rows + 49, 5);
            getCurrentTable().setValueAt("########", rows + 49, 6);
            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 50, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 50, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 50, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 50, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 50, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 50, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 50, 6);
                rows++;
            }
            updateUI("Generate8");
        }
        if(stage == 8){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 58, 0);
            getCurrentTable().setValueAt("########", rows + 58, 1);
            getCurrentTable().setValueAt("########", rows + 58, 2);
            getCurrentTable().setValueAt("########", rows + 58, 3);
            getCurrentTable().setValueAt("########", rows + 58, 4);
            getCurrentTable().setValueAt("########", rows + 58, 5);
            getCurrentTable().setValueAt("########", rows + 58, 6);

            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 59, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 59, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 59, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 59, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 59, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 59, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 59, 6);
                rows++;
            }
            updateUI("Generate4");
        }
        if(stage == 4){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 63, 0);
            getCurrentTable().setValueAt("########", rows + 63, 1);
            getCurrentTable().setValueAt("########", rows + 63, 2);
            getCurrentTable().setValueAt("########", rows + 63, 3);
            getCurrentTable().setValueAt("########", rows + 63, 4);
            getCurrentTable().setValueAt("########", rows + 63, 5);
            getCurrentTable().setValueAt("########", rows + 63, 6);
            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 64, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 64, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 64, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 64, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 64, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 64, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 64, 6);
                rows++;
            }
            updateUI("Generate34");
        }
        if(stage == 2){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 66, 0);
            getCurrentTable().setValueAt("########", rows + 66, 1);
            getCurrentTable().setValueAt("########", rows + 66, 2);
            getCurrentTable().setValueAt("########", rows + 66, 3);
            getCurrentTable().setValueAt("########", rows + 66, 4);
            getCurrentTable().setValueAt("########", rows + 66, 5);
            getCurrentTable().setValueAt("########", rows + 66, 6);
            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 67, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 67, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 67, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 67, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 67, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 67, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 67, 6);
                rows++;
            }
            updateUI("Generate12");
        }
        if(stage == 1){
            int rows = 0;
            getCurrentTable().setValueAt("########", rows + 68, 0);
            getCurrentTable().setValueAt("########", rows + 68, 1);
            getCurrentTable().setValueAt("########", rows + 68, 2);
            getCurrentTable().setValueAt("########", rows + 68, 3);
            getCurrentTable().setValueAt("########", rows + 68, 4);
            getCurrentTable().setValueAt("########", rows + 68, 5);
            getCurrentTable().setValueAt("########", rows + 68, 6);
            for (Stat st : listStat) {
                getCurrentTable().setValueAt(st.getNameT1(), rows + 69, 0);
                getCurrentTable().setValueAt(st.getRankT1(), rows + 69, 1);
                getCurrentTable().setValueAt(st.getScoreT1(), rows + 69, 2);
                getCurrentTable().setValueAt(st.getScoreT2(), rows + 69, 3);
                getCurrentTable().setValueAt(st.getNameT2(), rows + 69, 4);
                getCurrentTable().setValueAt(st.getRankT2(), rows + 69, 5);
                getCurrentTable().setValueAt((st.getTime()-1), rows + 69, 6);
                rows++;
            }
            updateUI("SaveComp");
        }



    }




    public List<Team> setListByTable(List<Team> list, JTable table){
        List<Team> listTeams = new ArrayList();
        for (int i = 0; i < 64; i++) {
            for (Team tm : list) {
                if (tm.getId() == Integer.parseInt(table.getValueAt(i, 2).toString())) {
                    listTeams.add(tm);
                }
            }
        }
        System.out.println(listTeams.size());
        return listTeams;
    }

//## Update view buttons

    public void updateUI(String text){
        if(text.equals("Info")){
            buttonInfo.setText("OK");
            buttonInfo.setActionCommand("OK");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate")){
            buttonInfo.setText("Generate");
            buttonInfo.setActionCommand("Generate");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Save")){
            buttonInfo.setText("Save");
            buttonInfo.setActionCommand("SaveDB");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("SaveComp")){
            buttonInfo.setText("Save Resultats");
            buttonInfo.setActionCommand("SaveDBComp");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Restart")){
            buttonInfo.setText("RestartDB");
            buttonInfo.setActionCommand("RestartDB");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate64")){
            buttonInfo.setText("Generate64");
            buttonInfo.setActionCommand("Generate64");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate32")){
            buttonInfo.setText("Generate32");
            buttonInfo.setActionCommand("Generate32");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate16")){
            buttonInfo.setText("Generate16");
            buttonInfo.setActionCommand("Generate16");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate8")){
            buttonInfo.setText("Generate8");
            buttonInfo.setActionCommand("Generate8");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate4")){
            buttonInfo.setText("Generate4");
            buttonInfo.setActionCommand("Generate4");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate34")){
            buttonInfo.setText("Generate34");
            buttonInfo.setActionCommand("Generate34");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }
        if(text.equals("Generate12")){
            buttonInfo.setText("Generate12");
            buttonInfo.setActionCommand("Generate12");
            buttonExit.setText("Exit");
            buttonExit.setActionCommand("Exit");
        }

    }
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }


}