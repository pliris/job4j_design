package ru.job4j.exam;

import org.openjdk.jmh.annotations.Benchmark;
import java.util.HashSet;

public class Article {
    @Benchmark
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originArr = origin.split(" ");
        String[] text = line.split(" ");
        String regex = "[!?,.;:]";
        HashSet<String> check = new HashSet<>();
        for (String strOrg : originArr) {
            strOrg = strOrg.replaceAll(regex, "");
            check.add(strOrg);
        }
        for (String strText : text) {
            if (!check.contains(strText)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
