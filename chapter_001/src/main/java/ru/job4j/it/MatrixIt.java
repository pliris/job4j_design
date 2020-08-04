package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean check = false;
        if (data.length != 0 || data[row].length != 0) {
            check = (row < data.length) | (column < data[row].length);
        }
        return check;
    }

    @Override
    public Integer next() {
        Integer num;
        if (data.length == 0 || data[row].length == 0) {
            row++;
        } else if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (data[row].length > column) {
                num = data[row][column++];
            } else {
                column = 0;
                row++;
                num = data[row][column];
                column++;
            }
            return num;
        }
}