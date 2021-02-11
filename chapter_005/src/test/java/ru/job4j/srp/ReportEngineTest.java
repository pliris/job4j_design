package ru.job4j.srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenChangeSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new SalaryEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append("$").append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Calendar lastYear = Calendar.getInstance();
        lastYear.set(2019, Calendar.FEBRUARY, 12);
        Calendar currentYear = Calendar.getInstance();
        currentYear.set(2021, Calendar.JANUARY, 2);
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee bill = new Employee("Bill", lastYear, lastYear, 200);
        Employee tina = new Employee("Tina", currentYear, currentYear, 150);
        store.add(ivan);
        store.add(bill);
        store.add(tina);
        Report engine = new HRReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(bill.getName()).append(";")
                .append(bill.getSalary()).append(";");
        expect.append(tina.getName()).append(";")
                .append(tina.getSalary()).append(";");
        expect.append(ivan.getName()).append(";")
                .append(ivan.getSalary()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
    @Test
    public void whenHTMLReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Calendar lastYear = Calendar.getInstance();
        lastYear.set(2019, Calendar.FEBRUARY, 12);
        Calendar currentYear = Calendar.getInstance();
        currentYear.set(2021, Calendar.JANUARY, 2);
        Employee ivan = new Employee("Ivan", now, now, 100);
        Employee bill = new Employee("Bill", lastYear, lastYear, 200);
        Employee tina = new Employee("Tina", currentYear, currentYear, 150);
        store.add(ivan);
        store.add(bill);
        store.add(tina);
        Report engine = new HTMLReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n"
                        + "<html>\n"
                        + " <head>\n"
                        + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                        + "  <title>Employee</title>\n"
                        + " </head>\n"
                        + " <body>\n");
        expect.append("<h1>").append(ivan.getName()).append("</h1>\n")
                        .append("<p>").append(ivan.getHired()).append("</p>\n")
                        .append("<p>").append(ivan.getFired()).append("</p>\n")
                        .append("<p>").append(ivan.getSalary()).append("</p>\n");
        expect.append("<h1>").append(bill.getName()).append("</h1>\n")
                .append("<p>").append(bill.getHired()).append("</p>\n")
                .append("<p>").append(bill.getFired()).append("</p>\n")
                .append("<p>").append(bill.getSalary()).append("</p>\n");
        expect.append("<h1>").append(tina.getName()).append("</h1>\n")
                .append("<p>").append(tina.getHired()).append("</p>\n")
                .append("<p>").append(tina.getFired()).append("</p>\n")
                .append("<p>").append(tina.getSalary()).append("</p>\n");
        expect.append("</body>\n </html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }


}