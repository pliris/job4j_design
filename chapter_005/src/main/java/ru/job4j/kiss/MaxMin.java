package ru.job4j.kiss;


import java.util.Comparator;
import java.util.List;

public class MaxMin<T> {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        List<T> list = this.sort(value, comparator);
        return list.get(list.size() - 1);
    }


    public <T> T min(List<T> value, Comparator<T> comparator) {
        List<T> list = this.sort(value, comparator);
        return list.get(0);
    }


    private <T> List<T> sort(List<T> value, Comparator<T> comparator) {
        List<T> list = value;
        boolean sorted = false;
        T temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (comparator.compare(list.get(i), list.get(i + 1)) >= 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return list;
    }

//    private <T> T findInArray(List<T> value, Comparator<T> comparator, Predicate<T> predicate) {
//        T current = value.get(0);
//        for (T t: value) {
//            if (predicate.test(t)) {
//                current = t;
//            }
//        }
//    }

}