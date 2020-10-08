package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;

public class Duplicate {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("C:\\temp");
        check(start).entrySet().forEach(System.out::println);
    }
    public static Map<Path, Long> check(Path root) throws IOException {
        DuplFiles dupl = new DuplFiles();
        Files.walkFileTree(root, dupl);
        return dupl.getSet();
    }

    static class DuplFiles extends SimpleFileVisitor<Path> {
        Map<Path, Long> original = new HashMap<>();
        Map<Path, Long> duplicate = new HashMap<>();
        Long size;
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (original.containsKey(file.getFileName())) {
                size = (Long) Files.getAttribute(file, "size");
                if (size == (original.get(file.getFileName()))) {
                    duplicate.put(file.getFileName(), attrs.size());
                }

            } else {
                original.put(file.getFileName(), attrs.size());
            }
            return super.visitFile(file, attrs);
        }
        public Map<Path, Long> getSet() {
            return duplicate;
        }
    }
}
