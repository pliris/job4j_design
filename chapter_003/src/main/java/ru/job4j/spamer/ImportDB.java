package ru.job4j.spamer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Загружает строки из потока ввода(файла), делит по разделителю и создаёт объекты User
     * @return список загруженных пользователей
     * @throws IOException исключение ввода-вывода
     */

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .forEach(s -> {
                        String[] str = s.split(";");
                        users.add(new User(str[0], str[1]));
                    });
        }
        return users;
    }

    /**
     * Сохраняет список пользователей в поток вывода (БД)
     * @param users список пользователей для сохранения
     * @throws ClassNotFoundException исключение при загрузке драйвера БД
     * @throws SQLException исключение при доступе к БД (БД нет или нет доступа)
     */

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        String getProperty = cfg.getProperty("jdbc.driver");
        Class.forName(getProperty);
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values(?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "dump.txt");
        db.save(db.load());
    }
}