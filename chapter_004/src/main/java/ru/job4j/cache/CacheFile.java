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
     * @param key ключ (искомый файл)
     */
    @Override
    public void setObject(String key) {
        String str;
        if ((this.key == null) || !(this.key.equals(key))) {
        if (checkFile(key)) {
            try (BufferedReader in = new BufferedReader(new FileReader(key))) {
                List<String> tempList = new ArrayList<>();
                while ((str = in.readLine()) != null) {
                    tempList.add(str);
                }
                listReferences = new SoftReference<>(tempList);
                this.key = key;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
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
        while (!sc.equals("s")) {
        cacheFile.setObject(sc.nextLine());
        for (String s : cacheFile.getListReferences().get()) {
            System.out.println(s);
        }
        }

    }
}
