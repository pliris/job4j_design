package ru.job4j.io;


public class ArgsSearch {
    private String[] args;

    public ArgsSearch(String[] args) {
        if (valid(args)) {
            this.args = args;
        } else {
            throw new IllegalArgumentException("Указаны некорректные аргументы");
        }
    }


    public static boolean valid(String[] args) {
        boolean valid = true;
        if (args.length != 6) {
            valid = false;
        }
        if (!args[0].contains("-d")) {
            valid = false;
        }
        if (!args[2].contains("-n") && !args[2].contains("-m") && !args[2].contains("-f")) {
            valid = false;
        }
        if (!args[4].contains("-o")) {
            valid = false;
        }
        return valid;
    }

    public String directory() {
        return args[1];
    }

    public String include() {
        return args[3];
    }

    public String out() {
        return args[5];
    }

    public String argFind() {
        return args[2];
    }
}
