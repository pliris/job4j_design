package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CacheFile extends Cache {
    private String key;
    private List<Path> files;
    private SoftReference<List<String>> listReferences;


    public CacheFile() throws IOException {
        this.setFiles();
    }


    /**
     * Получаем список файлов в текущей директории
     * @throws IOException исключение при попытке доступа к текущему каталогу
     */
    private void setFiles() throws IOException {
        this.files = Files.list(Path.of("")).collect(Collectors.toList());
    }

    /**
     * Получаем содержимое объекта (файла) по ключу
     * @param name ключ (искомый файл)
     * @return
     */
    @Override
    public List<String> get(String name) {
        String str;
        if ((this.key == null) || !(this.key.equals(name))) {
        if (checkFile(name)) {
            try (BufferedReader in = new BufferedReader(new FileReader(name))) {
                List<String> tempList = new ArrayList<>();
                while ((str = in.readLine()) != null) {
                    tempList.add(str);
                }
                listReferences = new SoftReference<>(tempList);
                this.key = name;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
        return this.listReferences.get();
    }

    /**
     * Проверка наличия искомого файла в каталоге
     * @param file искомый файл
     * @return истина, если файл найден
     */
    private boolean checkFile(String file) {
        boolean check = false;
        for (Path p : this.files) {
            if (p.getFileName().equals(Path.of(file))) {
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Получаем поле Объекта
     * @return Поле Объекта, содержащее информацию кэша
     */
    public SoftReference<List<String>> getListReferences() {
        return this.listReferences;
    }


    public static void main(String[] args) throws IOException {
        CacheFile cacheFile = new CacheFile();
        Scanner sc = new Scanner(System.in);
        while (!sc.equals("stop")) {
        System.out.println(cacheFile.get(sc.nextLine()));
        }

    }
}
