package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;

public class CacheFile extends Cache {
    private Map<String, SoftReference<String>> referenceMap = new HashMap<>();

    /**
     * Метод возращает кэш содержимого файла name
     * @param name имя файла содержимое которого требуептся получить
     * @return содержимое файла в виде строки, которое содержится в HashMap в значении
     */
    @Override
    public String get(String name) {
        File file = new File(name);
        String temp = null;
        if (this.referenceMap.containsKey(name)) {
            temp = this.referenceMap.get(name).get();
        }
        if (file.exists() && temp == null) {
            this.writeFile(name);
        }
        return this.referenceMap.get(name).get();
    }

    /**
     * Метод читает содержимое файла и добавляет в HashMap ключ - Имя файла и значение - Содержимое файла
     * @param name Имя файла
     */
    private void writeFile(String name) {
        StringBuilder sb = new StringBuilder();
        String temp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            while ((temp = bufferedReader.readLine()) != null) {
                sb.append(temp);
            }
            SoftReference<String> str = new SoftReference<>(sb.toString());
            this.referenceMap.put(name, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        CacheFile cacheFile = new CacheFile();
        Scanner sc = new Scanner(System.in);
        while (!sc.equals("stop")) {
        System.out.println(cacheFile.get(sc.nextLine()));
        }
    }
}
