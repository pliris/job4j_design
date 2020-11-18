package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;



    private List<String> answers;
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
        setAnswers(this.botAnswers);
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
                    String s = getAnswer();
                    joiner.add(str);
                    joiner.add(s);
                    System.out.println(str + " - " + s);
                } else {
                    joiner.add(str);
                    System.out.println(str);
                }
        }
        }

    /**
     * Метод записывает диалог в файл
     * @param path путь до файла в который записывается диалог
     * @param dialog диалог который требуется записать
     */
    private void writeDialog(String path, String dialog) {
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true));) {
            bufWriter.write(dialog);
            bufWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создаёт список ответов бота
     * @param botAnswers путь до файла с ответами бота
     */
    private void setAnswers(String botAnswers) {
        try (BufferedReader bufReader = new BufferedReader(new FileReader(botAnswers));) {
            this.answers = bufReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает ответ бота
     * @return возвращает случайный ответ бота
     */
    private String getAnswer() {
            int index = (int) (Math.random() * this.answers.size());
            return this.answers.get(index);
        }


        public static void main(String[] args) {
            ConsoleChat cc = new ConsoleChat("C:\\temp\\dialog.txt", "C:\\temp\\answers.txt");
            cc.run();
        }
}
