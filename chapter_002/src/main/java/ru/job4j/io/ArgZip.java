package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        return args.length == 3;
    }

    public String directory() {
        return args[0];
    }

    public String exclude() {
        return args[1];
    }

    public String output() {
        return args[2];
    }
}
