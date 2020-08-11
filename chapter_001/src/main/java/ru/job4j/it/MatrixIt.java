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
//            while (data[row].length == 0 || column >= data[row].length) {
//                row++;
//                column = 0;
//                if (data.length == row) {
//                    break;
//                }
//            }

        while (row < data.length && column >= data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
  //      Integer num;
        if (!hasNext()) {
                throw new NoSuchElementException();
            }
//            if (data[row].length > column) {
//                num = data[row][column++];
//            } else {
//                column = 0;
//                row++;
//                num = data[row][column];
//                column++;
//            }
//            return num;
        return data[row][column++];
        }
}