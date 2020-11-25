package ru.job4j.io;

import java.nio.file.Path;

public class Shell {
    private String tree = "/user/local";
    private String current = "/";

    public void cd(String path) {
    if (path.contains("..") || path.contains("/")) {
        int i = Path.of(current).getNameCount();
        if (i > 1) {
            this.current = current.substring(0, i - 1);
        } else {
            this.current = "/";
        }
        } else {
        this.current = this.getSubString(path);
    }
    }
    private String getSubString(String path) {
        String str = tree;
        return str.substring(0, str.lastIndexOf(path) + path.length());
    }
    public String pwd() {
        return current;
    }
}