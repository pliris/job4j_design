package ru.job4j.gc;

class GCDemo {

    private static final long KB = 1024;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.println("Free: " + freeMemory / MB);
        System.out.println("Total: " + totalMemory / MB);
        System.out.println("Max: " + maxMemory / MB);
    }

//    public static void main(String[] args) {
//        info();
//        for (int i = 0; i < 50; i++) {
//            new Person(i, "N" + i);
//        }
//        System.gc();
//        info();
//    }

}