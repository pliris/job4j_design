package ru.job4j.srp;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReportEngine implements Report {
    private Store store;

    public HRReportEngine(MemStore store) {
        this.store = store;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder builder = new StringBuilder();
        builder.append("Name; Salary;");
        Comparator<Employee> hrComparator  = new HRComparator();
        List<Employee> list = store.findBy(filter);
        list.sort(hrComparator);
        for (Employee employee : list) {
            builder.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return builder.toString();
    }
}
