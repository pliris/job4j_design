package ru.job4j.ood.srp;

import java.util.List;

public class MathOperations {
    public List<Integer> sortBubble(List<Integer> value) {
            List<Integer> list = value;
            boolean sorted = false;
            Integer temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i).compareTo(list.get(i + 1)) >= 0) {
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                        sorted = false;
                    }
                }
            }
            return list;
        }


        public Integer averageArray(Integer[] array) {
                Integer sum = 0;
                for (Integer i : array) {
                    sum += i;
                }
                return  sum / array.length;
        }
    }
