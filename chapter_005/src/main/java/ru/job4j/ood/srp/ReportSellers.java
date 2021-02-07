package ru.job4j.ood.srp;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public interface ReportSellers {

    public List<Integer> volumeSales(Calendar date);

    public List<Integer> conversionSales(Calendar date);

    public List<Integer> averageCheck(Calendar date);

    public void writeVolumeSalesToDB(Properties properties);

}
