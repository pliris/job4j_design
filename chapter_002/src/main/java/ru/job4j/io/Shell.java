package ru.job4j.io;

import java.nio.file.Path;

public class Shell {
    private Path tree = Path.of("/user/local");
    private Path current = Path.of("/");

    public void cd(String path) {
    if (path.contains("..") || path.contains("/")) {
            this.tree = Path.of(path).getParent();
    }
        this.current = Path.of(this.getSubString(path));

    }
    private String getSubString(String path) {
        String str = tree.toString();
        return str.substring(0, str.lastIndexOf(path) + path.length());
    }


    public String pwd() {
        return current.toString();
    }
}