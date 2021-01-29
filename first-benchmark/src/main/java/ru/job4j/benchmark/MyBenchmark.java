
package ru.job4j.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@State(Scope.Thread)
@Fork(2)

public class MyBenchmark {
    static String origin;
    static String line;
    boolean rsl = true;
    String[] originArr;
    String[] text;
    String regex;
    HashSet<String> check = new HashSet<>();

    //    public static void main(String[] args) throws Exception {
//        org.openjdk.jmh.Main.main(args);
//    }
    @Setup
    public void prepare() {
        origin =  "Мой дядя самых честных правил, "
                + "Когда не в шутку занемог, "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог. "
                + "Его пример другим наука; "
                + "Но, боже мой, какая скука "
                + "С больным сидеть и день и ночь, "
                + "Не отходя ни шагу прочь! "
                + "Какое низкое коварство "
                + "Полуживого забавлять, "
                + "Ему подушки поправлять, "
                + "Печально подносить лекарство, "
                + "Вздыхать и думать про себя: "
                + "Когда же черт возьмет тебя!";
        line = "Мой дядя мог думать про тебя и день и ночь";
        originArr = origin.split(" ");
        text = line.split(" ");
        regex = "[!?,.;:]";
    }


    @Benchmark
        public boolean  generateBy() {
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
        @Benchmark
        public void setOrigin() {
            for (String strOrg : originArr) {
                strOrg = strOrg.replaceAll(regex, "");
                check.add(strOrg);
            }
    }
        @State(Scope.Thread)
        public static class MyState {
        boolean rsl = true;
        String[] originArr = origin.split(" ");
        String[] text = line.split(" ");
        String regex = "[!?,.;:]";
        HashSet<String> check = new HashSet<>();
            @Setup(Level.Trial)
            public void setOriginArr() {
                for (String strOrg : originArr) {
                    strOrg = strOrg.replaceAll(regex, "");
                    check.add(strOrg);
                }
            }
        }
    @Benchmark
    public boolean checkText(MyState state) {
        for (String strText : state.text) {
                if (!state.check.contains(strText)) {
                    state.rsl = false;
                    break;
                }
            }
        return state.rsl;
    }
    }



