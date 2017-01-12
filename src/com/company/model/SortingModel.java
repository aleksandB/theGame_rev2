package com.company.model;

import com.company.data.Team;


import javax.swing.*;

import java.util.*;

/**
 * Created by user on 15.12.2016.
 */
public class SortingModel {

    private TreeMap<Integer, Double> sort;
    private TreeMap<Integer, Integer> sortStart;


    public SortingModel(List<Team> list) {
        TreeMap<Integer,Double> tree = new TreeMap<>();

        for(int i = 0; i< list.size(); i++)
        {
            tree.put(list.get(i).getId(),list.get(i).getRank());
        }

        setSort(tree);
    }

    public SortingModel(JTable table){
        TreeMap<Integer,Integer> treeSort = new TreeMap<>();
        StartGenerator stGen1 = new StartGenerator(31);
        StartGenerator stGen2 = new StartGenerator(47);
        StartGenerator stGen3 = new StartGenerator(118);


        for (int i = 0; i <16 ; i++) {
            treeSort.put((int)table.getValueAt(i, 0),(int)table.getValueAt(i, 1));
            System.out.println(table.getValueAt(i, 0) + " ## " + table.getValueAt(i, 1));

        }

        for (int i = 0; i <16 ; i++) {
            treeSort.put((int)table.getValueAt(stGen1.getIdSelection().get(i) + 16, 0),(int)table.getValueAt(stGen1.getIdSelection().get(i) + 16, 1));


        }
        for (int i = 0; i <16 ; i++) {
            treeSort.put((int)table.getValueAt(stGen2.getIdSelection().get(i) + 48, 0),(int)table.getValueAt(stGen2.getIdSelection().get(i) + 48, 1));

        }
        for (int i = 0; i <16 ; i++) {
            treeSort.put((int)table.getValueAt(stGen3.getIdSelection().get(i) + 96, 0),(int)table.getValueAt(stGen3.getIdSelection().get(i) + 96, 1));

        }
        setSortStart(treeSort);
    }


    public void sortingStartTable(List<Team> list){

    }

    public static void printMap(Map<Integer, Double> map)
    {
        for (Map.Entry<Integer, Double> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }


    public TreeMap<Integer, Double> getSort() {
        return sort;
    }

    public void setSort(TreeMap<Integer, Double> sort) {
        this.sort = sort;
    }

    public TreeMap<Integer, Integer> getSortStart() {
        return sortStart;
    }

    public void setSortStart(TreeMap<Integer, Integer> sortStart) {
        this.sortStart = sortStart;
    }
}
