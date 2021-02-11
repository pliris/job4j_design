package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortArray {
    private ArrayList<String> list = new ArrayList<>();

    private ArrayList<String> sortArrayList(ArrayList<String> list) {
        ArrayList<String> array = list;
        Collections.sort(array);
        return array;
    }
    private LinkedList<String> sortArrayList(LinkedList<String> list) {
        LinkedList<String> array = list;
        Collections.sort(array);
        return array;
    }


    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        LinkedList<String> list = new LinkedList<>();
        sortArray.sortArrayList(list);
    }

}
