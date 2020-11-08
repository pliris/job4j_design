package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        StringJoiner joiner = new StringJoiner(";" + System.lineSeparator());
        System.out.println("Начните диалог");
        boolean work = true;
        while (sc.hasNext()) {
            String str = sc.nextLine().strip();
                if (str.equals(STOP)) {
                    work = false;
                }
                if (str.equals(CONTINUE)) {
                    work = true;
                }
                if (str.equals(OUT)) {
                    writeDialog(this.path, joiner.toString());
                    break;
                }
                if (work) {
                    String s = getAnswers(this.botAnswers);
                    joiner.add(str);
                    joiner.add(s);
                    System.out.println(str + " - " + s);
                } else {
                    joiner.add(str);
                    System.out.println(str);
                }

        }
        }

    private void writeDialog(String path, String dialog) {
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true));) {
            bufWriter.write(dialog);
            bufWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private List<String> getListAnswers(String botAnswers) {
//        List<String> answers = null;
//        try (BufferedReader bufReader = new BufferedReader(new FileReader(botAnswers));) {
//            answers = bufReader.lines().collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return answers;
//    }

    private String getAnswers(String botAnswers) {
        List<String> answers = new ArrayList<>();
            try (BufferedReader bufReader = new BufferedReader(new FileReader(botAnswers));) {
                answers = bufReader.lines().collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            int index = (int) (Math.random() * answers.size());
            return answers.get(index);
        }


        public static void main(String[] args) {
            ConsoleChat cc = new ConsoleChat("C:\\temp\\dialog.txt", "C:\\temp\\answers.txt");
            cc.run();
        }
}
