package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearcherFactory extends SimpleFileVisitor<Path> {
        private List<Path> pathsList = new ArrayList<>();
        private Predicate<String> filter;

        public SearcherFactory(Predicate<String> filter, String key) {
            if (key.contains("-n")) {
                new NameSearcher(filter, key);
            }
            if (key.contains("-f")) {
                this.filter = new FullNameSearcher(filter, key).getFilter();
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
        if (filter.test(file.toString())) {
            pathsList.add(file);
        }
        return super.visitFile(file, attrs);
    }


    public List<Path> getPaths() {
            return this.pathsList;
    }
}

