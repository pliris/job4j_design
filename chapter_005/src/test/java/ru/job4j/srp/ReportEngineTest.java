package ru.job4j.srp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.gson.Gson;
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
    @Test
    public void whenJSONReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Calendar lastYear = Calendar.getInstance();
        lastYear.set(2019, Calendar.FEBRUARY, 12);
        Calendar currentYear = Calendar.getInstance();
        currentYear.set(2021, Calendar.JANUARY, 2);
        Employee ivan = new Employee("Ivan", now, now, 100);
        store.add(ivan);
        Report engine = new JSONReport(store);
        String iStr = "{\"name\":\"" + ivan.getName()
                + "\",\"hired\":{\"year\":" + ivan.getHired().get(Calendar.YEAR)
                + ",\"month\":" + ivan.getHired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":" + ivan.getHired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":" + ivan.getHired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":" + ivan.getHired().get(Calendar.MINUTE)
                + ",\"second\":" + ivan.getHired().get(Calendar.SECOND)
                + "},\"fired\":"
                + "{\"year\":" + ivan.getFired().get(Calendar.YEAR)
                + ",\"month\":" + ivan.getFired().get(Calendar.MONTH)
                + ",\"dayOfMonth\":" + ivan.getFired().get(Calendar.DAY_OF_MONTH)
                + ",\"hourOfDay\":" + ivan.getFired().get(Calendar.HOUR_OF_DAY)
                + ",\"minute\":" + ivan.getFired().get(Calendar.MINUTE)
                + ",\"second\":" + ivan.getFired().get(Calendar.SECOND)
                + "},\"salary\":" + ivan.getSalary()
                + "}";
        assertThat(engine.generate(em -> true), is(iStr));
    }
    @Test
    public void whenXMLReport() {
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
        Report engine = new XMLReport(store);
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"windows-1251\"?>").append(System.lineSeparator());
        builder.append("<Employees>");
        builder.append("<name>").append(ivan.getName()).append("</name>").append(System.lineSeparator())
                .append("<hired>").append(ivan.getHired()).append("</hired>").append(System.lineSeparator())
                .append("<fired>").append(ivan.getFired()).append("</fired>").append(System.lineSeparator())
                .append("<salary>").append(ivan.getSalary()).append("</salary>").append(System.lineSeparator());
        builder.append("<name>").append(bill.getName()).append("</name>").append(System.lineSeparator())
                .append("<hired>").append(bill.getHired()).append("</hired>").append(System.lineSeparator())
                .append("<fired>").append(bill.getFired()).append("</fired>").append(System.lineSeparator())
                .append("<salary>").append(bill.getSalary()).append("</salary>").append(System.lineSeparator());
        builder.append("<name>").append(tina.getName()).append("</name>").append(System.lineSeparator())
                .append("<hired>").append(tina.getHired()).append("</hired>").append(System.lineSeparator())
                .append("<fired>").append(tina.getFired()).append("</fired>").append(System.lineSeparator())
                .append("<salary>").append(tina.getSalary()).append("</salary>").append(System.lineSeparator());
        builder.append("</Employees>");
        assertThat(engine.generate(em -> true), is(builder.toString()));
    }
}