package ru.job4j.srp;

import java.util.function.Predicate;

public class XMLReport implements Report {
    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.0\" encoding=\"windows-1251\"?>").append(System.lineSeparator());
        text.append("<Employees>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<name>").append(employee.getName()).append("</name>").append(System.lineSeparator())
                    .append("<hired>").append(employee.getHired()).append("</hired>").append(System.lineSeparator())
                    .append("<fired>").append(employee.getFired()).append("</fired>").append(System.lineSeparator())
                    .append("<salary>").append(employee.getSalary()).append("</salary>").append(System.lineSeparator());
        }
        text.append("</Employees>");
        return text.toString();
    }
}
