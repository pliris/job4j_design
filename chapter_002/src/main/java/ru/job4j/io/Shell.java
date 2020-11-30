package ru.job4j.io;

import java.nio.file.Path;

public class Shell {
    private final String tree = "/user/local/dir1/dir2";
    private String current = "/";

    public void cd(String path) {
    if (path.contains("..") || path.contains("/")) {
        int i = Path.of(current).getNameCount();
        if (i > 1) {
            this.current = current.substring(0, this.current.lastIndexOf("/"));
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

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.cd("dir1");
        System.out.println(shell.pwd());

        shell.cd("dir2");
        System.out.println(shell.pwd());
        shell.cd("..");
        System.out.println(shell.pwd());
    }
}