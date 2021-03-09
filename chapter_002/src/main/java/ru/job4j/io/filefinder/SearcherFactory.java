package ru.job4j.io.filefinder;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearcherFactory extends SimpleFileVisitor<Path> {
        private List<Path> pathsList = new ArrayList<>();
        private Predicate<String> filter;

    /**
     * Конструктор Класса, который осуществляет обход дерева файлов
     * @param filter Значение (маска, имя файла, полное имя файла) по которому ищем файл(ы)
     * @param key Ключ для поиска (создания соответсвующего Предиката):
     *            -n по имени, -f по полнмоу имени файла, -m по маске файла
     */
        public SearcherFactory(String filter, String key) {
            if (key.contains("-n")) {
                this.filter = s -> s.startsWith(filter);
            }
            if (key.contains("-f")) {
                this.filter = s -> s.equals(filter);
            }
            if (key.contains("-m")) {
                Pattern pattern = Pattern.compile(filter, Pattern.CASE_INSENSITIVE);
                this.filter = pattern.asPredicate();
            }
        }

        public SearcherFactory() {
    }

    public Predicate<String> getFilter() {
        return filter;
    }

    public void setFilter(Predicate<String> filter) {
        this.filter = filter;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (filter.test(file.getFileName().toString())) {
            pathsList.add(file);
        }
        return super.visitFile(file, attrs);
    }


    public List<Path> getPaths() {
            return this.pathsList;
    }
}

