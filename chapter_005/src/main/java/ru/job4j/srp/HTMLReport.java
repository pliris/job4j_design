package ru.job4j.srp;

import java.util.function.Predicate;

public class HTMLReport implements Report {
    private Store store;

    public HTMLReport(MemStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n"
                + "<html>\n"
                + " <head>\n"
                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                + "  <title>Employee</title>\n"
                + " </head>\n"
                + " <body>\n");
        for (Employee employee : store.findBy(filter)) {
            text.append("<h1>").append(employee.getName()).append("</h1>\n")
                    .append("<p>").append(employee.getHired()).append("</p>\n")
                    .append("<p>").append(employee.getFired()).append("</p>\n")
                    .append("<p>").append(employee.getSalary()).append("</p>\n");
        }
        text.append("</body>\n </html>");
        return text.toString();
    }
}
