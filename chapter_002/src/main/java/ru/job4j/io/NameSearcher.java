package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NameSearcher extends SearcherFactory {
    private List<Path> pathsList = new ArrayList<>();
    private Predicate<String> filter;

    public NameSearcher(Predicate<String> filter, String key) {
        this.filter = s -> s.startsWith(filter.toString());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (filter.test(file.toString())) {
            pathsList.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getPaths() {
        return pathsList;
    }
}
