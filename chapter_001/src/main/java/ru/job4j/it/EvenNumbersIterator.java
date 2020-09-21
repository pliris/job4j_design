//package ru.job4j.it;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class EvenNumbersIterator implements Iterator<Integer> {
//    private final int[] numbers;
//    private int positionHasNext = 0;
//    private int positionNext = 0;
//
//    public EvenNumbersIterator(int[] numbers) {
//        this.numbers = numbers;
//    }
//
//    private int checkIndex(int position) {
//        boolean check = false;
//        int index;
//        while (positionHasNext < numbers.length) {
//            if (numbers[positionHasNext] % 2 == 0) {
//                check = true;
//                break;
//            }
//            positionHasNext++;
//        }
//        return index;
//    }
//
//
//
//    @Override
//    public boolean hasNext() {
//        boolean check = false;
//        if (positionNext < positionHasNext) {
//            return true;
//        }
//        while (positionHasNext < numbers.length) {
//            if (numbers[positionHasNext] % 2 == 0) {
//                check = true;
//                break;
//            }
//            positionHasNext++;
//        }
//        return check;
//    }
//
//    @Override
//    public Integer next() {
////        Integer num = 0;
////        while (positionNext < numbers.length) {
////            if (numbers[positionNext] % 2 == 0) {
////                num = numbers[positionNext];
////                break;
////            }
////            positionNext++;
////        }
////        if (positionNext == numbers.length) {
////            throw new NoSuchElementException();
////        }
////        positionNext++;
////        return num;
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        return numbers[positionNext++];
//    }
//}
