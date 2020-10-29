package ru.job4j.io;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return args.length == 6;
    }

    public String directory() {
        return args[1];
    }

    public String exclude() {
        return args[3];
    }

    public String output() {
        return args[5];
    }
}
