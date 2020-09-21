package ru.job4j.collection;

import java.util.Objects;

public class testHash {
    int i;

    public testHash() {
    }
    public int hashCode(int i) {
        int hash  = 1;
        hash = 31 * hash + i;
        return hash;
    }

    private int bucketIndex(int hash) {
        int index;
        index = (16 - 1) & hash;
        return index;
    }

    public static void main(String[] args) {
        testHash hash1 = new testHash();
        testHash hash2 = new testHash();
        System.out.println(hash1.hashCode(1) + "hash");
        System.out.println(hash2.hashCode(2) + "hash");
        System.out.println(hash2.hashCode(3) + "hash");
        System.out.println(hash2.hashCode(4) + "hash");
        System.out.println(hash2.hashCode(5) + "hash");
        System.out.println(hash2.hashCode(6) + "hash");
        System.out.println(hash2.hashCode(7) + "hash");
        System.out.println(hash2.hashCode(8) + "hash");
        System.out.println(hash2.hashCode(9) + "hash");
        System.out.println(hash2.hashCode(22) + "hash");
        System.out.println(hash2.hashCode(45) + "hash");

        System.out.println(hash1.bucketIndex(1) + "bucket");

        System.out.println(hash2.bucketIndex(2) + "bucket");
        System.out.println(hash2.bucketIndex(3) + "bucket");
        System.out.println(hash2.bucketIndex(4) + "bucket");
        System.out.println(hash2.bucketIndex(5) + "bucket");
        System.out.println(hash2.bucketIndex(6) + "bucket");
        System.out.println(hash2.bucketIndex(7) + "bucket");
        System.out.println(hash2.bucketIndex(8) + "bucket");
        System.out.println(hash2.bucketIndex(9) + "bucket");
        System.out.println(hash2.bucketIndex(22) + "bucket");
        System.out.println(hash2.bucketIndex(45) + "bucket");






    }
}
