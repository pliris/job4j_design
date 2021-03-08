package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FullNameSearcher extends  SearcherFactory {
    private List<Path> pathsList = new ArrayList<>();
    private Predicate<String> filter;

    public FullNameSearcher(Predicate<String> filter, String key) {
        this.filter = s -> s.equals(filter.toString());

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (filter.test(file.toString())) {
            pathsList.add(file);
        }
        return super.visitFile(file, attrs);
    }
    @Override
    public Predicate<String> getFilter() {
        return filter;
    }

    @Override
    public void setFilter(Predicate<String> filter) {
        this.filter = filter;
    }


    public List<Path> getPaths() {
        return pathsList;
    }
}
