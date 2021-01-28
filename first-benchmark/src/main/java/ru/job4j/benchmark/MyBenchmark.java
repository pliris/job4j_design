
package ru.job4j.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(3)

public class MyBenchmark {
    String origin;
    String line;
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
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

    }


