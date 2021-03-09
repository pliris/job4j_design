package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int position;

    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    private boolean nextEven() {
        boolean even = false;
        int index;
        for (index = this.position; index < numbers.length; index++) {
            if (this.checkEven(index)) {
                this.position = index;
                even = true;
                break;
            }
        }
        return even;
    }

    private boolean checkEven(int cursor) {
        return (numbers[cursor] % 2 == 0);
    }

    @Override
    public boolean hasNext() {
        return nextEven();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[position++];
    }
}
