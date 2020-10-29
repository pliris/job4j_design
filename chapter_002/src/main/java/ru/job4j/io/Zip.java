package ru.job4j.io;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, Path target, Path directory) {
        try (FileOutputStream fileOut = new FileOutputStream(target.toString());
             BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);
             ZipOutputStream zip = new ZipOutputStream(bufferOut)) {
            for (Path source : sources) {
                if (source.toFile().isDirectory()) {
                    packFiles(Files.list(source).collect(Collectors.toList()), target, directory);
                    continue;
                } else {
                    try (FileInputStream fileIn = new FileInputStream(source.toString());
                         BufferedInputStream bufferIn = new BufferedInputStream(fileIn)) {
                        zip.putNextEntry(new ZipEntry(directory.relativize(source).toString()));
                        zip.write(bufferIn.readAllBytes());
                        zip.closeEntry();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Path> getListPaths(Path root, String exclude) throws IOException {
        SearchDirect searcher = new SearchDirect(exclude);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    static class SearchDirect implements FileVisitor<Path> {
        private List<Path> pathsList = new LinkedList<>();
        String exclude;

        SearchDirect(String exclude) {
            this.exclude = exclude;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (attrs.isDirectory()) {
                pathsList.add(dir);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!file.toFile().getName().contains(exclude)) {
                pathsList.add(file);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.SKIP_SIBLINGS;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        public List<Path> getPaths() {
            return pathsList;
        }
    }

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target.getFileName().toString())))) {
            zip.putNextEntry(new ZipEntry(source.getFileName().toString()));
            try (BufferedInputStream out = new BufferedInputStream(
                    new FileInputStream(source.toString()))) {
                zip.write(out.readAllBytes());
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        new Zip().packSingleFile(
//                Paths.get("./chapter_003/pom.xml"),
//                Paths.get("./chapter_003/pom.zip")
//        );
        Zip zip = new Zip();
        ArgZip arg = new ArgZip(args);
        if (arg.valid()) {
            List<Path> list = zip.getListPaths(Path.of(arg.directory()), arg.exclude());
            zip.packFiles(list, Path.of(arg.output()), Path.of(arg.directory()));
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }

    }
}