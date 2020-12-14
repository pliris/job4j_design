package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    private Properties properties;

    public void loadProperties() {
        Properties properties = new Properties();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            properties.load(io);
            this.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperties(String str) {
        return properties.get(str).toString();
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/test";
        String login = "postgres";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
        System.out.println("with use Properties and ClassLoader");
        ConnectionDemo connectionDemo = new ConnectionDemo();
        connectionDemo.loadProperties();
        System.out.println(connectionDemo.getProperties("user"));
        System.out.println(connectionDemo.getProperties("password"));
        System.out.println(connectionDemo.getProperties("url"));

    }
}