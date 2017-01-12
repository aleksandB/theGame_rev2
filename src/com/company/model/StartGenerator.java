package com.company.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 12.12.2016.
 */
public class StartGenerator {

    private ArrayList<Integer> idSelection, temp;



    private Random randomGenerator;

    public StartGenerator(int count) {
        temp = new ArrayList<>();
        idSelection = new ArrayList<>();
        randomGenerator = new Random();
        for (int i = 1; i <= count; i++) {
            temp.add(i-1,i);
        }
        for (int i = 1; i <= count ; i++) {
            idSelection.add(anyItem());
            System.out.println(getTemp().size());
        }
        System.out.println(idSelection.size());

     }

    public Integer anyItem()
    {
        int index = randomGenerator.nextInt(getTemp().size());
        Integer item = getTemp().get(index);
        getTemp().remove(item);
        return item;
    }

    public ArrayList<Integer> getTemp() {
        return temp;
    }


    public ArrayList<Integer> getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(ArrayList<Integer> idSelection) {
        this.idSelection = idSelection;
    }

}
