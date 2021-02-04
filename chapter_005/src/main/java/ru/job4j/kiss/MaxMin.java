package ru.job4j.kiss;


import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin<T> {

    public T max(List<T> value, Comparator<T> comparator) {
        return this.findInArray(value, (t1, t2) -> comparator.compare(t1, t2) < 0);
    }

    public T min(List<T> value, Comparator<T> comparator) {
        return this.findInArray(value, (t1, t2) -> comparator.compare(t1, t2) > 0);
    }

    private T findInArray(List<T> value, BiPredicate<T, T> predicate) {
        T current = value.get(0);
        for (T t: value) {
            if (predicate.test(current, t)) {
                current = t;
            }
        }
        return current;
    }
}