package ru.job4j.io;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchFile {
    private ArgsSearch argsSearch;
    private String dir;
    private String include;
    private String out;
    private String argFind;

    /**
     * Конструктор, если аргументы получаем в виде массива
     * @param args массив строк Ключей с Параметрами
     */
    public SearchFile(String[] args) {
        this.argsSearch = new ArgsSearch(args);
        this.setDir();
        this.setInclude();
        this.setOut();
        this.setArgFind();
    }

    /**
     * Метод возвращает значение параметра
     * @param arg строка содержащая ключ и параметр
     * @return возращает параметр
     */
    private String getArgument(String arg) {
       return arg.substring(arg.indexOf(" "));
    }

    /**
     * Метод ищет файлы в папке и попдпаках и возвращает список совпадений
     * @param dir Корень откуда начинать искать
     * @param include что ищем (может быть: макса файла, имя файла, имя файла с расширением)
     * @return список файлов удовлетворяющих требованиям
     * @throws IOException искллючение ввода-вывода при итерации по сущностям "Path"
     */
    private List<Path> search(String dir, String include) throws IOException {
        SearcherFactory searcher  = new SearcherFactory(include, this.getArgFind());
        Files.walkFileTree(Path.of(dir), searcher);
        return searcher.getPaths();
    }

    /**
     * Записываем список файлов в файл
     * @param list список файлов, удовлетворяющих требованию
     * @param out файл в который пишем результат работы
     */

    private void writeResult(List<Path> list, String out) {
        for (Path current : list) {
            try (Writer fileWriter = new FileWriter(out, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                 bufferedWriter.write(current.toString() + System.lineSeparator());
                 bufferedWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод запускает метод записи файла в параметрах которого метод поиска
     * @throws IOException исключение ввода-вывода
     */

    public void work() throws IOException {
        writeResult(search(this.getDir(), getInclude()), getOut());
    }


    public String getDir() {
        return dir;
    }

    public void setDir() {
        this.dir = argsSearch.directory();
    }

    public String getInclude() {
        return include;
    }

    public void setInclude() {
        this.include = argsSearch.include();
    }

    public String getOut() {
        return out;
    }

    public void setOut() {
        this.out = argsSearch.out();
    }
    public String getArgFind() {
        return argFind;
    }
    public void setArgFind() {
        this.argFind = argsSearch.argFind();
    }


    public static void main(String[] args) throws IOException {
        SearchFile searchFile = new SearchFile(args);
        searchFile.work();
    }
}
